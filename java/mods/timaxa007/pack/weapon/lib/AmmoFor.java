package mods.timaxa007.pack.weapon.lib;

import mods.timaxa007.tms.Core;
import net.minecraft.util.StatCollector;
/**
 * Use in <b>ItemAmmos</b>.
 * @author timaxa007
 * @param 
 * @param 
 * @param 
 */
public class AmmoFor {

	public static final AmmoFor[] list = new AmmoFor[2048];

	public static final AmmoFor empty = new AmmoFor(0);

	public int id;
	public String tag;
	private String name;
	private String type;

	private int color_hex1;
	private int color_hex2;
	private float temperature;
	private float temperature_min;
	private float temperature_max;

	private String texture1Name;
	private String texture2Name;

	/**It is not recommended to use this method.**/
	@Deprecated
	public AmmoFor() {
		id = nextID();
		list[id] = this;
	}

	/**It is not recommended to use this method.**/
	@Deprecated
	public AmmoFor(int id) {
		this.id = id;
		list[id] = this;
	}

	/**It is not recommended to use this method.**/
	@Deprecated
	public AmmoFor(int id, String tag) {
		if (Core.show_tip_info_testing) checkTag(tag);
		this.id = id;
		list[id] = this;
		this.tag = tag;
	}

	public AmmoFor(String tag) {
		if (Core.show_tip_info_testing) checkTag(tag);
		id = nextID();
		list[id] = this;
		this.tag = tag;
	}

	public static int nextID() {
		for (int i = 0; i < list.length; i++)
			if (list[i] == null)
				return i;
		return list.length - 1;
	}

	public static boolean hasTag(String tag) {
		for (int i = 0; i < list.length; i++)
			if (tag.equalsIgnoreCase(list[i].tag))
				return true;
		return false;
	}

	public static int getID_tag(String tag) {
		for (int i = 0; i < list.length; i++)
			if (tag.equalsIgnoreCase(list[i].tag))
				return i;
		return 0;
	}

	private void checkTag(String tag) {
		for (int i = 0; i < list.length; i++)
			if (list[i] != null && list[i].tag == tag)
				System.out.println("!Duplicate: " + tag);
	}

	public AmmoFor setName(String name) {
		this.name = name;
		return this;
	}

	public String getName() {
		return name == null ? "unnamed" : name;
	}

	public String getLocalizedName() {
		return StatCollector.translateToLocal("ammo." + getName() + ".name");
	}

	public AmmoFor setType(String type) {
		this.type = type;
		return this;
	}

	public String getType() {
		return type == null ? "untype" : type;
	}

	public String getLocalizedType() {
		return StatCollector.translateToLocal("type." + getType().toLowerCase() + ".name");
	}

	public AmmoFor setColors(int color) {
		color_hex1 = color;
		color_hex2 = color;
		return this;
	}

	public AmmoFor setColors(int color1, int color2) {
		color_hex1 = color1;
		color_hex2 = color2;
		return this;
	}

	public AmmoFor setColor1(int color1) {
		color_hex1 = color1;
		return this;
	}

	public int getColor1() {
		return color_hex1 == 0 ? 0xFFFFFF : color_hex1;
	}

	public AmmoFor setColor2(int color2) {
		color_hex2 = color2;
		return this;
	}

	public int getColor2() {
		return color_hex2 == 0 ? 0xFFFFFF : color_hex2;
	}

	public AmmoFor setTemperatures(float temp, float temp_min, float temp_max) {
		temperature = temp;
		temperature_min = temp_min;
		temperature_max = temp_max;
		return this;
	}

	public AmmoFor setTemperature(float f) {
		temperature = f;
		return this;
	}

	public float getTemperature() {
		return temperature == 0 ? 0.0F : temperature;
	}

	public AmmoFor setTemperatureMin(float f) {
		temperature_min = f;
		return this;
	}

	public float getTemperatureMin() {
		return temperature_min == 0 ? 0.0F : temperature_min;
	}

	public AmmoFor setTemperatureMax(float f) {
		temperature_max = f;
		return this;
	}

	public float getTemperatureMax() {
		return temperature_max == 0 ? 0.0F : temperature_max;
	}

	public AmmoFor setTextures(String path) {
		texture1Name = path;
		texture2Name = path + "_overlay";
		return this;
	}

	public AmmoFor setTextures(String path1, String path2) {
		texture1Name = path1;
		texture2Name = path2;
		return this;
	}

	public AmmoFor setTexture1(String path1) {
		texture1Name = path1;
		return this;
	}

	public String getTexture1() {
		return texture1Name == null ? getName() : texture1Name;}

	public AmmoFor setTexture2(String path2) {
		texture2Name = path2;
		return this;
	}

	public String getTexture2() {
		return texture2Name == null ? getTexture1() : texture2Name;
	}

}
