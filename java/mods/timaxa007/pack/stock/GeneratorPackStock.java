package mods.timaxa007.pack.stock;

import java.util.Random;

import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import cpw.mods.fml.common.IWorldGenerator;

public class GeneratorPackStock implements IWorldGenerator {

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		switch(world.provider.dimensionId) {
		case -1:generateNether(world, random, chunkX * 16, chunkZ * 16);break;
		case 0:generateSurface(world, random, chunkX * 16, chunkZ * 16);break;
		case 1:generateEnd(world, random, chunkX * 16, chunkZ * 16);break;
		}
	}

	private void generateEnd(World world, Random random, int x, int y) {

	}

	private void generateSurface(World world, Random random, int x, int y) {

		int x1 = x + random.nextInt(16);
		int y1 = y + random.nextInt(16);
		/*
		if (world.getBiomeGenForCoords(x, y).biomeID == BiomeGenBase.forest.biomeID || world.getBiomeGenForCoords(x, y).biomeID == BiomeGenBase.forestHills.biomeID) {
			for (int z = 1; z < world.getHeight(); ++z) {
				if (world.getBlock(x1, z - 1, y1) == Block.grass && world.isAirBlock(x1, z, y1)) {
					world.setBlock(x1, z, y1, PackStock.proxy.block_saplings);
					TileEntitySaplings te = new TileEntitySaplings();
					te.setType("oak");
					te.setHeight(1);
					te.setThickness(1);
					world.setTileEntity(x1, z, y1, te);
				}
			}
		}
		 */
		/*
		if (world.getBiomeGenForCoords(x, y).biomeID == BiomeGenBase.ocean.biomeID) {
			for (int z = 1; z < world.getHeight(); ++z) {
				if (world.getBlock(x1, z - 1, y1) == Block.sand && world.getBlockMaterial(x1, z, y1) == Material.water) {
					world.setBlock(x1, z, y1, PackStock.proxy.blockSapling2);
				}
			}
		}
		 */
		/*
		if (world.getBiomeGenForCoords(x, y).biomeID == 30 || world.getBiomeGenForCoords(x, y).biomeID == 31) {
			for (int z = 1; z < world.getHeight(); ++z) {
				for (int x2 = 0; x2 < 16; ++x2) {
					for (int y2 = 0; y2 < 16; ++y2) {
						if ((world.getBlock(x + x2, z - 1, y + y2) == Block.grass || world.getBlock(x + x2, z - 1, y + y2) == Block.netherrack) && world.isAirBlock(x + x2, z, y + y2)) {
							world.setBlock(x + x2, z, y + y2, PackStock.proxy.blockSapling2);
						}
					}
				}
			}
		}
		 */
	}

	private void generateNether(World world, Random random, int x, int y) {

	}

}
