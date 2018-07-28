package smt.pack.magic.world;

import java.util.ArrayList;
import java.util.HashMap;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.ChunkPosition;
import net.minecraft.world.World;
import net.minecraft.world.WorldSavedData;
import net.minecraft.world.chunk.Chunk;

public class ChunkPower extends WorldSavedData {

	public static final String TAG = "ChunkPower";
	private HashMap<Chunk, ArrayList<ChunkPosition>> map = new HashMap<Chunk, ArrayList<ChunkPosition>>();
	private World world;

	public ChunkPower(String tag) {
		super(tag);
	}

	public boolean hasAdd(int x, int y, int z) {
		Chunk chunk = world.getChunkFromBlockCoords(x, z);
		ArrayList<ChunkPosition> list;
		if (map.containsKey(chunk)) {
			list = map.get(chunk);
			for (ChunkPosition pos : list) {
				if (pos.chunkPosX == x && pos.chunkPosY == y && pos.chunkPosZ == z)
					return false;
			}
		}
		return true;
	}

	public void add(int x, int y, int z) {
		Chunk chunk = world.getChunkFromBlockCoords(x, z);
		ArrayList<ChunkPosition> list;
		if (map.containsKey(chunk)) {
			list = map.get(chunk);
			list.add(new ChunkPosition(x, y, z));
		} else {
			list = new ArrayList<ChunkPosition>();
			list.add(new ChunkPosition(x, y, z));
			map.put(chunk, list);
		}
	}

	public boolean remove(int x, int y, int z) {
		Chunk chunk = world.getChunkFromBlockCoords(x, z);
		if (map.containsKey(chunk)) {
			ArrayList<ChunkPosition> list = map.get(chunk);
			for (int i = 0; i < list.size(); ++i) {
				ChunkPosition pos = list.get(i);
				if (pos.chunkPosX == x && pos.chunkPosY == y && pos.chunkPosZ == z) {
					list.remove(i);
					return true;
				}
			}
		}
		return false;
	}

	public ChunkPower setWorld(World world) {
		this.world = world;
		return this;
	}

	public static ChunkPower get(World world) {
		if (world.mapStorage == null) return null;

		ChunkPower data = (ChunkPower)world.mapStorage.loadData(ChunkPower.class, TAG);

		if (data == null) {
			data = new ChunkPower(TAG);
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
