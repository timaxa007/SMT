package smt.pack.player.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import smt.pack.player.SMTPlayer;

public final class Blocks {

	public static Block
	blocksPlayer
	;

	public static final void init() {

		blocksPlayer = new BlockBlocksPlayer().setBlockName("blocks_player").setCreativeTab(SMTPlayer.tabPlayer);
		GameRegistry.registerBlock(blocksPlayer, "block_blocks_player");

	}

}
