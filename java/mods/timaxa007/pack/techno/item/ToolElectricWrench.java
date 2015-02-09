package mods.timaxa007.pack.techno.item;

import mods.timaxa007.pack.techno.PackTechno;
import mods.timaxa007.tms.util.ModifiedItem;

public class ToolElectricWrench extends ModifiedItem {

	public ToolElectricWrench(String tag) {
		super(tag);
		setCreativeTab(PackTechno.tab_techno);
		setTextureName("timaxa007:tool/electric/wrench");
	}

}