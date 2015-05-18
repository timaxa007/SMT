package timaxa007.pack.stock.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import timaxa007.smt.util.UtilString;

public class RegistryPlants {

	private static HashMap<String, Plant> plants_map = new HashMap<String, Plant>();

	public static final Plant EMPTY = new Plant("empty");

	static {
		RegistryPlants.registerPlant(EMPTY);
	}

	public static void registerPlant(Plant[] plants) {
		for (Plant plant : plants) if (plant != null) registerPlant(plant);
	}

	public static void registerPlant(Plant plant) {
		if (plant != null && UtilString.hasString(plant.getTag()))
			if (plants_map.get(plant.getTag()) == null)
				plants_map.put(plant.getTag(), plant);
			else throw new IllegalArgumentException("Duplicate " + plant);
		else throw new IllegalArgumentException("Error " + plant);
	}

	public static Plant getPlant(String tag) {
		return (plants_map.get(tag) != null ? plants_map.get(tag) : EMPTY);
	}

	public static List getTagPlants() {
		//List list = Lists.newArrayList();
		ArrayList<String> list = new ArrayList<String>();
		for (Entry<String, Plant> entry : plants_map.entrySet())
			list.add(entry.getKey().toString());
		return list;
	}

	public static boolean hasPlant(Plant plant) {
		return !(plant == null || plant == EMPTY);
	}

	public static boolean hasPlant(String tag) {
		return UtilString.hasString(tag) && hasPlant(RegistryPlants.getPlant(tag));
	}

	//--------------------------------------------------------------------------
	public static class PlantParametersMain {

		/**<b>growth</b> 0xF (0 - 15) - на сколько быстро будет расти.**/
		public int growth_mach;
		public static final int GrowthMachMax = 0xF;

		/**<b>growth</b> 0xF (0 - 15) - на сколько качествено будет расти.**/
		public int growth_quality;
		public static final int GrowthQualityMax = 0xF;

		/**<b>fertility</b> 0xF (0 - 15) - плодовитость качество**/
		public int fertility_quality;
		public static final int FertilityQualityMax = 0xF;

		/**<b>fertility</b> 0xF (0 - 15) - плодовитость количество**/
		public int fertility_quantity;
		public static final int FertilityQuantityMax = 0xF;

		/**<b>resistance</b> 0xF (0 - 15) - сопротивление к сорнякам**/
		public int resistance;
		public static final int ResistanceMax = 0xF;

		/**<b>protection</b> 0xF (0 - 15) - защита от топтания**/
		public int protection;
		public static final int ProtectionMax = 0xF;

		/**<b>dead_plant</b> 0x1 (0 - 1) - отмершие растение**/
		public boolean dead_plant;
		public static final int DeadPlantMax = 0x1;

		public PlantParametersMain(int growth_mach, int growth_quality, int fertility_quality, int fertility_quantity, int resistance, int protection, boolean dead_plant) {
			this.growth_mach = growth_mach;
			this.growth_quality = growth_quality;
			this.fertility_quality = fertility_quality;
			this.fertility_quantity = fertility_quantity;
			this.resistance = resistance;
			this.protection = protection;
			this.dead_plant = dead_plant;
		}

		public PlantParametersMain(int parameters_plant_main) {
			this.growth_mach = (parameters_plant_main & GrowthMachMax);
			this.growth_quality = (parameters_plant_main >> 4 & GrowthQualityMax);
			this.fertility_quality = (parameters_plant_main >> 8 & FertilityQualityMax);
			this.fertility_quantity = (parameters_plant_main >> 12 & FertilityQuantityMax);
			this.resistance = (parameters_plant_main >> 16 & ResistanceMax);
			this.protection = (parameters_plant_main >> 20 & ProtectionMax);
			this.dead_plant = ((parameters_plant_main >> 24 & DeadPlantMax) == 0 ? false : true);
			//25
		}

		public static PlantParametersMain create(int growth_mach, int growth_quality, int fertility_quality, int fertility_quantity, int resistance, int protection, boolean dead_plant) {
			return new PlantParametersMain(growth_mach, growth_quality, fertility_quality, fertility_quantity, resistance, protection, dead_plant);
		}

