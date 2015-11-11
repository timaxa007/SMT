package smt.pack.technology.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import smt.pack.technology.object.ItemDummy;

public class ListItems {

	public static Item
	itemsTechnology
	;

	public static Item[] items;

	public static void init() {

		itemsTechnology = new ItemItemsTechnology("itemsTechnology");

		items = new Item[]{
				itemsTechnology
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
