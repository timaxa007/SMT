package timaxa007.pack.magic.item;

import timaxa007.tms.util.UtilTMS;
import net.minecraft.item.Item;

public class ListItem {

	public static boolean 
	items_for_magic_be,
	wands_be,
	stuffs_be,
	teleport_be,
	globular_be, 
	magic_bag_be;

	public static Item 
	items_for_magic,
	wands,
	stuffs,
	teleport,
	globular, 
	magic_bag;

	public static Item[] list_item;

	public static void preInit() {

		if (items_for_magic_be) items_for_magic = new ItemsMagic("items_for_magic");
		if (wands_be) wands = new ItemWands("wands");
		if (stuffs_be) stuffs = new ItemStuffs("stuffs");
		if (teleport_be) teleport = new ItemTeleport("teleport");
		if (globular_be) globular = new ItemGlobular("globular");
		if (magic_bag_be) magic_bag = new ItemMagicBag("magic_bag");
		//if (magic_bow_be) magic_bow = new BowMagic("magic_bow");
		//if (arrow_mini_be) arrow_mini = new ItemArrowMini("arrow_mini");

		list_item = new Item[] {
				items_for_magic,
				wands,
				stuffs,
				teleport,
				globular, 
				magic_bag
		};

		UtilTMS.UtilItem.RegItem(list_item);

	}

}
