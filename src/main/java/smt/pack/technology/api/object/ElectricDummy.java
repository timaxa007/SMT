package smt.pack.technology.api.object;

import net.minecraft.nbt.NBTTagCompound;

public class ElectricDummy implements smt.pack.technology.api.IElectricDummy {

	private int energy;
	private int energyMax;
	private int rate;

	public ElectricDummy() {
		setEnergy(0);
		setEnergyMax(0);
		setRateMax(0);
	}

	public ElectricDummy(int energy, int energyMax) {
		setEnergy(energy);
		setEnergyMax(energyMax);
		setRateMax(0);
	}

	public ElectricDummy(int energy, int energyMax, int rate) {
		setEnergy(energy);
		setEnergyMax(energyMax);
		setRateMax(rate);
	}

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

	public void setRateMax(int i) {
		rate = i;
	}

	@Override
	public int getRateMax() {
		return rate;
	}

	@Override
	public boolean isCharging() {
		return false;
	}

	@Override
	public boolean isDischarging() {
		return false;
	}

	public void readFromNBT(NBTTagCompound nbt) {
		setEnergy(nbt.getInteger("EPC"));
		setEnergyMax(nbt.getInteger("EPM"));
	}

	public void writeToNBT(NBTTagCompound nbt) {
		nbt.setInteger("EPC", getEnergy());
		nbt.setInteger("EPM", getEnergyMax());
	}

}
