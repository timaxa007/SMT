package mods.timaxa007.pack.item.item;

import mods.timaxa007.tms.util.UtilTMS;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ListItem {

	public static final ArmorMaterial CLOTHWOOL = EnumHelper.addArmorMaterial("CLOTHWOOL", 6, new int[] {2, 3, 2, 1}, 10);

	public static Item 
	items_for_items, 

	armor_wool_colors_helmet, 
	armor_wool_colors_chest, 
	armor_wool_colors_leggin, 
	armor_wool_colors_boot, 

	tool_axe, 
	tool_shovel, 
	tool_pickaxe, 
	tool_hoe, 
	tool_hammer, 
	tool_sickle, 
	tool_scythe, 
	tool_sword, 
	tool_battle_axe, 
	tool_battle_hammer, 
	tool_chisel, 
	tool_cutter, 
	tool_screwdriver, 
	tool_wrench, 
	tool_knife, 
	tool_fry_pan, 
	tool_pan, 
	tool_jar, 
	tool_saw, 
	tool_crowbar, 
	tool_dagger, 
	tool_cleaver, 
	tool_greatsword, 
	tool_spear, 
	tool_whip, 
	tool_shuriken, 
	tool_tomahawk, 
	tool_shield;

	public static Item[] list_items;

	public static void preInit() {

		items_for_items = new ItemsItems("items_for_items");

		armor_wool_colors_helmet = new ArmorWoolColors("armor_wool_colors_helmet", CLOTHWOOL, 0, 0);
		armor_wool_colors_chest = new ArmorWoolColors("armor_wool_colors_chest", CLOTHWOOL, 0, 1);
		armor_wool_colors_leggin = new ArmorWoolColors("armor_wool_colors_leggin", CLOTHWOOL, 0, 2);
		armor_wool_colors_boot = new ArmorWoolColors("armor_wool_colors_boot", CLOTHWOOL, 0, 3);

		tool_axe = new ToolAxe("tool_axe");
		tool_shovel = new ToolShovel("tool_shovel");
		tool_pickaxe = new ToolPickaxe("tool_pickaxe");
		tool_hoe = new ToolHoe("tool_hoe");
		tool_hammer = new ToolHammer("tool_hammer");
		tool_sickle = new ToolSickle("tool_sickle");
		tool_scythe = new ToolScythe("tool_scythe");
		tool_sword = new ToolSword("tool_sword");
		tool_battle_axe = new ToolBattleAxe("tool_battle_axe");
		tool_battle_hammer = new ToolBattleHammer("tool_battle_hammer");

		list_items = new Item[] {
				items_for_items, 

				armor_wool_colors_helmet, 
				armor_wool_colors_chest, 
				armor_wool_colors_leggin, 
				armor_wool_colors_boot, 

				tool_axe, 
				tool_shovel, 
				tool_pickaxe, 
				tool_hoe, 
				tool_hammer, 
				tool_sickle, 
				tool_scythe, 
				tool_sword, 
				tool_battle_axe, 
				tool_battle_hammer
		};

		for (int i = 0; i < list_items.length; i++)
			UtilTMS.UtilItem.RegItem(list_items[i]);
	}

}
