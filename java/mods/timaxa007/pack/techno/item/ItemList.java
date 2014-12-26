package mods.timaxa007.pack.techno.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class ItemList {

	public static Item items_for_techno;
	public static Item tool_electric_wrench;
	public static Item tool_electric_drills;

	public static void preInit() {

		items_for_techno = new ItemsTechno();
		tool_electric_wrench = new ToolElectricWrench();
		tool_electric_drills = new ToolElectricDrills();

		GameRegistry.registerItem(items_for_techno, "ItemsTechno");
		GameRegistry.registerItem(tool_electric_wrench, "ToolWrench");
		GameRegistry.registerItem(tool_electric_drills, "ToolElectricDrills");

	}

}
