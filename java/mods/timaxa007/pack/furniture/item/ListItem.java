package mods.timaxa007.pack.furniture.item;

import mods.timaxa007.tms.util.UtilTMS;
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

	public static Item items_for_furniture;
	public static Item colored;
	public static Item paint_can;
	public static Item backpack;
	public static Item filter_charcoal;
	public static Item kitchenware;
	public static Item particles_gun;

	public static Item tool_brush;
	public static Item tool_airbrush;

	public static Item armor_masks;
	public static Item armor_backpacks;
	public static Item armor_costumes_helmet;
	public static Item armor_costumes_chest;
	public static Item armor_costumes_leggin;
	public static Item armor_costumes_boot;
	public static Item armor_medieval_helmet;
	public static Item armor_medieval_chest;
	public static Item armor_medieval_leggin;
	public static Item armor_medieval_boot;
	public static Item armor_new_helmet;
	public static Item armor_new_chest;
	public static Item armor_new_leggin;
	public static Item armor_new_boot;

	public static Item[] list_item;

	public static void preInit() {

		items_for_furniture = new ItemsFurniture();
		colored = new ItemColored();
		paint_can = new ItemPaintCan();
		backpack = new ItemBackpack();
		filter_charcoal = new ItemFilterCharcoal();
		kitchenware = new ItemKitchenware();
		particles_gun = new ItemParticlesGun();

		tool_brush = new ToolBrush();
		tool_airbrush = new ToolAirBrush();

		armor_masks = new ArmorMasks();
		armor_backpacks = new ArmorBackpacks();
		armor_costumes_helmet = new ArmorCostumes(COSTUME, 0, 0).setUnlocalizedName("armor_costumes_helmet");
		armor_costumes_chest = new ArmorCostumes(COSTUME, 0, 1).setUnlocalizedName("armor_costumes_chest");
		armor_costumes_leggin = new ArmorCostumes(COSTUME, 0, 2).setUnlocalizedName("armor_costumes_leggin");
		armor_costumes_boot = new ArmorCostumes(COSTUME, 0, 3).setUnlocalizedName("armor_costumes_boot");
		armor_medieval_helmet = new ArmorMedieval(COSTUME, 0, 0).setUnlocalizedName("armor_medieval_helmet");
		armor_medieval_chest = new ArmorMedieval(COSTUME, 0, 1).setUnlocalizedName("armor_medieval_chest");
		armor_medieval_leggin = new ArmorMedieval(COSTUME, 0, 2).setUnlocalizedName("armor_medieval_leggin");
		armor_medieval_boot = new ArmorMedieval(COSTUME, 0, 3).setUnlocalizedName("armor_medieval_boot");
		armor_new_helmet = new ArmorNew(COSTUME, 0, 0).setUnlocalizedName("armor_new_helmet");
		armor_new_chest = new ArmorNew(COSTUME, 0, 1).setUnlocalizedName("armor_new_chest");
		armor_new_leggin = new ArmorNew(COSTUME, 0, 2).setUnlocalizedName("armor_new_leggin");
		armor_new_boot = new ArmorNew(COSTUME, 0, 3).setUnlocalizedName("armor_new_boot");

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

		for (int i = 0; i < list_item.length; i++) 
			UtilTMS.UtilItem.RegItem(list_item[i]);

	}

}
