package mods.timaxa007.pack.stock.list;

import mods.timaxa007.lib.FluidFake;
import mods.timaxa007.pack.stock.lib.FoodForBlock;
import mods.timaxa007.pack.stock.lib.FoodForItem;
import mods.timaxa007.pack.stock.lib.GerminationPlants;

public class Tea {

	public static GerminationPlants shrub_tea = new GerminationPlants("shrub_tea").setName("tea").setType("Shrub").setTexture("tea").setPlantStats(3, 2, 1).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static GerminationPlants tree_tea = new GerminationPlants("tree_tea").setName("tea").setType("Tree").setTexture("tea").setPlantStats(1, 2, 3).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);

}
