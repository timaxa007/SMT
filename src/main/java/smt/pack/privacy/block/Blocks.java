package smt.pack.privacy.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import smt.pack.privacy.SMTPrivacy;

public final class Blocks {

	public static Block
	blocksPrivacy
	;

	public static final void init() {

		blocksPrivacy = new BlockBlocksPrivacy().setBlockName("blocks_privacy").setCreativeTab(SMTPrivacy.tabPrivacy);
		GameRegistry.registerBlock(blocksPrivacy, "block_blocks_privacy");

	}

}
