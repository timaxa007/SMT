package timaxa007.pack.techno.item;

import timaxa007.pack.techno.PackTechno;
import timaxa007.tms.util.ModifiedItem;

public class ToolElectricWrench extends ModifiedItem {

	public ToolElectricWrench(String tag) {
		super(tag);
		setCreativeTab(PackTechno.tab_techno);
		setTextureName("timaxa007:tool/electric/wrench");
	}

}