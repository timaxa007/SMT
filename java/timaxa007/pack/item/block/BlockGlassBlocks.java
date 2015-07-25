package timaxa007.pack.item.block;

import net.minecraft.block.material.Material;
import timaxa007.pack.item.PackItem;
import timaxa007.smt.object.ModifiedBlock;

public class BlockGlassBlocks extends ModifiedBlock {

	public BlockGlassBlocks(String tag) {
		super(tag, Material.glass);
		setCreativeTab(PackItem.tab_items);
	}

}
