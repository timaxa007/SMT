package mods.timaxa007.pack.weapon.lib;

import net.minecraft.util.StatCollector;

/**
 * @author timaxa007
 * @param ammo or magazine
 * @param 
 * @param 
 */
public class WeaponFor {

	public static final WeaponFor[] weapon_list = new WeaponFor[2048];

	public static final WeaponFor weapon_empty = new WeaponFor(0);

	public int weaponID;
	public String tagID;
	private String name;
	private String type;

	private MagazineFor magazine;
	private AmmoFor ammo;
	private int size_ammo;

	private int color_hex1;
	private int color_hex2;
	private float temperature;
	private float temperature_min;
	private float temperature_max;

	protected String texture1Name;
	protected String texture2Name;

	/**It is not recommended to use this method.**/
	@Deprecated
	public WeaponFor() {
		weapon_list[nextID()] = this;
		weaponID = nextID();
	}

	/**It is not recommended to use this method.**/
	@Deprecated
	public WeaponFor(int id) {
		weapon_list[id] = this;
		weaponID = id;
	}

	public WeaponFor(String str) {
		checkTagID(str);//OFF
		weapon_list[nextID()] = this;
		weaponID = nextID();
		tagID = str;
	}

	/**It is not recommended to use this method.**/
	@Deprecated
	public WeaponFor(int id, String str) {
		checkTagID(str);//OFF
		weapon_list[id] = this;
		weaponID = id;
		tagID = str;
	}

	public static int nextID() {
		for (int i = 0; i < weapon_list.length; i++) {
			if (weapon_list[i] == null) {
				return i;
			}
		}
		return 0;
	}

	public static boolean hasTagID(String str) {
		for (int i = 0; i < weapon_list.length; i++) {
			if (str.equalsIgnoreCase(weapon_list[i].tagID)) {
				return true;
			}
		}
		return false;
	}

	public static int getID_tag(String str) {
		for (int i = 0; i < weapon_list.length; i++) {
			if (str.equalsIgnoreCase(weapon_list[i].tagID)) {return i;}
		}
		return 0;
	}

	private void checkTagID(String str) {
		for (int i = 0; i < weapon_list.length; i++) {
			if (weapon_list[i] != null && weapon_list[i].tagID == str) {
				System.out.println("!Duplicate: " + str);
			}
		}
	}

	public WeaponFor setName(String str) {
		name = str;
		return this;
	}

	public String getName() {
		return name == null ? "unnamed" : name;
	}

	public String getLocalizedName() {
		return StatCollector.translateToLocal("weapon." + getName() + ".name");
	}

	public WeaponFor setType(String str) {
		type = str;return this;
	}

	public String getType() {
		return type == null ? "untype" : type;
	}

	public String getLocalizedType() {
		return StatCollector.translateToLocal("type." + getType().toLowerCase() + ".name");
	}

	public WeaponFor setColors(int i) {
		color_hex1 = i;
		color_hex2 = i;
		return this;
	}

	public WeaponFor setColors(int i1, int i2) {
		color_hex1 = i1;
		color_hex2 = i2;
		return this;
	}

	public WeaponFor setColor1(int i) {
		color_hex1 = i;
		return this;
	}

	public int getColor1() {
		return color_hex1 == 0 ? 0xFFFFFF : color_hex1;
	}

	public WeaponFor setColor2(int i) {
		color_hex2 = i;
		return this;
	}

	public int getColor2() {
		return color_hex2 == 0 ? 0xFFFFFF : color_hex2;
	}

	public WeaponFor setTemperatures(float temp, float temp_min, float temp_max) {
		temperature = temp;
		temperature_min = temp_min;
		temperature_max = temp_max;
		return this;
	}

	public WeaponFor setTemperature(float f) {
		temperature = f;
		return this;
	}

	public float getTemperature() {
		return temperature == 0 ? 0.0F : temperature;
	}

	public WeaponFor setTemperatureMin(float f) {
		temperature_min = f;
		return this;
	}

	public float getTemperatureMin() {
		return temperature_min == 0 ? 0.0F : temperature_min;
	}

	public WeaponFor setTemperatureMax(float f) {
		temperature_max = f;
		return this;
	}

	public float getTemperatureMax() {
		return temperature_max == 0 ? 0.0F : temperature_max;
	}

	public WeaponFor setTextures(String str) {
		texture1Name = str;
		texture2Name = str + "_overlay";
		return this;
	}

	public WeaponFor setTextures(String str1, String str2) {
		texture1Name = str1;
		texture2Name = str2;
		return this;
	}

	public WeaponFor setTexture1(String str) {
		texture1Name = str;
		return this;
	}

	public String getTexture1() {
		return texture1Name == null ? getName() : texture1Name;
	}

	public WeaponFor setTexture2Name(String str) {
		texture2Name = str;
		return this;
	}

	public String getTexture2() {
		return texture2Name == null ? getTexture1() : texture2Name;
	}

	public WeaponFor setAmmo(MagazineFor magazines) {
		ammo = null;
		magazine = magazines;
		return this;
	}

	public WeaponFor setAmmo(AmmoFor ammos) {
		ammo = ammos;
		magazine = null;
		return this;
	}

	public AmmoFor getAmmo() {
		return ammo;
	}

	public MagazineFor getMagazine() {
		return magazine;
	}

	public WeaponFor setSizeAmmo(int i) {
		size_ammo = i;
		return this;
	}

	public int getSizeAmmo() {
		return size_ammo;
	}

}
