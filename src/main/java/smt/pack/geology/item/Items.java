package smt.pack.geology.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public final class Items {

	public static Item
	itemsGeology
	;

	public static final void init() {

		itemsGeology = new ItemItemsGeology().setUnlocalizedName("items_geology");
		GameRegistry.registerItem(itemsGeology, "item_items_geology");

	}

}
