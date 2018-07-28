package smt.pack.technology.world;

import net.minecraft.util.AxisAlignedBB;

public class WireLocations {

	public final int posXa, posYa, posZa, posXb, posYb, posZb;
	private final AxisAlignedBB aabb;

	public WireLocations(int posXa, int posYa, int posZa, int posXb, int posYb, int posZb) {
		this.posXa = posXa;this.posYa = posYa;this.posZa = posZa;
		this.posXb = posXb;this.posYb = posYb;this.posZb = posZb;
		aabb = AxisAlignedBB.getBoundingBox(
		Math.min(posXa, posXb), Math.min(posYa, posYb), Math.min(posZa, posZb),
		Math.max(posXa, posXb) + 1, Math.max(posYa, posYb) + 1, Math.max(posZa, posZb) + 1);
		/*aabb = AxisAlignedBB.getBoundingBox(
				Math.min(posXa, posXb) + 0.5, Math.min(posYa, posYb) + 0.5, Math.min(posZa, posZb) + 0.5,
				Math.max(posXa, posXb) + 0.5, Math.max(posYa, posYb) + 0.5, Math.max(posZa, posZb) + 0.5);*/
		//aabb = aabb.expand(-0.625D, -0.625D, -0.625D);
	}

	public AxisAlignedBB getAABB() {
		return aabb;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
		if (obj instanceof WireLocations) {
			WireLocations wl = (WireLocations)obj;
			if (wl == this) return true;
			else if (wl.posXa == this.posXa && wl.posYa == this.posYa && wl.posZa == this.posZa &&
					wl.posXb == this.posXb && wl.posYb == this.posYb && wl.posZb == this.posZb) return true;
		}
		return false;
	}

}
