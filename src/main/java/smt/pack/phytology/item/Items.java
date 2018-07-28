package smt.pack.phytology.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import smt.pack.phytology.SMTPhytology;

public final class Items {

	public static Item
	itemsPhytology,
	itemFeed
	;

	public static final void init() {

		itemsPhytology = new ItemItemsPhytology().setUnlocalizedName("items_phytology").setCreativeTab(SMTPhytology.tabPhytology);
		GameRegistry.registerItem(itemsPhytology, "items_phytology");

		itemFeed = new ItemFeed().setUnlocalizedName("item_feed").setCreativeTab(SMTPhytology.tabPhytology);
		GameRegistry.registerItem(itemFeed, "item_feed");

	}

}
