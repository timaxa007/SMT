package timaxa007.pack.item.block;

import net.minecraft.block.material.Material;
import timaxa007.pack.item.PackItems;
import timaxa007.smt.object.ModifiedBlock;

public class BlockClothBlocks extends ModifiedBlock {

	public BlockClothBlocks(String tag) {
		super(tag, Material.cloth);
		setCreativeTab(PackItems.tab_items);
	}

}
