package smt.pack.meteorology.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import smt.pack.meteorology.SMTMeteorology;

public final class Blocks {

	public static Block
	blocksMeteorology
	;

	public static final void init() {

		blocksMeteorology = new BlockBlocksMeteorology().setBlockName("blocks_meteorology").setCreativeTab(SMTMeteorology.tabMeteorology);
		GameRegistry.registerBlock(blocksMeteorology, "block_blocks_meteorology");

	}

}
