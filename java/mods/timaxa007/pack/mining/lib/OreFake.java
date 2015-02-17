package mods.timaxa007.pack.mining.lib;

import mods.timaxa007.tms.util.UtilString;
import net.minecraft.util.StatCollector;

/**
 * Use in <b>OreOres</b>.
 * @author timaxa007
 * @param 
 * @param 
 * @param 
 */
public class OreFake {

	public static final OreFake[] list = new OreFake[4096];

	public static final OreFake empty = new OreFake("");

	public int id;
	public String tag;
	private String name;
	private String type;
	private int color_hex;
	private float temperature;
	private float temperature_min;
	private float temperature_max;

	private String texture;

	/**It is not recommended to use this method.**/@Deprecated
	public OreFake() {id = nextID();list[id] = this;}

	/**It is not recommended to use this method.**/@Deprecated
	public OreFake(int id) {checkID(this, id);this.id = id;list[id] = this;}

	/**It is not recommended to use this method.**/@Deprecated
	public OreFake(int id, String tag) {
		checkID(this, id);checkTag(this, tag);
		this.id = id;this.tag = tag;list[id] = this;
	}

	public OreFake(String tag) {
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
			for (int i = 0; i < list.length; i++)
				if (list[i] != null && tag.equalsIgnoreCase(list[i].tag))
					return true;
		return false;
	}

	public static int getID_tag(String tag) {
		if (UtilString.hasString(tag))
			for (int i = 0; i < list.length; i++)
				if (list[i] != null && tag.equalsIgnoreCase(list[i].tag))
					return i;
		return 0;
	}

	private static void checkID(OreFake oreFake, int id) {
		if (list[id] != null)
			throw new IllegalArgumentException("Duplicate id: " + id + " in " + oreFake.getClass() + ".");
	}

	private static void checkTag(OreFake oreFake, String tag) {
		for (int i = 0; i < list.length; i++)
			if (list[i] != null && list[i].tag == tag)
				throw new IllegalArgumentException("Duplicate tag: " + tag + " in " + oreFake.getClass() + ".");
	}

	public static OreFake get(String tag) {
		return list[getID_tag(tag)];
	}

	public static boolean isNull(String tag) {
		return isNull(get(tag));
	}

	public static boolean isNull(OreFake of) {
		return of == null || of == empty;
	}
	//--------------------------------------------------------
	public OreFake setName(String name) {
		this.name = name;
		return this;
	}

	public String getName() {
		return UtilString.hasString(name) ? name : UtilString.hasString(tag) ? tag : "unname";
	}

	public String getLocalizedName() {
		return StatCollector.translateToLocal("ore." + getName() + ".name");
	}

	public OreFake setType(String type) {
		this.type = type;
		return this;
	}

	public String getType() {
		return UtilString.hasString(type) ? type : "untype";
	}

	public String getLocalizedType() {
		return StatCollector.translateToLocal("type." + getType().toLowerCase() + ".name");
	}

	public OreFake setColor(int color) {
		color_hex = color;
		return this;
	}

	public int getColor() {
		return color_hex == 0 ? 0xFFFFFF : color_hex;
	}

	public OreFake setTemperatures(float temp, float temp_min, float temp_max) {
		temperature = temp;
		temperature_min = temp_min;
		temperature_max = temp_max;
		return this;
	}

	public OreFake setTemperature(float f) {
		temperature = f;
		return this;
	}

	public float getTemperature() {
		return temperature == 0 ? 0.0F : temperature;
	}

	public OreFake setTemperatureMin(float f) {
		temperature_min = f;
		return this;
	}

	public float getTemperatureMin() {
		return temperature_min == 0 ? 0.0F : temperature_min;
	}

	public OreFake setTemperatureMax(float f) {
		temperature_max = f;
		return this;
	}

	public float getTemperatureMax() {
		return temperature_max == 0 ? 0.0F : temperature_max;
	}

	public OreFake setTexture(String path) {
		texture = path;
		return this;
	}

	public OreFake setTextureOre(String path) {
		texture = "ore/" + path;
		return this;
	}

	public String getTexture() {
		return texture == null ? getName() : texture;
	}

}
