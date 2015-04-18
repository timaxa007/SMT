package timaxa007.pack.stock.block;

import timaxa007.pack.stock.tile.*;
import timaxa007.tms.util.UtilTMS;
import net.minecraft.block.Block;

public class ListBlock {

	public static boolean 
	plants_be,
	foods_be,
	healing_be,
	apiary_be,
	petalled_be
	;

	public static Block 
	plants,
	foods,
	healing,
	apiary,
	petalled
	;

	public static Class 
	te_plants,
	te_foods,
	te_healing,
	te_apiary,
	te_petalled
	;

	public static Block[] list_block;

	public static Class[] list_te;

	public static void preInit() {

		if (plants_be) {
			plants = new BlockPlants("plants");
			te_plants = TileEntityPlants.class;
		}

		if (foods_be) {
			foods = new BlockFoods("foods");
			te_foods = TileEntityFoods.class;
		}

		if (healing_be) {
			healing = new BlockHealing("healing");
			te_healing = TileEntityHealing.class;
		}

		if (apiary_be) {
			apiary = new BlockApiary("apiary");
			te_apiary = TileEntityApiary.class;
		}

		if (petalled_be) {
			petalled = new BlockPetalled("petalled");
			te_petalled = TileEntityPetalled.class;
		}

		list_block = new Block[] {
				plants,
				foods,
				healing,
				apiary,
				petalled
		};

		UtilTMS.UtilBlock.RegBlock(list_block);

		list_te = new Class[] {
				te_plants,
				te_foods,
				te_healing,
				te_apiary,
				te_petalled
		};

		UtilTMS.UtilBlock.RegTE(list_te);

	}

}
