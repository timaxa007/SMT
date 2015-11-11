package smt.pack.technology.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import smt.pack.technology.object.BlockDummy;

public class ListBlocks {

	public static Block
	blocksTechnology
	;

	public static Block[] blocks;

	public static void init() {

		blocksTechnology = new BlockBlocksTechnology("blocksTechnology");

		blocks = new Block[]{
				blocksTechnology
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
