package smt.pack.magic.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import smt.pack.magic.object.ItemDummy;

public class ListItems {

	public static Item
	itemsMagic
	;

	public static Item[] items;

	public static void init() {

		itemsMagic = new ItemItemsMagic("itemsMagic");

		items = new Item[]{
				itemsMagic
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
