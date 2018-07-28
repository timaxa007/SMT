package smt.pack.medicine.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import smt.pack.medicine.SMTMedicine;

public final class Items {

	public static Item
	itemsMedicine
	;

	public static final void init() {

		itemsMedicine = new ItemItemsMedicine().setUnlocalizedName("items_medicine").setCreativeTab(SMTMedicine.tabMedicine).setHasSubtypes(true).setMaxDamage(0);
		GameRegistry.registerItem(itemsMedicine, "item_items_medicine");

	}

}
