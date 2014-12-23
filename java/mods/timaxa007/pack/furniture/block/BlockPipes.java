package mods.timaxa007.pack.furniture.block;

import java.util.List;

import mods.timaxa007.lib.TileTexture;
import mods.timaxa007.pack.furniture.PackFurniture;
import mods.timaxa007.pack.furniture.tile.TileEntityPipes;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockPipes extends Block implements ITileEntityProvider {

	public BlockPipes() {
		super(Material.glass);
		setCreativeTab(PackFurniture.tab_furniture);
		setBlockTextureName("glass");
		setBlockName("pipes");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityPipes();
	}

	public int getRenderType() {
		return PackFurniture.proxy.render_block_pipes_modelID;
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	public int idPicked(World world, int x, int y, int z) {
		return 0;
	}

	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(x, y, z);
		if (te != null && te instanceof TileEntityPipes)
			return addTag(((TileEntityPipes)te).getType(), ((TileEntityPipes)te).getSize(), ((TileEntityPipes)te).getColor());
		return null;
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack is) {
		TileEntity te = world.getTileEntity(x, y, z);
		NBTTagCompound tag = is.getTagCompound();
		if (te != null && te instanceof TileEntityPipes) {
			if (tag != null) {
				if (tag.hasKey("Type")) ((TileEntityPipes)te).setType(tag.getInteger("Type"));
				if (tag.hasKey("Size")) ((TileEntityPipes)te).setSize(tag.getInteger("Size"));
				if (tag.hasKey("Color")) ((TileEntityPipes)te).setColor(tag.getInteger("Color"));
			}
		}
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item id, CreativeTabs table, List list) {
		for (int j = 0; j < TileTexture.texTest01.length; ++j) {
			list.add(addTag(j, 1, 0xFFFFFF));
			list.add(addTag(j, 2, 0xFFFFFF));
			list.add(addTag(j, 3, 0xFFFFFF));
			list.add(addTag(j, 4, 0xFFFFFF));
			list.add(addTag(j, 5, 0xFFFFFF));
			list.add(addTag(j, 6, 0xFFFFFF));
			list.add(addTag(j, 7, 0xFFFFFF));
			list.add(addTag(j, 8, 0xFFFFFF));
		}
		//list.add(new ItemStack(id, 1, 0));
	}

	private static ItemStack addTag(int par1, int par2, int par3) {
		ItemStack is = new ItemStack(PackFurniture.proxy.block.pipes, 1, 0);
		NBTTagCompound tag = new NBTTagCompound();
		tag.setInteger("Type", par1);
		tag.setInteger("Size", par2);
		tag.setInteger("Color", par3);
		is.setTagCompound(tag);
		return is;
	}

}
