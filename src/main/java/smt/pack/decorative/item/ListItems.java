package smt.pack.decorative.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import smt.pack.decorative.object.ItemDummy;

public class ListItems {

	public static Item
	itemsDecorative
	;

	public static Item[] items;

	public static void init() {

		itemsDecorative = new ItemItemsDecorative("itemsDecorative");

		items = new Item[]{
				itemsDecorative
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