		public static PlantParametersMain create(int parameters_plant_main) {
			return new PlantParametersMain(parameters_plant_main);
		}

		public void edit(int growth_mach, int growth_quality, int fertility_quality, int fertility_quantity, int resistance, int protection, boolean dead_plant) {
			editGrowthMach(growth_mach);
			editGrowthQuality(growth_quality);
			editFertilityQuality(fertility_quality);
			editFertilityQuantity(fertility_quantity);
			editResistance(resistance);
			editProtection(protection);
			editDeadPlant(dead_plant);
		}

		/**@param growth_mach = (0 - 15)**/
		public void editGrowthMach(int growth_mach) {
			this.growth_mach = (growth_mach <= 0 ? 0 : 
				(growth_mach >= GrowthMachMax ? GrowthMachMax : growth_mach));
		}

		/**@param growth_quality = (0 - 15)**/
		public void editGrowthQuality(int growth_quality) {
			this.growth_quality = (growth_quality <= 0 ? 0 : 
				(growth_quality >= GrowthQualityMax ? GrowthQualityMax : growth_quality));
		}

		/**@param fertility_quality = (0 - 15)**/
		public void editFertilityQuality(int fertility_quality) {
			this.fertility_quality = (fertility_quality <= 0 ? 0 : 
				(fertility_quality >= FertilityQualityMax ? FertilityQualityMax : fertility_quality));
		}

		/**@param fertility_quantity = (0 - 15)**/
		public void editFertilityQuantity(int fertility_quantity) {
			this.fertility_quantity = (fertility_quantity <= 0 ? 0 : 
				(fertility_quantity >= FertilityQuantityMax ? FertilityQuantityMax : fertility_quantity));
		}

		/**@param resistance = (0 - 15)**/
		public void editResistance(int resistance) {
			this.resistance = (resistance <= 0 ? 0 : (resistance >= ResistanceMax ? ResistanceMax : resistance));
		}

		/**@param protection = (0 - 15)**/
		public void editProtection(int protection) {
			this.protection = (protection <= 0 ? 0 : (protection >= ProtectionMax ? ProtectionMax : protection));
		}

		/**@param dead_plant = (<b>true</b> or <b>false</b>)**/
		public void editDeadPlant(boolean dead_plant) {
			this.dead_plant = dead_plant;
		}

		public int getPlantParametersMain() {
			return (this.dead_plant ? 1 : 0) << 24 | this.protection << 20 | this.resistance << 16 | this.fertility_quantity << 12 | this.fertility_quality << 8 | this.growth_quality << 4 | this.growth_mach;
		}

		public String toString() {
			return "(" + this.growth_mach + ", " + this.growth_quality + ", " + this.fertility_quality + ", " + this.fertility_quantity + ", " + this.resistance + ", " + this.protection + ", " + (this.dead_plant) + ")";
		}

	}
	//--------------------------------------------------------------------------
	public static class PlantParametersSecondary {

		public int fertilizer;
		public int humidity;
		public int temperature;

		public static PlantParametersSecondary createParameters(int fertilizer, int humidity, int temperature) {
			return new PlantParametersSecondary(fertilizer, humidity, temperature);
		}

		public static PlantParametersSecondary createParameters(int parameters_plant_secondary) {
			return new PlantParametersSecondary(parameters_plant_secondary);
		}

		public PlantParametersSecondary(int fertilizer, int humidity, int temperature) {
			this.fertilizer = fertilizer;
			this.humidity = humidity;
			this.temperature = temperature;
		}

		public PlantParametersSecondary(int parameters_plant_secondary) {
			this.fertilizer = (parameters_plant_secondary >> 16 & 0xFF);
			this.humidity = (parameters_plant_secondary >> 8 & 0xFF);
			this.temperature = (parameters_plant_secondary & 0xFF);
		}

		public void edit(int fertilizer, int humidity, int temperature) {
			editFertilizer(fertilizer);
			editHumidity(humidity);
			editTemperature(temperature);
		}

		public void editFertilizer(int fertilizer) {
			this.fertilizer = fertilizer;
		}

