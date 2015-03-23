package mods.timaxa007.pack.stock.lib.list;

import mods.timaxa007.pack.stock.lib.FoodForBlock;
import mods.timaxa007.pack.stock.lib.FoodForItem;
import mods.timaxa007.pack.stock.lib.GerminationPlants;
import mods.timaxa007.tms.lib.FluidFake;

public class Peanut {

	public static GerminationPlants crop_peanut = new GerminationPlants("crop_peanut").setName("peanut").setType("Crop").setTexture("peanut").setPlantStats(3, 2, 1).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static GerminationPlants shrub_peanut = new GerminationPlants("shrub_peanut").setName("peanut").setType("Shrub").setTexture("peanut").setPlantStats(3, 2, 1).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);

}
