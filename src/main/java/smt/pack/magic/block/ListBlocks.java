package smt.pack.magic.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import smt.pack.magic.object.BlockDummy;

public class ListBlocks {

	public static Block
	blocksMagic
	;

	public static Block[] blocks;

	public static void init() {

		blocksMagic = new BlockBlocksMagic("blocksMagic");

		blocks = new Block[]{
				blocksMagic
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
