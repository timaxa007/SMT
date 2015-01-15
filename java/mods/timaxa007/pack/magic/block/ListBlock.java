package mods.timaxa007.pack.magic.block;

import mods.timaxa007.pack.magic.tile.*;
import mods.timaxa007.tms.util.UtilTMS;
import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;

public class ListBlock {

	public static Block 
	magic_machines, 
	magic_slims, 
	magic_cauldron, 
	magic_locked;

	public static Block[] list_block;

	public static void preInit() {

		magic_machines = new BlockMagicMachines("magic_machines");
		magic_slims = new BlockSlims("magic_slims");
		magic_cauldron = new BlockMagicCauldron("magic_cauldron");
		magic_locked = new BlockLocked("magic_locked");

		list_block = new Block[] {
				magic_machines, 
				magic_slims, 
				magic_cauldron, 
				magic_locked
		};

		for (int i = 0; i < list_block.length; i++) 
			UtilTMS.UtilBlock.RegBlock(list_block[i]);

		GameRegistry.registerTileEntity(TileEntityMagicMachines.class, "TileEntityMagicMachines");
		GameRegistry.registerTileEntity(TileEntityMagicCauldron.class, "TileEntityMagicCauldron");
		GameRegistry.registerTileEntity(TileEntityBlockLocked.class, "TileEntityBlockLocked");

	}

}
