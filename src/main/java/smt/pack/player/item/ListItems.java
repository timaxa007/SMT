package smt.pack.player.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import smt.pack.player.object.ItemDummy;

public class ListItems {

	public static Item
	itemsPlayer
	;

	public static Item[] items;

	public static void init() {

		itemsPlayer = new ItemItemsPlayer("itemsPlayer");

		items = new Item[]{
				itemsPlayer
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
