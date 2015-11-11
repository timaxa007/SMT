package smt.pack.geology.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import smt.pack.geology.object.BlockDummy;

public class ListBlocks {

	public static Block
	blocksGeology
	;

	public static Block[] blocks;

	public static void init() {

		blocksGeology = new BlockBlocksGeology("blocksGeology");

		blocks = new Block[]{
				blocksGeology
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
