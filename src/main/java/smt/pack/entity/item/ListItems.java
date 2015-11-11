package smt.pack.entity.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import smt.pack.entity.object.ItemDummy;

public class ListItems {

	public static Item
	itemsEntity
	;

	public static Item[] items;

	public static void init() {

		itemsEntity = new ItemItemsEntity("itemsEntity");

		items = new Item[]{
				itemsEntity
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
