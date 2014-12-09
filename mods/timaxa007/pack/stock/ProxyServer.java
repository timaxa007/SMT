package mods.timaxa007.pack.stock;

import mods.timaxa007.lib.*;
import mods.timaxa007.pack.stock.blocks.*;
import mods.timaxa007.pack.stock.entity.EntityTest;
import mods.timaxa007.pack.stock.items.*;
import mods.timaxa007.pack.stock.list.ListStock;
import mods.timaxa007.pack.stock.te.*;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityList;
import net.minecraft.item.Item;
import net.minecraftforge.common.Configuration;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class ProxyServer {

public static CreativeTabs tabStockPack = new TabStockPack(CreativeTabs.getNextID(), "tabStockPack");
public static CreativeTabs tabPlantPack = new TabPlantPack(CreativeTabs.getNextID(), "tabPlantPack");
public static CreativeTabs tabFoodPack = new TabFoodPack(CreativeTabs.getNextID(), "tabFoodPack");
public static CreativeTabs tabMedicalPack = new TabMedicalPack(CreativeTabs.getNextID(), "tabMedicalPack");
public static CreativeTabs tabApisPack = new TabApisPack(CreativeTabs.getNextID(), "tabApisPack");

//Blocks
public static Block block_germination_plants;public static int block_germination_plants_blockID;
public static Block block_foods;public static int block_foods_blockID;
public static Block block_healing;public static int block_healing_blockID;
public static Block block_pizzas;public static int block_pizzas_blockID;
public static Block block_cakes;public static int block_cakes_blockID;
public static Block block_pies;public static int block_pies_blockID;
public static Block block_apiary;public static int block_apiary_blockID;

//Items
public static Item items_for_stock;public static int items_for_stock_itemID;
public static Item item_germination_plants;public static int item_germination_plants_itemID;
public static Item item_nature_product;public static int item_nature_product_itemID;
public static Item item_foods;public static int item_foods_itemID;
public static Item item_drinks;public static int item_drinks_itemID;
public static Item item_medicals;public static int item_medicals_itemID;
public static Item item_honeycombs;public static int item_honeycombs_itemID;
public static Item item_bee_products;public static int item_bee_products_itemID;
public static Item item_bees;public static int item_bees_itemID;
//public static Item item_food_dog;public static int item_food_dog_itemID;

//Blocks
public static int render_block_germination_plants_modelID;
public static int render_block_foods_modelID;
public static int render_block_pizza_modelID;
public static int render_block_cake_modelID;
public static int render_block_pie_modelID;
public static int render_block_apiary_modelID;

public void init() {
TickRegistry.registerTickHandler(new TickHandlerPackStockServer(), Side.SERVER);

new ListStock();

//Blocks
block_germination_plants = new BlockGerminationPlants(block_germination_plants_blockID);
block_foods = new BlockFoods(block_foods_blockID);
block_healing = new BlockHealing(block_healing_blockID);
block_pizzas = new BlockPizzas(block_pizzas_blockID);
block_cakes = new BlockCakes(block_cakes_blockID);
block_pies = new BlockPies(block_pies_blockID);
block_apiary = new BlockApiary(block_apiary_blockID);

//Items
items_for_stock = new ItemsStock(items_for_stock_itemID);
item_germination_plants = new ItemGerminationPlants(item_germination_plants_itemID);
item_nature_product= new ItemNatureProduct(item_nature_product_itemID);
item_foods = new ItemFoods(item_foods_itemID);
item_drinks = new ItemDrinks(item_drinks_itemID);
item_medicals = new ItemMedicals(item_medicals_itemID);
item_honeycombs = new ItemHoneycombs(item_honeycombs_itemID);
item_bee_products = new ItemBeeProducts(item_bee_products_itemID);
item_bees = new ItemBees(item_bees_itemID);
//item_food_dog = new ItemFoodDog(item_food_dog_itemID);

//Blocks
GameRegistry.registerBlock(block_germination_plants, "BlockGerminationPlants");
GameRegistry.registerBlock(block_foods, ItemBlockFoods.class, "BlockFoods");
GameRegistry.registerBlock(block_healing, ItemBlockHealing.class, "BlockHealing");
GameRegistry.registerBlock(block_pizzas, ItemBlockPizza.class, "BlockPizza");
GameRegistry.registerBlock(block_cakes, ItemBlockCake.class, "BlockCake");
GameRegistry.registerBlock(block_pies, ItemBlockPie.class, "BlockPie");
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
GameRegistry.registerTileEntity(TEGerminationPlants.class, "TEGerminationPlants");
GameRegistry.registerTileEntity(TEFoods.class, "TEFoods");
GameRegistry.registerTileEntity(TEHealing.class, "TEHealing");
GameRegistry.registerTileEntity(TEPizza.class, "TEPizza");
GameRegistry.registerTileEntity(TECake.class, "TECake");
GameRegistry.registerTileEntity(TEPie.class, "TEPie");
GameRegistry.registerTileEntity(TEApiary.class, "TEApiary");

//Blocks
render_block_germination_plants_modelID = -1;
render_block_foods_modelID = -1;
render_block_pizza_modelID = -1;
render_block_cake_modelID = -1;
render_block_pie_modelID = -1;
render_block_apiary_modelID = -1;

EntityList.addMapping(EntityTest.class, "Test", 111, 0x0033FF, 0x00CCFF);

MinecraftForge.EVENT_BUS.register(new EventPackStock());

GameRegistry.registerWorldGenerator(new GeneratorPackStock());

GameRegistry.addRecipe(new RecipeFoodsColors());

Recipes_Stock.list();

}

public void preInit(FMLPreInitializationEvent event) {
Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());
cfg.load();
int idblock = 2100;
int iditem = 5100;
//Blocks
block_germination_plants_blockID = cfg.getBlock("germination_plants_block", idblock++).getInt();
block_foods_blockID = cfg.getBlock("block_foods", idblock++).getInt();
block_healing_blockID = cfg.getBlock("healing", idblock++).getInt();
block_pizzas_blockID = cfg.getBlock("pizzas", idblock++).getInt();
block_cakes_blockID = cfg.getBlock("cakes", idblock++).getInt();
block_pies_blockID = cfg.getBlock("pies", idblock++).getInt();
block_apiary_blockID = cfg.getBlock("apiary", idblock++).getInt();

//Items
items_for_stock_itemID = cfg.getItem("items_for_stock", iditem++).getInt();
item_germination_plants_itemID = cfg.getItem("germination_plants_item", iditem++).getInt();
item_nature_product_itemID = cfg.getItem("nature_product", iditem++).getInt();
item_foods_itemID = cfg.getItem("item_foods", iditem++).getInt();
item_drinks_itemID = cfg.getItem("drinks", iditem++).getInt();
item_medicals_itemID = cfg.getItem("medicals", iditem++).getInt();
item_honeycombs_itemID = cfg.getItem("honeycombs", iditem++).getInt();
item_bee_products_itemID = cfg.getItem("bee_products", iditem++).getInt();
item_bees_itemID = cfg.getItem("bees", iditem++).getInt();
//item_food_dog_itemID = cfg.getItem("item_food_dog", iditem++).getInt();

cfg.save();
}

}
