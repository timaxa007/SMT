package mods.timaxa007.pack.furniture.blocks;

import java.util.List;

import mods.timaxa007.pack.furniture.PackFurniture;
import mods.timaxa007.pack.furniture.tile.TileEntityCrystals;
import net.minecraft.block.BlockContainer;
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

public class BlockCrystals extends BlockContainer{

	public BlockCrystals() {
		super(Material.glass);
		setHardness(0.5F);
		setCreativeTab(PackFurniture.tab_furniture);
		setBlockTextureName("glass");
		setBlockName("crystals");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityCrystals();
	}

	public int getRenderType() {
		return PackFurniture.proxy.render_block_crystals_modelID;
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
		NBTTagCompound tag = is.getTagCompound();
		if (te != null && te instanceof TileEntityCrystals) {

			int l=MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
			((TileEntityCrystals)te).setRot(l);

			if (tag != null) {
				if (tag.hasKey("Amount")) ((TileEntityCrystals)te).setAmount(tag.getInteger("Amount"));
				if (tag.hasKey("Type")) ((TileEntityCrystals)te).setTypes(tag.getInteger("Type"));
			}

		}
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item id, CreativeTabs table, List list) {
		for (int j = 0; j < 16; ++j) {
			list.add(addTag(j));
		}
		list.add(new ItemStack(id, 1, 0));
	}

	private static ItemStack addTag(int par1) {
		ItemStack is = new ItemStack(PackFurniture.proxy.block_crystals, 1, par1);
		NBTTagCompound tag = new NBTTagCompound();
		tag.setInteger("Amount", 8);
		tag.setInteger("Type", par1);
		is.setTagCompound(tag);
		return is;
	}
	/*
@Override 
public ArrayList<ItemStack> getBlockDropped(World world, int x, int y, int z, int metadata, int fortune) {
ArrayList<ItemStack> ret=super.getBlockDropped(world, x, y, z, metadata, fortune);
ret.add(new ItemStack(PackFurniture.proxy.block_crystals, 1, metadata));
return ret;
}
	 */
}
