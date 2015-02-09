package mods.timaxa007.pack.furniture.block;

import mods.timaxa007.pack.furniture.PackFurniture;
import mods.timaxa007.tms.util.ModifiedBlock;
import net.minecraft.block.material.Material;

public class BlockFluidFakeWaterStatic extends ModifiedBlock {

	public BlockFluidFakeWaterStatic(String tag) {
		super(tag, Material.water);
		setCreativeTab(PackFurniture.tab_furniture);
		setHardness(100.0F);
	}

}
