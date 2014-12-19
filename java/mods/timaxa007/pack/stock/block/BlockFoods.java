package mods.timaxa007.pack.stock.block;

import java.util.List;
import java.util.Random;

import mods.timaxa007.pack.stock.PackStock;
import mods.timaxa007.pack.stock.lib.FoodForBlock;
import mods.timaxa007.pack.stock.tile.TileEntityFoods;
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

public class BlockFoods extends Block implements ITileEntityProvider {

	public BlockFoods() {
		super(Material.glass);
		setCreativeTab(PackStock.tab_food);
		setHardness(0.25F);
		setResistance(0.5F);
		setBlockTextureName("planks_oak");
		setBlockName("foods");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityFoods();
	}

	public int quantityDropped(Random random) {
		return 0;
	}

	public int getRenderType() {
		return PackStock.proxy.render_block_foods_modelID;
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
		if (te != null && te instanceof TileEntityFoods)
			return addTag(((TileEntityFoods)te).getFoodID(), ((TileEntityFoods)te).getType(), ((TileEntityFoods)te).getColor1(), ((TileEntityFoods)te).getColor2());
		return null;
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack is) {
		TileEntity te = world.getTileEntity(x, y, z);
		NBTTagCompound tag = is.getTagCompound();
		if (te != null && te instanceof TileEntityFoods && tag != null) {

			//((TileEntityFoods)te).setRotate((int)entity.rotationYaw);
			if (tag.hasKey("FoodID")) ((TileEntityFoods)te).setFoodID(tag.getInteger("FoodID"));
			if (tag.hasKey("Type")) ((TileEntityFoods)te).setType(tag.getInteger("Type"));
			if (tag.hasKey("Color1")) ((TileEntityFoods)te).setColor1(tag.getInteger("Color1"));
			if (tag.hasKey("Color2")) ((TileEntityFoods)te).setColor2(tag.getInteger("Color2"));

		}
	}

	@Override
	public void onBlockHarvested(World world, int x, int y, int z, int meta, EntityPlayer player) {
		if (!world.isRemote) {
			TileEntity te = world.getTileEntity(x, y, z);
			if (te != null && te instanceof TileEntityFoods && !player.capabilities.isCreativeMode) {
				dropBlockAsItem(world, x, y, z, addTag(((TileEntityFoods)te).getFoodID(), ((TileEntityFoods)te).getType(), ((TileEntityFoods)te).getColor1(), ((TileEntityFoods)te).getColor2()));
				world.removeTileEntity(x, y, z);
				world.setBlockToAir(x, y, z);
			}
		}
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item id, CreativeTabs table, List list) {
		for (int j = 1; j < FoodForBlock.list.length; ++j) {
			if (FoodForBlock.list[j] != null) {
				list.add(addTag(j, 0, FoodForBlock.list[j].getColor1(), FoodForBlock.list[j].getColor2()));
			}
		}
		//list.add(new ItemStack(id, 1, 0));
	}

	private static ItemStack addTag(int par1, int par2, int par3, int par4) {
		ItemStack is = new ItemStack(PackStock.proxy.block_foods, 1, 0);
		NBTTagCompound tag = new NBTTagCompound();
		tag.setInteger("FoodID", par1);
		tag.setInteger("Type", par2);
		tag.setInteger("Color1", par3);
		tag.setInteger("Color2", par4);
		is.setTagCompound(tag);
		return is;
	}

}
