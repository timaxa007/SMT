package smt.pack.phytology.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import smt.pack.phytology.object.ItemDummy;

public class ListItems {

	public static Item
	itemsPhytology
	;

	public static Item[] items;

	public static void init() {

		itemsPhytology = new ItemItemsPhytology("itemsPhytology");

		items = new Item[]{
				itemsPhytology
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
