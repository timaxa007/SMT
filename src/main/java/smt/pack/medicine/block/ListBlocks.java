package smt.pack.medicine.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import smt.pack.medicine.object.BlockDummy;

public class ListBlocks {

	public static Block
	blocksMedicine
	;

	public static Block[] blocks;

	public static void init() {

		blocksMedicine = new BlockBlocksMedicine("blocksMedicine");

		blocks = new Block[]{
				blocksMedicine
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
