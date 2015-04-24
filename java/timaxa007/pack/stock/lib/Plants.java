package timaxa007.pack.stock.lib;

import net.minecraft.util.StatCollector;
import timaxa007.module.environment.Humidity;
import timaxa007.module.environment.Temperature;
import timaxa007.tms.util.UtilString;

/**Use in <b>ItemPlants</b> and <b>BlockPlants</b> (<i>TileEntityPlants</i>).
 * @author timaxa007
 * @param 
 * @param 
 * @param 
 */
public class Plants {

	public static PlantType type_plants;

	public static final Plants[] list = new Plants[4096];

	public static final Plants empty = new Plants("");

	public int id;
	public String tag;
	private String name;
	private String type;
	//private int color_hex;

	private PlantParametersMain parameters_main;
	private Temperature temperature;
	private Humidity humidity;

	private String texture;

	/**Не рекомендуется использовать этот метод.<br>
	 * It is not recommended to use this method.**/
	@Deprecated
	public Plants() {id = nextID();list[id] = this;}

	/**Не рекомендуется использовать этот метод.<br>
	 * It is not recommended to use this method.**/
	@Deprecated
	public Plants(int id) {checkID(this, id);this.id = id;list[id] = this;}

	/**Не рекомендуется использовать этот метод.<br>
	 * It is not recommended to use this method.**/
	@Deprecated
	public Plants(int id, String tag) {
		checkID(this, id);checkTag(this, tag);
		this.id = id;this.tag = tag;list[id] = this;
	}

	public Plants(String tag) {
		checkTag(this, tag);
		id = nextID();
		list[id] = this;
		this.tag = tag;
	}
	//--------------------------------------------------------
	public static int nextID() {
		for (int i = 0; i < list.length; i++)
			if (list[i] == null)
				return i;
		return list.length - 1;
	}

	public static boolean hasTag(String tag) {
		if (UtilString.hasString(tag))
			for (Plants iteming : list)
				if (iteming != null && tag.equalsIgnoreCase(iteming.tag))
					return true;
		return false;
	}

	public static int getID_tag(String tag) {
		if (UtilString.hasString(tag))
			for (Plants iteming : list)
				if (iteming != null && tag.equalsIgnoreCase(iteming.tag))
					return iteming.id;
		return empty.id;
	}

	private static void checkID(Plants plant, int id) {
		if (list[id] != null)
			throw new IllegalArgumentException("Duplicate id: " + id + " in " + plant.getClass() + ".");
	}

	private static void checkTag(Plants plant, String tag) {
		if (UtilString.hasString(tag))
			for (Plants iteming : list)
				if (iteming != null && iteming.tag == tag)
					throw new IllegalArgumentException("Duplicate tag: " + tag + " in " + plant.getClass() + ".");
	}

	public static Plants get(String tag) {
		return list[getID_tag(tag)];
	}

	public static boolean isNull(String tag) {
		return isNull(get(tag));
	}

	public static boolean isNull(Plants plant) {
		return plant == null || plant == empty;
	}
	//--------------------------------------------------------
	public Plants setName(String name) {
		this.name = name;
		return this;
	}

	public String getName() {
		return UtilString.hasString(name) ? name : UtilString.hasString(tag) ? tag : "unname";
	}

	public String getLocalizedName() {
		return StatCollector.translateToLocal("plant." + getName() + ".name");
	}

	public Plants setType(String type) {
		this.type = type;
		return this;
	}

	public String getType() {
		return UtilString.hasString(type) ? type : "untype";
	}

	public String getLocalizedType() {
		return StatCollector.translateToLocal("type." + getType().toLowerCase() + ".name");
	}
	/*
	public Plants setColor(int i) {
		color_hex = i;
		return this;
	}

	public int getColor() {
		return color_hex == 0 ? 0xFFFFFF : color_hex;
	}
	 */
	public Plants setPlantStats(int growth, int fertility, int resistance, int protection) {
		this.parameters_main = Plants.PlantParametersMain.create(growth, fertility, resistance, protection);
		return this;
	}

	public int getGrowth() {return parameters_main.growth;}
	public int getFertility() {return parameters_main.fertility;}
	public int getResistance() {return parameters_main.resistance;}
	public int getProtection() {return parameters_main.protection;}

	public Plants setTemperatures(float temperature, float temperature_min, float temperature_max) {
		this.temperature = Temperature.createTemperature(temperature, temperature_min, temperature_max);
		return this;
	}

	public float getTemperature() {return temperature.temperature;}
	public float getTemperatureMin() {return temperature.temperature_min;}
	public float getTemperatureMax() {return temperature.temperature_max;}

	public Plants setHumidity(float humidity, float humidity_min, float humidity_max) {
		this.humidity = Humidity.createHumidity(humidity, humidity_min, humidity_max);
		return this;
	}

	public float getHumidity() {return humidity.humidity;}
	public float getHumidityMin() {return humidity.humidity_min;}
	public float getHumidityMax() {return humidity.humidity_max;}

	public Plants setTexture(String str) {
		texture = str;
		return this;
	}

	public String getTexture() {
		return UtilString.hasString(texture) ? texture : getName();
	}
	//--------------------------------------------------------------------------
	public static class PlantParametersMain {

		/****/
		public int growth;
		/****/
		public int fertility;
		/****/
		public int resistance;
		/****/
		public int protection;

		/** 0 x FF EE CD <br>
		 * @param growth (0 - 255) = FF - Насколько быстро будет расти/How quickly will grow (<i>ещё думаю о качестве роста</i>).<br>
		 * @param fertility (0 - 255) = EE - плодородие/fertility 
		 * (<i>пока-что задумался об том, чтобы разделить ещё на два параметра [количество/качество - (0-15)]</i>),<br>
		 * @param resistance (0 - 15) = C - сопротивление к сорнякам/resistance to weeds,<br>
		 * @param protection (0 - 15) = D - защита от топтания/protection from trampling.<br>
		 * **/
		public PlantParametersMain(int growth, int fertility, int resistance, int protection) {
			this.growth = growth;
			this.fertility = fertility;
			this.resistance = resistance;
			this.protection = protection;
		}

		public PlantParametersMain(int parameters_plant_main) {
			this.growth = (parameters_plant_main >> 16 & 0xFF);
			this.fertility = (parameters_plant_main >> 8 & 0xFF);
			this.resistance = (parameters_plant_main >> 4 & 0xF);
			this.protection = (parameters_plant_main & 0xF);
		}

		public static PlantParametersMain create(int growth, int fertility, int resistance, int protection) {
			return new PlantParametersMain(growth, fertility, resistance, protection);
		}

		public static PlantParametersMain create(int parameters_plant_main) {
			return new PlantParametersMain(parameters_plant_main);
		}

		public void edit(int growth, int fertility, int resistance, int protection) {
			editGrowth(growth);
			editFertility(fertility);
			editResistance(resistance);
			editProtection(protection);
		}

		public void editGrowth(int growth) {
			this.growth = growth;
		}

		public void editFertility(int fertility) {
			this.fertility = fertility;
		}

		public void editResistance(int resistance) {
			this.resistance = resistance;
		}

		public void editProtection(int protection) {
			this.protection = protection;
		}

		public int getPlantParametersMain() {
			return this.growth << 16 | this.fertility << 8 | this.resistance << 4 | protection;
		}

		public String toString() {
			return "(" + this.growth + ", " + this.fertility + ", " + this.resistance + ", " + this.protection + ")";
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
