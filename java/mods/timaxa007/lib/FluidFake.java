package mods.timaxa007.lib;

import mods.timaxa007.tms.Core;
import net.minecraft.util.StatCollector;
/**
 * @author timaxa007
 * @param 
 * @param 
 * @param 
 */
public class FluidFake {

	public static final FluidFake[] list = new FluidFake[4096];

	public static final FluidFake empty = new FluidFake(0);

	public int id;
	public String tag;
	private String name;
	private String type;
	private int color_hex;
	private float temperature;
	private float temperature_min;
	private float temperature_max;

	protected String texture;

	/**It is not recommended to use this method.**/
	@Deprecated
	public FluidFake() {
		id = nextID();
		list[id] = this;
	}

	/**It is not recommended to use this method.**/
	@Deprecated
	public FluidFake(int id) {
		this.id = id;
		list[id] = this;
	}

	/**It is not recommended to use this method.**/
	@Deprecated
	public FluidFake(int id, String tag) {
		if (Core.show_tip_info_testing) checkTag(tag);
		this.id = id;
		list[id] = this;
		this.tag = tag;
	}

	public FluidFake(String tag) {
		if (Core.show_tip_info_testing) checkTag(tag);
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

	public static boolean hasTag(String str) {
		for (int i = 0; i < list.length; i++)
			if (str.equalsIgnoreCase(list[i].tag))
				return true;
		return false;
	}

	public static int getID_tag(String str) {
		for (int i = 0; i < list.length; i++)
			if (str.equalsIgnoreCase(list[i].tag))
				return i;
		return 0;
	}

	private static void checkTag(String str) {
		for (int i = 0; i < list.length; i++)
			if (list[i] != null && list[i].tag == str)
				System.out.println("!Duplicate: " + str);
	}

	public static FluidFake get(String tag) {
		if (tag != null && tag.length() > 0)
			return list[getID_tag(tag)];
		return empty;
	}
	//--------------------------------------------------------
	public boolean hasTag() {
		return tag != null && tag.length() > 0;
	}

	public FluidFake setName(String name) {
		this.name = name;
		return this;
	}

	public String getName() {
		return name == null ? "unnamed" : name;
	}

	public String getLocalizedName() {
		return StatCollector.translateToLocal("fluid." + getName() + ".name");
	}

	public FluidFake setType(String type) {
		this.type = type;
		return this;
	}

	public String getType() {
		return type == null ? "untype" : type;
	}

	public String getLocalizedType() {
		return StatCollector.translateToLocal("type." + getType().toLowerCase() + ".name");
	}

	public FluidFake setColor(int color) {
		color_hex = color;
		return this;
	}

	public FluidFake setColorMix(int color1, int color2) {
		color_hex = GetColors.getColorMix(color1, color2);
		return this;
	}

	public int getColor() {
		return color_hex == 0 ? 0xFFFFFF : color_hex;
	}

	public FluidFake setTemperatures(float temp, float temp_min, float temp_max) {
		temperature = temp;
		temperature_min = temp_min;
		temperature_max = temp_max;
		return this;
	}

	public FluidFake setTemperature(float f) {
		temperature = f;
		return this;
	}

	public float getTemperature() {
		return temperature == 0 ? 0.0F : temperature;
	}

	public FluidFake setTemperatureMin(float f) {
		temperature_min = f;
		return this;
	}

	public float getTemperatureMin() {
		return temperature_min == 0 ? 0.0F : temperature_min;
	}

	public FluidFake setTemperatureMax(float f) {
		temperature_max = f;
		return this;
	}

	public float getTemperatureMax() {
		return temperature_max == 0 ? 0.0F : temperature_max;
	}

	public FluidFake setTexture(String path) {
		texture = path;
		return this;
	}

	public String getTexture() {
		return texture == null ? getName() : texture;
	}

}

