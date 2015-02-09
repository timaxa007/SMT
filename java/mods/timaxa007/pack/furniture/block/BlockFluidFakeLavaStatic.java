package mods.timaxa007.pack.furniture.block;

import mods.timaxa007.pack.furniture.PackFurniture;
import mods.timaxa007.tms.util.ModifiedBlock;
import net.minecraft.block.material.Material;

public class BlockFluidFakeLavaStatic extends ModifiedBlock {

	public BlockFluidFakeLavaStatic(String tag) {
		super(tag, Material.lava);
		setCreativeTab(PackFurniture.tab_furniture);
		setHardness(100.0F);
	}

}
