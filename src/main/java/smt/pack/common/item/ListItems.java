package smt.pack.common.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import smt.pack.common.object.ItemDummy;

public class ListItems {

	public static Item
	itemsCommon
	;

	public static Item[] items;

	public static void init() {

		itemsCommon = new ItemItemsCommon("itemsCommon");

		items = new Item[]{
				itemsCommon
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
