package smt.pack.decorative.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import smt.pack.decorative.SMTDecorative;

public final class Items {

	public static Item
	itemsDecorative,
	record_march1,
	record_march2,
	record_march3,
	armorHead,
	armorBody,
	armorLegs,
	armorFeet
	;

	public static final void init() {

		itemsDecorative = new ItemItemsDecorative().setUnlocalizedName("items_decorative").setCreativeTab(SMTDecorative.tabDecorative);
		GameRegistry.registerItem(itemsDecorative, "item_items_decorative");

		record_march1 = new ItemRecordIS("march1").setUnlocalizedName("march1").setCreativeTab(SMTDecorative.tabDecorative);
		GameRegistry.registerItem(record_march1, "item_march1");

		record_march2 = new ItemRecordIS("march2").setUnlocalizedName("march2").setCreativeTab(SMTDecorative.tabDecorative);
		GameRegistry.registerItem(record_march2, "item_march2");

		record_march3 = new ItemRecordIS("march3").setUnlocalizedName("march3").setCreativeTab(SMTDecorative.tabDecorative);
		GameRegistry.registerItem(record_march3, "item_march3");

		armorHead = new ItemArmorDecorative(0).setUnlocalizedName("armor_head").setCreativeTab(SMTDecorative.tabDecorative);
		GameRegistry.registerItem(armorHead, "item_armor_head");

		armorBody = new ItemArmorDecorative(1).setUnlocalizedName("armor_body").setCreativeTab(SMTDecorative.tabDecorative);
		GameRegistry.registerItem(armorBody, "item_armor_body");

		armorLegs = new ItemArmorDecorative(2).setUnlocalizedName("armor_legs").setCreativeTab(SMTDecorative.tabDecorative);
		GameRegistry.registerItem(armorLegs, "item_armor_legs");

		armorFeet = new ItemArmorDecorative(3).setUnlocalizedName("armor_feet").setCreativeTab(SMTDecorative.tabDecorative);
		GameRegistry.registerItem(armorFeet, "item_armor_feet");


	}

}
