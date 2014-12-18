package mods.timaxa007.pack.furniture.blocks;

import java.util.Random;

import mods.timaxa007.pack.furniture.PackFurniture;
import mods.timaxa007.tms.Core;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class AirLight extends Block {

	public AirLight() {
		super(Material.air);
		setHardness(0F);
		setResistance(0F);
		setLightLevel(15F);
		setCreativeTab(PackFurniture.proxy.tab_furniture);
		setBlockBounds(0F, 0F, 0F, 0F, 0F, 0F);
		setBlockTextureName("glass");
		setBlockName("air_light");
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

	@Override
	public int getRenderType() {
		return -1;
	}
}

