package timaxa007.pack.weapon.block;

import timaxa007.pack.weapon.tile.*;
import timaxa007.smt.util.UtilSMT;
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

		UtilSMT.UtilBlock.RegBlock(list_block);

		list_te = new Class[] {
				te_claymore
		};

		UtilSMT.UtilBlock.RegTE(list_te);

	}

}
