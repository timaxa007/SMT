package mods.timaxa007.pack.techno.item;

import mods.timaxa007.tms.util.UtilTMS;
import net.minecraft.item.Item;

public class ListItem {

	public static boolean 
	items_for_techno_be, 
	tool_electric_wrench_be, 
	tool_electric_drills_be;

	public static Item 
	items_for_techno, 
	tool_electric_wrench, 
	tool_electric_drills;

	public static Item[] list_item;

	public static void preInit() {

		if (items_for_techno_be) items_for_techno = new ItemsTechno("items_for_techno");
		if (tool_electric_wrench_be) tool_electric_wrench = new ToolElectricWrench("tool_electric_wrench");
		if (tool_electric_drills_be) tool_electric_drills = new ToolElectricDrills("tool_electric_drills");

		list_item = new Item[] {
				items_for_techno, 
				tool_electric_wrench, 
				tool_electric_drills
		};

		for (int i = 0; i < list_item.length; i++) 
			UtilTMS.UtilItem.RegItem(list_item[i]);

	}

}
