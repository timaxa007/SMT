package timaxa007.pack.item.config;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import timaxa007.pack.item.PackItem;

public class ConfigItem {
	//--------------------------------------------------------------------------------------------------------------
	public static void main() {
		Configuration cfg = new Configuration(new File("./config/smt/pack/" + PackItem.MODID, "main.cfg"));
		cfg.load();

		PackItem.block.rock_blocks_be = cfg.get("block", "rock_blocks", true).getBoolean();
		PackItem.block.glass_blocks_be = cfg.get("block", "glass_blocks", true).getBoolean();
		PackItem.block.wood_blocks_be = cfg.get("block", "wood_blocks", true).getBoolean();
		PackItem.block.ground_blocks_be = cfg.get("block", "ground_blocks", true).getBoolean();
		PackItem.block.sand_blocks_be = cfg.get("block", "sand_blocks", true).getBoolean();
		PackItem.block.cloth_blocks_be = cfg.get("block", "cloth_blocks", true).getBoolean();
		PackItem.block.metal_blocks_be = cfg.get("block", "metal_blocks", true).getBoolean();

		PackItem.item.items_for_items_be = cfg.get("item", "items_for_items", true).getBoolean();

		PackItem.item.tool_axe_be = cfg.get("item", "tool_axe", true).getBoolean();
		PackItem.item.tool_shovel_be = cfg.get("item", "tool_shovel", true).getBoolean();
		PackItem.item.tool_pickaxe_be = cfg.get("item", "tool_pickaxe", true).getBoolean();
		PackItem.item.tool_hoe_be = cfg.get("item", "tool_hoe", true).getBoolean();
		PackItem.item.tool_hammer_be = cfg.get("item", "tool_hammer", true).getBoolean();
		PackItem.item.tool_sickle_be = cfg.get("item", "tool_sickle", true).getBoolean();
		PackItem.item.tool_scythe_be = cfg.get("item", "tool_scythe", true).getBoolean();
		PackItem.item.tool_sword_be = cfg.get("item", "tool_sword", true).getBoolean();
		PackItem.item.tool_battle_axe_be = cfg.get("item", "tool_battle_axe", true).getBoolean();
		PackItem.item.tool_battle_hammer_be = cfg.get("item", "tool_battle_hammer", true).getBoolean();
		PackItem.item.tool_chisel_be = cfg.get("item", "tool_chisel", true).getBoolean();
		PackItem.item.tool_cutter_be = cfg.get("item", "tool_cutter", true).getBoolean();
		PackItem.item.tool_screwdriver_be = cfg.get("item", "tool_screwdriver", true).getBoolean();
		PackItem.item.tool_wrench_be = cfg.get("item", "tool_wrench", true).getBoolean();
		PackItem.item.tool_knife_be = cfg.get("item", "tool_knife", true).getBoolean();
		PackItem.item.tool_fry_pan_be = cfg.get("item", "tool_fry_pan", true).getBoolean();
		PackItem.item.tool_pan_be = cfg.get("item", "tool_pan", true).getBoolean();
		PackItem.item.tool_jar_be = cfg.get("item", "tool_jar", true).getBoolean();
		PackItem.item.tool_saw_be = cfg.get("item", "tool_saw", true).getBoolean();
		PackItem.item.tool_crowbar_be = cfg.get("item", "tool_crowbar", true).getBoolean();
		PackItem.item.tool_dagger_be = cfg.get("item", "tool_dagger", true).getBoolean();
		PackItem.item.tool_cleaver_be = cfg.get("item", "tool_cleaver", true).getBoolean();
		PackItem.item.tool_greatsword_be = cfg.get("item", "tool_greatsword", true).getBoolean();
		PackItem.item.tool_spear_be = cfg.get("item", "tool_spear", true).getBoolean();
		PackItem.item.tool_whip_be = cfg.get("item", "tool_whip", true).getBoolean();
		PackItem.item.tool_shuriken_be = cfg.get("item", "tool_shuriken", true).getBoolean();
		PackItem.item.tool_tomahawk_be = cfg.get("item", "tool_tomahawk", true).getBoolean();
		PackItem.item.tool_shield_be = cfg.get("item", "tool_shield", true).getBoolean();
		PackItem.item.tool_craft_be = cfg.get("item", "tool_craft", true).getBoolean();

		cfg.save();
	}
	//--------------------------------------------------------------------------------------------------------------
}
