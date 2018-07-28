package smt.pack.phytology.block;

import net.minecraft.block.Block;
import net.minecraft.item.ItemMultiTexture;

public class ItemBlockSapling extends ItemMultiTexture {

	public ItemBlockSapling(Block block) {
		super(block, block, BlockSapling.names);
	}

}
