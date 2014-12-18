package mods.timaxa007.pack.techno.items;

import mods.timaxa007.pack.techno.PackTechno;
import net.minecraft.item.Item;

public class ToolElectricWrench extends Item {

	public ToolElectricWrench() {
		super();
		setCreativeTab(PackTechno.proxy.tab_techno);
		setTextureName("timaxa007:test_item");
		setUnlocalizedName("electric.wrench");
	}

}