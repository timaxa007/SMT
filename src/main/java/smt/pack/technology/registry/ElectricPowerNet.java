package smt.pack.technology.registry;

import java.util.ArrayList;

import javax.annotation.Nonnull;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class ElectricPowerNet {

	@Nonnull public static final ElectricPowerNet INSTANCE = new ElectricPowerNet();

	World world;

	//final ArrayList<ChunkEnergy> all_chunk = new ArrayList<ChunkEnergy>();

	public void readFromNBT(NBTTagCompound nbt) {}

	public void writeToNBT(NBTTagCompound nbt) {}

	public static class EnergyNetGroup {

		//public final ArrayList<PosE> input = new ArrayList<PosE>();
		public final ArrayList<PosE> output = new ArrayList<PosE>();
		public final ArrayList<PosE> other = new ArrayList<PosE>();
		public int energy;

		public static class PosE {

			public final int x, y, z;

			public PosE(int x, int y, int z) {
				this.x = x;
				this.y = y;
				this.z = z;
			}

		}

	}

}
