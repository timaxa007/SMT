package timaxa007.pack.conjoint.block;

import net.minecraft.block.material.Material;
import timaxa007.pack.conjoint.PackConjoint;
import timaxa007.pack.conjoint.object.ModifiedBlock;

public class BlockGroundBlocks extends ModifiedBlock {

	public BlockGroundBlocks(String tag) {
		super(tag, Material.ground);
		setCreativeTab(PackConjoint.tab_conjoint);
	}

}
