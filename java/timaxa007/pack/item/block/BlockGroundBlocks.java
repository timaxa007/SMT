package timaxa007.pack.item.block;

import net.minecraft.block.material.Material;
import timaxa007.pack.item.PackItems;
import timaxa007.smt.object.ModifiedBlock;

public class BlockGroundBlocks extends ModifiedBlock {

	public BlockGroundBlocks(String tag) {
		super(tag, Material.ground);
		setCreativeTab(PackItems.tab_items);
	}

}
