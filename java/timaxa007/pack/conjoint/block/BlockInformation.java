package timaxa007.pack.conjoint.block;

import net.minecraft.block.material.Material;
import timaxa007.pack.conjoint.PackConjoint;
import timaxa007.pack.conjoint.object.ModifiedBlock;

public class BlockInformation extends ModifiedBlock {

	public BlockInformation(String tag) {
		super(tag, Material.iron);
		setCreativeTab(PackConjoint.tab_conjoint);
	}

}
