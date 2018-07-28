package smt.pack.technology.world;

import java.util.ArrayList;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraft.world.WorldSavedData;

public class WorldWireEnergy extends WorldSavedData {

	public static final String TAG = "WorldWireEnergy";
	World world;

	public final ArrayList<ChunkWireEnergy> load_chunk_wire_energy = new ArrayList<ChunkWireEnergy>();
	public final ArrayList<ChunkWireEnergy> unload_chunk_wire_energy = new ArrayList<ChunkWireEnergy>();
	public final ArrayList<GroupWireEnergy> group_wire_energy = new ArrayList<GroupWireEnergy>();
	public final ArrayList<SourceEnergy> source_energy = new ArrayList<SourceEnergy>();

	public boolean debug = false;

	public WorldWireEnergy(String tag) {
		super(tag);
	}

	public boolean is(int x, int y, int z) {
		int chunkX = x / 16;
		int chunkZ = z / 16;

		for (ChunkWireEnergy cwe : load_chunk_wire_energy) {
			if (cwe.chunkX == chunkX && cwe.chunkZ == chunkZ)
				return cwe.is(x, y, z);
			else continue;
		}

		return false;
	}

	public boolean add(int posXa, int posYa, int posZa, int posXb, int posYb, int posZb) {
		int chunkX = posXa / 16;
		int chunkZ = posZa / 16;

		for (ChunkWireEnergy cwe : load_chunk_wire_energy) {
			if (cwe.chunkX == chunkX && cwe.chunkZ == chunkZ) {
				cwe.add(posXa, posYa, posZa, posXb, posYb, posZb);
				return true;
			} else continue;
		}

		ChunkWireEnergy cwe = new ChunkWireEnergy(world, chunkX, chunkZ);
		cwe.add(posXa, posYa, posZa, posXb, posYb, posZb);
		load_chunk_wire_energy.add(cwe);
		return true;
	}

	public WireLocations get(int x, int y, int z) {
		int chunkX = x / 16;
		int chunkZ = z / 16;

		for (ChunkWireEnergy cwe : load_chunk_wire_energy) {
			if (cwe.chunkX == chunkX && cwe.chunkZ == chunkZ) {
				return cwe.get(x, y, z);
			} else continue;
		}

		return null;
	}

	public void loadChunk(int chunkX, int chunkZ) {
		for (ChunkWireEnergy cwe : load_chunk_wire_energy) {
			if (cwe.chunkX == chunkX && cwe.chunkZ == chunkZ) {
				load_chunk_wire_energy.add(cwe);
				unload_chunk_wire_energy.remove(cwe);
				break;
			} else continue;
		}
	}

	public void unloadChunk(int chunkX, int chunkZ) {
		for (ChunkWireEnergy cwe : unload_chunk_wire_energy) {
			if (cwe.chunkX == chunkX && cwe.chunkZ == chunkZ) {
				unload_chunk_wire_energy.add(cwe);
				load_chunk_wire_energy.remove(cwe);
				break;
			} else continue;
		}
	}

	public WorldWireEnergy setWorld(World world) {
		this.world = world;
		return this;
	}

	public static WorldWireEnergy get(World world) {
		if (world.mapStorage == null) return null;
		WorldWireEnergy data = (WorldWireEnergy)world.mapStorage.loadData(WorldWireEnergy.class, TAG);
		if (data == null) {
			data = new WorldWireEnergy(TAG);
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
