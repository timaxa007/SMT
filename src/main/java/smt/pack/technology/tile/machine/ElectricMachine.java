package smt.pack.technology.tile.machine;

import net.minecraft.inventory.IInventory;
import net.minecraft.nbt.NBTTagCompound;
import smt.pack.technology.tile.TileEntityElectricMachine;

public abstract class ElectricMachine {

	public final TileEntityElectricMachine tile;

	public ElectricMachine(TileEntityElectricMachine tile) {
		this.tile = tile;
	}

	public abstract void update();

	public abstract void readFromNBT(NBTTagCompound nbt);
	public abstract void writeToNBT(NBTTagCompound nbt);

}
