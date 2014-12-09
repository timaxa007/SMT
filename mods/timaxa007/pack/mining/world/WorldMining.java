package mods.timaxa007.pack.mining.world;

import mods.timaxa007.pack.mining.PackMining;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class WorldMining extends WorldProvider {

public void registerWorldChunkManager() {
worldChunkMgr = new WorldChunkManagerHell(PackMining.proxy.biome_hot, 1.0F, 0.5F);
//isHellWorld = true;
//hasNoSky = true;
//dimensionId = -1;
}
/*
@SideOnly(Side.CLIENT)
public Vec3 getFogColor(float par1, float par2) {
return worldObj.getWorldVec3Pool().getVecFromPool(0.20000000298023224D, 0.029999999329447746D, 0.029999999329447746D);
}*/
/*
protected void generateLightBrightnessTable() {
float f = 0.1F;
for (int i = 0; i <= 15; ++i) {
float f1 = 1.0F - (float)i / 15.0F;
lightBrightnessTable[i] = (1.0F - f1) / (f1 * 3.0F + 1.0F) * (1.0F - f) + f;
}
}*/
/*
public IChunkProvider createChunkGenerator() {
return new ChunkProviderHell(worldObj, worldObj.getSeed());
}*/

public boolean isSurfaceWorld() {
return false;
}

public boolean canCoordinateBeSpawn(int par1, int par2) {
return false;
}

public float calculateCelestialAngle(long par1, float par3) {
return 0.5F;
}

public boolean canRespawnHere() {
return false;
}

@SideOnly(Side.CLIENT)
public boolean doesXZShowFog(int par1, int par2) {
return true;
}

@Override
public String getDimensionName() {
return "Dimension Mining";
}

}