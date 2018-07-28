package smt.pack.cookery.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import smt.pack.cookery.SMTCookery;

public final class Blocks {

	public static Block
	blocksCookery,
	grill
	;

	public static final void init() {

		blocksCookery = new BlockBlocksCookery().setBlockName("blocks_cookery").setCreativeTab(SMTCookery.tabCookery);
		GameRegistry.registerBlock(blocksCookery, "block_blocks_cookery");

		grill = new BlockGrill().setBlockName("grill").setCreativeTab(SMTCookery.tabCookery);
		GameRegistry.registerBlock(grill, "block_grill");
		
	}

}
