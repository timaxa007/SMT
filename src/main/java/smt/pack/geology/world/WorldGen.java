package smt.pack.geology.world;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class WorldGen implements IWorldGenerator {

	//int heightValue = world.getHeightValue(x, y);

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

		for (int x1 = chunkX; x1 < chunkX + 16; ++x1) {
			for (int y1 = 0; y1 < world.provider.getHeight(); ++y1) {
				for (int z1 = chunkZ; z1 < chunkZ + 16; ++z1) {

					if (world.getBlock(x1, y1, z1) == Blocks.log
							&& world.getBlockMetadata(x1, y1, z1) == 0)
						for (int j = -2; j <= 2; ++j) {
							for (int k = -2; k <= 2; ++k) {
								if (random.nextInt(10) == 0)
									new WorldGenMushroom(Blocks.brown_mushroom).generate(world, random, x1 + j, y1, z1 + k);
							}
						}

					if (world.getBlock(x1, y1, z1) == Blocks.log
							&& world.getBlockMetadata(x1, y1, z1) == 2)
						for (int j = -2; j <= 2; ++j) {
							for (int k = -2; k <= 2; ++k) {
								if (random.nextInt(10) == 0)
									new WorldGenMushroom(Blocks.red_mushroom).generate(world, random, x1 + j, y1, z1 + k);
							}
						}

				}
			}
		}

		new WorldGenMinable(Blocks.clay, 10).generate(world, random, randomX, randomY, randomZ);
	}

	private void generateNether(World world, Random random, int chunkX, int chunkZ) {
		int randomX = chunkX + 8 + random.nextInt(8) - 4;
		int randomY = (world.provider.getHeight() / 2) + random.nextInt(world.provider.getHeight() / 2);
		int randomZ = chunkZ + 8 + random.nextInt(8) - 4;

		new WorldGenMinable(Blocks.clay, 10, Blocks.netherrack).generate(world, random, randomX, randomY, randomZ);
	}  

	private void generateEnd(World world, Random random, int chunkX, int chunkZ) {
		int randomX = chunkX + 8 + random.nextInt(8) - 4;
		int randomY = (world.provider.getHeight() / 2) + random.nextInt(world.provider.getHeight() / 2);
		int randomZ = chunkZ + 8 + random.nextInt(8) - 4;

		new WorldGenMinable(Blocks.clay, 10, Blocks.end_stone).generate(world, random, randomX, randomY, randomZ);
	}

}
