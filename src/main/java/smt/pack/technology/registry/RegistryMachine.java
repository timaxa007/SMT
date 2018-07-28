package smt.pack.technology.registry;

import java.util.HashMap;
import java.util.Map;

import smt.pack.technology.tile.TileEntityElectricMachine;
import smt.pack.technology.tile.machine.ElectricMachine;

public class RegistryMachine {
	/*
	private static final HashMap<String, ElectricMachine> ElectricMachines = new HashMap<String, ElectricMachine>();

	public static void addElectricMachine(String name, ElectricMachine machine) {
		if (ElectricMachines.containsKey(name))
			throw new IllegalArgumentException("Duplicate id: " + name + ".");
		else
			ElectricMachines.put(name, machine);
	}

	public static String getElectricMachineName(ElectricMachine machine) {
		for (Map.Entry<String, ElectricMachine> o : ElectricMachines.entrySet()) {
			if (o.getValue().equals(machine)) return o.getKey();
		}
		return null;
	}

	public static ElectricMachine getElectricMachineObject(String name) {
		if (ElectricMachines.containsKey(name)) return ElectricMachines.get(name);
		for (Map.Entry<String, ElectricMachine> o : ElectricMachines.entrySet()) {
			if (o.getKey().equals(name)) return o.getValue();
		}
		return null;
	}

	public static HashMap<String, ElectricMachine> getElectricMachines() {
		return ElectricMachines;
	}
	 */

	private static final HashMap<String, Class<? extends ElectricMachine>> ElectricMachines =
			new HashMap<String, Class<? extends ElectricMachine>>();

	public static void addElectricMachine(String name, Class<? extends ElectricMachine> machine) {
		if (ElectricMachines.containsKey(name))
			throw new IllegalArgumentException("Duplicate id: " + name + ".");
		else
			ElectricMachines.put(name, machine);
	}

	public static String getElectricMachineName(Class<? extends ElectricMachine> machine) {
		for (Map.Entry<String, Class<? extends ElectricMachine>> o : ElectricMachines.entrySet()) {
			if (o.getValue().equals(machine)) return o.getKey();
		}
		return null;
	}

	public static Class<? extends ElectricMachine> getElectricMachineClass(String name) {
		if (ElectricMachines.containsKey(name)) return ElectricMachines.get(name);
		for (Map.Entry<String, Class<? extends ElectricMachine>> o : ElectricMachines.entrySet()) {
			if (o.getKey().equals(name)) return o.getValue();
		}
		return null;
	}

	//.newInstance();
	//.getConstructor(new Class[] {TileEntityElectricMachine.class}).newInstance(new Object[] {tile});
	/*
	public static ElectricMachine getElectricMachineObject(String name) {
		Class machine = getElectricMachineClass(name);
		try {
			if (machine != null)
				return (ElectricMachine)machine.newInstance();
		} catch (Exception exception) {exception.printStackTrace();}
		return null;
	}
	 */
	public static ElectricMachine getElectricMachineObject(Class<? extends ElectricMachine> machine, TileEntityElectricMachine tile) {
		try {
			return (ElectricMachine)machine.getConstructor(new Class[] {TileEntityElectricMachine.class}).newInstance(new Object[] {tile});
		} catch (Exception exception) {exception.printStackTrace();}
		return null;
	}

	public static HashMap<String, Class<? extends ElectricMachine>> getElectricMachines() {
		return ElectricMachines;
	}

}
