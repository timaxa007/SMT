package mods.timaxa007.Pack.Mining.World;

import mods.timaxa007.Pack.Mining.PackMining;
import net.minecraft.world.WorldProvider;
import net.minecraft.world.biome.WorldChunkManagerHell;

public class WorldOnlyDay extends WorldProvider {

public void registerWorldChunkManager() {
worldChunkMgr = new WorldChunkManagerHell(PackMining.proxy.biome_test, 0.5F, 0.0F);
}

public boolean isSurfaceWorld() {
return false;
}
/*
public boolean canRespawnHere() {
return false;
}
*/
@Override
public String getDimensionName() {
return "Dimension Only Day";
}

}
