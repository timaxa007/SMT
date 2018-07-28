package smt.pack.technology.world;

import java.util.Arrays;

import net.minecraft.world.World;

public class ChunkEnergy {

	final World world;
	public final int chunkX, chunkZ;
	byte[] map;

	public ChunkEnergy(World world, int chunkX, int chunkZ) {
		this(world, chunkX, chunkZ, world.getHeight());
	}

	public ChunkEnergy(World world, int chunkX, int chunkZ, int height) {
		this.world = world;
		this.chunkX = chunkX;
		this.chunkZ = chunkZ;
		map = new byte[16 * 16 * height];
		Arrays.fill(map, (byte)-1);
	}

	public boolean isEnergy(int x, int y, int z) {
		//System.out.println("x = " + x + ", y = " + y + ", z = " + z + ".");
		return map[y << 8 | x << 4 | z] != -1;
	}

	public void addEnergy(int x, int y, int z, byte egergy) {
		//System.out.println("x = " + x + ", y = " + y + ", z = " + z + ".");
		map[y << 8 | x << 4 | z] = egergy;
	}

	public byte getEnergy(int x, int y, int z) {
		//System.out.println("x = " + x + ", y = " + y + ", z = " + z + ".");
		return map[y << 8 | x << 4 | z];
	}

}
