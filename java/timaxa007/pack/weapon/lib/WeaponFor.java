package timaxa007.pack.weapon.lib;

import timaxa007.tms.util.UtilString;
import net.minecraft.util.StatCollector;

/**
 * Use in <b>ItemWeapons</b>.
 * @author timaxa007
 * @param Useing ammo or magazine
 * @param 
 * @param 
 */
public class WeaponFor {

	public static final WeaponFor[] list = new WeaponFor[2048];

	public static final WeaponFor empty = new WeaponFor("");

	public static final String[] weapon_type = new String[] {
		"pistol", 
		"shotgun", 
		"avtomat", 
		"pulemet", 
		"sniper"
	};

	public int id;
	public String tag;
	private String name;
	private String type;

	private int delay;
	private String[] sound_fire;
	private String[] sound_reload = new String[3];//deploy, clip-out, clip-in

	private MagazineFor magazine;
	private AmmoFor ammo;
	private int size_ammo;
	/*
	private int color_hex1;
	private int color_hex2;
	private float temperature;
	private float temperature_min;
	private float temperature_max;
	 */
	private String texture1;
	private String texture2;

	/**Не рекомендуется использовать этот метод.<br>
	 * It is not recommended to use this method.**/
	@Deprecated
	public WeaponFor() {id = nextID();list[id] = this;delay = 0;}

	/**Не рекомендуется использовать этот метод.<br>
	 * It is not recommended to use this method.**/
	@Deprecated
	public WeaponFor(int id) {checkID(this, id);this.id = id;list[id] = this;delay = 0;}

	/**Не рекомендуется использовать этот метод.<br>
	 * It is not recommended to use this method.**/
	@Deprecated
	public WeaponFor(int id, String tag) {
		checkID(this, id);checkTag(this, tag);
		this.id = id;this.tag = tag;list[id] = this;delay = 0;
	}

	public WeaponFor(String tag) {
		checkTag(this, tag);
		id = nextID();
		list[id] = this;
		this.tag = tag;
		delay = 0;
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
			for (WeaponFor iteming : list)
				if (iteming != null && tag.equalsIgnoreCase(iteming.tag))
					return true;
		return false;
	}

	public static int getID_tag(String tag) {
		if (UtilString.hasString(tag))
			for (WeaponFor iteming : list)
				if (iteming != null && tag.equalsIgnoreCase(iteming.tag))
					return iteming.id;
		return empty.id;
	}

	private static void checkID(WeaponFor weaponFor, int id) {
		if (list[id] != null)
			throw new IllegalArgumentException("Duplicate id: " + id + " in " + weaponFor.getClass() + ".");
	}

	private static void checkTag(WeaponFor weaponFor, String tag) {
		if (UtilString.hasString(tag))
			for (WeaponFor iteming : list)
				if (iteming != null && iteming.tag == tag)
					throw new IllegalArgumentException("Duplicate tag: " + tag + " in " + weaponFor.getClass() + ".");
	}

	public static WeaponFor get(String tag) {
		return list[getID_tag(tag)];
	}

	public static boolean isNull(String tag) {
		return isNull(get(tag));
	}

	public static boolean isNull(WeaponFor weapon) {
		return weapon == null || weapon == empty;
	}
	//--------------------------------------------------------
	public WeaponFor setName(String name) {
		this.name = name;
		return this;
	}

	public String getName() {
		return UtilString.hasString(name) ? name : UtilString.hasString(tag) ? tag : "unname";
	}

	public String getLocalizedName() {
		return StatCollector.translateToLocal("weapon." + getName() + ".name");
	}

	public WeaponFor setType(String type) {
		this.type = type;
		return this;
	}

	public String getType() {
		return UtilString.hasString(type) ? type : "untype";
	}

	public String getLocalizedType() {
		return StatCollector.translateToLocal("type." + getType().toLowerCase() + ".name");
	}

	public WeaponFor setDelay(int delay) {
		this.delay = delay;
		return this;
	}

	public int getDelay() {
		return delay;
	}

	public WeaponFor setSoundFire(String[] sound_fire) {
		this.sound_fire = sound_fire;
		return this;
	}

	public WeaponFor setSoundFire(String sound_fire) {
		this.sound_fire = new String[1];
		this.sound_fire[0] = sound_fire;
		return this;
	}

	public String[] getSoundFire() {
		return sound_fire;
	}

	public WeaponFor setSoundReload(String[] sound_reload) {
		this.sound_reload = sound_reload;
		return this;
	}

	public WeaponFor setSoundReload(String sound_reload) {
		this.sound_reload = new String[1];
		this.sound_reload[0] = sound_reload;
		return this;
	}

	public String[] getSoundReload() {
		return sound_reload;
	}

	/*
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
		texture1 = path;
		texture2 = path + "_overlay";
		return this;
	}

	public WeaponFor setTextures(String path1, String path2) {
		texture1 = path1;
		texture2 = path2;
		return this;
	}

	public WeaponFor setTexture1(String path1) {
		texture1 = path1;
		return this;
	}

	public String getTexture1() {
		return texture1 == null ? getName() : texture1;
	}

	public WeaponFor setTexture2(String path2) {
		texture2 = path2;
		return this;
	}

	public String getTexture2() {
		return texture2 == null ? getTexture1() : texture2;
	}
	 */
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
