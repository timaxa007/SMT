package timaxa007.pack.furniture.block;

import timaxa007.pack.furniture.PackFurniture;
import timaxa007.tms.util.ModifiedBlock;
import net.minecraft.block.material.Material;

public class BlockFluidFakeLavaDynamic extends ModifiedBlock {

	public BlockFluidFakeLavaDynamic(String tag) {
		super(tag, Material.lava);
		setCreativeTab(PackFurniture.tab_furniture);
		setHardness(100.0F);
	}

}
