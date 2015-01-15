package mods.timaxa007.pack.mining.item;

import mods.timaxa007.tms.util.UtilTMS;
import net.minecraft.item.Item;

public class ListItem {

	public static Item 
	items_for_mining;

	public static Item[] list_item;

	public static void preInit() {

		items_for_mining = new ItemsMining("items_for_mining");

		list_item = new Item[] {
				items_for_mining
		};

		for (int i = 0; i < list_item.length; i++) 
			UtilTMS.UtilItem.RegItem(list_item[i]);

	}

}
