package timaxa007.module.substance.block;

import timaxa007.pack.furniture.PackFurniture;
import timaxa007.pack.conjoint.object.ModifiedBlock;
import net.minecraft.block.material.Material;

public class BlockSubstanceFakeLavaDynamic extends ModifiedBlock {

	public BlockSubstanceFakeLavaDynamic(String tag) {
		super(tag, Material.lava);
		setCreativeTab(PackFurniture.tab_furniture);
		setHardness(100.0F);
	}

}
