package mods.timaxa007.pack.weapon.lib;

import net.minecraft.util.StatCollector;
/**
 * @author timaxa007
 * @param 
 * @param 
 * @param 
 */
public class AmmoFor {

	public static final AmmoFor[] ammo_list = new AmmoFor[2048];

	public static final AmmoFor ammo_empty = new AmmoFor(0);

	public int ammoID;
	public String tagID;
	private String name;
	private String type;

	private int color_hex1;
	private int color_hex2;
	private float temperature;
	private float temperature_min;
	private float temperature_max;

	protected String texture1Name;
	protected String texture2Name;

	/**It is not recommended to use this method.**/
	@Deprecated
	public AmmoFor() {
		ammo_list[nextID()] = this;
		ammoID = nextID();
	}

	/**It is not recommended to use this method.**/
	@Deprecated
	public AmmoFor(int id) {
		ammo_list[id] = this;
		ammoID = id;
	}

	public AmmoFor(String str) {
		checkTagID(str);//OFF
		ammo_list[nextID()] = this;
		ammoID = nextID();
		tagID = str;
	}

	/**It is not recommended to use this method.**/
	@Deprecated
	public AmmoFor(int id, String str) {
		checkTagID(str);//OFF
		ammo_list[id] = this;
		ammoID = id;
		tagID = str;
	}

	public static int nextID() {
		for (int i = 0; i < ammo_list.length; i++) {
			if (ammo_list[i] == null) {
				return i;
			}
		}
		return ammo_list.length - 1;
	}

	public static boolean hasTagID(String str) {
		for (int i = 0; i < ammo_list.length; i++) {
			if (str.equalsIgnoreCase(ammo_list[i].tagID)) {
				return true;
			}
		}
		return false;
	}

	public static int getID_tag(String str) {
		for (int i = 0; i < ammo_list.length; i++) {
			if (str.equalsIgnoreCase(ammo_list[i].tagID)) {
				return i;
			}
		}
		return 0;
	}

	private void checkTagID(String str) {
		for (int i = 0; i < ammo_list.length; i++) {
			if (ammo_list[i] != null && ammo_list[i].tagID == str) {
				System.out.println("!Duplicate: " + str);
			}
		}
	}

	public AmmoFor setName(String str) {
		name = str;
		return this;
	}

	public String getName() {
		return name == null ? "unnamed" : name;
	}

	public String getLocalizedName() {
		return StatCollector.translateToLocal("ammo." + getName() + ".name");
	}

	public AmmoFor setType(String str) {
		type = str;return this;
	}

	public String getType() {
		return type == null ? "untype" : type;
	}

	public String getLocalizedType() {
		return StatCollector.translateToLocal("type." + getType().toLowerCase() + ".name");
	}

	public AmmoFor setColors(int i) {
		color_hex1 = i;
		color_hex2 = i;
		return this;
	}

	public AmmoFor setColors(int i1, int i2) {
		color_hex1 = i1;
		color_hex2 = i2;
		return this;
	}

	public AmmoFor setColor1(int i) {
		color_hex1 = i;
		return this;
	}

	public int getColor1() {
		return color_hex1 == 0 ? 0xFFFFFF : color_hex1;
	}

	public AmmoFor setColor2(int i) {
		color_hex2 = i;
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

	public AmmoFor setTextures(String str) {
		texture1Name = str;texture2Name = str + "_overlay";
		return this;
	}

	public AmmoFor setTextures(String str1, String str2) {
		texture1Name = str1;texture2Name = str2;
		return this;
	}

	public AmmoFor setTexture1(String str) {
		texture1Name = str;
		return this;
	}

	public String getTexture1() {
		return texture1Name == null ? getName() : texture1Name;}

	public AmmoFor setTexture2(String str) {
		texture2Name = str;
		return this;
	}

	public String getTexture2() {
		return texture2Name == null ? getTexture1() : texture2Name;
	}

}
