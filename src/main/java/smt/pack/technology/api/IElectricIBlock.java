package smt.pack.technology.api;

import net.minecraft.world.World;

public interface IElectricIBlock {

	int addEnergy(World world, int x, int y, int z, int side, int energy);
	boolean isAddEnergy(World world, int x, int y, int z, int side, int energy);
	void setEnergy(World world, int x, int y, int z, int side, int energy);
	int getEnergy(World world, int x, int y, int z, int side);
	void setEnergyMax(World world, int x, int y, int z, int side, int energy);
	int getEnergyMax(World world, int x, int y, int z, int side);

	/** The maximum possible rate of energy. **/
	int rateMax(World world, int x, int y, int z, int side);

	boolean isCharging(World world, int x, int y, int z, int side);
	boolean isDischarging(World world, int x, int y, int z, int side);

}
