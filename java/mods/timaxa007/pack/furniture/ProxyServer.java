package mods.timaxa007.pack.furniture;

import mods.timaxa007.pack.furniture.block.BlockList;
import mods.timaxa007.pack.furniture.event.EventFurniture;
import mods.timaxa007.pack.furniture.gui.HandlerGuiFurniture;
import mods.timaxa007.pack.furniture.item.ItemList;
import mods.timaxa007.pack.furniture.lib.ListFurniture;
import mods.timaxa007.pack.furniture.recipe.FuelHandlerFurniture;
import mods.timaxa007.pack.furniture.recipe.RecipeArmorColor;
import mods.timaxa007.pack.furniture.recipe.RecipeCnstorBlockColors;
import mods.timaxa007.pack.furniture.recipe.RecipeToolHammer;
import mods.timaxa007.pack.furniture.recipe.Recipes_Armor;
import mods.timaxa007.pack.furniture.recipe.Recipes_Furniture;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class ProxyServer {

	public static BlockList block;
	public static ItemList item;

	public static int render_block_cnstor_block_modelID;
	public static int render_block_cnstor_angle_modelID;
	public static int render_block_cnstor_fence_modelID;
	public static int render_block_lights_modelID;
	public static int render_block_candle_modelID;
	public static int render_block_crystals_modelID;
	public static int render_block_barrels_modelID;
	public static int render_block_bookshelf_modelID;
	public static int render_block_table_modelID;
	public static int render_block_chair_modelID;
	public static int render_block_wardrobe_modelID;
	public static int render_block_mincer_modelID;
	public static int render_block_armchair_modelID;
	public static int render_block_blender_modelID;
	public static int render_block_grills_modelID;
	public static int render_block_box_particles_modelID;
	public static int render_block_jar01_modelID;
	public static int render_block_pipes_modelID;
	public static int render_block_mashine_waiter_modelID;
	public static int render_block_furniture_chest_modelID;

	//GUI
	//public static int guiID = 0;
	public static int gui_furniture_machines = 1;
	public static int gui_furniture_chest = 15;
	public static int gui_bookshelf = 16;
	public static int gui_mincer = 17;
	public static int gui_grills = 18;
	public static int gui_mashine_water = 19;
	public static int gui_backpack = 20;

	public void preInit(FMLPreInitializationEvent event) {

		Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());
		cfg.load();
		//
		cfg.save();

		new ListFurniture();

		block.list();
		item.list();

		render_block_cnstor_block_modelID = -1;
		render_block_cnstor_angle_modelID = -1;
		render_block_cnstor_fence_modelID = -1;
		render_block_lights_modelID = -1;
		render_block_candle_modelID = -1;
		render_block_crystals_modelID = -1;
		render_block_barrels_modelID = -1;
		render_block_bookshelf_modelID = -1;
		render_block_table_modelID = -1;
		render_block_chair_modelID = -1;
		render_block_wardrobe_modelID = -1;
		render_block_mincer_modelID = -1;
		render_block_armchair_modelID = -1;
		render_block_blender_modelID = -1;
		render_block_grills_modelID = -1;
		render_block_box_particles_modelID = -1;
		render_block_jar01_modelID = -1;
		render_block_pipes_modelID = -1;
		render_block_mashine_waiter_modelID = -1;
		render_block_furniture_chest_modelID = -1;
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

		OreDictionary.registerOre("dyeBlack", new ItemStack(item_colored, 1, 16));
		OreDictionary.registerOre("dyeBlue", new ItemStack(item_colored, 1, 17));
		OreDictionary.registerOre("dyeBrown", new ItemStack(item_colored, 1, 18));
		OreDictionary.registerOre("dyeCyan", new ItemStack(item_colored, 1, 19));
		OreDictionary.registerOre("dyeGray", new ItemStack(item_colored, 1, 20));
		OreDictionary.registerOre("dyeGreen", new ItemStack(item_colored, 1, 21));
		OreDictionary.registerOre("dyeLightBlue", new ItemStack(item_colored, 1, 22));
		OreDictionary.registerOre("dyeLightGray", new ItemStack(item_colored, 1, 23));
		OreDictionary.registerOre("dyeLightGreen", new ItemStack(item_colored, 1, 24));
		OreDictionary.registerOre("dyeLime", new ItemStack(item_colored, 1, 24));
		OreDictionary.registerOre("dyeMagenta", new ItemStack(item_colored, 1, 25));
		OreDictionary.registerOre("dyeOrange", new ItemStack(item_colored, 1, 26));
		OreDictionary.registerOre("dyePink", new ItemStack(item_colored, 1, 27));
		OreDictionary.registerOre("dyePurple", new ItemStack(item_colored, 1, 28));
		OreDictionary.registerOre("dyeRed", new ItemStack(item_colored, 1, 29));
		OreDictionary.registerOre("dyeWhite", new ItemStack(item_colored, 1, 30));
		OreDictionary.registerOre("dyeYellow", new ItemStack(item_colored, 1, 31));
		 */
		GameRegistry.addRecipe(new RecipeCnstorBlockColors());
		GameRegistry.addRecipe(new RecipeArmorColor());
		GameRegistry.addRecipe(new RecipeToolHammer());
		//GameRegistry.registerCraftingHandler(new CraftFurnitureHandler());

		GameRegistry.registerFuelHandler(new FuelHandlerFurniture());
		/*
		TickRegistry.registerTickHandler(new TickClientHandler(), Side.CLIENT);
		TickRegistry.registerTickHandler(new TickServerHandler(), Side.SERVER);
		 */
		Recipes_Furniture.list();
		Recipes_Armor.list();

		MinecraftForge.EVENT_BUS.register(new EventFurniture());

	}

	public void init() {

		NetworkRegistry.INSTANCE.registerGuiHandler(PackFurniture.MODID, new HandlerGuiFurniture());

	}

}
