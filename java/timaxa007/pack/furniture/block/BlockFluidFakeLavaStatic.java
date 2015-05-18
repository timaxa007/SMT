package timaxa007.pack.furniture.block;

import timaxa007.pack.furniture.PackFurniture;
import timaxa007.smt.object.ModifiedBlock;
import net.minecraft.block.material.Material;

public class BlockFluidFakeLavaStatic extends ModifiedBlock {

	public BlockFluidFakeLavaStatic(String tag) {
		super(tag, Material.lava);
		setCreativeTab(PackFurniture.tab_furniture);
		setHardness(100.0F);
	}

}
