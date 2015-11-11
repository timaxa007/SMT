package smt.pack.meteorology.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import smt.pack.meteorology.object.BlockDummy;

public class ListBlocks {

	public static Block
	blocksMeteorology
	;

	public static Block[] blocks;

	public static void init() {

		blocksMeteorology = new BlockBlocksMeteorology("blocksMeteorology");

		blocks = new Block[]{
				blocksMeteorology
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
