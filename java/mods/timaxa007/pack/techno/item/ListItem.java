package mods.timaxa007.pack.techno.item;

import mods.timaxa007.tms.util.UtilTMS;
import net.minecraft.item.Item;

public class ListItem {

	public static Item items_for_techno;
	public static Item tool_electric_wrench;
	public static Item tool_electric_drills;

	public static Item[] list_item;

	public static void preInit() {

		items_for_techno = new ItemsTechno();
		tool_electric_wrench = new ToolElectricWrench();
		tool_electric_drills = new ToolElectricDrills();

		list_item = new Item[] {
				items_for_techno, 
				tool_electric_wrench, 
				tool_electric_drills
		};

		for (int i = 0; i < list_item.length; i++) 
			UtilTMS.UtilItem.RegItem(list_item[i]);

	}

}
