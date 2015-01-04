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
import mods.timaxa007.pack.furniture.recipe.RecipesArmor;
import mods.timaxa007.pack.furniture.recipe.Recipes_Furniture;
import mods.timaxa007.pack.furniture.render.RenderMain;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class ProxyCommon {

	public static BlockList block;
	public static ItemList item;
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

	public void preInit(FMLPreInitializationEvent event) {

		Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());
		cfg.load();
		//
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

		MinecraftForge.EVENT_BUS.register(new EventFurniture());

	}

	public void init() {

		NetworkRegistry.INSTANCE.registerGuiHandler(PackFurniture.MODID, new HandlerGuiFurniture());

	}

}
