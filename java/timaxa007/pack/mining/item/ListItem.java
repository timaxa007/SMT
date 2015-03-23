package timaxa007.pack.mining.item;

import timaxa007.tms.util.UtilTMS;
import net.minecraft.item.Item;

public class ListItem {

	public static boolean 
	items_for_mining_be;

	public static Item 
	items_for_mining;

	public static Item[] list_item;

	public static void preInit() {

		if (items_for_mining_be) items_for_mining = new ItemsMining("items_for_mining");

		list_item = new Item[] {
				items_for_mining
		};

		UtilTMS.UtilItem.RegItem(list_item);

	}

}
