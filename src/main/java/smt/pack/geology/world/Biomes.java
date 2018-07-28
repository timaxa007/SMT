package smt.pack.geology.world;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;

public class Biomes {

	public static final BiomeGenBase
	test = new BiomeGenTest(nextBiomeID()),
	light = new BiomeGenLight(nextBiomeID()),
	dark = new BiomeGenDark(nextBiomeID());

	public static final void init() {
		BiomeDictionary.registerBiomeType(test, BiomeDictionary.Type.PLAINS);
		BiomeDictionary.registerBiomeType(light, BiomeDictionary.Type.MAGICAL, BiomeDictionary.Type.PLAINS);
		BiomeDictionary.registerBiomeType(dark, BiomeDictionary.Type.MAGICAL, BiomeDictionary.Type.DEAD);
		/*
		BiomeManager.addSpawnBiome(test);
		BiomeManager.addSpawnBiome(light);
		BiomeManager.addSpawnBiome(dark);
		 */
		BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(test, 100));
		BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(light, 100));
		BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(dark, 100));
	}

	public static final int nextBiomeID() {
		BiomeGenBase[] biomes = BiomeGenBase.getBiomeGenArray();
		for (int i = 40; i < biomes.length; ++i)
			if (biomes[i] == null) return i;
		return -1;
	}

}
