package mods.timaxa007.pack.mining.block;

import mods.timaxa007.pack.mining.tile.*;
import mods.timaxa007.tms.util.UtilTMS;
import net.minecraft.block.Block;

public class ListBlock {

	public static boolean 
	ore_rock_ores_be, 
	ore_nether_ores_be, 
	ore_ender_ores_be, 
	cristals_be;

	public static Block 
	ore_rock_ores, 
	ore_nether_ores, 
	ore_ender_ores, 
	cristals;

	public static Class 
	te_ore_ores, 
	te_cristals;

	public static void preInit() {

		if (ore_rock_ores_be) ore_rock_ores = new OreOres("ore_rock_ores").setBlockTextureName("stone");
		if (ore_nether_ores_be) ore_nether_ores = new OreOres("ore_nether_ores").setBlockTextureName("netherrack");
		if (ore_ender_ores_be) ore_ender_ores = new OreOres("ore_ender_ores").setBlockTextureName("end_stone");
		if (ore_rock_ores_be || ore_nether_ores_be || ore_ender_ores_be) te_ore_ores = TileEntityOreOres.class;

		if (cristals_be) {
			cristals = new BlockCristals("cristals");
			te_cristals = TileEntityCristals.class;
		}

		UtilTMS.UtilBlock.RegBlock(new Block[] {
				ore_rock_ores, 
				ore_nether_ores, 
				ore_ender_ores, 
				cristals
		});

		UtilTMS.UtilBlock.RegTE(new Class[] {
				te_ore_ores, 
				te_cristals
		});

	}

}
