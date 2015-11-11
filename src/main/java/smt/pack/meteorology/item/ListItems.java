package smt.pack.meteorology.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import smt.pack.meteorology.object.ItemDummy;

public class ListItems {

	public static Item
	itemsMeteorology
	;

	public static Item[] items;

	public static void init() {

		itemsMeteorology = new ItemItemsMeteorology("itemsMeteorology");

		items = new Item[]{
				itemsMeteorology
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
