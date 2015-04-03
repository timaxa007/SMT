package timaxa007.pack.stock.world;

import java.util.Random;

import timaxa007.pack.stock.PackStock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
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

	private void generateSurface(World world, Random random, int x, int z) {
		/*
		//if (world.getBiomeGenForCoords(x, z).biomeID == BiomeGenBase.extremeHills.biomeID || world.getBiomeGenForCoords(x, z).biomeID == BiomeGenBase.extremeHillsEdge.biomeID) {
		for (int y = 0; y < world.provider.getHeight(); y++) {
			int x1 = 8 + (x + random.nextInt(8));
			int z1 = 8 + (z + random.nextInt(8));
			for (int j = 0; j < 16; j++) {
				for (int x2 = -2; x2 <= 2; ++x2) {
					for (int z2 = -2; z2 <= 2; ++z2) {
						if (world.getBlock(x1 + x2, y - 1, z1 + z2) == Blocks.grass && world.isAirBlock(x1 + x2, y, z1 + z2)) {
							if (random.nextInt(25) == 5) {
								world.setBlock(x1 + x2, y, z1 + z2, PackStock.block.healing, random.nextInt(15), 3);
							}
						}
					}
				}
			}
		}
		//}
		 */

		//if (world.getBiomeGenForCoords(x, z) == BiomeGenBase.forest || world.getBiomeGenForCoords(x, z) == BiomeGenBase.forestHills) {

		x += world.rand.nextInt(16);
		z += world.rand.nextInt(16);
		int h_tree = 6;
		int w_tree = 3;

		if (world.rand.nextInt(10) == 0) {
			for (int y = 1; y < world.getHeight(); ++y) {
				if (world.getBlock(x, y - 1, z) == Blocks.grass && is_tree1wood(world, x, y, z)) {
					//ствол
					for (int i = 0; i <= h_tree; i++) world.setBlock(x, y + i, z, Blocks.stone, 0, 4);
					//листва
					for (int i = 5; i <= (h_tree + 2); i++) {
						for (int j = -(w_tree); j <= w_tree; j++) {
							for (int k = -(w_tree); k <= w_tree; k++) {
								if (
										(j == -(w_tree) && k == -(w_tree)) || 
										(j == w_tree && k == w_tree) || 
										(j == -(w_tree) && k == w_tree) || 
										(j == w_tree && k == -(w_tree)) || 

										(j == -(w_tree - 1) && k == -(w_tree)) || 
										(j == w_tree - 1 && k == w_tree) || 
										(j == -(w_tree - 1) && k == w_tree) || 
										(j == w_tree - 1 && k == -(w_tree)) || 

										(j == -(w_tree) && k == -(w_tree - 1)) || 
										(j == w_tree && k == w_tree - 1) || 
										(j == -(w_tree) && k == w_tree - 1) || 
										(j == w_tree && k == -(w_tree - 1))

										) {
									;
								} else if (world.isAirBlock(x + j, y + i, z + k)) {
									world.setBlock(x + j, y + i, z + k, Blocks.glowstone, 0, 4);
								} else {
									;
								}
							}
						}
					}

				}
			}
		}
		//}
		/*
		if (world.getBiomeGenForCoords(x, z) == BiomeGenBase.forest || world.getBiomeGenForCoords(x, z) == BiomeGenBase.forestHills) {
			for (int y = 1; y < world.getHeight(); ++y) {
				for (int x1 = x; x < x + 16; x1++) {
					for (int z1 = z; z < z + 16; z1++) {
						if (world.getBlock(x1, y - 1, z1) == Blocks.grass && world.isAirBlock(x1, y, z1)) {
							world.setBlock(x1, y, z1, PackStock.block.germination_plants);
						}
					}
				}
			}
		}

		if (world.getBiomeGenForCoords(x, z) == BiomeGenBase.swampland) {
			for (int y = 1; y < world.getHeight(); ++y) {
				for (int x1 = x; x < x + 16; x1++) {
					for (int z1 = z; z < z + 16; z1++) {

						if (world.rand.nextInt(13) == 0) {

							if (world.getBlock(x1, y - 1, z1) == Blocks.grass && world.isAirBlock(x1, y, z1) && 
									(world.getBlock(x1 + 1, y - 1, z1).getMaterial() == Material.water || 
									world.getBlock(x1 - 1, y - 1, z1).getMaterial() == Material.water || 
									world.getBlock(x1, y - 1, z1 + 1).getMaterial() == Material.water || 
									world.getBlock(x1, y - 1, z1 - 1).getMaterial() == Material.water)) {
								world.setBlock(x1, y, z1, PackStock.block.germination_plants);
							}
						}

					}

				}
			}
		}
		 */
		/*
		 * if (world.getBiomeGenForCoords(x, z).biomeID == BiomeGenBase.forest.biomeID || world.getBiomeGenForCoords(x, z).biomeID == BiomeGenBase.forestHills.biomeID) {
			for (int y = 1; y < world.getHeight(); ++y) {
				if (world.getBlock(x1, y - 1, z1) == Blocks.grass && world.isAirBlock(x1, y, z1)) {
					world.setBlock(x1, y, z1, PackStock.block.saplings);
					TileEntitySaplings te = new TileEntitySaplings();
					te.setType("oak");
					te.setHeight(1);
					te.setThickness(1);
					world.setTileEntity(x1, y, y1, te);
				}
			}
		}
		 */
		/*
		if (world.getBiomeGenForCoords(x, y) == BiomeGenBase.ocean) {
			for (int z = 1; z < world.getHeight(); ++z) {
				if (world.getBlock(x1, z - 1, y1) == Block.sand && world.getBlockMaterial(x1, z, y1) == Material.water) {
					world.setBlock(x1, z, y1, PackStock.blockSapling2);
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
							world.setBlock(x + x2, z, y + y2, PackStock.blockSapling2);
						}
					}
				}
			}
		}
		 */
	}

	public static boolean is_tree1wood(World world, int x, int y, int z) {
		if (world.isAirBlock(x, y, z) && 
				world.isAirBlock(x, y + 1, z) && 
				world.isAirBlock(x, y + 2, z) && 
				world.isAirBlock(x, y + 3, z) && 
				world.isAirBlock(x, y + 4, z) && 
				world.isAirBlock(x, y + 5, z) && 
				world.isAirBlock(x, y + 6, z) && 
				world.isAirBlock(x, y + 7, z) && 
				world.isAirBlock(x, y + 8, z)) {
			return true;
		}
		return false;
	}

	private void generateNether(World world, Random random, int x, int y) {

	}

}
