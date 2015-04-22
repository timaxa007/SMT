package timaxa007.pack.stock.block;

import java.util.List;
import java.util.Random;

import timaxa007.pack.stock.PackStock;
import timaxa007.pack.stock.lib.FoodForBlock;
import timaxa007.pack.stock.tile.TileEntityFoods;
import timaxa007.tms.lib.ActionModel;
import timaxa007.tms.object.ModifiedBlock;
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

public class BlockFoods extends ModifiedBlock implements ITileEntityProvider {

	public BlockFoods(String tag) {
		super(tag, Material.cake);
		setCreativeTab(PackStock.tab_food);
		setHardness(0.25F);
		setResistance(0.5F);
		setBlockTextureName("planks_oak");
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEntityFoods();
	}

	public int quantityDropped(Random random) {
		return 0;
	}

	public int getRenderType() {
		return PackStock.render.block_foods_modelID;
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
		if (te != null && te instanceof TileEntityFoods) {
			TileEntityFoods tile = (TileEntityFoods)te;
			return addNBT(tile.getTag(), tile.getColor1(), tile.getColor2());
		}
		return null;
	}

	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z, EntityLivingBase entity, ItemStack is) {
		TileEntity te = world.getTileEntity(x, y, z);
		NBTTagCompound nbt = is.getTagCompound();

		if (te != null && te instanceof TileEntityFoods && nbt != null) {
			TileEntityFoods tile = (TileEntityFoods)te;

			if (nbt.hasKey("NameID")) tile.setTag(nbt.getString("NameID"));
			if (nbt.hasKey("Color1")) tile.setColor1(nbt.getInteger("Color1"));
			if (nbt.hasKey("Color2")) tile.setColor2(nbt.getInteger("Color2"));
			tile.setRotation(ActionModel.rotation_model_8sides(entity.rotationYaw));

		}

	}

	@Override
	public void onBlockHarvested(World world, int x, int y, int z, int meta, EntityPlayer player) {
		if (!world.isRemote) {
			TileEntity te = world.getTileEntity(x, y, z);
			if (te != null && te instanceof TileEntityFoods && !player.capabilities.isCreativeMode) {
				TileEntityFoods tile = (TileEntityFoods)te;
				dropBlockAsItem(world, x, y, z, addNBT(tile.getTag(), tile.getColor1(), tile.getColor2()));
				world.removeTileEntity(x, y, z);
				world.setBlockToAir(x, y, z);
			}
		}
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(Item id, CreativeTabs table, List list) {
		for (int j = 1; j < FoodForBlock.list.length; ++j) {
			if (FoodForBlock.list[j] != null) {
				list.add(addNBT(
						FoodForBlock.list[j].tag, 
						FoodForBlock.list[j].getColor1(), 
						FoodForBlock.list[j].getColor2()
						));
			}
		}
		//list.add(new ItemStack(id, 1, 0));
	}

	public static ItemStack addNBT(String par1, int par2, int par3) {
		ItemStack is = new ItemStack(PackStock.block.foods, 1, 0);
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setString("NameID", par1);
		nbt.setInteger("Color1", par2);
		nbt.setInteger("Color2", par3);
		is.setTagCompound(nbt);
		return is;
	}

}
