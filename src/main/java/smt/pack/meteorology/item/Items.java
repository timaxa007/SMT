package smt.pack.meteorology.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import smt.pack.meteorology.SMTMeteorology;

public final class Items {

	public static Item
	itemsMeteorology
	;

	public static final void init() {

		itemsMeteorology = new ItemItemsMeteorology().setUnlocalizedName("items_meteorology").setCreativeTab(SMTMeteorology.tabMeteorology);
		GameRegistry.registerItem(itemsMeteorology, "item_items_meteorology");


	}

}
