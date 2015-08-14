package timaxa007.pack.conjoint.block;

import net.minecraft.block.material.Material;
import timaxa007.pack.conjoint.PackConjoint;
import timaxa007.pack.conjoint.object.ModifiedBlock;

public class BlockGlassBlocks extends ModifiedBlock {

	public BlockGlassBlocks(String tag) {
		super(tag, Material.glass);
		setCreativeTab(PackConjoint.tab_conjoint);
	}

}
