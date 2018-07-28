package smt.pack.technology.world;

import java.util.ArrayList;

import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class ChunkWireEnergy {

	final World world;
	public final int chunkX, chunkZ;
	public final ArrayList<WireLocations> wire_loc = new ArrayList<WireLocations>();

	public ChunkWireEnergy(World world, int chunkX, int chunkZ) {
		this.world = world;
		this.chunkX = chunkX;
		this.chunkZ = chunkZ;
	}

	public boolean is(int x, int y, int z) {
		for (WireLocations wl : wire_loc)
			if ((wl.posXa == x && wl.posYa == y && wl.posZa == z) || (wl.posXb == x && wl.posYb == y && wl.posZb == z))
				return true;
		return false;
	}

	public boolean add(int posXa, int posYa, int posZa, int posXb, int posYb, int posZb) {
		return wire_loc.add(new WireLocations(posXa, posYa, posZa, posXb, posYb, posZb));
	}

	public WireLocations get(int x, int y, int z) {
		for (WireLocations wl : wire_loc)
			if ((wl.posXa == x && wl.posYa == y && wl.posZa == z) || (wl.posXb == x && wl.posYb == y && wl.posZb == z))
				return wl;
		return null;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (obj instanceof ChunkWireEnergy) {
			ChunkWireEnergy cwe = (ChunkWireEnergy)obj;
			if (cwe == this) return true;
			else if (cwe.chunkX == this.chunkX && cwe.chunkZ == this.chunkZ) return true;
		}
		return false;
	}

}
