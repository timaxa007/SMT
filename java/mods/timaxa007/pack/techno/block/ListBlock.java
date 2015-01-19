package mods.timaxa007.pack.techno.block;

import mods.timaxa007.pack.techno.tile.*;
import mods.timaxa007.tms.util.UtilTMS;
import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;

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

	public static Block[] list_block;

	public static void preInit() {

		if (electric_machines_be) electric_machines = new BlockElectricMachines("electric_machines");
		if (electric_wires_be) electric_wires = new BlockElectricWires("electric_wires");
		if (chip_be) chip = new BlockChip("chip");
		if (module_movement_be) module_movement = new BlockModuleMovement("module_movement");
		//transporter belt

		list_block = new Block[] {
				electric_machines, 
				electric_wires, 
				chip, 
				module_movement
		};

		for (int i = 0; i < list_block.length; i++) 
			UtilTMS.UtilBlock.RegBlock(list_block[i]);

		GameRegistry.registerTileEntity(TileEntityElectricMachines.class, "TileEntityElectricMachines");
		GameRegistry.registerTileEntity(TileEntityElectricWires.class, "TileEntityElectricWires");
		GameRegistry.registerTileEntity(TileEntityChip.class, "TileEntityChip");
		GameRegistry.registerTileEntity(TileEntityModuleMovement.class, "TileEntityModuleMovement");

	}

}
