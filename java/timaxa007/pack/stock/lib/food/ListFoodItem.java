package timaxa007.pack.stock.lib.food;

import timaxa007.pack.stock.util.FoodItem;
import timaxa007.pack.stock.util.RegistryFoods;

public class ListFoodItem {

	public static FoodItem
	test
	;

	public static FoodItem[] list;

	public static void init() {

		test = new FoodItem("test");

		list = new FoodItem[] {
				test
		};

		RegistryFoods.RegistryFoodItem.registerFoodItem(list);

	}

}
