package smt.pack.technology.tile.machine;

import net.minecraft.inventory.IInventory;
import net.minecraft.nbt.NBTTagCompound;

public class ElectricGenerator extends ElectricMachine {

	public ElectricGenerator(smt.pack.technology.tile.TileEntityElectricMachine tile) {
		super(tile);
	}

	@Override
	public void update() {
		int i = 1;
		if (tile.getEnergy().isAddEnergy(i))
			tile.getEnergy().addEnergy(i);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {

	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {

	}

}
