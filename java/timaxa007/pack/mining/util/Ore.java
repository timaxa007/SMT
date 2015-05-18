package timaxa007.pack.mining.util;

import net.minecraft.util.StatCollector;
import timaxa007.module.environment.Temperature;
import timaxa007.smt.util.UtilString;

/**
 * Use in <b>OreOres</b>.
 * @author timaxa007
 * @param 
 */
public class Ore {

	private String tag;
	private String name;
	private String type;

	public Temperature temperature;

	private int color_hex;
	private String texture;

	public Ore(String tag) {
		this.tag = tag;
		this.temperature = Temperature.create(32.0F, 16.0F, 48.0F);
	}
	//--------------------------------------------------------
	public String getTag() {
		return tag;
	}

	public Ore setName(String name) {
		this.name = name;
		return this;
	}

	public String getName() {
		return UtilString.hasString(name) ? name : UtilString.hasString(tag) ? getTag() : "unname";
	}

	public String getLocalizedName() {
		return StatCollector.translateToLocal("ore." + getName() + ".name");
	}

	public Ore setType(String type) {
		this.type = type;
		return this;
	}

	public String getType() {
		return UtilString.hasString(type) ? type : "untype";
	}

	public String getLocalizedType() {
		return StatCollector.translateToLocal("type." + getType().toLowerCase() + ".name");
	}

	public Ore setColor(int color) {
		color_hex = color;
		return this;
	}

	public int getColor() {return color_hex;}

	public Ore setTemperatures(float temp, float temp_min, float temp_max) {
		temperature.temperature = temp;
		temperature.temperature_min = temp_min;
		temperature.temperature_max = temp_max;
		return this;
	}

	public Ore setTemperature(float f) {
		temperature.temperature = f;
		return this;
	}

	public Ore setTemperatureMin(float f) {
		temperature.temperature_min = f;
		return this;
	}

	public Ore setTemperatureMax(float f) {
		temperature.temperature_max = f;
		return this;
	}

	public float getTemperature() {return temperature.temperature;}
	public float getTemperatureMin() {return temperature.temperature_min;}
	public float getTemperatureMax() {return temperature.temperature_max;}

	public Ore setTexture(String path) {
		texture = path;
		return this;
	}

	public Ore setTextureOre(String path) {
		texture = "ore/" + path;
		return this;
	}

	public String getTexture() {
		return texture == null ? getName() : texture;
	}

	public String toString() {
		return "Ore: " + getTag() + ".";
	}

}
