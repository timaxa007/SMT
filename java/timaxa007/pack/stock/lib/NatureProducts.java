package timaxa007.pack.stock.lib;

import net.minecraft.util.StatCollector;
import timaxa007.module.environment.Humidity;
import timaxa007.module.environment.Hydrogenated;
import timaxa007.module.environment.Temperature;
import timaxa007.tms.util.UtilString;

public class NatureProducts {

	public static final NatureProducts[] list = new NatureProducts[4096];

	public static final NatureProducts empty = new NatureProducts("");

	public int id;
	public String tag;
	private String name;
	private String type;
	private int color_hex;
	private String texture;

	private NatureProductParametersMain parameters_main;
	private Temperature temperature;
	private Humidity humidity;
	private Hydrogenated hydrogenated;

	/**Не рекомендуется использовать этот метод.<br>
	 * It is not recommended to use this method.**/
	@Deprecated
	public NatureProducts() {id = nextID();list[id] = this;}

	/**Не рекомендуется использовать этот метод.<br>
	 * It is not recommended to use this method.**/
	@Deprecated
	public NatureProducts(int id) {checkID(this, id);this.id = id;list[id] = this;}

	/**Не рекомендуется использовать этот метод.<br>
	 * It is not recommended to use this method.**/
	@Deprecated
	public NatureProducts(int id, String tag) {
		checkID(this, id);checkTag(this, tag);
		this.id = id;this.tag = tag;list[id] = this;
	}

	public NatureProducts(String tag) {
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
			for (NatureProducts iteming : list)
				if (iteming != null && tag.equalsIgnoreCase(iteming.tag))
					return true;
		return false;
	}

	public static int getID_tag(String tag) {
		if (UtilString.hasString(tag))
			for (NatureProducts iteming : list)
				if (iteming != null && tag.equalsIgnoreCase(iteming.tag))
					return iteming.id;
		return empty.id;
	}

	private static void checkID(NatureProducts nature_product, int id) {
		if (list[id] != null)
			throw new IllegalArgumentException("Duplicate id: " + id + " in " + nature_product.getClass() + ".");
	}

	private static void checkTag(NatureProducts nature_product, String tag) {
		if (UtilString.hasString(tag))
			for (NatureProducts iteming : list)
				if (iteming != null && iteming.tag == tag)
					throw new IllegalArgumentException("Duplicate tag: " + tag + " in " + nature_product.getClass() + ".");
	}

	public static NatureProducts get(String tag) {
		return list[getID_tag(tag)];
	}

	public static boolean isNull(String tag) {
		return isNull(get(tag));
	}

	public static boolean isNull(NatureProducts nature_product) {
		return nature_product == null || nature_product == empty;
	}
	//--------------------------------------------------------
	public NatureProducts setName(String name) {
		this.name = name;
		return this;
	}

	public String getName() {
		return UtilString.hasString(name) ? name : UtilString.hasString(tag) ? tag : "unname";
	}

	public String getLocalizedName() {
		return StatCollector.translateToLocal("nature_product." + getName() + ".name");
	}

	public NatureProducts setType(String type) {
		this.type = type;
		return this;
	}

	public String getType() {
		return UtilString.hasString(type) ? type : "untype";
	}

	public String getLocalizedType() {
		return StatCollector.translateToLocal("type." + getType().toLowerCase() + ".name");
	}

	public NatureProducts setColor(int i) {
		color_hex = i;
		return this;
	}

	public int getColor() {return color_hex;}

	public NatureProducts setNatureProductStats(int growth_mach, int growth_quality, int fertility_quality, int fertility_quantity, int resistance, int protection, boolean dead_nature_product) {
		this.parameters_main = NatureProducts.NatureProductParametersMain.create(growth_mach, growth_quality, fertility_quality, fertility_quantity, resistance, protection, dead_nature_product);
		return this;
	}

	public NatureProducts setNatureProductStats(int growth_mach, int growth_quality, int fertility_quality, int fertility_quantity, int resistance, int protection) {
		this.parameters_main = NatureProducts.NatureProductParametersMain.create(growth_mach, growth_quality, fertility_quality, fertility_quantity, resistance, protection, false);
		return this;
	}

	public int getGrowthMach() {return parameters_main.growth_mach;}
	public int getGrowthQuality() {return parameters_main.growth_quality;}
	public int getFertilityQuality() {return parameters_main.fertility_quality;}
	public int getFertilityQuantity() {return parameters_main.fertility_quantity;}
	public int getResistance() {return parameters_main.resistance;}
	public int getProtection() {return parameters_main.protection;}
	public boolean getDeadNatureProduct() {return parameters_main.dead_nature_product;}

