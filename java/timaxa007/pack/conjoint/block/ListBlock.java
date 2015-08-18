package timaxa007.pack.conjoint.block;

import net.minecraft.block.Block;
import timaxa007.smt.util.UtilSMT;

public class ListBlock {

	public static boolean
	information_be,

	rock_blocks_be,
	glass_blocks_be,
	wood_blocks_be,
	ground_blocks_be,
	sand_blocks_be,
	cloth_blocks_be,
	metal_blocks_be
	;

	public static Block
	information,

	rock_blocks,
	glass_blocks,
	wood_blocks,
	ground_blocks,
	sand_blocks,
	cloth_blocks,
	metal_blocks
	;

	public static Block[] list_block;

	public static void preInit() {

		if (information_be) information = new BlockInformation("information");

		if (rock_blocks_be) rock_blocks = new BlockRockBlocks("rock_blocks");
		if (glass_blocks_be) glass_blocks = new BlockGlassBlocks("glass_blocks");
		if (wood_blocks_be) wood_blocks = new BlockWoodBlocks("wood_blocks");
		if (ground_blocks_be) ground_blocks = new BlockGroundBlocks("ground_blocks");
		if (sand_blocks_be) sand_blocks = new BlockSandBlocks("sand_blocks");
		if (cloth_blocks_be) cloth_blocks = new BlockClothBlocks("cloth_blocks");
		if (metal_blocks_be) metal_blocks = new BlockMetalBlocks("metal_blocks");

		list_block = new Block[] {
				information,

				rock_blocks,
				glass_blocks,
				wood_blocks,
				ground_blocks,
				sand_blocks,
				cloth_blocks,
				metal_blocks
		};

		UtilSMT.UtilBlock.RegBlock(list_block);

		//UtilSMT.UtilBlock.RegTE(list_te);

	}

}
