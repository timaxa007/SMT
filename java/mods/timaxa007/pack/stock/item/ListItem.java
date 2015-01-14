package mods.timaxa007.pack.stock.item;

import mods.timaxa007.tms.util.UtilTMS;
import net.minecraft.item.Item;

public class ListItem {

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

	public static Item[] list_item;

	public static void preInit() {

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

		list_item = new Item[] {
				items_for_stock, 
				germination_plants, 
				nature_product, 
				foods, 
				drinks, 
				medicals, 
				honeycombs, 
				bee_products, 
				bees
		};

		for (int i = 0; i < list_item.length; i++) 
			UtilTMS.UtilItem.RegItem(list_item[i]);

	}

}
