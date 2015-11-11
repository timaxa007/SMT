package smt.pack.geology.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import smt.pack.geology.object.ItemDummy;

public class ListItems {

	public static Item
	itemsGeology
	;

	public static Item[] items;

	public static void init() {

		itemsGeology = new ItemItemsGeology("itemsGeology");

		items = new Item[]{
				itemsGeology
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
