package timaxa007.pack.stock.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import timaxa007.smt.util.UtilString;

public class RegistryFoods {
	//-------------------------------------------------------------------------------------------
	public static class RegistryFoodItem {

		private static HashMap<String, FoodItem> food_item_map = new HashMap<String, FoodItem>();

		public static final FoodItem EMPTY = new FoodItem("empty");

		static {
			RegistryFoodItem.registerFoodItem(EMPTY);
		}

		public static void registerFoodItem(FoodItem[] food_items) {
			for (FoodItem food_item : food_items) if (food_item != null) registerFoodItem(food_item);
		}

		public static void registerFoodItem(FoodItem food_item) {
			if (food_item != null && UtilString.hasString(food_item.getTag()))
				if (food_item_map.get(food_item.getTag()) == null)
					food_item_map.put(food_item.getTag(), food_item);
				else throw new IllegalArgumentException("Duplicate " + food_item);
			else throw new IllegalArgumentException("Error " + food_item);
		}

		public static FoodItem getFoodItem(String tag) {
			return (food_item_map.get(tag) != null ? food_item_map.get(tag) : EMPTY);
		}

		public static List getTagFoodItems() {
			ArrayList<String> list = new ArrayList<String>();
			for (Entry<String, FoodItem> entry : food_item_map.entrySet())
				list.add(entry.getKey().toString());
			return list;
		}

		public static boolean hasFoodItem(FoodItem food_item) {
			return !(food_item == null || food_item == EMPTY);
		}

		public static boolean hasFoodItem(String tag) {
			return UtilString.hasString(tag) && hasFoodItem(RegistryFoodItem.getFoodItem(tag));
		}

	}
	//-------------------------------------------------------------------------------------------
	public static class RegistryFoodBlock {

		private static HashMap<String, FoodBlock> food_block_map = new HashMap<String, FoodBlock>();

		public static final FoodBlock EMPTY = new FoodBlock("empty");

		static {
			RegistryFoodBlock.registerFoodBlock(EMPTY);
		}

		public static void registerFoodBlock(FoodBlock[] food_blocks) {
			for (FoodBlock food_block : food_blocks) if (food_block != null) registerFoodBlock(food_block);
		}

		public static void registerFoodBlock(FoodBlock food_block) {
			if (food_block != null && UtilString.hasString(food_block.getTag()))
				if (food_block_map.get(food_block.getTag()) == null)
					food_block_map.put(food_block.getTag(), food_block);
				else throw new IllegalArgumentException("Duplicate " + food_block);
			else throw new IllegalArgumentException("Error " + food_block);
		}

		public static FoodBlock getFoodBlock(String tag) {
			return (food_block_map.get(tag) != null ? food_block_map.get(tag) : EMPTY);
		}

		public static List getTagFoodBlocks() {
			ArrayList<String> list = new ArrayList<String>();
			for (Entry<String, FoodBlock> entry : food_block_map.entrySet())
				list.add(entry.getKey().toString());
			return list;
		}

		public static boolean hasFoodBlock(FoodBlock food_block) {
			return !(food_block == null || food_block == EMPTY);
		}

		public static boolean hasFoodBlock(String tag) {
			return UtilString.hasString(tag) && hasFoodBlock(RegistryFoodBlock.getFoodBlock(tag));
		}

	}
	//-------------------------------------------------------------------------------------------
}