	public NatureProducts setTemperatures(float temperature, float temperature_min, float temperature_max) {
		this.temperature = Temperature.create(temperature, temperature_min, temperature_max);
		return this;
	}

	public float getTemperature() {return temperature.temperature;}
	public float getTemperatureMin() {return temperature.temperature_min;}
	public float getTemperatureMax() {return temperature.temperature_max;}

	public NatureProducts setHumidity(float humidity, float humidity_min, float humidity_max) {
		this.humidity = Humidity.create(humidity, humidity_min, humidity_max);
		return this;
	}

	public float getHumidity() {return humidity.humidity;}
	public float getHumidityMin() {return humidity.humidity_min;}
	public float getHumidityMax() {return humidity.humidity_max;}

	public NatureProducts setHydrogenated(float hydrogenated, float hydrogenated_min, float hydrogenated_max) {
		this.hydrogenated = Hydrogenated.create(hydrogenated, hydrogenated_min, hydrogenated_max);
		return this;
	}

	public float getHydrogenated() {return hydrogenated.hydrogenated;}
	public float getHydrogenatedMin() {return hydrogenated.hydrogenated_min;}
	public float getHydrogenatedMax() {return hydrogenated.hydrogenated_max;}

	public NatureProducts setTexture(String str) {
		texture = str;
		return this;
	}

	public String getTexture() {
		return UtilString.hasString(texture) ? texture : getName();
	}
	//--------------------------------------------------------------------------
	public static class NatureProductParametersMain {

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

		/**<b>dead_nature_product</b> 0x1 (0 - 1) - отмершие растение**/
		public boolean dead_nature_product;
		public static final int DeadNatureProductMax = 0x1;

		public NatureProductParametersMain(int growth_mach, int growth_quality, int fertility_quality, int fertility_quantity, int resistance, int protection, boolean dead_nature_product) {
			this.growth_mach = growth_mach;
			this.growth_quality = growth_quality;
			this.fertility_quality = fertility_quality;
			this.fertility_quantity = fertility_quantity;
			this.resistance = resistance;
			this.protection = protection;
			this.dead_nature_product = dead_nature_product;
		}

		public NatureProductParametersMain(int parameters_nature_product_main) {
			this.growth_mach = (parameters_nature_product_main & GrowthMachMax);
			this.growth_quality = (parameters_nature_product_main >> 4 & GrowthQualityMax);
			this.fertility_quality = (parameters_nature_product_main >> 8 & FertilityQualityMax);
			this.fertility_quantity = (parameters_nature_product_main >> 12 & FertilityQuantityMax);
			this.resistance = (parameters_nature_product_main >> 16 & ResistanceMax);
			this.protection = (parameters_nature_product_main >> 20 & ProtectionMax);
			this.dead_nature_product = ((parameters_nature_product_main >> 24 & DeadNatureProductMax) == 0 ? false : true);
			//25
		}

		public static NatureProductParametersMain create(int growth_mach, int growth_quality, int fertility_quality, int fertility_quantity, int resistance, int protection, boolean dead_nature_product) {
			return new NatureProductParametersMain(growth_mach, growth_quality, fertility_quality, fertility_quantity, resistance, protection, dead_nature_product);
		}

		public static NatureProductParametersMain create(int parameters_nature_product_main) {
			return new NatureProductParametersMain(parameters_nature_product_main);
		}

		public void edit(int growth_mach, int growth_quality, int fertility_quality, int fertility_quantity, int resistance, int protection, boolean dead_nature_product) {
			editGrowthMach(growth_mach);
			editGrowthQuality(growth_quality);
			editFertilityQuality(fertility_quality);
			editFertilityQuantity(fertility_quantity);
			editResistance(resistance);
			editProtection(protection);
			editDeadNatureProduct(dead_nature_product);
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

		/**@param dead_nature_product = (<b>true</b> or <b>false</b>)**/
		public void editDeadNatureProduct(boolean dead_nature_product) {
			this.dead_nature_product = dead_nature_product;
		}

		public int getNatureProductParametersMain() {
			return (this.dead_nature_product ? 1 : 0) << 24 | this.protection << 20 | this.resistance << 16 | this.fertility_quantity << 12 | this.fertility_quality << 8 | this.growth_quality << 4 | this.growth_mach;
		}

		public String toString() {
			return "(" + this.growth_mach + ", " + this.growth_quality + ", " + this.fertility_quality + ", " + this.fertility_quantity + ", " + this.resistance + ", " + this.protection + ", " + (this.dead_nature_product) + ")";
		}

	}
	//--------------------------------------------------------------------------
}
