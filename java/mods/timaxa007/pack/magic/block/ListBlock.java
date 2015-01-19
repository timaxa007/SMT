package mods.timaxa007.pack.magic.block;

import mods.timaxa007.pack.magic.tile.*;
import mods.timaxa007.tms.util.UtilTMS;
import net.minecraft.block.Block;

public class ListBlock {

	public static boolean 
	magic_machines_be, 
	magic_slims_be, 
	magic_cauldron_be, 
	magic_locked_be;

	public static Block 
	magic_machines, 
	magic_slims, 
	magic_cauldron, 
	magic_locked;

	public static Block[] list_block;
	public static Class[] list_te;

	public static void preInit() {

		if (magic_machines_be) magic_machines = new BlockMagicMachines("magic_machines");
		if (magic_slims_be) magic_slims = new BlockSlims("magic_slims");
		if (magic_cauldron_be) magic_cauldron = new BlockMagicCauldron("magic_cauldron");
		if (magic_locked_be) magic_locked = new BlockLocked("magic_locked");

		list_block = new Block[] {
				magic_machines, 
				magic_slims, 
				magic_cauldron, 
				magic_locked
		};

		for (int i = 0; i < list_block.length; i++) 
			UtilTMS.UtilBlock.RegBlock(list_block[i]);

		list_te = new Class[] {
				TileEntityMagicMachines.class,
				TileEntityMagicCauldron.class,
				TileEntityBlockLocked.class
		};

		for (int i = 0; i < list_te.length; i++) 
			UtilTMS.UtilBlock.RegTE(list_te[i]);

	}

}
