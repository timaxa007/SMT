package smt.pack.technology.tile.machine;

import net.minecraft.inventory.IInventory;
import net.minecraft.nbt.NBTTagCompound;

public class ElectricBreaker extends ElectricMachine {

	int time = 0;
	int state_destroy = -1;

	public ElectricBreaker(smt.pack.technology.tile.TileEntityElectricMachine tile) {
		super(tile);
	}

	@Override
	public void update() {

		if (time > 0) --time;
		if (time == 0) time = 20 * 60;

		if (!tile.getWorldObj().isAirBlock(tile.xCoord, tile.yCoord - 1, tile.zCoord)) {
			if (time % 10 == 0) ++state_destroy;
			if (state_destroy < 10)
				tile.getWorldObj().destroyBlockInWorldPartially(0, tile.xCoord, tile.yCoord - 1, tile.zCoord, state_destroy);
			else {
				state_destroy = -1;
				tile.getWorldObj().func_147480_a(tile.xCoord, tile.yCoord - 1, tile.zCoord, true);
			}
		}

	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {

	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {

	}

}
