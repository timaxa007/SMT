package smt.pack.technology.api.object;

import net.minecraft.nbt.NBTTagCompound;

public abstract class TileEntityElectricDummy
extends net.minecraft.tileentity.TileEntity
implements smt.pack.technology.api.IElectricDummy {

	private int energy;
	private int energyMax;

	//Electric Power
	@Override
	public int addEnergy(int i) {
		if (i == 0) return i;
		else if (i > 0) {
			if (energyMax >= energy + i) {
				energy += i;
				return 0;
			}
			else if (energyMax > energy) {
				int remain = i - (energyMax - energy);
				energy = energyMax;
				return remain;
			}
		}
		else if (i < 0) {
			if (0 <= energy + i) {
				energy += i;
				return 0;
			}
			else if (0 < energy) {
				int remain = energy + i;
				energy = 0;
				return remain;
			}
		}
		return i;
	}

	public boolean isAddEnergy(int i) {
		if (i == 0) return false;
		else if (i > 0) {
			if (energyMax >= energy + i) {
				return true;
			}
			else if (energyMax > energy) {
				return true;
			}
		}
		else if (i < 0) {
			if (0 <= energy + i) {
				return true;
			}
			else if (0 < energy) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void setEnergy(int i) {
		energy = i;
	}

	@Override
	public int getEnergy() {
		return energy;
	}

	@Override
	public void setEnergyMax(int i) {
		energyMax = i;
	}

	@Override
	public int getEnergyMax() {
		return energyMax;
	}

	@Override
	public abstract int getRateMax();

	@Override
	public boolean isCharging() {
		return false;
	}

	@Override
	public boolean isDischarging() {
		return false;
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		setEnergy(nbt.getInteger("EPC"));
		setEnergyMax(nbt.getInteger("EPM"));
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setInteger("EPC", getEnergy());
		nbt.setInteger("EPM", getEnergyMax());
	}

}
