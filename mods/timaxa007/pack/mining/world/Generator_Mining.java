package mods.timaxa007.pack.mining.world;

import java.util.Random;

import mods.timaxa007.pack.mining.PackMining;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
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

(new WorldGenMinable(PackMining.proxy.blockRock.blockID, 12, 32, 
Block.netherrack.blockID)).generate(world, rand, chunkX + rand.nextInt(16), rand.nextInt(127), chunkZ + rand.nextInt(16));

}
 
public void generateSurface(World world, Random rand, int chunkX, int chunkY) {

for (int x = 0; x < 16; ++x) {
for (int y = 0; y < 16; ++y) {
for (int z = 1; z < world.getHeight(); ++z) {
if (world.getBiomeGenForCoords(chunkX + x, y).biomeID == 30 || world.getBiomeGenForCoords(chunkX + x, chunkY + y).biomeID == 31) {
if ((world.getBlockId(chunkX + x, z, chunkY + y) == Block.grass.blockID || world.getBlockId(chunkX + x, z, chunkY + y) == Block.netherrack.blockID)) {
world.setBlock(chunkX + x, z, chunkY + y, PackMining.proxy.blockRock.blockID);
}
}
}
}
}

/*
for (int j = 0;j<16;j++) {
int rdm = rand.nextInt(100);
if(rdm == 0) {
(new WorldGenMinable(PackMining.proxy.oreGemsLarge.blockID, j, 4, 
Block.stone.blockID)).generate(world, rand, chunkX + rand.nextInt(16), rand.nextInt(10), chunkZ + rand.nextInt(16));
}
}

for (int j = 0; j < 16; j++) {
int rdm = rand.nextInt(50);
if(rdm == 0) {
(new WorldGenMinable(PackMining.proxy.oreGemsMedium.blockID, j, 6, 
Block.stone.blockID)).generate(world, rand, chunkX + rand.nextInt(16), rand.nextInt(20), chunkZ + rand.nextInt(16));
}
}

for (int j = 0; j < 16; j++) {
int rdm = rand.nextInt(10);
if(rdm == 0) {
(new WorldGenMinable(PackMining.proxy.oreGemsSmall.blockID, j, 8, 
Block.stone.blockID)).generate(world, rand, chunkX + rand.nextInt(16), rand.nextInt(30), chunkZ + rand.nextInt(16));
}
}

for (int j = 0; j < 16; j++) {
(new WorldGenMinable(PackMining.proxy.blockRock.blockID, j, 16, 
Block.stone.blockID)).generate(world, rand, chunkX + rand.nextInt(16), rand.nextInt(96), chunkZ + rand.nextInt(16));
}

for (int j = 0; j < 16; j++) {
(new WorldGenMinable(PackMining.proxy.oreMetals.blockID, j, 8, 
Block.stone.blockID)).generate(world, rand, chunkX + rand.nextInt(16), rand.nextInt(60), chunkZ + rand.nextInt(16));
}
*/
}
 
public void generateEnd(World world, Random rand, int chunkX, int chunkZ) {

(new WorldGenMinable(PackMining.proxy.blockRock.blockID, 12, 32, 
Block.whiteStone.blockID)).generate(world, rand, chunkX + rand.nextInt(16), rand.nextInt(96), chunkZ + rand.nextInt(16));


}

}