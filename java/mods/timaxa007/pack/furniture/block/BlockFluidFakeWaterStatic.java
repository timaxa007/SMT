package mods.timaxa007.pack.furniture.block;

import mods.timaxa007.pack.furniture.PackFurniture;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockFluidFakeWaterStatic extends Block {

	public BlockFluidFakeWaterStatic() {
		super(Material.water);
		setCreativeTab(PackFurniture.tab_furniture);
		setHardness(100.0F);
	}

}
