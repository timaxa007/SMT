package timaxa007.pack.furniture.block;

import timaxa007.pack.furniture.PackFurniture;
import timaxa007.tms.object.ModifiedBlock;
import net.minecraft.block.material.Material;

public class BlockFluidFakeWaterDynamic extends ModifiedBlock {

	public BlockFluidFakeWaterDynamic(String tag) {
		super(tag, Material.water);
		setCreativeTab(PackFurniture.tab_furniture);
		setHardness(100.0F);
	}

}
