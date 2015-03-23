package mods.timaxa007.pack.furniture.block;

import java.util.List;
import java.util.Random;

import mods.timaxa007.pack.furniture.PackFurniture;
import mods.timaxa007.pack.furniture.tile.TileEntityVegetableFace;
import mods.timaxa007.tms.util.ModifiedBlock;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockVegetableFace extends ModifiedBlock implements ITileEntityProvider {

	@SideOnly(Side.CLIENT) private IIcon[][] icon_array;
	@SideOnly(Side.CLIENT) private IIcon[][] icon_face;

	public static String[] type_block = new String[] {"pumpkin", "water_melon"};

	public static String[] type_side = new String[] {"top", "botton", "side"};

	public static String[] type_face = new String[] {
		"face1", 
		"face2", 
		"face3", 
		"face4", 
		"face5", 
		"face6"
	};

	public BlockVegetableFace(String tag) {
		super(tag, Material.gourd);
		setCreativeTab(PackFurniture.tab_furniture);
		setHardness(0.5F);
		setResistance(2.5F);
		setStepSound(soundTypeWood);
		setBlockTextureName("pumpkin_side");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityVegetableFace();
	}

	/*public int getRenderType() {
		return -1;
	}*/

	public int quantityDropped(Random random) {
		return 0;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	public boolean isOpaqueCube() {
		return false;
	}

	@SideOnly(Side.CLIENT)
	public int colorMultiplier(IBlockAccess block_access, int x, int y, int z) {
		TileEntity te = block_access.getTileEntity(x, y, z);
		if (te != null && te instanceof TileEntityVegetableFace)
			return ((TileEntityVegetableFace)te).getColorBlock();
		return 0xFFFFFF;
	}

	@SideOnly(Side.CLIENT)
	public IIcon getBlockTexture(IBlockAccess block_access, int x, int y, int z, int side) {
		TileEntity te = block_access.getTileEntity(x, y, z);
		if (te != null && te instanceof TileEntityVegetableFace) {
			if (side == 0) {
				return icon_array[((TileEntityVegetableFace)te).getSubID()][1];
			} else if (side == 1) {
				return icon_array[((TileEntityVegetableFace)te).getSubID()][0];
			} else if (side == 4) {
				return icon_face[((TileEntityVegetableFace)te).getSubID()][((TileEntityVegetableFace)te).getFace()];
			} else {
				return icon_array[((TileEntityVegetableFace)te).getSubID()][2];
			}
		}
		return getIcon(side, block_access.getBlockMetadata(x, y, z));
	}

	public int idPicked(World world, int x, int y, int z) {return 0;}

	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(x, y, z);
		if (te != null && te instanceof TileEntityVegetableFace)
			return addNBT(world.getBlock(x, y, z), ((TileEntityVegetableFace)te).getSubID(), ((TileEntityVegetableFace)te).getFace(), ((TileEntityVegetableFace)te).getColorBlock());
		return null;
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack is) {
		TileEntity te = world.getTileEntity(x, y, z);
		NBTTagCompound nbt = is.getTagCompound();
		if (te != null && te instanceof TileEntityVegetableFace && nbt != null) {
			if (nbt.hasKey("SubID")) ((TileEntityVegetableFace)te).setSubID((int)nbt.getByte("SubID"));
			if (nbt.hasKey("FaceID")) ((TileEntityVegetableFace)te).setFace((int)nbt.getByte("FaceID"));
			if (nbt.hasKey("ColorBlock")) ((TileEntityVegetableFace)te).setColorBlock(nbt.getInteger("ColorBlock"));
		}
	}

	@Override
	public void onBlockHarvested(World world, int x, int y, int z, int meta, EntityPlayer player) {
		if (!world.isRemote) {
			TileEntity te = world.getTileEntity(x, y, z);
			if (te != null && te instanceof TileEntityVegetableFace && !player.capabilities.isCreativeMode) {
				dropBlockAsItem(world, x, y, z, addNBT(world.getBlock(x, y, z), ((TileEntityVegetableFace)te).getSubID(), ((TileEntityVegetableFace)te).getFace(), ((TileEntityVegetableFace)te).getColorBlock()));
				world.removeTileEntity(x, y, z);
				world.setBlockToAir(x, y, z);
			}
		}
	}
	/*
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int meta, float hitX, float hitY, float hitZ) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			TileEntity te = world.getTileEntity(x, y, z);
			//--------------------------------
			if (current.getItem() == PackFurniture.proxy.item.colored && (current.getItemDamage() >= 0 && current.getItemDamage() < 16)) {
				if (!player.capabilities.isCreativeMode) {--current.stackSize;}
				//((TileEntityVegetableFace)te).setColorBlock(GetColors.getHexColors[current.getItemDamage()]);
				((TileEntityVegetableFace)te).setColorBlock(GetColors.getColorMix(GetColors.getHexColors[current.getItemDamage()], ((TileEntityVegetableFace)te).getColorBlock()));
				//world.scheduleBlockUpdate(x, y, z, world.getBlock(x, y, z), 4);
				return true;
			}
			//--------------------------------
			else if (current.getItem() == Items.dye && (current.getItemDamage() >= 0 && current.getItemDamage() < 16)) {
				if (!player.capabilities.isCreativeMode) {--current.stackSize;}
				//((TileEntityVegetableFace)te).setColorBlock(ItemDye.dyeColors[current.getItemDamage()]);
				((TileEntityVegetableFace)te).setColorBlock(GetColors.getColorMix(ItemDye.field_150922_c[current.getItemDamage()], ((TileEntityVegetableFace)te).getColorBlock()));
				//world.scheduleBlockUpdate(x, y, z, world.getBlock(x, y, z), 4);
				return true;
			}
			//--------------------------------
			else return false;
			//--------------------------------
		} else return false;
	}
	 */
	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item id, CreativeTabs table, List list) {
		for (int i1 = 0; i1 < type_block.length; i1++) {
			for (int i3 = 0; i3 < type_face.length; i3++) {
				list.add(addNBT(id, i1, i3, 0xFFFFFF));
				/*for (int j = 0; j < (Integer.MAX_VALUE / 1000000); j++) {//int j = 14;
					list.add(addNBT(id, i, (j * 1000000)));
				}*/
			}
		}
		//list.add(new ItemStack(id, 1, 0));
	}

	public static ItemStack addNBT(Block par1, int par2, int par3, int par4) {
		return addNBT(Item.getItemFromBlock(par1), par2, par3, par4);
	}

	public static ItemStack addNBT(Item par1, int par2, int par3, int par4) {
		ItemStack is = new ItemStack(par1, 1, 0);
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setByte("SubID", (byte)par2);
		nbt.setByte("FaceID", (byte)par3);
		nbt.setInteger("ColorBlock", par4);
		is.setTagCompound(nbt);
		return is;
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister ir) {
		icon_array = new IIcon[type_block.length][type_side.length];
		icon_face = new IIcon[type_block.length][type_face.length];
		blockIcon = ir.registerIcon("pumpkin_side");
		for (int i1 = 0; i1 < icon_array.length; ++i1) {
			for (int i2 = 0; i2 < type_side.length; ++i2) {
				icon_array[i1][i2] = ir.registerIcon("timaxa007:" + "germination/" + type_block[i1] + "_" + type_side[i2]);
			}
			for (int i3 = 0; i3 < type_face.length; ++i3) {
				icon_face[i1][i3] = ir.registerIcon("timaxa007:" + "germination/" + type_block[i1] + "_" + type_face[i3] + "_off");
			}
		}
	}

}
