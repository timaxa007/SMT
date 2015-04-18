package timaxa007.pack.stock.item;

import net.minecraft.item.Item;
import timaxa007.pack.stock.lib.food.ListFoodFirst;
import timaxa007.tms.util.UtilTMS;

public class ListItem {

	public static boolean 
	items_for_stock_be,
	plants_be,
	nature_product_be,
	foods_be,
	drinks_be,
	medicals_be,
	honeycombs_be,
	bee_products_be,
	bees_be,
	petals_be
	;
	//food_dog_be;

	public static Item 
	items_for_stock,
	plants,
	nature_product,
	foods,
	drinks,
	medicals,
	honeycombs,
	bee_products,
	bees,
	petals
	;
	//food_dog;

	public static Item[] list_item;

	public static void preInit() {

		if (items_for_stock_be) items_for_stock = new ItemsStock("items_for_stock");
		if (plants_be) plants = new ItemPlants("plants");
		if (nature_product_be) nature_product= new ItemNatureProduct("nature_product");
		if (foods_be) {
			new ListFoodFirst();
			foods = new ItemFoods("foods");
		}
		if (drinks_be) drinks = new ItemDrinks("drinks");
		if (medicals_be) medicals = new ItemMedicals("medicals");
		if (honeycombs_be) honeycombs = new ItemHoneycombs("honeycombs");
		if (bee_products_be) bee_products = new ItemBeeProducts("bee_products");
		if (bees_be) bees = new ItemBees("bees");
		if (petals_be) petals = new ItemPetals("petals");
		//if (food_dog_be) food_dog = new ItemFoodDog(food_dog_itemID);

		list_item = new Item[] {
				items_for_stock,
				plants,
				nature_product,
				foods,
				drinks,
				medicals,
				honeycombs,
				bee_products,
				bees,
				petals
		};

		UtilTMS.UtilItem.RegItem(list_item);

	}

}
