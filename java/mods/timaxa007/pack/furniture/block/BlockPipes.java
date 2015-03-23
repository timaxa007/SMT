package mods.timaxa007.pack.furniture.block;

import java.util.List;

import mods.timaxa007.pack.furniture.PackFurniture;
import mods.timaxa007.pack.furniture.tile.TileEntityPipes;
import mods.timaxa007.tms.lib.AddTextureModel;
import mods.timaxa007.tms.util.ModifiedBlock;
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

public class BlockPipes extends ModifiedBlock implements ITileEntityProvider {

	public BlockPipes(String tag) {
		super(tag, Material.glass);
		setCreativeTab(PackFurniture.tab_furniture);
		setBlockTextureName("glass");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityPipes();
	}

	public int getRenderType() {
		return PackFurniture.proxy.render.block_pipes_modelID;
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
		if (te != null && te instanceof TileEntityPipes) {
			TileEntityPipes tile = (TileEntityPipes)te;
			return addNBT(tile.getStyle(), tile.getSize(), tile.getColor());
		}
		return null;
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack is) {
		TileEntity te = world.getTileEntity(x, y, z);
		NBTTagCompound nbt = is.getTagCompound();
		if (te != null && te instanceof TileEntityPipes) {
			TileEntityPipes tile = (TileEntityPipes)te;
			if (nbt != null) {
				if (nbt.hasKey("Style")) tile.setStyle(nbt.getString("Style"));
				if (nbt.hasKey("Size")) tile.setSize(nbt.getInteger("Size"));
				if (nbt.hasKey("Color")) tile.setColor(nbt.getInteger("Color"));
			}
		}
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item id, CreativeTabs table, List list) {
		for (int j = 0; j < AddTextureModel.list.length; ++j) {
			if (AddTextureModel.list[j] != null && AddTextureModel.list[j].tag != null) {
				list.add(addNBT(AddTextureModel.list[j].tag, 1, 0xFFFFFF));
				list.add(addNBT(AddTextureModel.list[j].tag, 2, 0xFFFFFF));
				list.add(addNBT(AddTextureModel.list[j].tag, 3, 0xFFFFFF));
				list.add(addNBT(AddTextureModel.list[j].tag, 4, 0xFFFFFF));
				list.add(addNBT(AddTextureModel.list[j].tag, 5, 0xFFFFFF));
				list.add(addNBT(AddTextureModel.list[j].tag, 6, 0xFFFFFF));
				list.add(addNBT(AddTextureModel.list[j].tag, 7, 0xFFFFFF));
				list.add(addNBT(AddTextureModel.list[j].tag, 8, 0xFFFFFF));
			}
		}
		//list.add(new ItemStack(id, 1, 0));
	}

	public static ItemStack addNBT(String par1, int par2, int par3) {
		ItemStack is = new ItemStack(PackFurniture.proxy.block.pipes, 1, 0);
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setString("Style", par1);
		nbt.setInteger("Size", par2);
		nbt.setInteger("Color", par3);
		is.setTagCompound(nbt);
		return is;
	}

}
