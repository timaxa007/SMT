package mods.timaxa007.pack.weapon.block;

import mods.timaxa007.pack.weapon.tile.*;
import net.minecraft.block.Block;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlockList {

	public static Block claymore;

	public static void list() {

		claymore = new BlockClaymore();

		GameRegistry.registerBlock(claymore, "BlockClaymore");

		GameRegistry.registerTileEntity(TileEntityClaymore.class, "TileEntityClaymore");

	}

}
