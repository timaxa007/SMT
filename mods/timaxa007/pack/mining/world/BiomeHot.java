package mods.timaxa007.pack.mining.world;

import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeHot extends BiomeGenBase {

public BiomeHot() {
super();
biomeName = "Hot Biome";
topBlock = (byte)Block.netherrack;
fillerBlock = (byte)Block.stone;
waterColorMultiplier = 14185574;
}

}