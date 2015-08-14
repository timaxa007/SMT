package timaxa007.pack.mining.world;

import net.minecraft.world.World;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.WorldChunkManager;
import net.minecraft.world.biome.WorldChunkManagerHell;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.ChunkProviderFlat;
import net.minecraft.world.gen.ChunkProviderGenerate;
import net.minecraft.world.gen.FlatGeneratorInfo;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerBiome;
import net.minecraft.world.gen.layer.GenLayerBiomeEdge;
import net.minecraft.world.gen.layer.GenLayerZoom;

public class WorldSMT extends WorldType {

	public WorldSMT() {
		super("world_smt");
	}
	/*
	@Override
	public WorldChunkManager getChunkManager(World world) {
		if (this == FLAT) {
			FlatGeneratorInfo flatgeneratorinfo = FlatGeneratorInfo.createFlatGeneratorFromString(world.getWorldInfo().getGeneratorOptions());
			return new WorldChunkManagerHell(BiomeGenBase.getBiome(flatgeneratorinfo.getBiome()), 0.5F);
		} else {
			return new WorldChunkManager(world);
		}
	}

	@Override
	public IChunkProvider getChunkGenerator(World world, String generatorOptions) {
		return (this == FLAT ? new ChunkProviderFlat(world, world.getSeed(), world.getWorldInfo().isMapFeaturesEnabled(), generatorOptions) : new ChunkProviderGenerate(world, world.getSeed(), world.getWorldInfo().isMapFeaturesEnabled()));
	}
	 */
	@Override
	public int getMinimumSpawnHeight(World world) {
		return 94;
	}

	@Override
	public double getHorizon(World world) {
		return 93.0D;
	}
	/*
	@Override
	public boolean hasVoidParticles(boolean flag) {
		return this != FLAT && !flag;
	}

	@Override
	public double voidFadeMagnitude() {
		return this == FLAT ? 1.0D : 0.03125D;
	}
	 */
	@Override
	public float getCloudHeight() {
		return 230.0F;
	}

	@Override
	public GenLayer getBiomeLayer(long worldSeed, GenLayer parentLayer) {
		GenLayer ret = new GenLayerBiome(200L, parentLayer, this);
		ret = GenLayerZoom.magnify(1000L, ret, 2);
		ret = new GenLayerBiomeEdge(1000L, ret);
		return ret;
	}

}
