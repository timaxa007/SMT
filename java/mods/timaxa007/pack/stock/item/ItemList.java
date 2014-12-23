package mods.timaxa007.pack.stock.item;

import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;

public class ItemList {

	public static Item items_for_stock;
	public static Item germination_plants;
	public static Item nature_product;
	public static Item foods;
	public static Item drinks;
	public static Item medicals;
	public static Item honeycombs;
	public static Item bee_products;
	public static Item bees;
	//public static Item food_dog;

	public static void list() {

		items_for_stock = new ItemsStock();
		germination_plants = new ItemGerminationPlants();
		nature_product= new ItemNatureProduct();
		foods = new ItemFoods();
		drinks = new ItemDrinks();
		medicals = new ItemMedicals();
		honeycombs = new ItemHoneycombs();
		bee_products = new ItemBeeProducts();
		bees = new ItemBees();
		//food_dog = new ItemFoodDog(food_dog_itemID);

		GameRegistry.registerItem(items_for_stock, "ItemsStock");
		GameRegistry.registerItem(germination_plants, "ItemGerminationPlants");
		GameRegistry.registerItem(nature_product, "ItemNatureProduct");
		GameRegistry.registerItem(foods, "ItemFoods");
		GameRegistry.registerItem(drinks, "ItemDrinks");
		GameRegistry.registerItem(medicals, "ItemMedicals");
		GameRegistry.registerItem(honeycombs, "ItemHoneycombs");
		GameRegistry.registerItem(bee_products, "ItemBeeProducts");
		GameRegistry.registerItem(bees, "ItemBees");
		//GameRegistry.registerItem(food_dog, "ItemFoodDog");

	}

}
