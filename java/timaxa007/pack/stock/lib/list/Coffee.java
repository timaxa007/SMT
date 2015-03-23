package timaxa007.pack.stock.lib.list;

import timaxa007.pack.stock.lib.FoodForBlock;
import timaxa007.pack.stock.lib.FoodForItem;
import timaxa007.pack.stock.lib.GerminationPlants;
import timaxa007.tms.lib.FluidFake;

public class Coffee {

	public static GerminationPlants shrub_coffee = new GerminationPlants("shrub_coffee").setName("coffee").setType("Shrub").setTexture("coffee").setPlantStats(3, 2, 1).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static GerminationPlants tree_coffee = new GerminationPlants("tree_coffee").setName("coffee").setType("Tree").setTexture("coffee").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);

}
