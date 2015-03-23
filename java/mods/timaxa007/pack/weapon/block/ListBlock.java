package mods.timaxa007.pack.weapon.block;

import mods.timaxa007.pack.weapon.tile.*;
import mods.timaxa007.tms.util.UtilTMS;
import net.minecraft.block.Block;

public class ListBlock {

	public static boolean 
	claymore_be;

	public static Block 
	claymore;

	public static Class 
	te_claymore;

	public static Block[] list_block;

	public static Class[] list_te;

	public static void preInit() {

		if (claymore_be) {
			claymore = new BlockClaymore("claymore");
			te_claymore = TileEntityClaymore.class;
		}

		list_block = new Block[] {
				claymore
		};

		UtilTMS.UtilBlock.RegBlock(list_block);

		list_te = new Class[] {
				te_claymore
		};

		UtilTMS.UtilBlock.RegTE(list_te);

	}

}
