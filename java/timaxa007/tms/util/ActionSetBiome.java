package timaxa007.tms.util;

import net.minecraft.client.Minecraft;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.Chunk;
import timaxa007.tms.CoreTMS;
import timaxa007.tms.packet.MessageSetBiome;

public class ActionSetBiome {

	public static void setBiome(BiomeGenBase biome, World world, int x, int z) {
		setBiome(biome.biomeID, world, x, z);
	}

	public static void setBiome(int biomeID, World world, int x, int z) {
		if (world == null) world = Minecraft.getMinecraft().theWorld;
		if (world != null) {
		Chunk chunk = world.getChunkFromBlockCoords(x, z);
		byte[] array = chunk.getBiomeArray();
		array[((z & 0xF) << 4 | x & 0xF)] = ((byte)(biomeID & 0xFF));
		chunk.setBiomeArray(array);
		if (!world.isRemote) CoreTMS.network.sendToAll(new MessageSetBiome(biomeID, x, z));
		}
	}

}
