package timaxa007.pack.weapon.item;

import net.minecraft.item.Item;
import timaxa007.smt.util.UtilSMT;

public class ListItem {

	public static boolean 
	items_for_weapons_be, 
	molotov_cocktail_be, 
	weapon_be, 
	ammo_be, 
	magazine_be;

	public static Item 
	items_for_weapons, 
	molotov_cocktail, 
	weapon, 
	ammo, 
	magazine;

	public static Item[] list_item;

	public static void preInit() {

		if (items_for_weapons_be) items_for_weapons = new ItemsWeapons("items_for_weapons");
		if (molotov_cocktail_be) molotov_cocktail = new MolotovCocktail("molotov_cocktail");
		if (weapon_be) weapon = new ItemWeapons("weapon");
		//if (ammo_be) ammo = new ItemAmmos("ammo");
		//if (magazine_be) magazine = new ItemMagazines("magazine");

		list_item = new Item[] {
				items_for_weapons, 
				molotov_cocktail, 
				weapon, 
				ammo, 
				magazine
		};

		UtilSMT.UtilItem.RegItem(list_item);

	}

}
