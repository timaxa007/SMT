package smt.pack.entity.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public final class Blocks {

	public static Block
	blocksEntity
	;

	public static final void init() {

		blocksEntity = new BlockBlocksEntity().setBlockName("blocks_entity");
		GameRegistry.registerBlock(blocksEntity, "block_blocks_entity");

	}

}
