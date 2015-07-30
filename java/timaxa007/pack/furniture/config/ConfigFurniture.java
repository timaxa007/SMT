package timaxa007.pack.furniture.config;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import timaxa007.pack.furniture.PackFurniture;

public class ConfigFurniture {
	//--------------------------------------------------------------------------------------------------------------
	public static void main() {
		Configuration cfg = new Configuration(new File("./config/smt/pack/" + PackFurniture.MODID, "main.cfg"));
		cfg.load();

		PackFurniture.block.furniture_machines_be = cfg.get("block", "furniture_machines", true).getBoolean();
		PackFurniture.block.furniture_rock_blocks_be = cfg.get("block", "furniture_rock_blocks", true).getBoolean();
		PackFurniture.block.furniture_glass_blocks_be = cfg.get("block", "furniture_glass_blocks", true).getBoolean();
		PackFurniture.block.furniture_wood_blocks_be = cfg.get("block", "furniture_wood_blocks", true).getBoolean();
		PackFurniture.block.furniture_ground_blocks_be = cfg.get("block", "furniture_ground_blocks", true).getBoolean();
		PackFurniture.block.furniture_sand_blocks_be = cfg.get("block", "furniture_sand_blocks", true).getBoolean();
		PackFurniture.block.furniture_cloth_blocks_be = cfg.get("block", "furniture_cloth_blocks", true).getBoolean();
		PackFurniture.block.furniture_metal_blocks_be = cfg.get("block", "furniture_metal_blocks", true).getBoolean();
		PackFurniture.block.cnstor_block_be = cfg.get("block", "cnstor_block", true).getBoolean();
		PackFurniture.block.cnstor_angle_be = cfg.get("block", "cnstor_angle", true).getBoolean();
		PackFurniture.block.cnstor_half_be = cfg.get("block", "cnstor_half", true).getBoolean();
		PackFurniture.block.cnstor_button_be = cfg.get("block", "cnstor_button", true).getBoolean();
		PackFurniture.block.cnstor_lever_be = cfg.get("block", "cnstor_lever", true).getBoolean();
		PackFurniture.block.cnstor_stairs_be = cfg.get("block", "cnstor_stairs", true).getBoolean();
		PackFurniture.block.cnstor_fence_be = cfg.get("block", "cnstor_fence", true).getBoolean();
		PackFurniture.block.cnstor_wall_be = cfg.get("block", "cnstor_wall", true).getBoolean();
		PackFurniture.block.cnstor_door_be = cfg.get("block", "cnstor_door", true).getBoolean();
		PackFurniture.block.cnstor_bed_be = cfg.get("block", "cnstor_bed", true).getBoolean();

		PackFurniture.block.air_light_0_be = cfg.get("block", "air_light_0", true).getBoolean();
		PackFurniture.block.air_light_1_be = cfg.get("block", "air_light_1", true).getBoolean();
		PackFurniture.block.air_light_2_be = cfg.get("block", "air_light_2", true).getBoolean();
		PackFurniture.block.air_light_3_be = cfg.get("block", "air_light_3", true).getBoolean();
		PackFurniture.block.air_light_4_be = cfg.get("block", "air_light_4", true).getBoolean();
		PackFurniture.block.air_light_5_be = cfg.get("block", "air_light_5", true).getBoolean();
		PackFurniture.block.air_light_6_be = cfg.get("block", "air_light_6", true).getBoolean();
		PackFurniture.block.air_light_7_be = cfg.get("block", "air_light_7", true).getBoolean();
		PackFurniture.block.air_light_8_be = cfg.get("block", "air_light_8", true).getBoolean();
		PackFurniture.block.air_light_9_be = cfg.get("block", "air_light_9", true).getBoolean();
		PackFurniture.block.air_light_10_be = cfg.get("block", "air_light_10", true).getBoolean();
		PackFurniture.block.air_light_11_be = cfg.get("block", "air_light_11", true).getBoolean();
		PackFurniture.block.air_light_12_be = cfg.get("block", "air_light_12", true).getBoolean();
		PackFurniture.block.air_light_13_be = cfg.get("block", "air_light_13", true).getBoolean();
		PackFurniture.block.air_light_14_be = cfg.get("block", "air_light_14", true).getBoolean();
		PackFurniture.block.air_light_15_be = cfg.get("block", "air_light_15", true).getBoolean();
		PackFurniture.block.air_light_16_be = cfg.get("block", "air_light_16", true).getBoolean();

		PackFurniture.block.light_0_be = cfg.get("block", "light_0", true).getBoolean();
		PackFurniture.block.light_1_be = cfg.get("block", "light_1", true).getBoolean();
		PackFurniture.block.light_2_be = cfg.get("block", "light_2", true).getBoolean();
		PackFurniture.block.light_3_be = cfg.get("block", "light_3", true).getBoolean();
		PackFurniture.block.light_4_be = cfg.get("block", "light_4", true).getBoolean();
		PackFurniture.block.light_5_be = cfg.get("block", "light_5", true).getBoolean();
		PackFurniture.block.light_6_be = cfg.get("block", "light_6", true).getBoolean();
		PackFurniture.block.light_7_be = cfg.get("block", "light_7", true).getBoolean();
		PackFurniture.block.light_8_be = cfg.get("block", "light_8", true).getBoolean();
		PackFurniture.block.light_9_be = cfg.get("block", "light_9", true).getBoolean();
		PackFurniture.block.light_10_be = cfg.get("block", "light_10", true).getBoolean();
		PackFurniture.block.light_11_be = cfg.get("block", "light_11", true).getBoolean();
		PackFurniture.block.light_12_be = cfg.get("block", "light_12", true).getBoolean();
		PackFurniture.block.light_13_be = cfg.get("block", "light_13", true).getBoolean();
		PackFurniture.block.light_14_be = cfg.get("block", "light_14", true).getBoolean();
		PackFurniture.block.light_15_be = cfg.get("block", "light_15", true).getBoolean();
		PackFurniture.block.light_16_be = cfg.get("block", "light_16", true).getBoolean();

		PackFurniture.block.stone_colona1_colors_be = cfg.get("block", "stone_colona1_colors", true).getBoolean();
		PackFurniture.block.candle_be = cfg.get("block", "candle", true).getBoolean();
		PackFurniture.block.candle_light_be = cfg.get("block", "candle_light", true).getBoolean();
		PackFurniture.block.crystals_be = cfg.get("block", "crystals", true).getBoolean();
		PackFurniture.block.barrels_be = cfg.get("block", "barrels", true).getBoolean();
		PackFurniture.block.bookshelf_be = cfg.get("block", "bookshelf", true).getBoolean();
		PackFurniture.block.table_be = cfg.get("block", "table", true).getBoolean();
		PackFurniture.block.chair_be = cfg.get("block", "chair", true).getBoolean();
		PackFurniture.block.wardrobe_be = cfg.get("block", "wardrobe", true).getBoolean();
		PackFurniture.block.mincer_be = cfg.get("block", "mincer", true).getBoolean();
		PackFurniture.block.arm_chair_be = cfg.get("block", "arm_chair", true).getBoolean();
		PackFurniture.block.blender_be = cfg.get("block", "blender", true).getBoolean();
		PackFurniture.block.grills_be = cfg.get("block", "grills", true).getBoolean();
		PackFurniture.block.box_particles_be = cfg.get("block", "box_particles", true).getBoolean();
		PackFurniture.block.bonfires_be = cfg.get("block", "bonfires", true).getBoolean();
		PackFurniture.block.bonfires_burning_be = cfg.get("block", "bonfires_burning", true).getBoolean();
		PackFurniture.block.jar01_be = cfg.get("block", "jar01", true).getBoolean();
		PackFurniture.block.pipes_be = cfg.get("block", "pipes", true).getBoolean();
		PackFurniture.block.mashine_waiter_be = cfg.get("block", "mashine_waiter", true).getBoolean();
		PackFurniture.block.vegetable_face_be = cfg.get("block", "vegetable_face", true).getBoolean();
		PackFurniture.block.furniture_chest_be = cfg.get("block", "furniture_chest", true).getBoolean();


		PackFurniture.item.items_for_furniture_be = cfg.get("item", "items_for_furniture", true).getBoolean();
		PackFurniture.item.colored_be = cfg.get("item", "colored", true).getBoolean();
		PackFurniture.item.paint_can_be = cfg.get("item", "paint_can", true).getBoolean();
		PackFurniture.item.backpack_be = cfg.get("item", "backpack", true).getBoolean();
		PackFurniture.item.filter_charcoal_be = cfg.get("item", "filter_charcoal", true).getBoolean();
		PackFurniture.item.kitchenware_be = cfg.get("item", "kitchenware", true).getBoolean();
		PackFurniture.item.particles_gun_be = cfg.get("item", "particles_gun", true).getBoolean();

		PackFurniture.item.tool_brush_be = cfg.get("item", "tool_brush", true).getBoolean();
		PackFurniture.item.tool_airbrush_be = cfg.get("item", "tool_airbrush", true).getBoolean();

		cfg.save();
	}
	//--------------------------------------------------------------------------------------------------------------
}
