package timaxa007.pack.stock.block;

import net.minecraft.block.Block;
import timaxa007.pack.stock.tile.*;
import timaxa007.smt.util.UtilSMT;

public class ListBlock {

	public static boolean
	stock_machines_be,
	plants_be,
	foods_be,
	apiary_be,
	petalled_be
	;

	public static Block
	stock_machines,
	plants,
	foods,
	apiary,
	petalled
	;

	public static Class
	te_stock_machines,
	te_plants,
	te_foods,
	te_apiary,
	te_petalled
	;

	public static Block[] list_block;

	public static Class[] list_te;

	public static void preInit() {

		if (stock_machines_be) {
			stock_machines = new BlockStockMachines("stock_machines");
			te_stock_machines = TileEntityStockMachines.class;
		}

		if (plants_be) {
			plants = new BlockPlants("plants");
			te_plants = TileEntityPlants.class;
		}

		if (foods_be) {
			foods = new BlockFoods("foods");
			te_foods = TileEntityFoods.class;
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
				stock_machines,
				plants,
				foods,
				apiary,
				petalled
		};

		UtilSMT.UtilBlock.RegBlock(list_block);

		list_te = new Class[] {
				te_stock_machines,
				te_plants,
				te_foods,
				te_apiary,
				te_petalled
		};

		UtilSMT.UtilBlock.RegTE(list_te);

	}

}
