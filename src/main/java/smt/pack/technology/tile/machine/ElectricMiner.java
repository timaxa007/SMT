package smt.pack.technology.tile.machine;

import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.nbt.NBTTagCompound;

public class ElectricMiner extends ElectricMachine {

	int time = 0;
	int state_destroy = -1;

	int offsetXcurrent = 0;
	int offsetYcurrent = 0;
	int offsetZcurrent = 0;

	int offsetXa = 0;
	int offsetYa = 0;
	int offsetZa = 0;

	int offsetXb = 0;
	int offsetYb = 0;
	int offsetZb = 0;

	public ElectricMiner(smt.pack.technology.tile.TileEntityElectricMachine tile) {
		super(tile);
	}

	@Override
	public void update() {

		if (time > 0) --time;
		if (time == 0) time = 20 * 6;

		int p_y = tile.yCoord - 1;

		while (p_y > 0) {
			if (tile.getWorldObj().getBlock(tile.xCoord, p_y, tile.zCoord) != null && tile.getWorldObj().getBlock(tile.xCoord, p_y, tile.zCoord) != Blocks.air) break; else --p_y;
		}

		if (tile.getWorldObj().getBlock(tile.xCoord, p_y, tile.zCoord) != null && !tile.getWorldObj().isAirBlock(tile.xCoord, p_y, tile.zCoord)) {
			if (time % 10 == 0) ++state_destroy;
			if (state_destroy < 10)
				tile.getWorldObj().destroyBlockInWorldPartially(0, tile.xCoord, p_y, tile.zCoord, state_destroy);
			else {
				state_destroy = -1;
				tile.getWorldObj().func_147480_a(tile.xCoord, p_y, tile.zCoord, true);
			}
		}

		/*
		if (time > 0) {
			--time;
			tile.getWorldObj().destroyBlockInWorldPartially(0, tile.xCoord, offsetYcurrent, tile.zCoord, 1);
			offsetYcurrent = (offsetYa > offsetYb ? --offsetYcurrent : ++offsetYcurrent);
			System.out.println("time > 0 - " + time);
		} 
		if (time == 0) {
			offsetYa = tile.yCoord - 1;
			offsetYb = tile.yCoord - 10;
			double pY = (double)(offsetYa - offsetYb);
			time = (int)Math.sqrt(pY * pY);
			offsetYcurrent = offsetYa;
			System.out.println("time == 0 - " + time);
		}
		 */
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {

	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {

	}

}
