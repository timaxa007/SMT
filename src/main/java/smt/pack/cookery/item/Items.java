package smt.pack.cookery.item;

import net.minecraft.item.Item;
import smt.pack.cookery.SMTCookery;
import cpw.mods.fml.common.registry.GameRegistry;
 
public final class Items {

	public static Item
	itemsCookery,
	food,
	drink
	;

	public static final void init() {

		itemsCookery = new ItemItemsCookery().setUnlocalizedName("items_cookery").setTextureName(SMTCookery.MODID + ":item_cookery").setCreativeTab(SMTCookery.tabCookery);
		GameRegistry.registerItem(itemsCookery, "item_items_cookery");

		food = new ItemFood().setUnlocalizedName("food").setTextureName(SMTCookery.MODID + ":food")/*.setMaxStackSize(1).setHasSubtypes(true).setMaxDamage(0)*/.setCreativeTab(SMTCookery.tabCookery);
		GameRegistry.registerItem(food, "item_food");

		drink = new ItemDrink().setUnlocalizedName("drink").setTextureName(SMTCookery.MODID + ":drink")/*.setMaxStackSize(1).setHasSubtypes(true).setMaxDamage(0)*/.setCreativeTab(SMTCookery.tabCookery);
		GameRegistry.registerItem(drink, "item_drink");

	}

}
