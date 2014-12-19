package mods.timaxa007.pack.stock;

import mods.timaxa007.pack.stock.block.*;
import mods.timaxa007.pack.stock.event.EventStock;
import mods.timaxa007.pack.stock.item.*;
import mods.timaxa007.pack.stock.lib.ListStock;
import mods.timaxa007.pack.stock.recipe.RecipeFoodsColors;
import mods.timaxa007.pack.stock.recipe.Recipes_Stock;
import mods.timaxa007.pack.stock.tile.*;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class ProxyServer {

	//Blocks
	public static Block block_germination_plants;
	public static Block block_foods;
	public static Block block_healing;
	public static Block block_apiary;

	//Items
	public static Item items_for_stock;
	public static Item item_germination_plants;
	public static Item item_nature_product;
	public static Item item_foods;
	public static Item item_drinks;
	public static Item item_medicals;
	public static Item item_honeycombs;
	public static Item item_bee_products;
	public static Item item_bees;
	//public static Item item_food_dog;

	//Blocks
	public static int render_block_germination_plants_modelID;
	public static int render_block_foods_modelID;
	public static int render_block_apiary_modelID;

	public void preInit(FMLPreInitializationEvent event) {
		Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());
		cfg.load();

		cfg.save();

		new ListStock();

		//Blocks
		block_germination_plants = new BlockGerminationPlants();
		block_foods = new BlockFoods();
		block_healing = new BlockHealing();
		block_apiary = new BlockApiary();

		//Items
		items_for_stock = new ItemsStock();
		item_germination_plants = new ItemGerminationPlants();
		item_nature_product= new ItemNatureProduct();
		item_foods = new ItemFoods();
		item_drinks = new ItemDrinks();
		item_medicals = new ItemMedicals();
		item_honeycombs = new ItemHoneycombs();
		item_bee_products = new ItemBeeProducts();
		item_bees = new ItemBees();
		//item_food_dog = new ItemFoodDog(item_food_dog_itemID);

		//Blocks
		GameRegistry.registerBlock(block_germination_plants, "BlockGerminationPlants");
		GameRegistry.registerBlock(block_foods, ItemBlockFoods.class, "BlockFoods");
		GameRegistry.registerBlock(block_healing, "BlockHealing");
		GameRegistry.registerBlock(block_apiary, "BlockApiary");

		//Items
		GameRegistry.registerItem(items_for_stock, "ItemsStock");
		GameRegistry.registerItem(item_germination_plants, "ItemGerminationPlants");
		GameRegistry.registerItem(item_nature_product, "ItemNatureProduct");
		GameRegistry.registerItem(item_foods, "ItemFoods");
		GameRegistry.registerItem(item_drinks, "ItemDrinks");
		GameRegistry.registerItem(item_medicals, "ItemMedicals");
		GameRegistry.registerItem(item_honeycombs, "ItemHoneycombs");
		GameRegistry.registerItem(item_bee_products, "ItemBeeProducts");
		GameRegistry.registerItem(item_bees, "ItemBees");
		//GameRegistry.registerItem(item_food_dog, "ItemFoodDog");

		//Blocks
		GameRegistry.registerTileEntity(TileEntityGerminationPlants.class, "TileEntityGerminationPlants");
		GameRegistry.registerTileEntity(TileEntityFoods.class, "TileEntityFoods");
		GameRegistry.registerTileEntity(TileEntityHealing.class, "TileEntityHealing");
		GameRegistry.registerTileEntity(TileEntityApiary.class, "TileEntityApiary");

		//Blocks
		render_block_germination_plants_modelID = -1;
		render_block_foods_modelID = -1;
		render_block_apiary_modelID = -1;

		//EntityList.addMapping(EntityTest.class, "Test", 111, 0x0033FF, 0x00CCFF);

		//GameRegistry.registerWorldGenerator(new GeneratorPackStock());

		GameRegistry.addRecipe(new RecipeFoodsColors());

		Recipes_Stock.list();

		MinecraftForge.EVENT_BUS.register(new EventStock());

	}

	public void init() {

	}

}
