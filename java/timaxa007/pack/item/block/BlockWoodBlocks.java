package timaxa007.pack.item.block;

import net.minecraft.block.material.Material;
import timaxa007.pack.item.PackItem;
import timaxa007.smt.object.ModifiedBlock;

public class BlockWoodBlocks extends ModifiedBlock {

	public BlockWoodBlocks(String tag) {
		super(tag, Material.wood);
		setCreativeTab(PackItem.tab_items);
	}

}
