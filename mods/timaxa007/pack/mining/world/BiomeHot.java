package mods.timaxa007.pack.mining.world;

import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeHot extends BiomeGenBase {

public BiomeHot() {
super(id);
biomeName = "Hot Biome";
topBlock = (byte)Block.netherrack.blockID;
fillerBlock = (byte)Block.stone.blockID;
waterColorMultiplier = 14185574;
}

}