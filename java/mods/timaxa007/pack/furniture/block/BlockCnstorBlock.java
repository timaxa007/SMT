package mods.timaxa007.pack.furniture.block;

import java.util.List;
import java.util.Random;

import mods.timaxa007.lib.AddTextureModel;
import mods.timaxa007.lib.GetColors;
import mods.timaxa007.pack.furniture.PackFurniture;
import mods.timaxa007.pack.furniture.tile.TileEntityCnstorBlock;
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
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockCnstorBlock extends Block implements ITileEntityProvider {

	public BlockCnstorBlock() {
		super(Material.glass);
		setCreativeTab(PackFurniture.tab_furniture);
		setHardness(1.0F);
		setResistance(3.5F);
		setLightOpacity(0);
		setStepSound(soundTypeWood);
		setBlockTextureName("timaxa007:woodFrame");
		setBlockName("cnstor.block");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityCnstorBlock();
	}

	public int quantityDropped(Random radom) {
		return 0;
	}

	public int getRenderType() {
		return PackFurniture.proxy.render.block_cnstor_block_modelID;
	}

	public boolean isOpaqueCube() {
		return false;
	}

	/*public boolean renderAsNormalBlock() {
		return false;
	}*/

	public int idPicked(World world, int x, int y, int z) {
		return 0;
	}

	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(x, y, z);
		if (te != null && te instanceof TileEntityCnstorBlock) {
			TileEntityCnstorBlock tile = (TileEntityCnstorBlock)te;
			return addTag(tile.getStyle(), tile.getColor());
		}
		return null;
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack is) {

		TileEntity te = world.getTileEntity(x, y, z);
		NBTTagCompound tag = is.getTagCompound();

		if (te != null && te instanceof TileEntityCnstorBlock) {
			TileEntityCnstorBlock tile = (TileEntityCnstorBlock)te;
			if (tag != null) {
				if (tag.hasKey("Style")) tile.setStyle(tag.getString("Style"));
				if (tag.hasKey("Color")) tile.setColor(tag.getInteger("Color"));
			}
		}

	}

	@Override
	public void onBlockHarvested(World world, int x, int y, int z, int meta, EntityPlayer player) {
		if (!world.isRemote) {
			TileEntity te = world.getTileEntity(x, y, z);
			if (te != null && te instanceof TileEntityCnstorBlock && !player.capabilities.isCreativeMode) {
				TileEntityCnstorBlock tile = (TileEntityCnstorBlock)te;
				dropBlockAsItem(world, x, y, z, addTag(tile.getStyle(), tile.getColor()));
				world.removeTileEntity(x, y, z);
				world.setBlockToAir(x, y, z);
			}
		}
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item id, CreativeTabs table, List list) {
		for (int j = 0; j < AddTextureModel.list.length; ++j) {
			//for (int i = 0; i < 16; ++i) {
			int i = 14;
			list.add(addTag(AddTextureModel.list[j].tag, GetColors.getHexColors[i]));
			//}
		}
		//list.add(new ItemStack(id, 1, 0));
	}

	private static ItemStack addTag(String par1, int par2) {
		ItemStack is = new ItemStack(PackFurniture.proxy.block.cnstor_block);
		NBTTagCompound tag = new NBTTagCompound();
		tag.setString("Style", par1);
		tag.setInteger("Color", par2);
		is.setTagCompound(tag);
		return is;
	}

}
