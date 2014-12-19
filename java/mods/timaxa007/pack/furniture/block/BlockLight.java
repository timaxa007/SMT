package mods.timaxa007.pack.furniture.block;

import java.util.List;
import java.util.Random;

import mods.timaxa007.lib.GetColors;
import mods.timaxa007.pack.furniture.PackFurniture;
import mods.timaxa007.pack.furniture.tile.TileEntityLights;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockLight extends Block implements ITileEntityProvider {

	public static final String[] block_type = new String[] {
		"burner", 
		"flashlight", 
		"lantern", 
		//"blowtorch", 
		""
	};

	public BlockLight() {
		super(Material.circuits);
		setBlockTextureName("glass");
		setBlockName("lights");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityLights();
	}

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
		return null;
	}
/*
	public int getRenderType() {
		return 4;
	}
*/
	public int idDropped(int par1, Random random, int par3) {
		return 0;
	}

	public int quantityDropped(Random random) {
		return 0;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public int idPicked(World world, int x, int y, int z) {
		return 0;
	}

	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(x, y, z);
		if (te != null && te instanceof TileEntityLights)
			return addTag(world.getBlock(x, y, z), ((TileEntityLights)te).getType(), ((TileEntityLights)te).getColorHex1());
		return null;
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack is) {
		TileEntity te = world.getTileEntity(x, y, z);
		NBTTagCompound tag = is.getTagCompound();
		if (te != null && te instanceof TileEntityLights && tag != null) {
			if (tag.hasKey("Type")) ((TileEntityLights)te).setType(tag.getString("Type"));
			if (tag.hasKey("ColorHex1")) ((TileEntityLights)te).setColorHex1(tag.getInteger("ColorHex1"));
		}
	}

	@Override
	public void onBlockHarvested(World world, int x, int y, int z, int meta, EntityPlayer player) {
		if (!world.isRemote) {
			TileEntity te = world.getTileEntity(x, y, z);
			if (te != null && te instanceof TileEntityLights && !player.capabilities.isCreativeMode) {
				dropBlockAsItem(world, x, y, z, addTag(world.getBlock(x, y, z), ((TileEntityLights)te).getType(), ((TileEntityLights)te).getColorHex1()));
				world.removeTileEntity(x, y, z);
				world.setBlockToAir(x, y, z);
			}
		}
	}

	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float hitX, float hitY, float hitZ) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			TileEntity te = world.getTileEntity(x, y, z);
			//--------------------------------
			/*if (current.getItem() == PackFurniture.proxy.item_colored && (current.getItemDamage() >= 0 && current.getItemDamage() < 16)) {
				if (!player.capabilities.isCreativeMode) {--current.stackSize;}
				return true;
			}
			//--------------------------------
			else return false;*/
			//--------------------------------
		}
		return false;
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item id, CreativeTabs table, List list) {
		for (int i = 0; i < block_type.length; i++) {
			for (int j = 0; j < 16; j++) {
				//int j = 14;
				list.add(addTag(id, block_type[i], GetColors.getHexColors[j]));
			}
		}
		//list.add(new ItemStack(id, 1, 0));
	}

	private static ItemStack addTag(Block par1, String par2, int par3) {
		return addTag(Item.getItemFromBlock(par1), par2, par3);
	}

	private static ItemStack addTag(Item par1, String par2, int par3) {
		ItemStack is = new ItemStack(par1, 1, 0);
		NBTTagCompound tag = new NBTTagCompound();
		tag.setString("Type", par2);
		tag.setInteger("ColorHex1", par3);
		is.setTagCompound(tag);
		return is;
	}

}
