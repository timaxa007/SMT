package mods.timaxa007.pack.magic.item;

import mods.timaxa007.tms.util.UtilTMS;
import net.minecraft.item.Item;

public class ListItem {

	public static Item 
	items_for_magic, 
	wands, 
	stuffs, 
	arrow_mini, 
	teleport, 
	globular;

	public static Item[] list_item;

	public static void preInit() {

		items_for_magic = new ItemsMagic("items_for_magic");
		//magic_bow = new BowMagic("magic_bow");
		wands = new ItemWands("wands");
		stuffs = new ItemStuffs("stuffs");
		arrow_mini = new ItemArrowMini("arrow_mini");
		teleport = new ItemTeleport("teleport");
		globular = new ItemGlobular("globular");

		list_item = new Item[] {
				items_for_magic, 
				wands, 
				stuffs, 
				arrow_mini, 
				teleport, 
				globular
		};

		for (int i = 0; i < list_item.length; i++) 
			UtilTMS.UtilItem.RegItem(list_item[i]);

	}

}
