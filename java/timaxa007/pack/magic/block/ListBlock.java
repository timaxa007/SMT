package timaxa007.pack.magic.block;

import net.minecraft.block.Block;
import timaxa007.pack.magic.tile.*;
import timaxa007.smt.util.UtilSMT;

public class ListBlock {

	public static boolean
	magic_machines_be,
	magic_cauldron_be,
	magic_spawner_be
	;

	public static Block
	magic_machines,
	magic_cauldron,
	magic_spawner
	;

	public static Class
	te_magic_machines,
	te_magic_cauldron,
	te_magic_spawner
	;

	public static Block[] list_block;

	public static Class[] list_te;

	public static void preInit() {

		if (magic_machines_be) {
			magic_machines = new BlockMagicMachines("magic_machines");
			te_magic_machines = TileEntityMagicMachines.class;
		}

		if (magic_cauldron_be) {
			magic_cauldron = new BlockMagicCauldron("magic_cauldron");
			te_magic_cauldron = TileEntityMagicCauldron.class;
		}

		if (magic_spawner_be) {
			magic_spawner = new BlockMagicSpawner("magic_spawner");
			te_magic_spawner = TileEntityMagicSpawner.class;
		}

		list_block = new Block[] {
				magic_machines,
				magic_cauldron,
				magic_spawner
		};

		UtilSMT.UtilBlock.RegBlock(list_block);

		list_te = new Class[] {
				te_magic_machines,
				te_magic_cauldron,
				te_magic_spawner
		};

		UtilSMT.UtilBlock.RegTE(list_te);

	}

}
