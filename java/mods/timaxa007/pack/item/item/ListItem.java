package mods.timaxa007.pack.item.item;

import mods.timaxa007.tms.util.UtilTMS;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ListItem {

	public static final ArmorMaterial CLOTHWOOL = EnumHelper.addArmorMaterial("CLOTHWOOL", 6, new int[] {2, 3, 2, 1}, 10);

	public static Item items_for_items;

	public static Item armor_wool_colors_helmet;
	public static Item armor_wool_colors_chest;
	public static Item armor_wool_colors_leggin;
	public static Item armor_wool_colors_boot;

	public static Item tool_axe;
	public static Item tool_shovel;
	public static Item tool_pickaxe;
	public static Item tool_hoe;
	public static Item tool_hammer;
	public static Item tool_sickle;
	public static Item tool_scythe;
	public static Item tool_sword;
	public static Item tool_battle_axe;
	public static Item tool_battle_hammer;
	public static Item tool_chisel;
	public static Item tool_cutter;
	public static Item tool_screwdriver;
	public static Item tool_wrench;
	public static Item tool_knife;
	public static Item tool_fry_pan;
	public static Item tool_pan;
	public static Item tool_jar;
	public static Item tool_saw;
	public static Item tool_crowbar;
	public static Item tool_dagger;
	public static Item tool_cleaver;
	public static Item tool_greatsword;
	public static Item tool_spear;
	public static Item tool_whip;
	public static Item tool_shuriken;
	public static Item tool_tomahawk;
	public static Item tool_shield;

	public static Item[] list_items;

	public static void preInit() {

		items_for_items = new ItemsItems();

		armor_wool_colors_helmet = new ArmorWoolColors(CLOTHWOOL, 0, 0).setUnlocalizedName("armor_wool_colors_helmet");
		armor_wool_colors_chest = new ArmorWoolColors(CLOTHWOOL, 0, 1).setUnlocalizedName("armor_wool_colors_chest");
		armor_wool_colors_leggin = new ArmorWoolColors(CLOTHWOOL, 0, 2).setUnlocalizedName("armor_wool_colors_leggin");
		armor_wool_colors_boot = new ArmorWoolColors(CLOTHWOOL, 0, 3).setUnlocalizedName("armor_wool_colors_boot");

		tool_axe = new ToolAxe();
		tool_shovel = new ToolShovel();
		tool_pickaxe = new ToolPickaxe();
		tool_hoe = new ToolHoe();
		tool_hammer = new ToolHammer();
		tool_sickle = new ToolSickle();
		tool_scythe = new ToolScythe();
		tool_sword = new ToolSword();
		tool_battle_axe = new ToolBattleAxe();
		tool_battle_hammer = new ToolBattleHammer();

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
