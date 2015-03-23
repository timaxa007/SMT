package timaxa007.pack.furniture.item;

import timaxa007.tms.util.UtilTMS;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ListItem {

	public static final ArmorMaterial COSTUME = EnumHelper.addArmorMaterial("COSTUME", 0, new int[] {2, 2, 2, 1}, 3);
	public static final ArmorMaterial METALSMATERIAL = EnumHelper.addArmorMaterial("METALSMATERIAL", 15, new int[] {3, 7, 5, 3}, 10);
	public static final ArmorMaterial GEMSMATERIAL = EnumHelper.addArmorMaterial("GEMSMATERIAL", 15, new int[] {5, 10, 7, 4}, 12);

	public static final ToolMaterial TOOLGEMS = EnumHelper.addToolMaterial("TOOLGEMS", 3, 512, 7.0F, 3, 7);
	public static final ToolMaterial TOOLMETALS = EnumHelper.addToolMaterial("TOOLMETALS", 2, 300, 6.0F, 2, 11);

	public static boolean 
	items_for_furniture_be, 
	colored_be, 
	paint_can_be, 
	backpack_be, 
	filter_charcoal_be, 
	kitchenware_be, 
	particles_gun_be, 

	tool_brush_be, 
	tool_airbrush_be, 

	armor_masks_be, 
	armor_backpacks_be, 
	armor_costumes_helmet_be, 
	armor_costumes_chest_be, 
	armor_costumes_leggin_be, 
	armor_costumes_boot_be, 
	armor_medieval_helmet_be, 
	armor_medieval_chest_be, 
	armor_medieval_leggin_be, 
	armor_medieval_boot_be, 
	armor_new_helmet_be, 
	armor_new_chest_be, 
	armor_new_leggin_be, 
	armor_new_boot_be;

	public static Item 
	items_for_furniture, 
	colored, 
	paint_can, 
	backpack, 
	filter_charcoal, 
	kitchenware, 
	particles_gun, 

	tool_brush, 
	tool_airbrush, 

	armor_masks, 
	armor_backpacks, 
	armor_costumes_helmet, 
	armor_costumes_chest, 
	armor_costumes_leggin, 
	armor_costumes_boot, 
	armor_medieval_helmet, 
	armor_medieval_chest, 
	armor_medieval_leggin, 
	armor_medieval_boot, 
	armor_new_helmet, 
	armor_new_chest, 
	armor_new_leggin, 
	armor_new_boot;

	public static Item[] list_item;

	public static void preInit() {

		if (items_for_furniture_be) items_for_furniture = new ItemsFurniture("items_for_furniture");
		if (colored_be) colored = new ItemColored("colored");
		if (paint_can_be) paint_can = new ItemPaintCan("paint_can");
		if (backpack_be) backpack = new ItemBackpack("backpack");
		if (filter_charcoal_be) filter_charcoal = new ItemFilterCharcoal("filter_charcoal");
		if (kitchenware_be) kitchenware = new ItemKitchenware("kitchenware");
		if (particles_gun_be) particles_gun = new ItemParticlesGun("particles_gun");

		if (tool_brush_be) tool_brush = new ToolBrush("tool_brush");
		if (tool_airbrush_be) tool_airbrush = new ToolAirBrush("tool_airbrush");

		if (armor_masks_be) armor_masks = new ArmorMasks("armor_masks");
		if (armor_backpacks_be) armor_backpacks = new ArmorBackpacks("armor_backpacks");
		if (armor_costumes_helmet_be) armor_costumes_helmet = new ArmorCostumes("armor_costumes_helmet", COSTUME, 0, 0);
		if (armor_costumes_chest_be) armor_costumes_chest = new ArmorCostumes("armor_costumes_chest", COSTUME, 0, 1);
		if (armor_costumes_leggin_be) armor_costumes_leggin = new ArmorCostumes("armor_costumes_leggin", COSTUME, 0, 2);
		if (armor_costumes_boot_be) armor_costumes_boot = new ArmorCostumes("armor_costumes_boot", COSTUME, 0, 3);
		if (armor_medieval_helmet_be) armor_medieval_helmet = new ArmorMedieval("armor_medieval_helmet", COSTUME, 0, 0);
		if (armor_medieval_chest_be) armor_medieval_chest = new ArmorMedieval("armor_medieval_chest", COSTUME, 0, 1);
		if (armor_medieval_leggin_be) armor_medieval_leggin = new ArmorMedieval("armor_medieval_leggin", COSTUME, 0, 2);
		if (armor_medieval_boot_be) armor_medieval_boot = new ArmorMedieval("armor_medieval_boot", COSTUME, 0, 3);
		if (armor_new_helmet_be) armor_new_helmet = new ArmorNew("armor_new_helmet", COSTUME, 0, 0);
		if (armor_new_chest_be) armor_new_chest = new ArmorNew("armor_new_chest", COSTUME, 0, 1);
		if (armor_new_leggin_be) armor_new_leggin = new ArmorNew("armor_new_leggin", COSTUME, 0, 2);
		if (armor_new_boot_be) armor_new_boot = new ArmorNew("armor_new_boot", COSTUME, 0, 3);

		list_item = new Item[] {
				items_for_furniture, 
				colored, 
				paint_can, 
				backpack, 
				filter_charcoal, 
				kitchenware, 
				particles_gun, 

				tool_brush, 
				tool_airbrush, 

				armor_masks, 
				armor_backpacks, 
				armor_costumes_helmet, 
				armor_costumes_chest, 
				armor_costumes_leggin, 
				armor_costumes_boot, 
				armor_medieval_helmet, 
				armor_medieval_chest, 
				armor_medieval_leggin, 
				armor_medieval_boot, 
				armor_new_helmet, 
				armor_new_chest, 
				armor_new_leggin, 
				armor_new_boot
		};

		UtilTMS.UtilItem.RegItem(list_item);

	}

}
