package mods.timaxa007.pack.weapon.item;

import mods.timaxa007.tms.util.UtilTMS;
import net.minecraft.item.Item;

public class ListItem {

	public static boolean 
	items_for_weapons_be, 
	molotov_cocktail_be, 
	weapons_be, 
	ammos_be, 
	magazines_be;

	public static Item 
	items_for_weapons, 
	molotov_cocktail, 
	weapons, 
	ammos, 
	magazines;

	public static Item[] list_item;

	public static void preInit() {

		if (items_for_weapons_be) items_for_weapons = new ItemsWeapons("items_for_weapons");
		if (molotov_cocktail_be) molotov_cocktail = new MolotovCocktail("molotov_cocktail");
		if (weapons_be) weapons = new ItemWeapons("weapons");
		if (ammos_be) ammos = new ItemAmmos("ammos");
		if (magazines_be) magazines = new ItemMagazines("magazines");

		list_item = new Item[] {
				items_for_weapons, 
				molotov_cocktail, 
				weapons, 
				ammos, 
				magazines
		};

		UtilTMS.UtilItem.RegItem(list_item);

	}

}
