package mods.timaxa007.pack.furniture.block;

import mods.timaxa007.pack.furniture.PackFurniture;
import mods.timaxa007.tms.util.BlockFixReg;
import net.minecraft.block.material.Material;

public class BlockFluidFakeWaterDynamic extends BlockFixReg {

	public BlockFluidFakeWaterDynamic(String tag) {
		super(tag, Material.water);
		setCreativeTab(PackFurniture.tab_furniture);
		setHardness(100.0F);
	}

}
