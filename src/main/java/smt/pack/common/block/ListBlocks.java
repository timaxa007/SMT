package smt.pack.common.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import smt.pack.common.object.BlockDummy;

public class ListBlocks {

	public static Block
	blocksCommon
	;

	public static Block[] blocks;

	public static void init() {

		blocksCommon = new BlockBlocksCommon("blocksCommon");

		blocks = new Block[] {
				blocksCommon
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
