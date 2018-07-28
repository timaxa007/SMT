package smt.pack.technology.api;

public interface IElectricDummy {

	int addEnergy(int i);
	boolean isAddEnergy(int i);
	void setEnergy(int i);
	int getEnergy();
	void setEnergyMax(int i);
	int getEnergyMax();

	/** The maximum possible rate of energy. **/
	int getRateMax();

	boolean isCharging();
	boolean isDischarging();

}
