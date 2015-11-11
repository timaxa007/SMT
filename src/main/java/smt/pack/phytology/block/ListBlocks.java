package smt.pack.phytology.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import smt.pack.phytology.object.BlockDummy;

public class ListBlocks {

	public static Block
	blocksPhytology
	;

	public static Block[] blocks;

	public static void init() {

		blocksPhytology = new BlockBlocksPhytology("blocksPhytology");

		blocks = new Block[]{
				blocksPhytology
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
