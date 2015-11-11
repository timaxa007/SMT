package smt.pack.cookery.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import smt.pack.cookery.object.ItemDummy;

public class ListItems {

	public static Item
	itemsCookery
	;

	public static Item[] items;

	public static void init() {

		itemsCookery = new ItemItemsCookery("itemsCookery");

		items = new Item[]{
				itemsCookery
		};

		for (Item item : items) {
			if (item != null) {
				if (item instanceof ItemDummy)
					GameRegistry.registerItem(item, ((ItemDummy) item).getTag());
				else
					GameRegistry.registerItem(item, item.getUnlocalizedName().substring(5));
			}
		}

	}

}
