package timaxa007.pack.weapon.lib;

import timaxa007.tms.util.UtilString;
import net.minecraft.util.StatCollector;

public class UpgradeFor {

	public static final UpgradeFor[] list = new UpgradeFor[2048];

	public static final UpgradeFor empty = new UpgradeFor("");

	public int id;
	public String tag;
	private String name;
	private String type;

	private int color_hex1;
	private int color_hex2;
	/*private float temperature;
	private float temperature_min;
	private float temperature_max;*/

	private String texture1;
	private String texture2;

	/**Не рекомендуется использовать этот метод.<br>
	 * It is not recommended to use this method.**/
	@Deprecated
	public UpgradeFor() {id = nextID();list[id] = this;}

	/**Не рекомендуется использовать этот метод.<br>
	 * It is not recommended to use this method.**/
	@Deprecated
	public UpgradeFor(int id) {checkID(this, id);this.id = id;list[id] = this;}

	/**Не рекомендуется использовать этот метод.<br>
	 * It is not recommended to use this method.**/
	@Deprecated
	public UpgradeFor(int id, String tag) {
		checkID(this, id);checkTag(this, tag);
		this.id = id;this.tag = tag;list[id] = this;
	}

	public UpgradeFor(String tag) {
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
			for (UpgradeFor iteming : list)
				if (iteming != null && tag.equalsIgnoreCase(iteming.tag))
					return true;
		return false;
	}

	public static int getID_tag(String tag) {
		if (UtilString.hasString(tag))
			for (UpgradeFor iteming : list)
				if (iteming != null && tag.equalsIgnoreCase(iteming.tag))
					return iteming.id;
		return empty.id;
	}

	private static void checkID(UpgradeFor upgradeFor, int id) {
		if (list[id] != null)
			throw new IllegalArgumentException("Duplicate id: " + id + " in " + upgradeFor.getClass() + ".");
	}

	private static void checkTag(UpgradeFor upgradeFor, String tag) {
		if (UtilString.hasString(tag))
			for (UpgradeFor iteming : list)
				if (iteming != null && iteming.tag == tag)
					throw new IllegalArgumentException("Duplicate tag: " + tag + " in " + upgradeFor.getClass() + ".");
	}

	public static UpgradeFor get(String tag) {
		return list[getID_tag(tag)];
	}

	public static boolean isNull(String tag) {
		return isNull(get(tag));
	}

	public static boolean isNull(UpgradeFor spell) {
		return spell == null || spell == empty;
	}
	//--------------------------------------------------------
	public UpgradeFor setName(String name) {
		this.name = name;
		return this;
	}

	public String getName() {
		return UtilString.hasString(name) ? name : UtilString.hasString(tag) ? tag : "unname";
	}

	public String getLocalizedName() {
		return StatCollector.translateToLocal("ammo." + getName() + ".name");
	}

	public UpgradeFor setType(String type) {
		this.type = type;
		return this;
	}

	public String getType() {
		return UtilString.hasString(type) ? type : "untype";
	}

	public String getLocalizedType() {
		return StatCollector.translateToLocal("type." + getType().toLowerCase() + ".name");
	}

	public UpgradeFor setColors(int color) {
		color_hex1 = color;
		color_hex2 = color;
		return this;
	}

	public UpgradeFor setColors(int color1, int color2) {
		color_hex1 = color1;
		color_hex2 = color2;
		return this;
	}

	public UpgradeFor setColor1(int color1) {
		color_hex1 = color1;
		return this;
	}

	public int getColor1() {
		return color_hex1 == 0 ? 0xFFFFFF : color_hex1;
	}

	public UpgradeFor setColor2(int color2) {
		color_hex2 = color2;
		return this;
	}

	public int getColor2() {
		return color_hex2 == 0 ? 0xFFFFFF : color_hex2;
	}
	/*
	public UpgradeFor setTemperatures(float temp, float temp_min, float temp_max) {
		temperature = temp;
		temperature_min = temp_min;
		temperature_max = temp_max;
		return this;
	}

	public UpgradeFor setTemperature(float f) {
		temperature = f;
		return this;
	}

	public float getTemperature() {
		return temperature == 0 ? 0.0F : temperature;
	}

	public UpgradeFor setTemperatureMin(float f) {
		temperature_min = f;
		return this;
	}

	public float getTemperatureMin() {
		return temperature_min == 0 ? 0.0F : temperature_min;
	}

	public UpgradeFor setTemperatureMax(float f) {
		temperature_max = f;
		return this;
	}

	public float getTemperatureMax() {
		return temperature_max == 0 ? 0.0F : temperature_max;
	}
	 */
	public UpgradeFor setTextures(String path) {
		texture1 = path;
		texture2 = path + "_overlay";
		return this;
	}

	public UpgradeFor setTextures(String path1, String path2) {
		texture1 = path1;
		texture2 = path2;
		return this;
	}

	public UpgradeFor setTexture1(String path1) {
		texture1 = path1;
		return this;
	}

	public String getTexture1() {
		return texture1 == null ? getName() : texture1;}

	public UpgradeFor setTexture2(String path2) {
		texture2 = path2;
		return this;
	}

	public String getTexture2() {
		return texture2 == null ? getTexture1() : texture2;
	}

}
