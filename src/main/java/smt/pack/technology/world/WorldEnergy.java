package smt.pack.technology.world;

import java.util.ArrayList;
import java.util.HashMap;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.WorldSavedData;
import net.minecraft.world.chunk.Chunk;

public class WorldEnergy extends WorldSavedData {

	public static final String TAG = "WorldEnergy";
	World world;

	final ArrayList<ChunkEnergy> load_chunk_energy = new ArrayList<ChunkEnergy>();
	final ArrayList<ChunkEnergy> unload_chunk_energy = new ArrayList<ChunkEnergy>();

	public boolean debug = false;

	public WorldEnergy(String tag) {
		super(tag);
	}

	public boolean is(int x, int y, int z) {
		int chunkX = x / 16;
		int chunkZ = z / 16;

		for (ChunkEnergy ce : load_chunk_energy) {
			if (ce.chunkX == chunkX && ce.chunkZ == chunkZ) {
				return ce.isEnergy(x & 15, y, z & 15);
			} else continue;
		}

		return false;
	}

	public boolean add(int x, int y, int z, byte egergy) {
		int chunkX = x / 16;
		int chunkZ = z / 16;

		for (ChunkEnergy ce : load_chunk_energy) {
			if (ce.chunkX == chunkX && ce.chunkZ == chunkZ) {
				ce.addEnergy(x & 15, y, z & 15, egergy);
				return true;
			} else continue;
		}

		ChunkEnergy ce = new ChunkEnergy(world, chunkX, chunkZ);
		ce.addEnergy(x & 15, y, z & 15, egergy);
		load_chunk_energy.add(ce);
		return true;
	}

	public byte get(int x, int y, int z) {
		int chunkX = x / 16;
		int chunkZ = z / 16;

		for (ChunkEnergy ce : load_chunk_energy) {
			if (ce.chunkX == chunkX && ce.chunkZ == chunkZ) {
				return ce.getEnergy(x & 15, y, z & 15);
			} else continue;
		}

		return (byte)-1;
	}

	public void loadChunk(int chunkX, int chunkZ) {
		for (ChunkEnergy ce : load_chunk_energy) {
			if (ce.chunkX == chunkX && ce.chunkZ == chunkZ) {
				load_chunk_energy.add(ce);
				unload_chunk_energy.remove(ce);
				break;
			} else continue;
		}
	}

	public void unloadChunk(int chunkX, int chunkZ) {
		for (ChunkEnergy ce : unload_chunk_energy) {
			if (ce.chunkX == chunkX && ce.chunkZ == chunkZ) {
				unload_chunk_energy.add(ce);
				load_chunk_energy.remove(ce);
				break;
			} else continue;
		}
	}

	public WorldEnergy setWorld(World world) {
		this.world = world;
		return this;
	}

	public static WorldEnergy get(World world) {
		if (world.mapStorage == null) return null;
		WorldEnergy data = (WorldEnergy)world.mapStorage.loadData(WorldEnergy.class, TAG);
		if (data == null) {
			data = new WorldEnergy(TAG);
			data.markDirty();
			world.mapStorage.setData(TAG, data);
		}
		data.setWorld(world);
		return data;
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {

	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {

	}

}
