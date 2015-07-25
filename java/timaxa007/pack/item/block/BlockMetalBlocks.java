package timaxa007.pack.item.block;

import net.minecraft.block.material.Material;
import timaxa007.pack.item.PackItem;
import timaxa007.smt.object.ModifiedBlock;

public class BlockMetalBlocks extends ModifiedBlock {

	public BlockMetalBlocks(String tag) {
		super(tag, Material.iron);
		setCreativeTab(PackItem.tab_items);
	}

}
