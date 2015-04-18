package timaxa007.pack.stock.lib;

import net.minecraft.util.StatCollector;
import timaxa007.tms.util.UtilString;
/**
 * Use in <b>ItemPlants</b> and <b>BlockPlants</b>.
 * @author timaxa007
 * @param 
 * @param 
 * @param 
 */
public class Plants {

	public PlantType type_plants;

	public static final Plants[] list = new Plants[4096];

	public static final Plants empty = new Plants("");

	public int id;
	public String tag;
	private String name;
	private String type;
	//private int color_hex;

	private int growth;
	private int fertility;
	private int resistance;

	private float temperature;
	private float temperature_min;
	private float temperature_max;

	private float humidity;
	private float humidity_min;
	private float humidity_max;

	private String texture;

	/**It is not recommended to use this method.**/@Deprecated
	public Plants() {id = nextID();list[id] = this;}

	/**It is not recommended to use this method.**/@Deprecated
	public Plants(int id) {checkID(this, id);this.id = id;list[id] = this;}

	/**It is not recommended to use this method.**/@Deprecated
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
	public Plants setPlantStats(int gro, int fer, int res) {
		growth = gro;
		fertility = fer;
		resistance = res;
		return this;
	}

	public Plants setGrowth(int gro) {
		growth = gro;
		return this;
	}

	public int getGrowth() {
		return growth == 0 ? 0 : growth;
	}

	public Plants setFertility(int fer) {
		fertility = fer;
		return this;
	}

	public int getFertility() {
		return fertility == 0 ? 0 : fertility;
	}

	public Plants setResistance(int res) {
		resistance = res;
		return this;
	}

	public int getResistance() {
		return resistance == 0 ? 0 : resistance;
	}

	public Plants setTemperatures(float temp, float temp_min, float temp_max) {
		temperature = temp;
		temperature_min = temp_min;
		temperature_max = temp_max;
		return this;
	}

	public Plants setTemperature(float f) {
		temperature = f;
		return this;
	}

	public float getTemperature() {
		return temperature == 0 ? 0.0F : temperature;
	}

	public Plants setTemperatureMin(float f) {
		temperature_min = f;
		return this;
	}

	public float getTemperatureMin() {
		return temperature_min == 0 ? 0.0F : temperature_min;
	}

	public Plants setTemperatureMax(float f) {
		temperature_max = f;
		return this;
	}

	public float getTemperatureMax() {
		return temperature_max == 0 ? 0.0F : temperature_max;
	}

	public Plants setHumidity(float humy, float humy_min, float humy_max) {
		humidity = humy;
		humidity_min = humy_min;
		humidity_max = humy_max;
		return this;
	}

	public Plants setHumidity(float f) {
		humidity = f;
		return this;
	}

	public float getHumidity() {
		return humidity == 0 ? 0.0F : humidity;
	}

	public Plants setHumidityMin(float f) {
		humidity_min = f;
		return this;
	}

	public float getHumidityMin() {
		return humidity_min == 0 ? 0.0F : humidity_min;
	}

	public Plants setHumidityMax(float f) {
		humidity_max = f;
		return this;
	}

	public float getHumidityMax() {
		return humidity_max == 0 ? 0.0F : humidity_max;
	}

	public Plants setTexture(String str) {
		texture = str;
		return this;
	}

	public String getTexture() {
		return texture == null ? getName() : texture;
	}

	private static class PlantType/*Build*/ {

		public int id_type;
		public String type_plant;

		public static final PlantType[] list_type_plant = new PlantType[128];

		public static final PlantType none_type = new PlantType("");

		public static final PlantType herbal = new PlantType("Herbal");
		public static final PlantType flower = new PlantType("Flower");
		public static final PlantType crop = new PlantType("");
		public static final PlantType crop_cap = new PlantType("Crop Cap");
		public static final PlantType mushroom = new PlantType("Mushroom");
		public static final PlantType stem = new PlantType("Stem");
		//public static final PlantType squash = new PlantType("Squash");
		public static final PlantType shrub = new PlantType("Shrub");
		public static final PlantType sapling = new PlantType("Sapling");
		public static final PlantType tree = new PlantType("Tree");
		public static final PlantType palma = new PlantType("Palma");
		public static final PlantType cactus = new PlantType("Cactus");

		/**It is not recommended to use this method.**/@Deprecated
		public PlantType() {id_type = nextID();list_type_plant[id_type] = this;}

		/**It is not recommended to use this method.**/@Deprecated
		public PlantType(int id_type) {checkID(this, id_type);this.id_type = id_type;list_type_plant[id_type] = this;}

		/**It is not recommended to use this method.**/@Deprecated
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

}
