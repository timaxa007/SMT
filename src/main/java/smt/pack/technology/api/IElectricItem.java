package smt.pack.technology.api;

import net.minecraft.item.ItemStack;

public interface IElectricItem {

	int addEnergy(ItemStack item, int i);
	boolean isAddEnergy(ItemStack item, int i);
	ItemStack setEnergy(ItemStack item, int i);
	int getEnergy(ItemStack item);
	ItemStack setEnergyMax(ItemStack item, int i);
	int getEnergyMax(ItemStack item);

	/** The maximum possible rate of energy. **/
	int getRateMax();

	boolean isCharging(ItemStack item);
	boolean isDischarging(ItemStack item);

}
