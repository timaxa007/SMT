package smt.pack.cookery.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import smt.pack.cookery.object.BlockDummy;

public class ListBlocks {

	public static Block
	blocksCookery
	;

	public static Block[] blocks;

	public static void init() {

		blocksCookery = new BlockBlocksCookery("blocksCookery");

		blocks = new Block[]{
				blocksCookery
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
