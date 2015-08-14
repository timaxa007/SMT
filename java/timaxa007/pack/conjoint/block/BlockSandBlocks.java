package timaxa007.pack.conjoint.block;

import net.minecraft.block.material.Material;
import timaxa007.pack.conjoint.PackConjoint;
import timaxa007.pack.conjoint.object.ModifiedBlock;

public class BlockSandBlocks extends ModifiedBlock {

	public BlockSandBlocks(String tag) {
		super(tag, Material.sand);
		setCreativeTab(PackConjoint.tab_conjoint);
	}

}
