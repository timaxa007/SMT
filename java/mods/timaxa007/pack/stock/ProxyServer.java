package mods.timaxa007.pack.stock;

import mods.timaxa007.lib.*;
import mods.timaxa007.pack.stock.blocks.*;
import mods.timaxa007.pack.stock.entity.*;
import mods.timaxa007.pack.stock.items.*;
import mods.timaxa007.pack.stock.list.ListStock;
import mods.timaxa007.pack.stock.te.*;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityList;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class ProxyServer {

public static CreativeTabs tabStockPack = new TabStockPack("tabStockPack");
public static CreativeTabs tabPlantPack = new TabPlantPack("tabPlantPack");
public static CreativeTabs tabFoodPack = new TabFoodPack("tabFoodPack");
public static CreativeTabs tabMedicalPack = new TabMedicalPack("tabMedicalPack");
public static CreativeTabs tabApisPack = new TabApisPack("tabApisPack");

//Blocks
public static Block block_germination_plants;
public static Block block_foods;
public static Block block_healing;
public static Block block_pizzas;
public static Block block_cakes;
public static Block block_pies;
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
public static int render_block_pizza_modelID;
public static int render_block_cake_modelID;
public static int render_block_pie_modelID;
public static int render_block_apiary_modelID;

public void init() {

}

public void preInit(FMLPreInitializationEvent event) {
Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());
cfg.load();

cfg.save();

new ListStock();

//Blocks
block_germination_plants = new BlockGerminationPlants();
block_foods = new BlockFoods();
block_healing = new BlockHealing();
block_pizzas = new BlockPizzas();
block_cakes = new BlockCakes();
block_pies = new BlockPies();
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

//EntityList.addMapping(EntityTest.class, "Test", 111, 0x0033FF, 0x00CCFF);

MinecraftForge.EVENT_BUS.register(new EventPackStock());

//GameRegistry.registerWorldGenerator(new GeneratorPackStock());

GameRegistry.addRecipe(new RecipeFoodsColors());

Recipes_Stock.list();

}

}
