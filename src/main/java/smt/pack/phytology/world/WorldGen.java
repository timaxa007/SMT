package smt.pack.phytology.world;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGen implements IWorldGenerator {

	static final WorldGenerator
	gen1 = new WorldGenTwoTree();
	;

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.dimensionId) {
		case 0 :generateSurface(world, random, chunkX * 16, chunkZ * 16);break;
		case -1 :generateNether(world, random, chunkX * 16, chunkZ * 16);break;
		case 1 :generateEnd(world, random, chunkX * 16, chunkZ * 16);break;
		}
	}

	private void generateSurface(World world, Random random, int chunkX, int chunkZ) {
		int randomX = chunkX + 8 + random.nextInt(8) - 4;
		int randomY = (world.provider.getHeight() / 2) + random.nextInt(world.provider.getHeight() / 2);
		int randomZ = chunkZ + 8 + random.nextInt(8) - 4;
		int heightValue = world.getHeightValue(randomX, randomZ);

		if (world.getBlock(randomX, heightValue, randomZ).isReplaceable(world, randomX, heightValue, randomZ) && (
				world.getBlock(randomX, heightValue - 1, randomZ).getMaterial() == Material.grass ||
				world.getBlock(randomX, heightValue - 1, randomZ).getMaterial() == Material.ground
				))
			gen1.generate(world, random, randomX, heightValue, randomZ);

	}

	private void generateNether(World world, Random random, int chunkX, int chunkZ) {

	}

	private void generateEnd(World world, Random random, int chunkX, int chunkZ) {

	}

}
