package smt.pack.vehicle.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import smt.pack.vehicle.SMTVehicle;

public final class Items {

	public static Item
	itemsVehicle
	;

	public static final void init() {

		itemsVehicle = new ItemItemsVehicle().setUnlocalizedName("items_vehicle").setCreativeTab(SMTVehicle.tabVehicle);
		GameRegistry.registerItem(itemsVehicle, "item_items_vehicle");

	}

}
