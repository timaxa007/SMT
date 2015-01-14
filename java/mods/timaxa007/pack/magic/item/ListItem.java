package mods.timaxa007.pack.magic.item;

import mods.timaxa007.tms.util.UtilTMS;
import net.minecraft.item.Item;

public class ListItem {

	public static Item items_for_magic;
	public static Item wands;
	public static Item stuffs;
	public static Item arrow_mini;
	public static Item teleport;
	public static Item globular;

	public static Item[] list_item;

	public static void preInit() {

		items_for_magic = new ItemsMagic();
		//magic_bow = new BowMagic();
		wands = new ItemWands();
		stuffs = new ItemStuffs();
		arrow_mini = new ItemArrowMini();
		teleport = new ItemTeleport();
		globular = new ItemGlobular();

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
