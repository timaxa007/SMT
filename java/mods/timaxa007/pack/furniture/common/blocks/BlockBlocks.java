package mods.timaxa007.pack.furniture.common.blocks;

import java.util.List;

import mods.timaxa007.lib.GetColors;
import mods.timaxa007.pack.furniture.common.main.PackFurniture;
import mods.timaxa007.pack.furniture.common.tile.TEBlockBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
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

public class BlockBlocks extends Block implements ITileEntityProvider {

	@SideOnly(Side.CLIENT) private IIcon[] icon_array;

	public static String[] type_block = new String[] {
		"wood_white", 
		"stone_brick_white", 
		"glass_white"
	};

	public BlockBlocks(int id, Material mat) {
		super(mat);
		setCreativeTab(PackFurniture.proxy.tab_furniture);
		setBlockTextureName("planks_oak");
		setBlockName("block_blocks");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {return new TEBlockBlocks();}

	@SideOnly(Side.CLIENT)
	public int colorMultiplier(IBlockAccess block_access, int x, int y, int z) {
		TileEntity te = block_access.getTileEntity(x, y, z);
		if (te != null && te instanceof TEBlockBlocks) {
			return ((TEBlockBlocks)te).getColorBlock();
		}
		return 0xFFFFFF;
	}

	@SideOnly(Side.CLIENT)
	public IIcon getBlockTexture(IBlockAccess block_access, int x, int y, int z, int side) {
		TileEntity te = block_access.getTileEntity(x, y, z);
		if (te != null && te instanceof TEBlockBlocks) {
			return icon_array[((TEBlockBlocks)te).getSubID()];
		}
		return getIcon(side, block_access.getBlockMetadata(x, y, z));
	}

	public int idPicked(World world, int x, int y, int z) {return 0;}

	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(x, y, z);
		if (te != null && te instanceof TEBlockBlocks)
			return addTag(world.getBlock(x, y, z), ((TEBlockBlocks)te).getSubID(), ((TEBlockBlocks)te).getColorBlock());
		return addTag(world.getBlock(x, y, z), 0, 0xFFFFFF);
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack is) {
		TileEntity te = world.getTileEntity(x, y, z);
		NBTTagCompound tag = is.getTagCompound();
		if (te != null && te instanceof TEBlockBlocks && tag != null) {
			if (tag.hasKey("SubID")) ((TEBlockBlocks)te).setSubID((int)tag.getByte("SubID"));
			if (tag.hasKey("ColorBlock")) ((TEBlockBlocks)te).setColorBlock(tag.getInteger("ColorBlock"));
		}
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item id, CreativeTabs table, List list) {
		for (int i = 0; i < type_block.length; i++) {
			//for (int j = 0; j < 16; j++) {
			int j = 14;
			list.add(addTag(id, i, GetColors.getHexColors[j]));
			//}
		}
		//list.add(new ItemStack(id, 1, 0));
	}

	private static ItemStack addTag(Block par1, int par2, int par3) {
		return addTag(Item.getItemFromBlock(par1), par2, par3);
	}

	private static ItemStack addTag(Item par1, int par2, int par3) {
		ItemStack is = new ItemStack(par1, 1, 0);
		NBTTagCompound tag = new NBTTagCompound();
		tag.setByte("SubID", (byte)par2);
		tag.setInteger("ColorBlock", par3);
		is.setTagCompound(tag);
		return is;
	}

	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister ir) {
		icon_array = new IIcon[type_block.length];
		for (int i = 0; i < icon_array.length; ++i) {
			icon_array[i] = ir.registerIcon("timaxa007:" + "stone/" + type_block[i]);
		}
	}

}
