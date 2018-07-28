package smt.pack.geology.world;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class StructurePost extends WorldGenerator {

	public boolean generate(World world, Random random, int x, int y, int z) {
		world.setBlock(x, y + 2, z, Blocks.diamond_block);
		world.setBlock(x, y + 1, z, Blocks.diamond_block);
		world.setBlock(x, y, z, Blocks.diamond_block);
		return false;
	}

}
