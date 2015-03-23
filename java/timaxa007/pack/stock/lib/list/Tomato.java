package timaxa007.pack.stock.lib.list;

import timaxa007.pack.stock.lib.FoodForBlock;
import timaxa007.pack.stock.lib.FoodForItem;
import timaxa007.pack.stock.lib.GerminationPlants;
import timaxa007.tms.lib.FluidFake;

public class Tomato {

	public static GerminationPlants crop_tomato = new GerminationPlants("crop_tomato").setName("tomato").setType("Crop").setTexture("tomato").setPlantStats(3, 2, 1).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);
	public static GerminationPlants herbal_tomato = new GerminationPlants("herbal_tomato").setName("tomato").setType("Herbal").setTexture("tomato").setPlantStats(3, 2, 1).setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);

}
