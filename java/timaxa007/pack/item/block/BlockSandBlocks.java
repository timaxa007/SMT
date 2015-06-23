package timaxa007.pack.item.block;

import net.minecraft.block.material.Material;
import timaxa007.pack.item.PackItems;
import timaxa007.smt.object.ModifiedBlock;

public class BlockSandBlocks extends ModifiedBlock {

	public BlockSandBlocks(String tag) {
		super(tag, Material.sand);
		setCreativeTab(PackItems.tab_items);
	}

}
