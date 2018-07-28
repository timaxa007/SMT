package smt.pack.phytology.block;

import java.util.ArrayList;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.IGrowable;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;
import net.minecraftforge.common.util.ForgeDirection;
import smt.pack.phytology.SMTPhytology;

public class BlockBlocksPhytology extends Block implements IPlantable, IGrowable {

	public BlockBlocksPhytology() {
		super(Material.wood);
	}

	@Override
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
		if (world.isAirBlock(x, y - 1, z))
			world.func_147480_a(x, y, z, true);
	}
	/*
	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int metadata) {
		if (world.getBlock(x, y + 1, z) == this)
			world.func_147480_a(x, y + 1 , z, true);
	}
	 */
	@Override
	public void updateTick(World world, int x, int y, int z, Random random) {
		super.updateTick(world, x, y, z, random);
		int metadata = world.getBlockMetadata(x, y, z);
		if (!world.isRemote && world.getBlockLightValue(x, y + 1, z) >= 9 && metadata < 7){
			world.setBlockMetadataWithNotify(x, y, z, metadata + 1, 3);
		}
	}

	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
		ArrayList<ItemStack> ret = new ArrayList<ItemStack>();

		ret.add(new ItemStack(Items.iron_ingot, 1, 0));
		if (metadata == 7) ret.add(new ItemStack(Blocks.iron_block, 1, 0));

		return ret;
	}

	@Override
	public boolean canSustainPlant(IBlockAccess world, int x, int y, int z, ForgeDirection direction, IPlantable plantable) {
		if (world.getBlock(x, y, z) == Blocks.farmland) return true;
		return false;
	}

	@Override
	public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z) {
		return EnumPlantType.Crop;
	}

	@Override
	public Block getPlant(IBlockAccess world, int x, int y, int z) {
		return this;
	}

	@Override
	public int getPlantMetadata(IBlockAccess world, int x, int y, int z) {
		return world.getBlockMetadata(x, y, z);
	}

	@Override
	public boolean func_149851_a(World world, int x, int y, int z, boolean isRemote) {
		return true;
	}

	@Override
	public boolean func_149852_a(World world, Random random, int x, int y, int z) {
		int metadata = world.getBlockMetadata(x, y, z);
		if (metadata < 7) return true;
		return false;
	}

	@Override
	public void func_149853_b(World world, Random random, int x, int y, int z) {
		int metadata = world.getBlockMetadata(x, y, z);
		world.setBlockMetadataWithNotify(x, y, z, metadata + 1, 3);
	}

}
