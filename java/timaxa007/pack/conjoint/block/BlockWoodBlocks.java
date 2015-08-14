package timaxa007.pack.conjoint.block;

import net.minecraft.block.material.Material;
import timaxa007.pack.conjoint.PackConjoint;
import timaxa007.pack.conjoint.object.ModifiedBlock;

public class BlockWoodBlocks extends ModifiedBlock {

	public BlockWoodBlocks(String tag) {
		super(tag, Material.wood);
		setCreativeTab(PackConjoint.tab_conjoint);
	}

}
