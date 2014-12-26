package mods.timaxa007.pack.weapon.item;

import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;

public class ItemList {

	public static Item items_for_weapons;
	public static Item molotov_cocktail;
	public static Item weapons;
	public static Item ammos;
	public static Item magazines;

	public static void preInit() {

		items_for_weapons = new ItemsWeapons();
		molotov_cocktail = new MolotovCocktail();
		weapons = new ItemWeapons();
		ammos = new ItemAmmos();
		magazines = new ItemMagazines();

		GameRegistry.registerItem(items_for_weapons, "ItemsWeapons");
		GameRegistry.registerItem(molotov_cocktail, "MolotovCocktail");
		GameRegistry.registerItem(weapons, "ItemWeapons");
		GameRegistry.registerItem(ammos, "ItemAmmos");
		GameRegistry.registerItem(magazines, "ItemMagazines");

	}

}
