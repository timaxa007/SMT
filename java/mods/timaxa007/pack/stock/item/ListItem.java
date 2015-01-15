package mods.timaxa007.pack.stock.item;

import mods.timaxa007.tms.util.UtilTMS;
import net.minecraft.item.Item;

public class ListItem {

	public static Item 
	items_for_stock, 
	germination_plants, 
	nature_product, 
	foods, 
	drinks, 
	medicals, 
	honeycombs, 
	bee_products, 
	bees;
	//food_dog;

	public static Item[] list_item;

	public static void preInit() {

		items_for_stock = new ItemsStock("items_for_stock");
		germination_plants = new ItemGerminationPlants("germination_plants");
		nature_product= new ItemNatureProduct("nature_product");
		foods = new ItemFoods("foods");
		drinks = new ItemDrinks("drinks");
		medicals = new ItemMedicals("medicals");
		honeycombs = new ItemHoneycombs("honeycombs");
		bee_products = new ItemBeeProducts("bee_products");
		bees = new ItemBees("bees");
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
