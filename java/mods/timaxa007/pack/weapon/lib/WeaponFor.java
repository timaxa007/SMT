package mods.timaxa007.pack.weapon.lib;

import mods.timaxa007.tms.Core;
import net.minecraft.util.StatCollector;

/**
 * Use in <b>ItemWeapons</b>.
 * @author timaxa007
 * @param ammo or magazine
 * @param 
 * @param 
 */
public class WeaponFor {

	public static final WeaponFor[] list = new WeaponFor[2048];

	public static final WeaponFor weapon_empty = new WeaponFor(0);

	public int id;
	public String tag;
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
		id = nextID();
		list[id] = this;
	}

	/**It is not recommended to use this method.**/
	@Deprecated
	public WeaponFor(int id) {
		this.id = id;
		list[id] = this;
	}

	/**It is not recommended to use this method.**/
	@Deprecated
	public WeaponFor(int id, String tag) {
		this.id = id;
		list[id] = this;
		this.tag = tag;
		if (Core.show_tip_info_testing) checkTag(tag);//OFF
	}

	public WeaponFor(String tag) {
		id = nextID();
		list[id] = this;
		this.tag = tag;
		if (Core.show_tip_info_testing) checkTag(tag);//OFF
	}

	public static int nextID() {
		for (int i = 0; i < list.length; i++)
			if (list[i] == null)
				return i;
		return 0;
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

	public WeaponFor setName(String name) {
		this.name = name;
		return this;
	}

	public String getName() {
		return name == null ? "unnamed" : name;
	}

	public String getLocalizedName() {
		return StatCollector.translateToLocal("weapon." + getName() + ".name");
	}

	public WeaponFor setType(String type) {
		this.type = type;
		return this;
	}

	public String getType() {
		return type == null ? "untype" : type;
	}

	public String getLocalizedType() {
		return StatCollector.translateToLocal("type." + getType().toLowerCase() + ".name");
	}

	public WeaponFor setColors(int color) {
		color_hex1 = color;
		color_hex2 = color;
		return this;
	}

	public WeaponFor setColors(int color1, int color2) {
		color_hex1 = color1;
		color_hex2 = color2;
		return this;
	}

	public WeaponFor setColor1(int color1) {
		color_hex1 = color1;
		return this;
	}

	public int getColor1() {
		return color_hex1 == 0 ? 0xFFFFFF : color_hex1;
	}

	public WeaponFor setColor2(int color2) {
		color_hex2 = color2;
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

	public WeaponFor setTextures(String path) {
		texture1Name = path;
		texture2Name = path + "_overlay";
		return this;
	}

	public WeaponFor setTextures(String path1, String path2) {
		texture1Name = path1;
		texture2Name = path2;
		return this;
	}

	public WeaponFor setTexture1(String path1) {
		texture1Name = path1;
		return this;
	}

	public String getTexture1() {
		return texture1Name == null ? getName() : texture1Name;
	}

	public WeaponFor setTexture2Name(String path2) {
		texture2Name = path2;
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
