package mods.timaxa007.pack.furniture.block;

import java.util.Random;

import mods.timaxa007.pack.furniture.PackFurniture;
import mods.timaxa007.tms.util.ModifiedBlock;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class AirLight extends ModifiedBlock {

	public AirLight(String tag) {
		super(tag, Material.air);
		setCreativeTab(PackFurniture.tab_furniture);
		setHardness(0F);
		setResistance(0F);
		setLightLevel(15F);
		setBlockBounds(0F, 0F, 0F, 0F, 0F, 0F);
		setBlockTextureName("glass");
	}

	@Override
	public int getRenderType() {
		return -1;
	}

	@Override
	public Item getItemDropped(int meta, Random rand, int fortune) {
		return null;
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
		return null;
	}

	@Override
	public AxisAlignedBB getSelectedBoundingBoxFromPool(World world, int x, int y, int z) {
		return null;
	}

}

