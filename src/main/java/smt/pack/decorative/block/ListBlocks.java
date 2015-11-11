package smt.pack.decorative.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import smt.pack.decorative.object.BlockDummy;

public class ListBlocks {

	public static Block
	blocksDecorative
	;

	public static Block[] blocks;

	public static void init() {

		blocksDecorative = new BlockBlocksDecorative("blocksDecorative");

		blocks = new Block[]{
				blocksDecorative
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
