package smt.pack.entity.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import smt.pack.entity.object.BlockDummy;

public class ListBlocks {

	public static Block
	blocksEntity
	;

	public static Block[] blocks;

	public static void init() {

		blocksEntity = new BlockBlocksEntity("blocksEntity");

		blocks = new Block[]{
				blocksEntity
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
