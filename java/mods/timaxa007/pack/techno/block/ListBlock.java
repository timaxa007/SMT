package mods.timaxa007.pack.techno.block;

import mods.timaxa007.pack.techno.tile.*;
import mods.timaxa007.tms.util.UtilTMS;
import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;

public class ListBlock {

	public static Block 
	electric_machines, 
	electric_wires, 
	chip, 
	module_movement;

	public static Block[] list_block;

	public static void preInit() {

		electric_machines = new BlockElectricMachines("electric_machines");
		electric_wires = new BlockElectricWires("electric_wires");
		chip = new BlockChip("chip");
		module_movement = new BlockModuleMovement("module_movement");
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
