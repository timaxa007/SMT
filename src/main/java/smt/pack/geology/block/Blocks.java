package smt.pack.geology.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import smt.pack.geology.SMTGeology;

public final class Blocks {

	public static Block
	blocksGeology,
	ores
	;

	public static final void init() {

		blocksGeology = new BlockBlocksGeology().setBlockName("blocks_geology");
		GameRegistry.registerBlock(blocksGeology, "block_blocks_geology");

		ores = new BlockOres().setBlockName("ores").setCreativeTab(SMTGeology.tabGeology);
		GameRegistry.registerBlock(ores, "block_ores");

	}

}
