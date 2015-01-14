package mods.timaxa007.pack.magic.block;

import mods.timaxa007.pack.magic.tile.*;
import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;

public class ListBlock {

	public static Block magic_machines;
	public static Block magic_slims;
	public static Block magic_cauldron;
	public static Block magic_locked;

	public static void preInit() {

		magic_machines = new BlockMagicMachines();
		magic_slims = new BlockSlims();
		magic_cauldron = new BlockMagicCauldron();
		magic_locked = new BlockLocked();

		GameRegistry.registerBlock(magic_machines, "BlockMagicMachines");
		GameRegistry.registerBlock(magic_slims, ItemBlockSlims.class, "BlockSlims");
		GameRegistry.registerBlock(magic_cauldron, "BlockMagicCauldron");
		GameRegistry.registerBlock(magic_locked, "BlockLocked");

		GameRegistry.registerTileEntity(TileEntityMagicMachines.class, "TileEntityMagicMachines");
		GameRegistry.registerTileEntity(TileEntityMagicCauldron.class, "TileEntityMagicCauldron");
		GameRegistry.registerTileEntity(TileEntityBlockLocked.class, "TileEntityBlockLocked");

	}

}
