package mods.timaxa007.pack.furniture.block;

import java.util.List;

import mods.timaxa007.pack.furniture.PackFurniture;
import mods.timaxa007.pack.furniture.tile.TileEntityCrystals;
import mods.timaxa007.tms.util.ModifiedBlock;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockCrystals extends ModifiedBlock implements ITileEntityProvider {

	public BlockCrystals(String tag) {
		super(tag, Material.glass);
		setHardness(0.5F);
		setCreativeTab(PackFurniture.tab_furniture);
		setBlockTextureName("glass");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityCrystals();
	}

	public int getRenderType() {
		return PackFurniture.proxy.render.block_crystals_modelID;
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack is) {
		TileEntity te = world.getTileEntity(x, y, z);
		NBTTagCompound nbt = is.getTagCompound();
		if (te != null && te instanceof TileEntityCrystals) {

			int l=MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			((TileEntityCrystals)te).setRot(l);

			if (nbt != null) {
				if (nbt.hasKey("Amount")) ((TileEntityCrystals)te).setAmount(nbt.getInteger("Amount"));
				if (nbt.hasKey("Type")) ((TileEntityCrystals)te).setTypes(nbt.getInteger("Type"));
			}

		}
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item id, CreativeTabs table, List list) {
		for (int j = 0; j < 16; ++j) {
			list.add(addNBT(j));
		}
		list.add(new ItemStack(id, 1, 0));
	}

	public static ItemStack addNBT(int par1) {
		ItemStack is = new ItemStack(PackFurniture.proxy.block.crystals, 1, par1);
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setInteger("Amount", 8);
		nbt.setInteger("Type", par1);
		is.setTagCompound(nbt);
		return is;
	}
	/*
@Override 
public ArrayList<ItemStack> getBlockDropped(World world, int x, int y, int z, int metadata, int fortune) {
ArrayList<ItemStack> ret=super.getBlockDropped(world, x, y, z, metadata, fortune);
ret.add(new ItemStack(PackFurniture.proxy.block.crystals, 1, metadata));
return ret;
}
	 */
}
