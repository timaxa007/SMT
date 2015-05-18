package timaxa007.pack.stock.lib;

import timaxa007.pack.stock.util.Plant;
import timaxa007.pack.stock.util.RegistryPlants;

public class ListPlants {

	public static Plant
	test_plant
	;

	public static Plant[] list;

	public static void init() {

		test_plant = new Plant("test_plant").setType("Plant").setPlantStats(5, 4, 3, 2, 1, 10)
				.setTemperatures(30.0F, 0.0F, 60.0F).setHumidity(30.0F, 0.0F, 60.0F);

		list = new Plant[] {
				test_plant
		};

		RegistryPlants.registerPlant(list);

	}

}
