package timaxa007.pack.techno.block;

import timaxa007.pack.techno.tile.*;
import timaxa007.tms.util.UtilTMS;
import net.minecraft.block.Block;

public class ListBlock {

	public static boolean 
	electric_machines_be,
	electric_wires_be,
	chip_be,
	module_movement_be,
	farm_mashines_be;

	public static Block 
	electric_machines,
	electric_wires,
	chip,
	module_movement,
	farm_mashines;

	public static Class 
	te_electric_machines,
	te_electric_wires,
	te_chip,
	te_module_movement,
	te_farm_mashines;

	public static Block[] list_block;

	public static Class[] list_te;

	public static void preInit() {

		if (electric_machines_be) {
			electric_machines = new BlockElectricMachines("electric_machines");
			te_electric_machines = TileEntityElectricMachines.class;
		}

		if (electric_wires_be) {
			electric_wires = new BlockElectricWires("electric_wires");
			te_electric_wires = TileEntityElectricWires.class;
		}

		if (chip_be) {
			chip = new BlockChip("chip");
			te_chip = TileEntityChip.class;
		}

		if (module_movement_be) {
			module_movement = new BlockModuleMovement("module_movement");
			te_module_movement = TileEntityModuleMovement.class;
		}
		
		if (farm_mashines_be) {
			farm_mashines = new BlockFarmMashines("farm_mashines");
			te_farm_mashines = TileEntityFarmMashines.class;
		}
		
		//transporter belt

		list_block = new Block[] {
				electric_machines, 
				electric_wires, 
				chip, 
				module_movement,
				farm_mashines
		};

		UtilTMS.UtilBlock.RegBlock(list_block);

		list_te = new Class[] {
				te_electric_machines, 
				te_electric_wires, 
				te_chip, 
				te_module_movement,
				te_farm_mashines
		};

		UtilTMS.UtilBlock.RegTE(list_te);

	}

}
