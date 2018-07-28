package smt.pack.privacy.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import smt.pack.privacy.SMTPrivacy;

public final class Items {

	public static Item
	itemsPrivacy
	;

	public static final void init() {

		itemsPrivacy = new ItemItemsPrivacy().setUnlocalizedName("items_privacy").setCreativeTab(SMTPrivacy.tabPrivacy);
		GameRegistry.registerItem(itemsPrivacy, "item_items_privacy");

	}

}
