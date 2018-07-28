package smt.pack.technology.tile.machine;

import smt.pack.technology.registry.RegistryMachine;

public class ListElectricMachines {
	/*
	public static ElectricMachine
	furnace,
	crasher,
	breaker,
	placer,
	miner,
	generator,
	transposer,
	builder;
	 */
	public static final void init() {
		/*
		furnace = new ElectricFurnace();
		RegistryMachine.addElectricMachine("furnace", furnace);
		 */

		RegistryMachine.addElectricMachine("furnace", ElectricFurnace.class);
		RegistryMachine.addElectricMachine("crusher", ElectricCrusher.class);
		RegistryMachine.addElectricMachine("breaker", ElectricBreaker.class);
		RegistryMachine.addElectricMachine("placer", ElectricPlacer.class);
		RegistryMachine.addElectricMachine("miner", ElectricMiner.class);
		RegistryMachine.addElectricMachine("generator", ElectricGenerator.class);
		RegistryMachine.addElectricMachine("transposer", ElectricTransposer.class);
		RegistryMachine.addElectricMachine("builder", ElectricBuilder.class);
		RegistryMachine.addElectricMachine("freezer", ElectricFreezer.class);
		RegistryMachine.addElectricMachine("grinder", ElectricGrinder.class);
		RegistryMachine.addElectricMachine("sharpener", ElectricSharpener.class);
		RegistryMachine.addElectricMachine("macerator", ElectricMacerator.class);
		RegistryMachine.addElectricMachine("mixer", ElectricMixer.class);
		RegistryMachine.addElectricMachine("centrifuge", ElectricCentrifuge.class);
		RegistryMachine.addElectricMachine("smelter", ElectricSmelter.class);
		RegistryMachine.addElectricMachine("oven", ElectricOven.class);
		RegistryMachine.addElectricMachine("kiln", ElectricKiln.class);
		RegistryMachine.addElectricMachine("accumulator", ElectricAccumulator.class);
		RegistryMachine.addElectricMachine("big_buffer_item", ElectricBigBufferItem.class);

	}

}
