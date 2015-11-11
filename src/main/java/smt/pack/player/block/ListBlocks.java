package smt.pack.player.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import smt.pack.player.object.BlockDummy;

public class ListBlocks {

	public static Block
	blocksPlayer
	;

	public static Block[] blocks;

	public static void init() {

		blocksPlayer = new BlockBlocksPlayer("blocksPlayer");

		blocks = new Block[]{
				blocksPlayer
		};

		for (Block block : blocks) {
			if (block != null) {
				if (block instanceof BlockDummy)
					GameRegistry.registerBlock(block, ((BlockDummy) block).getTag());
				else
					GameRegistry.registerBlock(block, block.getUnlocalizedName().substring(5));
			}
		}

	}

}
