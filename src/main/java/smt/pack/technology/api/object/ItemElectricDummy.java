package smt.pack.technology.api.object;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.common.util.Constants.NBT;

public abstract class ItemElectricDummy
extends net.minecraft.item.Item
implements smt.pack.technology.api.IElectricItem {

	//Electric Power
	/*
	@Override
	public int addEnergy(ItemStack item, int i) {
		NBTTagCompound ept = checkEPT(item);
		NBTTagCompound nbt = item.getTagCompound();

		eet.setInteger("EPC", eet.getInteger("EPC") + i);

		nbt.setTag("EPT", eet);
		item.setTagCompound(nbt);
		return i;
	}
	 */
	@Override
	public int addEnergy(ItemStack item, int i) {
		if (i == 0) return i;

		int energy = getEnergy(item);
		if (energy == -1) return 0;

		int energyMax = getEnergyMax(item);
		if (energyMax == -1) return 0;


		if (i > 0 && isCharging(item)) {
			if (energyMax >= energy + i) {
				setEnergy(item, energy + i);
				return 0;
			}
			else if (energyMax > energy) {
				int remain = i - (energyMax - energy);
				setEnergy(item, energyMax);
				return remain;
			}
		}
		else if (i < 0 && isDischarging(item)) {
			if (0 <= energy + i) {
				setEnergy(item, energy + i);
				return 0;
			}
			else if (0 < energy) {
				int remain = energy + i;
				setEnergy(item, 0);
				return remain;
			}

		}
		return i;
	}

	public boolean isAddEnergy(ItemStack item, int i) {
		if (i == 0) return false;

		int energy = getEnergy(item);
		if (energy == -1) return false;

		int energyMax = getEnergyMax(item);
		if (energyMax == -1) return false;


		if (i > 0 && isCharging(item)) {
			if (energyMax >= energy + i) {
				return true;
			}
			else if (energyMax > energy) {
				return true;
			}
		}
		else if (i < 0 && isDischarging(item)) {
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
	public ItemStack setEnergy(ItemStack item, int i) {
		NBTTagCompound eet = checkEPT(item);
		NBTTagCompound nbt = item.getTagCompound();

		eet.setInteger("EPC", i);

		nbt.setTag("EPT", eet);
		item.setTagCompound(nbt);
		return item;
	}

	@Override
	public int getEnergy(ItemStack item) {
		if (!isTagEPT(item)) return -1;
		NBTTagCompound eet = checkEPT(item);
		return eet.hasKey("EPC", NBT.TAG_INT) ? eet.getInteger("EPC") : -1;
	}

	@Override
	public ItemStack setEnergyMax(ItemStack item, int i) {
		NBTTagCompound eet = checkEPT(item);
		NBTTagCompound nbt = item.getTagCompound();

		eet.setInteger("EPM", i);

		nbt.setTag("EPT", eet);
		item.setTagCompound(nbt);
		return item;
	}

	@Override
	public int getEnergyMax(ItemStack item) {
		if (!isTagEPT(item)) return -1;
		NBTTagCompound eet = checkEPT(item);
		return eet.hasKey("EPM", NBT.TAG_INT) ? eet.getInteger("EPM") : -1;
	}

	public ItemStack setEnergyMax(ItemStack item, int i, int max) {
		NBTTagCompound eet = checkEPT(item);
		NBTTagCompound nbt = item.getTagCompound();

		eet.setInteger("EPC", i);
		eet.setInteger("EPM", max);

		nbt.setTag("EPT", eet);
		item.setTagCompound(nbt);
		return item;
	}

	@Override
	public abstract int getRateMax();

	@Override
	public boolean isCharging(ItemStack item) {
		return false;
	}

	@Override
	public boolean isDischarging(ItemStack item) {
		return false;
	}

	public static boolean isTagEPT(ItemStack item) {
		return item != null && item.getTagCompound() != null && item.getTagCompound().hasKey("EPT", NBT.TAG_COMPOUND);
	}

	public static NBTTagCompound checkEPT(ItemStack item) {
		NBTTagCompound nbt = item.getTagCompound();
		if (nbt == null) {
			nbt = new NBTTagCompound();
			item.setTagCompound(nbt);
			return new NBTTagCompound();
		}
		NBTTagCompound eet;
		if (nbt.hasKey("EPT", NBT.TAG_COMPOUND))
			eet = nbt.getCompoundTag("EPT");
		else
			eet = new NBTTagCompound();
		return eet;
	}

}
