package timaxa007.pack.theurgy.item;

import net.minecraft.item.Item;
import timaxa007.core.object.ItemDummy;
import cpw.mods.fml.common.registry.GameRegistry;

public class ListItem {

	public static Item
	test
	;

	public static Item[] list;

	public static void init() {

		//test = new ItemTest("test");

		list = new Item[] {
				test
		};

		for (Item item : list) {
			if (item != null && item instanceof ItemDummy)
				GameRegistry.registerItem(item, "item_" + ((ItemDummy)item).getTag());
		}

	}

}
