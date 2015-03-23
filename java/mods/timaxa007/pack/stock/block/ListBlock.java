package mods.timaxa007.pack.stock.block;

import mods.timaxa007.pack.stock.tile.*;
import mods.timaxa007.tms.util.UtilTMS;
import net.minecraft.block.Block;

public class ListBlock {

	public static boolean 
	germination_plants_be, 
	foods_be, 
	healing_be, 
	apiary_be;

	public static Block 
	germination_plants, 
	foods, 
	healing, 
	apiary;

	public static Class 
	te_germination_plants, 
	te_foods, 
	te_healing, 
	te_apiary;

	public static Block[] list_block;

	public static Class[] list_te;

	public static void preInit() {

		if (germination_plants_be) {
			germination_plants = new BlockGerminationPlants("germination_plants");
			te_germination_plants = TileEntityGerminationPlants.class;
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

		list_block = new Block[] {
				germination_plants, 
				foods, 
				healing, 
				apiary
		};

		UtilTMS.UtilBlock.RegBlock(list_block);

		list_te = new Class[] {
				te_germination_plants, 
				te_foods, 
				te_healing, 
				te_apiary
		};

		UtilTMS.UtilBlock.RegTE(list_te);

	}

}
