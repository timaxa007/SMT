package timaxa007.pack.furniture;

import timaxa007.pack.furniture.block.ListBlock;
import timaxa007.pack.furniture.event.EventFurniture;
import timaxa007.pack.furniture.gui.HandlerGuiFurniture;
import timaxa007.pack.furniture.item.ListItem;
import timaxa007.pack.furniture.lib.ListFurniture;
import timaxa007.pack.furniture.recipe.FuelHandlerFurniture;
import timaxa007.pack.furniture.recipe.RecipesArmor;
import timaxa007.pack.furniture.recipe.Recipes_Furniture;
import timaxa007.pack.furniture.render.RenderMain;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class ProxyCommon {

	public static ListBlock block;
	public static ListItem item;
	public static RenderMain render;

	//GUI
	//public static int guiID = 0;
	public static int gui_furniture_machines = 1;
	public static int gui_furniture_chest = 15;
	public static int gui_bookshelf = 16;
	public static int gui_mincer = 17;
	public static int gui_grills = 18;
	public static int gui_mashine_water = 19;
	public static int gui_backpack = 20;
	public static int gui_backpack_1 = 32;
	public static int gui_backpack_2 = 33;
	public static int gui_backpack_3 = 34;
	public static int gui_backpack_4 = 35;
	public static int gui_backpack_5 = 36;
	public static int gui_backpack_6 = 37;
	public static int gui_backpack_7 = 38;
	public static int gui_backpack_8 = 39;
	public static int gui_backpack_9 = 40;
	public static int gui_backpack_10 = 41;
	public static int gui_backpack_11 = 42;
	public static int gui_backpack_12 = 43;
	public static int gui_backpack_13 = 44;
	public static int gui_backpack_14 = 45;
	public static int gui_backpack_15 = 46;
	public static int gui_backpack_16 = 47;

	public void preInit(FMLPreInitializationEvent event) {

		Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());
		cfg.load();

		block.furniture_machines_be = cfg.get("block", "furniture_machines", true).getBoolean(true);
		block.furniture_rock_blocks_be = cfg.get("block", "furniture_rock_blocks", true).getBoolean(true);
		block.furniture_glass_blocks_be = cfg.get("block", "furniture_glass_blocks", true).getBoolean(true);
		block.furniture_wood_blocks_be = cfg.get("block", "furniture_wood_blocks", true).getBoolean(true);
		block.furniture_ground_blocks_be = cfg.get("block", "furniture_ground_blocks", true).getBoolean(true);
		block.furniture_sand_blocks_be = cfg.get("block", "furniture_sand_blocks", true).getBoolean(true);
		block.furniture_cloth_blocks_be = cfg.get("block", "furniture_cloth_blocks", true).getBoolean(true);
		block.furniture_metal_blocks_be = cfg.get("block", "furniture_metal_blocks", true).getBoolean(true);
		block.cnstor_block_be = cfg.get("block", "cnstor_block", true).getBoolean(true);
		block.cnstor_angle_be = cfg.get("block", "cnstor_angle", true).getBoolean(true);
		block.cnstor_half_be = cfg.get("block", "cnstor_half", true).getBoolean(true);
		block.cnstor_button_be = cfg.get("block", "cnstor_button", true).getBoolean(true);
		block.cnstor_lever_be = cfg.get("block", "cnstor_lever", true).getBoolean(true);
		block.cnstor_stairs_be = cfg.get("block", "cnstor_stairs", true).getBoolean(true);
		block.cnstor_fence_be = cfg.get("block", "cnstor_fence", true).getBoolean(true);
		block.cnstor_wall_be = cfg.get("block", "cnstor_wall", true).getBoolean(true);
		block.cnstor_door_be = cfg.get("block", "cnstor_door", true).getBoolean(true);
		block.cnstor_bed_be = cfg.get("block", "cnstor_bed", true).getBoolean(true);

		block.fluid_fake_water_be = cfg.get("block", "fluid_fake_water", true).getBoolean(true);
		block.fluid_fake_water_flowing_be = cfg.get("block", "fluid_fake_water_flowing", true).getBoolean(true);
		block.fluid_fake_lava_be = cfg.get("block", "fluid_fake_lava", true).getBoolean(true);
		block.fluid_fake_lava_flowing_be = cfg.get("block", "fluid_fake_lava_flowing", true).getBoolean(true);

		block.air_light_0_be = cfg.get("block", "air_light_0", true).getBoolean(true);
		block.air_light_1_be = cfg.get("block", "air_light_1", true).getBoolean(true);
		block.air_light_2_be = cfg.get("block", "air_light_2", true).getBoolean(true);
		block.air_light_3_be = cfg.get("block", "air_light_3", true).getBoolean(true);
		block.air_light_4_be = cfg.get("block", "air_light_4", true).getBoolean(true);
		block.air_light_5_be = cfg.get("block", "air_light_5", true).getBoolean(true);
		block.air_light_6_be = cfg.get("block", "air_light_6", true).getBoolean(true);
		block.air_light_7_be = cfg.get("block", "air_light_7", true).getBoolean(true);
		block.air_light_8_be = cfg.get("block", "air_light_8", true).getBoolean(true);
		block.air_light_9_be = cfg.get("block", "air_light_9", true).getBoolean(true);
		block.air_light_10_be = cfg.get("block", "air_light_10", true).getBoolean(true);
		block.air_light_11_be = cfg.get("block", "air_light_11", true).getBoolean(true);
		block.air_light_12_be = cfg.get("block", "air_light_12", true).getBoolean(true);
		block.air_light_13_be = cfg.get("block", "air_light_13", true).getBoolean(true);
		block.air_light_14_be = cfg.get("block", "air_light_14", true).getBoolean(true);
		block.air_light_15_be = cfg.get("block", "air_light_15", true).getBoolean(true);
		block.air_light_16_be = cfg.get("block", "air_light_16", true).getBoolean(true);

		block.light_0_be = cfg.get("block", "light_0", true).getBoolean(true);
		block.light_1_be = cfg.get("block", "light_1", true).getBoolean(true);
		block.light_2_be = cfg.get("block", "light_2", true).getBoolean(true);
		block.light_3_be = cfg.get("block", "light_3", true).getBoolean(true);
		block.light_4_be = cfg.get("block", "light_4", true).getBoolean(true);
		block.light_5_be = cfg.get("block", "light_5", true).getBoolean(true);
		block.light_6_be = cfg.get("block", "light_6", true).getBoolean(true);
		block.light_7_be = cfg.get("block", "light_7", true).getBoolean(true);
		block.light_8_be = cfg.get("block", "light_8", true).getBoolean(true);
		block.light_9_be = cfg.get("block", "light_9", true).getBoolean(true);
		block.light_10_be = cfg.get("block", "light_10", true).getBoolean(true);
		block.light_11_be = cfg.get("block", "light_11", true).getBoolean(true);
		block.light_12_be = cfg.get("block", "light_12", true).getBoolean(true);
		block.light_13_be = cfg.get("block", "light_13", true).getBoolean(true);
		block.light_14_be = cfg.get("block", "light_14", true).getBoolean(true);
		block.light_15_be = cfg.get("block", "light_15", true).getBoolean(true);
		block.light_16_be = cfg.get("block", "light_16", true).getBoolean(true);

		block.stone_colona1_colors_be = cfg.get("block", "stone_colona1_colors", true).getBoolean(true);
		block.candle_be = cfg.get("block", "candle", true).getBoolean(true);
		block.candle_light_be = cfg.get("block", "candle_light", true).getBoolean(true);
		block.crystals_be = cfg.get("block", "crystals", true).getBoolean(true);
		block.barrels_be = cfg.get("block", "barrels", true).getBoolean(true);
		block.bookshelf_be = cfg.get("block", "bookshelf", true).getBoolean(true);
		block.table_be = cfg.get("block", "table", true).getBoolean(true);
		block.chair_be = cfg.get("block", "chair", true).getBoolean(true);
		block.wardrobe_be = cfg.get("block", "wardrobe", true).getBoolean(true);
		block.mincer_be = cfg.get("block", "mincer", true).getBoolean(true);
		block.arm_chair_be = cfg.get("block", "arm_chair", true).getBoolean(true);
		block.blender_be = cfg.get("block", "blender", true).getBoolean(true);
		block.grills_be = cfg.get("block", "grills", true).getBoolean(true);
		block.box_particles_be = cfg.get("block", "box_particles", true).getBoolean(true);
		block.bonfires_be = cfg.get("block", "bonfires", true).getBoolean(true);
		block.bonfires_burning_be = cfg.get("block", "bonfires_burning", true).getBoolean(true);
		block.jar01_be = cfg.get("block", "jar01", true).getBoolean(true);
		block.pipes_be = cfg.get("block", "pipes", true).getBoolean(true);
		block.mashine_waiter_be = cfg.get("block", "mashine_waiter", true).getBoolean(true);
		block.rock_blocks_be = cfg.get("block", "rock_blocks", true).getBoolean(true);
		block.glass_blocks_be = cfg.get("block", "glass_blocks", true).getBoolean(true);
		block.wood_blocks_be = cfg.get("block", "wood_blocks", true).getBoolean(true);
		block.ground_blocks_be = cfg.get("block", "ground_blocks", true).getBoolean(true);
		block.sand_blocks_be = cfg.get("block", "sand_blocks", true).getBoolean(true);
		block.cloth_blocks_be = cfg.get("block", "cloth_blocks", true).getBoolean(true);
		block.metal_blocks_be = cfg.get("block", "metal_blocks", true).getBoolean(true);
		block.vegetable_face_be = cfg.get("block", "vegetable_face", true).getBoolean(true);
		block.furniture_chest_be = cfg.get("block", "furniture_chest", true).getBoolean(true);


		item.items_for_furniture_be = cfg.get("item", "items_for_furniture", true).getBoolean(true);
		item.colored_be = cfg.get("item", "colored", true).getBoolean(true);
		item.paint_can_be = cfg.get("item", "paint_can", true).getBoolean(true);
		item.backpack_be = cfg.get("item", "backpack", true).getBoolean(true);
		item.filter_charcoal_be = cfg.get("item", "filter_charcoal", true).getBoolean(true);
		item.kitchenware_be = cfg.get("item", "kitchenware", true).getBoolean(true);
		item.particles_gun_be = cfg.get("item", "particles_gun", true).getBoolean(true);

		item.tool_brush_be = cfg.get("item", "tool_brush", true).getBoolean(true);
		item.tool_airbrush_be = cfg.get("item", "tool_airbrush", true).getBoolean(true);

		item.armor_masks_be = cfg.get("item", "armor_masks", true).getBoolean(true);
		item.armor_backpacks_be = cfg.get("item", "armor_backpacks", true).getBoolean(true);
		item.armor_costumes_helmet_be = cfg.get("item", "armor_costumes_helmet", true).getBoolean(true);
		item.armor_costumes_chest_be = cfg.get("item", "armor_costumes_chest", true).getBoolean(true);
		item.armor_costumes_leggin_be = cfg.get("item", "armor_costumes_leggin", true).getBoolean(true);
		item.armor_costumes_boot_be = cfg.get("item", "armor_costumes_boot", true).getBoolean(true);
		item.armor_medieval_helmet_be = cfg.get("item", "armor_medieval_helmet", true).getBoolean(true);
		item.armor_medieval_chest_be = cfg.get("item", "armor_medieval_chest", true).getBoolean(true);
		item.armor_medieval_leggin_be = cfg.get("item", "armor_medieval_leggin", true).getBoolean(true);
		item.armor_medieval_boot_be = cfg.get("item", "armor_medieval_boot", true).getBoolean(true);
		item.armor_new_helmet_be = cfg.get("item", "armor_new_helmet", true).getBoolean(true);
		item.armor_new_chest_be = cfg.get("item", "armor_new_chest", true).getBoolean(true);
		item.armor_new_leggin_be = cfg.get("item", "armor_new_leggin", true).getBoolean(true);
		item.armor_new_boot_be = cfg.get("item", "armor_new_boot", true).getBoolean(true);

		cfg.save();

		new ListFurniture();

		block.preInit();
		item.preInit();
		render.preInit();
		/*
		OreDictionary.registerOre("dyeBlack", new ItemStack(item_colored, 1, 0));
		OreDictionary.registerOre("dyeBlue", new ItemStack(item_colored, 1, 1));
		OreDictionary.registerOre("dyeBrown", new ItemStack(item_colored, 1, 2));
		OreDictionary.registerOre("dyeCyan", new ItemStack(item_colored, 1, 3));
		OreDictionary.registerOre("dyeGray", new ItemStack(item_colored, 1, 4));
		OreDictionary.registerOre("dyeGreen", new ItemStack(item_colored, 1, 5));
		OreDictionary.registerOre("dyeLightBlue", new ItemStack(item_colored, 1, 6));
		OreDictionary.registerOre("dyeLightGray", new ItemStack(item_colored, 1, 7));
		OreDictionary.registerOre("dyeLightGreen", new ItemStack(item_colored, 1, 8));
		OreDictionary.registerOre("dyeLime", new ItemStack(item_colored, 1, 8));
		OreDictionary.registerOre("dyeMagenta", new ItemStack(item_colored, 1, 9));
		OreDictionary.registerOre("dyeOrange", new ItemStack(item_colored, 1, 10));
		OreDictionary.registerOre("dyePink", new ItemStack(item_colored, 1, 11));
		OreDictionary.registerOre("dyePurple", new ItemStack(item_colored, 1, 12));
		OreDictionary.registerOre("dyeRed", new ItemStack(item_colored, 1, 13));
		OreDictionary.registerOre("dyeWhite", new ItemStack(item_colored, 1, 14));
		OreDictionary.registerOre("dyeYellow", new ItemStack(item_colored, 1, 15));
		 */
		GameRegistry.addRecipe(new RecipesArmor());
		//GameRegistry.registerCraftingHandler(new CraftFurnitureHandler());

		GameRegistry.registerFuelHandler(new FuelHandlerFurniture());
		/*
		TickRegistry.registerTickHandler(new TickClientHandler(), Side.CLIENT);
		TickRegistry.registerTickHandler(new TickServerHandler(), Side.SERVER);
		 */
		Recipes_Furniture.list();

		MinecraftForge.EVENT_BUS.register(new EventFurniture());

	}

	public void init() {

		NetworkRegistry.INSTANCE.registerGuiHandler(PackFurniture.MODID, new HandlerGuiFurniture());

	}

}
