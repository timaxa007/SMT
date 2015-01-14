package mods.timaxa007.pack.weapon.item;

import mods.timaxa007.tms.util.UtilTMS;
import net.minecraft.item.Item;

public class ListItem {

	public static Item items_for_weapons;
	public static Item molotov_cocktail;
	public static Item weapons;
	public static Item ammos;
	public static Item magazines;

	public static Item[] list_item;

	public static void preInit() {

		items_for_weapons = new ItemsWeapons();
		molotov_cocktail = new MolotovCocktail();
		weapons = new ItemWeapons();
		ammos = new ItemAmmos();
		magazines = new ItemMagazines();

		list_item = new Item[] {
				items_for_weapons, 
				molotov_cocktail, 
				weapons, 
				ammos, 
				magazines
		};

		for (int i = 0; i < list_item.length; i++) 
			UtilTMS.UtilItem.RegItem(list_item[i]);

	}

}
