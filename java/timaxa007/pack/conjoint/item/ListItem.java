package timaxa007.pack.conjoint.item;

import net.minecraft.item.Item;
import timaxa007.smt.util.UtilSMT;

public class ListItem {

	public static boolean
	items_for_conjoint_be,

	information_be,

	storage_be,

	tool_axe_be,
	tool_shovel_be,
	tool_pickaxe_be,
	tool_hoe_be,
	tool_hammer_be,
	tool_sickle_be,
	tool_scythe_be,
	tool_sword_be,
	tool_battle_axe_be,
	tool_battle_hammer_be,
	tool_chisel_be,
	tool_cutter_be,
	tool_screwdriver_be,
	tool_wrench_be,
	tool_knife_be,
	tool_fry_pan_be,
	tool_pan_be,
	tool_jar_be,
	tool_saw_be,
	tool_crowbar_be,
	tool_dagger_be,
	tool_cleaver_be,
	tool_greatsword_be,
	tool_spear_be,
	tool_whip_be,
	tool_shuriken_be,
	tool_tomahawk_be,
	tool_shield_be,
	tool_craft_be,
	armor_techne_be
	;

	public static Item 
	items_for_conjoint,

	information,

	storage,

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
	tool_shield,
	tool_craft,
	armor_techne
	;

	public static Item[] list_item;

	public static void preInit() {

		if (items_for_conjoint_be) items_for_conjoint = new ItemsItems("items_for_items");

		if (information_be) information = new ItemInformation("information");

		if (storage_be) storage = new ItemStorage("storage");

		if (tool_axe_be) tool_axe = new ToolAxe("tool_axe");
		if (tool_shovel_be) tool_shovel = new ToolShovel("tool_shovel");
		if (tool_pickaxe_be) tool_pickaxe = new ToolPickaxe("tool_pickaxe");
		if (tool_hoe_be) tool_hoe = new ToolHoe("tool_hoe");
		if (tool_hammer_be) tool_hammer = new ToolHammer("tool_hammer");
		if (tool_sickle_be) tool_sickle = new ToolSickle("tool_sickle");
		if (tool_scythe_be) tool_scythe = new ToolScythe("tool_scythe");
		if (tool_sword_be) tool_sword = new ToolSword("tool_sword");
		if (tool_battle_axe_be) tool_battle_axe = new ToolBattleAxe("tool_battle_axe");
		if (tool_battle_hammer_be) tool_battle_hammer = new ToolBattleHammer("tool_battle_hammer");
		if (tool_chisel_be) tool_chisel = new ToolAxe("tool_chisel");
		if (tool_cutter_be) tool_cutter = new ToolAxe("tool_cutter");
		if (tool_screwdriver_be) tool_screwdriver = new ToolAxe("tool_screwdriver");
		if (tool_wrench_be) tool_wrench = new ToolAxe("tool_wrench");
		if (tool_knife_be) tool_knife = new ToolAxe("tool_knife");
		if (tool_fry_pan_be) tool_fry_pan = new ToolAxe("tool_fry_pan");
		if (tool_pan_be) tool_pan = new ToolAxe("tool_pan");
		if (tool_jar_be) tool_jar = new ToolAxe("tool_jar");
		if (tool_saw_be) tool_saw = new ToolAxe("tool_saw");
		if (tool_crowbar_be) tool_crowbar = new ToolAxe("tool_crowbar");
		if (tool_dagger_be) tool_dagger = new ToolAxe("tool_dagger");
		if (tool_cleaver_be) tool_cleaver = new ToolAxe("tool_cleaver");
		if (tool_greatsword_be) tool_greatsword = new ToolAxe("tool_greatsword");
		if (tool_spear_be) tool_spear = new ToolAxe("tool_spear");
		if (tool_whip_be) tool_whip = new ToolAxe("tool_whip");
		if (tool_shuriken_be) tool_shuriken = new ToolAxe("tool_shuriken");
		if (tool_tomahawk_be) tool_tomahawk = new ToolAxe("tool_tomahawk");
		if (tool_shield_be) tool_shield = new ToolShield("tool_shield");
		if (tool_craft_be) tool_craft = new ToolCraft("tool_craft");
		if (armor_techne_be) armor_techne = new ArmorTechne("armor_techne");

		list_item = new Item[] {
				items_for_conjoint,

				information,

				storage,

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
				tool_shield,
				tool_craft,
				armor_techne
		};

		UtilSMT.UtilItem.RegItem(list_item);
	}

}