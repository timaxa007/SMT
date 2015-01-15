package mods.timaxa007.pack.weapon.block;

import mods.timaxa007.pack.weapon.tile.*;
import mods.timaxa007.tms.util.UtilTMS;
import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;

public class ListBlock {

	public static Block 
	claymore;

	public static Block[] list_block;

	public static void preInit() {

		claymore = new BlockClaymore("claymore");

		list_block = new Block[] {
				claymore
		};

		for (int i = 0; i < list_block.length; i++) 
			UtilTMS.UtilBlock.RegBlock(list_block[i]);

		GameRegistry.registerTileEntity(TileEntityClaymore.class, "TileEntityClaymore");

	}

}
