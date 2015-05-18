package timaxa007.pack.stock.util;

import net.minecraft.util.StatCollector;
import timaxa007.module.environment.Humidity;
import timaxa007.module.environment.Hydrogenated;
import timaxa007.module.environment.Temperature;
import timaxa007.smt.util.UtilString;

public class Plant {

	private String tag;
	private String name;
	private String type;

	private RegistryPlants.PlantType type_plants;
	private RegistryPlants.PlantParametersMain parameters_main;
	private Temperature temperature;
	private Humidity humidity;
	private Hydrogenated hydrogenated;

	private String texture;
	//private IIcon icon;

	public Plant(String tag) {
		this.tag = tag;
	}

	public String getTag() {return tag;}

	public Plant setName(String name) {
		this.name = name;
		return this;
	}

	public String getName() {
		return (UtilString.hasString(name) ? name : (UtilString.hasString(tag) ? getTag() : "unname"));
	}

	public String getLocalizedName() {
		return StatCollector.translateToLocal("plant." + getName() + ".name");
	}

	public Plant setType(String type) {
		this.type = type;
		return this;
	}

	public String getType() {
		return UtilString.hasString(type) ? type : "untype";
	}

	public String getLocalizedType() {
		return StatCollector.translateToLocal("type." + getType() + ".name");
	}

	public Plant setPlantStats(int growth_mach, int growth_quality, int fertility_quality, int fertility_quantity, int resistance, int protection, boolean dead_plant) {
		this.parameters_main = RegistryPlants.PlantParametersMain.create(growth_mach, growth_quality, fertility_quality, fertility_quantity, resistance, protection, dead_plant);
		return this;
	}

	public Plant setPlantStats(int growth_mach, int growth_quality, int fertility_quality, int fertility_quantity, int resistance, int protection) {
		this.parameters_main = RegistryPlants.PlantParametersMain.create(growth_mach, growth_quality, fertility_quality, fertility_quantity, resistance, protection, false);
		return this;
	}

	public int getGrowthMach() {return parameters_main.growth_mach;}
	public int getGrowthQuality() {return parameters_main.growth_quality;}
	public int getFertilityQuality() {return parameters_main.fertility_quality;}
	public int getFertilityQuantity() {return parameters_main.fertility_quantity;}
	public int getResistance() {return parameters_main.resistance;}
	public int getProtection() {return parameters_main.protection;}
	public boolean getDeadPlant() {return parameters_main.dead_plant;}

	public Plant setTemperatures(float temperature, float temperature_min, float temperature_max) {
		this.temperature = Temperature.create(temperature, temperature_min, temperature_max);
		return this;
	}

	public float getTemperature() {return temperature.temperature;}
	public float getTemperatureMin() {return temperature.temperature_min;}
	public float getTemperatureMax() {return temperature.temperature_max;}

	public Plant setHumidity(float humidity, float humidity_min, float humidity_max) {
		this.humidity = Humidity.create(humidity, humidity_min, humidity_max);
		return this;
	}

	public float getHumidity() {return humidity.humidity;}
	public float getHumidityMin() {return humidity.humidity_min;}
	public float getHumidityMax() {return humidity.humidity_max;}

	public Plant setHydrogenated(float hydrogenated, float hydrogenated_min, float hydrogenated_max) {
		this.hydrogenated = Hydrogenated.create(hydrogenated, hydrogenated_min, hydrogenated_max);
		return this;
	}

	public float getHydrogenated() {return hydrogenated.hydrogenated;}
	public float getHydrogenatedMin() {return hydrogenated.hydrogenated_min;}
	public float getHydrogenatedMax() {return hydrogenated.hydrogenated_max;}

	public Plant setTexture(String str) {
		texture = str;
		return this;
	}

	public String getTexture() {
		return UtilString.hasString(texture) ? texture : getName();
	}

	public String toString() {
		return "Plant: " + getTag() + ".";
	}

}
