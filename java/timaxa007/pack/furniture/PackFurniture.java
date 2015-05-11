package timaxa007.pack.furniture;

import java.io.File;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;

import org.apache.logging.log4j.Logger;

import timaxa007.api.IPackClass;
import timaxa007.pack.furniture.block.ListBlock;
import timaxa007.pack.furniture.item.ListItem;
import timaxa007.pack.furniture.lib.ListFurniture;
import timaxa007.pack.furniture.packet.RegisterMessage;
import timaxa007.pack.furniture.recipe.*;
import timaxa007.pack.furniture.render.RenderMain;
import timaxa007.pack.stock.PackStock;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PackFurniture implements IPackClass {

	public static final String MODID = "furniturepack";
	public static final String MODNAME = "PackFurniture";
	public static final String VERSION = "0.332";
	public static final String[] AUTHORS = new String[] {"timaxa007"};

	public static Logger log;
	public static SimpleNetworkWrapper network;

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
	public static int gui_storage = 21;
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

	public static CreativeTabs tab_furniture = new CreativeTabs("tab_furniture") {
		@SideOnly(Side.CLIENT) public Item getTabIconItem() {return PackFurniture.item.items_for_furniture;}
	};

	@Override
	public void preInit(FMLPreInitializationEvent event) {

		log = event.getModLog();
		log.info("Starting sub-mod " + PackFurniture.MODNAME + ", build: " + PackStock.VERSION + ".");

		Configuration cfg = new Configuration(new File("./config/tms/pack", PackFurniture.MODID + ".cfg"));
		cfg.load();

		block.furniture_machines_be = cfg.get("block", "furniture_machines", true).getBoolean();
		block.furniture_rock_blocks_be = cfg.get("block", "furniture_rock_blocks", true).getBoolean();
		block.furniture_glass_blocks_be = cfg.get("block", "furniture_glass_blocks", true).getBoolean();
		block.furniture_wood_blocks_be = cfg.get("block", "furniture_wood_blocks", true).getBoolean();
		block.furniture_ground_blocks_be = cfg.get("block", "furniture_ground_blocks", true).getBoolean();
		block.furniture_sand_blocks_be = cfg.get("block", "furniture_sand_blocks", true).getBoolean();
		block.furniture_cloth_blocks_be = cfg.get("block", "furniture_cloth_blocks", true).getBoolean();
		block.furniture_metal_blocks_be = cfg.get("block", "furniture_metal_blocks", true).getBoolean();
		block.cnstor_block_be = cfg.get("block", "cnstor_block", true).getBoolean();
		block.cnstor_angle_be = cfg.get("block", "cnstor_angle", true).getBoolean();
		block.cnstor_half_be = cfg.get("block", "cnstor_half", true).getBoolean();
		block.cnstor_button_be = cfg.get("block", "cnstor_button", true).getBoolean();
		block.cnstor_lever_be = cfg.get("block", "cnstor_lever", true).getBoolean();
		block.cnstor_stairs_be = cfg.get("block", "cnstor_stairs", true).getBoolean();
		block.cnstor_fence_be = cfg.get("block", "cnstor_fence", true).getBoolean();
		block.cnstor_wall_be = cfg.get("block", "cnstor_wall", true).getBoolean();
		block.cnstor_door_be = cfg.get("block", "cnstor_door", true).getBoolean();
		block.cnstor_bed_be = cfg.get("block", "cnstor_bed", true).getBoolean();

		block.fluid_fake_water_be = cfg.get("block", "fluid_fake_water", true).getBoolean();
		block.fluid_fake_water_flowing_be = cfg.get("block", "fluid_fake_water_flowing", true).getBoolean();
		block.fluid_fake_lava_be = cfg.get("block", "fluid_fake_lava", true).getBoolean();
		block.fluid_fake_lava_flowing_be = cfg.get("block", "fluid_fake_lava_flowing", true).getBoolean();

		block.air_light_0_be = cfg.get("block", "air_light_0", true).getBoolean();
		block.air_light_1_be = cfg.get("block", "air_light_1", true).getBoolean();
		block.air_light_2_be = cfg.get("block", "air_light_2", true).getBoolean();
		block.air_light_3_be = cfg.get("block", "air_light_3", true).getBoolean();
		block.air_light_4_be = cfg.get("block", "air_light_4", true).getBoolean();
		block.air_light_5_be = cfg.get("block", "air_light_5", true).getBoolean();
		block.air_light_6_be = cfg.get("block", "air_light_6", true).getBoolean();
		block.air_light_7_be = cfg.get("block", "air_light_7", true).getBoolean();
		block.air_light_8_be = cfg.get("block", "air_light_8", true).getBoolean();
		block.air_light_9_be = cfg.get("block", "air_light_9", true).getBoolean();
		block.air_light_10_be = cfg.get("block", "air_light_10", true).getBoolean();
		block.air_light_11_be = cfg.get("block", "air_light_11", true).getBoolean();
		block.air_light_12_be = cfg.get("block", "air_light_12", true).getBoolean();
		block.air_light_13_be = cfg.get("block", "air_light_13", true).getBoolean();
		block.air_light_14_be = cfg.get("block", "air_light_14", true).getBoolean();
		block.air_light_15_be = cfg.get("block", "air_light_15", true).getBoolean();
		block.air_light_16_be = cfg.get("block", "air_light_16", true).getBoolean();

		block.light_0_be = cfg.get("block", "light_0", true).getBoolean();
		block.light_1_be = cfg.get("block", "light_1", true).getBoolean();
		block.light_2_be = cfg.get("block", "light_2", true).getBoolean();
		block.light_3_be = cfg.get("block", "light_3", true).getBoolean();
		block.light_4_be = cfg.get("block", "light_4", true).getBoolean();
		block.light_5_be = cfg.get("block", "light_5", true).getBoolean();
		block.light_6_be = cfg.get("block", "light_6", true).getBoolean();
		block.light_7_be = cfg.get("block", "light_7", true).getBoolean();
		block.light_8_be = cfg.get("block", "light_8", true).getBoolean();
		block.light_9_be = cfg.get("block", "light_9", true).getBoolean();
		block.light_10_be = cfg.get("block", "light_10", true).getBoolean();
		block.light_11_be = cfg.get("block", "light_11", true).getBoolean();
		block.light_12_be = cfg.get("block", "light_12", true).getBoolean();
		block.light_13_be = cfg.get("block", "light_13", true).getBoolean();
		block.light_14_be = cfg.get("block", "light_14", true).getBoolean();
		block.light_15_be = cfg.get("block", "light_15", true).getBoolean();
		block.light_16_be = cfg.get("block", "light_16", true).getBoolean();

		block.stone_colona1_colors_be = cfg.get("block", "stone_colona1_colors", true).getBoolean();
		block.candle_be = cfg.get("block", "candle", true).getBoolean();
		block.candle_light_be = cfg.get("block", "candle_light", true).getBoolean();
		block.crystals_be = cfg.get("block", "crystals", true).getBoolean();
		block.barrels_be = cfg.get("block", "barrels", true).getBoolean();
		block.bookshelf_be = cfg.get("block", "bookshelf", true).getBoolean();
		block.table_be = cfg.get("block", "table", true).getBoolean();
		block.chair_be = cfg.get("block", "chair", true).getBoolean();
		block.wardrobe_be = cfg.get("block", "wardrobe", true).getBoolean();
		block.mincer_be = cfg.get("block", "mincer", true).getBoolean();
		block.arm_chair_be = cfg.get("block", "arm_chair", true).getBoolean();
		block.blender_be = cfg.get("block", "blender", true).getBoolean();
		block.grills_be = cfg.get("block", "grills", true).getBoolean();
		block.box_particles_be = cfg.get("block", "box_particles", true).getBoolean();
		block.bonfires_be = cfg.get("block", "bonfires", true).getBoolean();
		block.bonfires_burning_be = cfg.get("block", "bonfires_burning", true).getBoolean();
		block.jar01_be = cfg.get("block", "jar01", true).getBoolean();
		block.pipes_be = cfg.get("block", "pipes", true).getBoolean();
		block.mashine_waiter_be = cfg.get("block", "mashine_waiter", true).getBoolean();
		block.rock_blocks_be = cfg.get("block", "rock_blocks", true).getBoolean();
		block.glass_blocks_be = cfg.get("block", "glass_blocks", true).getBoolean();
		block.wood_blocks_be = cfg.get("block", "wood_blocks", true).getBoolean();
		block.ground_blocks_be = cfg.get("block", "ground_blocks", true).getBoolean();
		block.sand_blocks_be = cfg.get("block", "sand_blocks", true).getBoolean();
		block.cloth_blocks_be = cfg.get("block", "cloth_blocks", true).getBoolean();
		block.metal_blocks_be = cfg.get("block", "metal_blocks", true).getBoolean();
		block.vegetable_face_be = cfg.get("block", "vegetable_face", true).getBoolean();
		block.furniture_chest_be = cfg.get("block", "furniture_chest", true).getBoolean();
		block.storage_be = cfg.get("block", "storage", true).getBoolean();


		item.items_for_furniture_be = cfg.get("item", "items_for_furniture", true).getBoolean();
		item.colored_be = cfg.get("item", "colored", true).getBoolean();
		item.paint_can_be = cfg.get("item", "paint_can", true).getBoolean();
		item.backpack_be = cfg.get("item", "backpack", true).getBoolean();
		item.filter_charcoal_be = cfg.get("item", "filter_charcoal", true).getBoolean();
		item.kitchenware_be = cfg.get("item", "kitchenware", true).getBoolean();
		item.particles_gun_be = cfg.get("item", "particles_gun", true).getBoolean();

		item.tool_brush_be = cfg.get("item", "tool_brush", true).getBoolean();
		item.tool_airbrush_be = cfg.get("item", "tool_airbrush", true).getBoolean();

		cfg.save();

		network = NetworkRegistry.INSTANCE.newSimpleChannel(PackFurniture.MODID);
		RegisterMessage.init(network);

		new ListFurniture();

		block.preInit();
		item.preInit();

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
		//GameRegistry.addRecipe(new RecipesArmor());
		//GameRegistry.registerCraftingHandler(new CraftFurnitureHandler());

		GameRegistry.registerFuelHandler(new FuelHandlerFurniture());
		/*
		TickRegistry.registerTickHandler(new TickClientHandler(), Side.CLIENT);
		TickRegistry.registerTickHandler(new TickServerHandler(), Side.SERVER);
		 */
		Recipes_Furniture.list();

	}

}