		public void editHumidity(int humidity) {
			this.humidity = humidity;
		}

		public void editTemperature(int temperature) {
			this.temperature = temperature;
		}

		public int getPlantParametersSecondary() {
			return this.fertilizer << 16 | this.humidity << 8 | temperature;
		}

		public String toString() {
			return "(" + this.fertilizer + ", " + this.humidity + ", " + this.temperature + ")";
		}

	}
	//--------------------------------------------------------------------------
	public static class PlantType/*Build*/ {

		private int id_type;
		public String type_plant;

		public static final PlantType[] list_type_plant = new PlantType[128];

		public static final PlantType none_type = new PlantType("");

		public static final PlantType herbal = new PlantType("Herbal");
		public static final PlantType flower = new PlantType("Flower");
		public static final PlantType crop = new PlantType("");
		public static final PlantType crop_cap = new PlantType("Crop Cap");
		public static final PlantType mushroom = new PlantType("Mushroom");
		public static final PlantType stem = new PlantType("Stem");
		//public static final PlantType squash = new PlantType("Squash");//type for plod
		public static final PlantType shrub = new PlantType("Shrub");
		public static final PlantType sapling = new PlantType("Sapling");
		public static final PlantType tree = new PlantType("Tree");
		public static final PlantType palma = new PlantType("Palma");
		public static final PlantType cactus = new PlantType("Cactus");

		/**Не рекомендуется использовать этот метод.<br>
		 * It is not recommended to use this method.**/
		@Deprecated
		public PlantType() {id_type = nextID();list_type_plant[id_type] = this;}

		/**Не рекомендуется использовать этот метод.<br>
		 * It is not recommended to use this method.**/
		@Deprecated
		public PlantType(int id_type) {checkID(this, id_type);this.id_type = id_type;list_type_plant[id_type] = this;}

		/**Не рекомендуется использовать этот метод.<br>
		 * It is not recommended to use this method.**/
		@Deprecated
		public PlantType(int id_type, String type_plant) {
			checkID(this, id_type);checkTag(this, type_plant);
			this.id_type = id_type;this.type_plant = type_plant;list_type_plant[id_type] = this;
		}

		public PlantType(String type_plant) {
			checkTag(this, type_plant);
			id_type = nextID();
			list_type_plant[id_type] = this;
			this.type_plant = type_plant;
		}
		//--------------------------------------------------------
		public static int nextID() {
			for (int i = 0; i < list_type_plant.length; i++)
				if (list_type_plant[i] == null)
					return i;
			return list_type_plant.length - 1;
		}

		public static boolean hasTag(String type_plant) {
			if (UtilString.hasString(type_plant))
				for (PlantType iteming : list_type_plant)
					if (iteming != null && type_plant.equalsIgnoreCase(iteming.type_plant))
						return true;
			return false;
		}

		public static int getID_type(String type_plant) {
			if (UtilString.hasString(type_plant))
				for (PlantType iteming : list_type_plant)
					if (iteming != null && type_plant.equalsIgnoreCase(iteming.type_plant))
						return iteming.id_type;
			return none_type.id_type;
		}

		private static void checkID(PlantType plant_type, int id_type) {
			if (list_type_plant[id_type] != null)
				throw new IllegalArgumentException("Duplicate id_type: " + id_type + " in " + plant_type.getClass() + ".");
		}

		private static void checkTag(PlantType plant_type, String type_plant) {
			if (UtilString.hasString(type_plant))
				for (PlantType iteming : list_type_plant)
					if (iteming != null && iteming.type_plant == type_plant)
						throw new IllegalArgumentException("Duplicate type_plant: " + type_plant + 
								" in " + plant_type.getClass() + ".");
		}

		public static PlantType get(String type_plant) {
			return list_type_plant[getID_type(type_plant)];
		}

		public static boolean isNull(String type_plant) {
			return isNull(get(type_plant));
		}

		public static boolean isNull(PlantType plant_type) {
			return plant_type == null || plant_type == none_type;
		}
		//--------------------------------------------------------
	}
	//--------------------------------------------------------------------------
}
