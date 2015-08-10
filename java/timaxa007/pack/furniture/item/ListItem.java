package timaxa007.pack.furniture.item;

import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;
import timaxa007.smt.util.UtilSMT;

public class ListItem {

	public static boolean 
	items_for_furniture_be,
	colored_be,
	paint_can_be,
	storage_be,
	filter_charcoal_be,
	kitchenware_be,
	particles_gun_be,

	tool_brush_be,
	tool_airbrush_be
	;

	public static Item 
	items_for_furniture,
	colored,
	paint_can,
	storage,
	filter_charcoal,
	kitchenware,
	particles_gun,

	tool_brush,
	tool_airbrush
	;

	public static Item[] list_item;

	public static void preInit() {

		if (items_for_furniture_be) items_for_furniture = new ItemsFurniture("items_for_furniture");
		if (colored_be) colored = new ItemColored("colored");
		if (paint_can_be) paint_can = new ItemPaintCan("paint_can");
		if (storage_be) storage = new ItemStorage("storage");
		if (filter_charcoal_be) filter_charcoal = new ItemFilterCharcoal("filter_charcoal");
		if (kitchenware_be) kitchenware = new ItemKitchenware("kitchenware");
		if (particles_gun_be) particles_gun = new ItemParticlesGun("particles_gun");

		if (tool_brush_be) tool_brush = new ToolBrush("tool_brush");
		if (tool_airbrush_be) tool_airbrush = new ToolAirBrush("tool_airbrush");

		list_item = new Item[] {
				items_for_furniture,
				colored,
				paint_can,
				storage,
				filter_charcoal,
				kitchenware,
				particles_gun,

				tool_brush,
				tool_airbrush

		};

		UtilSMT.UtilItem.RegItem(list_item);

	}

}
