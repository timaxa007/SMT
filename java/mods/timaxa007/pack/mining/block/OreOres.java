package mods.timaxa007.pack.mining.block;

import java.util.List;

import mods.timaxa007.pack.mining.PackMining;
import mods.timaxa007.pack.mining.tile.TileEntityOreOres;
import mods.timaxa007.tms.util.BlockFixReg;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class OreOres extends BlockFixReg implements ITileEntityProvider {

	public static String[] type_ore = new String[] {
		"appa", 
		"chunk", 
		"creg", 
		"dust", 
		"gem_large", 
		"gem_med1", 
		"gem_medium_2", 
		"gem_medium_3", 
		"gem_medium_4", 
		"gem_medium", 
		"gem_small", 
		"gem_smalled_4", 
		"lap", 
		"metal_2", 
		"metal", 
		"shard"
	};

	public OreOres(String tag) {
		super(tag, Material.rock);
		setCreativeTab(PackMining.tab_mining);
		setStepSound(soundTypeStone);
		setHardness(1.0F);
		setResistance(5.0F);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityOreOres();
	}
	/*
	public int getRenderType() {
		return -1;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	public boolean isOpaqueCube() {
		return false;
	}
	 */
	@SideOnly(Side.CLIENT)
	public int colorMultiplier(IBlockAccess block_access, int x, int y, int z) {
		TileEntity te = block_access.getTileEntity(x, y, z);
		if (te != null && te instanceof TileEntityOreOres) {
			return ((TileEntityOreOres)te).getColorBlock();
		}
		return 0xFFFFFF;
	}

	@SideOnly(Side.CLIENT)
	public IIcon getBlockTexture(IBlockAccess block_access, int x, int y, int z, int side) {
		TileEntity te = block_access.getTileEntity(x, y, z);
		if (te != null && te instanceof TileEntityOreOres) {
			if (this == PackMining.proxy.block.ore_rock_ores) {return Blocks.stone.getIcon(side, block_access.getBlockMetadata(x, y, z));}
			if (this == PackMining.proxy.block.ore_nether_ores) {return Blocks.netherrack.getIcon(side, block_access.getBlockMetadata(x, y, z));}
			if (this == PackMining.proxy.block.ore_ender_ores) {return Blocks.end_stone.getIcon(side, block_access.getBlockMetadata(x, y, z));}
			return Blocks.stone.getIcon(side, block_access.getBlockMetadata(x, y, z));
		}
		return getIcon(side, block_access.getBlockMetadata(x, y, z));
	}

	public int idPicked(World world, int x, int y, int z) {return 0;}

	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(x, y, z);
		if (te != null && te instanceof TileEntityOreOres)
			return addTag(world.getBlock(x, y, z), ((TileEntityOreOres)te).getType(), ((TileEntityOreOres)te).getColorBlock());
		return null;
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack is) {
		TileEntity te = world.getTileEntity(x, y, z);
		NBTTagCompound tag = is.getTagCompound();
		if (te != null && te instanceof TileEntityOreOres && tag != null) {
			if (tag.hasKey("Type")) ((TileEntityOreOres)te).setType((int)tag.getByte("Type"));
			if (tag.hasKey("ColorBlock")) ((TileEntityOreOres)te).setColorBlock(tag.getInteger("ColorBlock"));
		}
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item id, CreativeTabs table, List list) {
		for (int i = 0; i < type_ore.length; i++) {
			list.add(addTag(id, i, 0xFFFFFF));
		}
		//list.add(new ItemStack(id, 1, 0));
	}

	private static ItemStack addTag(Block par1, int par2, int par3) {
		return addTag(Item.getItemFromBlock(par1), par2, par3);
	}

	private static ItemStack addTag(Item par1, int par2, int par3) {
		ItemStack is = new ItemStack(par1, 1, 0);
		NBTTagCompound tag = new NBTTagCompound();
		tag.setByte("Type", (byte)par2);
		tag.setInteger("ColorBlock", par3);
		is.setTagCompound(tag);
		return is;
	}

}
