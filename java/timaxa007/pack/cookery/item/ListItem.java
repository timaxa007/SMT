package timaxa007.pack.cookery.item;

import net.minecraft.item.Item;
import timaxa007.core.object.ItemDummy;
import timaxa007.pack.cookery.PackCookery;
import cpw.mods.fml.common.registry.GameRegistry;

public class ListItem {

	public static Item
	nutrient
	;

	public static Item[] list;

	public static void init() {

		nutrient = new ItemNutrient("nutrient").setCreativeTab(PackCookery.tabCookery);

		list = new Item[] {
				nutrient
		};

		for (Item item : list) {
			if (item != null && item instanceof ItemDummy)
				GameRegistry.registerItem(item, "item_" + ((ItemDummy)item).getTag());
		}

	}

}
