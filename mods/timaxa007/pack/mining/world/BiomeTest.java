package mods.timaxa007.pack.mining.world;

import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;

public class BiomeTest extends BiomeGenBase{

public BiomeTest(int id) {
super(id);
setBiomeName("Test Biome");
//setMinMaxHeight(-1.0F, 0.5F);
setTemperatureRainfall(1.0F, 0.6F);
this.topBlock=(byte)Block.grass.blockID;
this.fillerBlock=(byte)Block.dirt.blockID;
this.color=0x0000FF;
this.waterColorMultiplier=0x00FF00;
}

}