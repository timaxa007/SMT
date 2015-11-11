package smt.pack.medicine.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import smt.pack.medicine.object.ItemDummy;

public class ListItems {

	public static Item
	itemsMedicine
	;

	public static Item[] items;

	public static void init() {

		itemsMedicine = new ItemItemsMedicine("itemsMedicine");

		items = new Item[]{
				itemsMedicine
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
