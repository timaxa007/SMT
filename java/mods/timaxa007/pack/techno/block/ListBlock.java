package mods.timaxa007.pack.techno.block;

import mods.timaxa007.pack.techno.tile.*;
import mods.timaxa007.tms.util.UtilTMS;
import net.minecraft.block.Block;

public class ListBlock {

	public static boolean 
	electric_machines_be, 
	electric_wires_be, 
	chip_be, 
	module_movement_be;

	public static Block 
	electric_machines, 
	electric_wires, 
	chip, 
	module_movement;

	public static Class 
	te_electric_machines, 
	te_electric_wires, 
	te_chip, 
	te_module_movement;

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

		//transporter belt

		UtilTMS.UtilBlock.RegBlock(new Block[] {
				electric_machines, 
				electric_wires, 
				chip, 
				module_movement
		});

		UtilTMS.UtilBlock.RegTE(new Class[] {
				te_electric_machines, 
				te_electric_wires, 
				te_chip, 
				te_module_movement
		});

	}

}
