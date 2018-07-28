package smt.pack.geology.world;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenMushroom extends WorldGenerator {
	
	final Block block;

	public WorldGenMushroom(Block block) {
		this.block = block;
	}

	@Override
	public boolean generate(World world, Random random, int x, int y, int z) {
		for (int i = -2; i < 2; ++i) {
			y += i;
			Block down = world.getBlock(x, y - 1, z);
			if (down.getMaterial() == Material.ground || down.getMaterial() == Material.grass) {
				if (world.isAirBlock(x, y, z)) {
					world.setBlock(x, y, z, block, 0, 2);
					return true;
				}
			}
		}
		return false;
	}

}
