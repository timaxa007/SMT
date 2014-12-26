package mods.timaxa007.pack.techno.block;

import cpw.mods.fml.common.registry.GameRegistry;
import mods.timaxa007.pack.techno.tile.TileEntityChip;
import mods.timaxa007.pack.techno.tile.TileEntityElectricMachines;
import mods.timaxa007.pack.techno.tile.TileEntityElectricWires;
import mods.timaxa007.pack.techno.tile.TileEntityModuleMovement;
import net.minecraft.block.Block;

public class BlockList {

	public static Block electric_machines;
	public static Block electric_wires;
	public static Block chip;
	public static Block module_movement;

	public static void preInit() {

		electric_machines = new BlockElectricMachines();
		electric_wires = new BlockElectricWires();
		chip = new BlockChip();
		module_movement = new BlockModuleMovement();
		//transporter belt

		GameRegistry.registerBlock(electric_machines, "BlockElectricMachines");//Microwave Oven
		GameRegistry.registerBlock(electric_wires, "BlockElectricWires");
		GameRegistry.registerBlock(chip, "BlockChip");
		GameRegistry.registerBlock(module_movement, ItemBlockModuleMovement.class, "BlockModuleMovement");

		GameRegistry.registerTileEntity(TileEntityElectricMachines.class, "TileEntityElectricMachines");
		GameRegistry.registerTileEntity(TileEntityElectricWires.class, "TileEntityElectricWires");
		GameRegistry.registerTileEntity(TileEntityChip.class, "TileEntityChip");
		GameRegistry.registerTileEntity(TileEntityModuleMovement.class, "TileEntityModuleMovement");

	}

}
