package mods.timaxa007.pack.mining.world;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;

public class Generator_Mining implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.dimensionId) {
		case -1:generateNether(world, random, chunkX * 16, chunkZ * 16);break;
		case 0:generateSurface(world, random, chunkX * 16, chunkZ * 16);break;
		case 1:generateEnd(world, random, chunkX * 16, chunkZ * 16);break;
		}
	}

	public void generateNether(World world, Random rand, int chunkX, int chunkZ) {
/*
		(new WorldGenMinable(PackMining.proxy.blockRock, 12, 32, 
				Blocks.netherrack)).generate(world, rand, chunkX + rand.nextInt(16), rand.nextInt(127), chunkZ + rand.nextInt(16));
*/
	}

	public void generateSurface(World world, Random rand, int chunkX, int chunkY) {
/*
		for (int x = 0; x < 16; ++x) {
			for (int y = 0; y < 16; ++y) {
				for (int z = 1; z < world.getHeight(); ++z) {
					if (world.getBiomeGenForCoords(chunkX + x, y).biomeID == 30 || world.getBiomeGenForCoords(chunkX + x, chunkY + y).biomeID == 31) {
						if ((world.getBlock(chunkX + x, z, chunkY + y) == Blocks.grass || world.getBlock(chunkX + x, z, chunkY + y) == Blocks.netherrack)) {
							world.setBlock(chunkX + x, z, chunkY + y, PackMining.proxy.blockRock);
						}
					}
				}
			}
		}


		for (int j = 0;j<16;j++) {
			int rdm = rand.nextInt(100);
			if (rdm == 0) {
				(new WorldGenMinable(PackMining.proxy.oreGemsLarge, j, 4, 
						Block.stone)).generate(world, rand, chunkX + rand.nextInt(16), rand.nextInt(10), chunkZ + rand.nextInt(16));
			}
		}

		for (int j = 0; j < 16; j++) {
			int rdm = rand.nextInt(50);
			if (rdm == 0) {
				(new WorldGenMinable(PackMining.proxy.oreGemsMedium, j, 6, 
						Block.stone)).generate(world, rand, chunkX + rand.nextInt(16), rand.nextInt(20), chunkZ + rand.nextInt(16));
			}
		}

		for (int j = 0; j < 16; j++) {
			int rdm = rand.nextInt(10);
			if (rdm == 0) {
				(new WorldGenMinable(PackMining.proxy.oreGemsSmall, j, 8, 
						Block.stone)).generate(world, rand, chunkX + rand.nextInt(16), rand.nextInt(30), chunkZ + rand.nextInt(16));
			}
		}

		for (int j = 0; j < 16; j++) {
			(new WorldGenMinable(PackMining.proxy.blockRock, j, 16, 
					Block.stone)).generate(world, rand, chunkX + rand.nextInt(16), rand.nextInt(96), chunkZ + rand.nextInt(16));
		}

		for (int j = 0; j < 16; j++) {
			(new WorldGenMinable(PackMining.proxy.oreMetals, j, 8, 
					Block.stone)).generate(world, rand, chunkX + rand.nextInt(16), rand.nextInt(60), chunkZ + rand.nextInt(16));
		}
*/
	}

	public void generateEnd(World world, Random rand, int chunkX, int chunkZ) {
/*
		(new WorldGenMinable(PackMining.proxy.blockRock, 12, 32, 
				Blocks.end_stone)).generate(world, rand, chunkX + rand.nextInt(16), rand.nextInt(96), chunkZ + rand.nextInt(16));
*/
	}

}