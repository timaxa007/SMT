package timaxa007.pack.mining.block;

import java.util.List;

import timaxa007.pack.mining.PackMining;
import timaxa007.pack.mining.tile.TileEntityOreOres;
import timaxa007.smt.object.ModifiedBlock;
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

public class OreOres extends ModifiedBlock implements ITileEntityProvider {

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
	public TileEntity createNewTileEntity(World world, int meta) {return new TileEntityOreOres();}

	public int getRenderType() {return PackMining.render.block_ore_modelID;}
	public boolean isOpaqueCube() {return false;}
	public boolean renderAsNormalBlock() {return false;}

	public int idPicked(World world, int x, int y, int z) {return 0;}

	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(x, y, z);
		if (te != null && te instanceof TileEntityOreOres)
			return addNBT(world.getBlock(x, y, z), ((TileEntityOreOres)te).getType(), ((TileEntityOreOres)te).getColorBlock());
		return null;
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack is) {
		TileEntity te = world.getTileEntity(x, y, z);
		NBTTagCompound nbt = is.getTagCompound();
		if (te != null && te instanceof TileEntityOreOres && nbt != null) {
			if (nbt.hasKey("Type")) ((TileEntityOreOres)te).setType((int)nbt.getByte("Type"));
			if (nbt.hasKey("ColorBlock")) ((TileEntityOreOres)te).setColorBlock(nbt.getInteger("ColorBlock"));
		}
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item id, CreativeTabs table, List list) {
		for (int i = 0; i < type_ore.length; i++) {
			list.add(addNBT(id, i, 0xFFFFFF));
		}
		//list.add(new ItemStack(id, 1, 0));
	}

	public static ItemStack addNBT(Block par1, int par2, int par3) {
		return addNBT(Item.getItemFromBlock(par1), par2, par3);
	}

	public static ItemStack addNBT(Item par1, int par2, int par3) {
		ItemStack is = new ItemStack(par1, 1, 0);
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setByte("Type", (byte)par2);
		nbt.setInteger("ColorBlock", par3);
		is.setTagCompound(nbt);
		return is;
	}

}
