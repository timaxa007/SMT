package mods.timaxa007.pack.mining.item;

import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;

public class ItemList {

	public static Item items_for_mining;

	public static void list() {

		items_for_mining = new ItemsMining();

		GameRegistry.registerItem(items_for_mining, "ItemsMining");

	}

}
