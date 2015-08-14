package timaxa007.pack.conjoint.block;

import net.minecraft.block.material.Material;
import timaxa007.pack.conjoint.PackConjoint;
import timaxa007.pack.conjoint.object.ModifiedBlock;

public class BlockMetalBlocks extends ModifiedBlock {

	public BlockMetalBlocks(String tag) {
		super(tag, Material.iron);
		setCreativeTab(PackConjoint.tab_conjoint);
	}

}
