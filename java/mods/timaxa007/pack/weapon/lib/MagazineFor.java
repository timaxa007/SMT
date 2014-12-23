package mods.timaxa007.pack.weapon.lib;

import mods.timaxa007.tms.Core;
import net.minecraft.util.StatCollector;

/**
 * Use in <b>ItemMagazines</b>.
 * @author timaxa007
 * @param 
 * @param 
 * @param 
 */
public class MagazineFor {

	public static final MagazineFor[] list = new MagazineFor[1024];

	public static final MagazineFor empty = new MagazineFor(0);

	public int id;
	public String tag;
	private String name;
	private String type;

	private int color_hex1;
	private int color_hex2;
	private float temperature;
	private float temperature_min;
	private float temperature_max;

	private String texture1;
	private String texture2;

	private AmmoFor bullet;
	private int size;

	/**It is not recommended to use this method.**/
	@Deprecated
	public MagazineFor() {
		id = nextID();
		list[id] = this;
	}

	/**It is not recommended to use this method.**/
	@Deprecated
	public MagazineFor(int id) {
		this.id = id;
		list[id] = this;
	}

	/**It is not recommended to use this method.**/
	@Deprecated
	public MagazineFor(int id, String tag) {
		if (Core.show_tip_info_testing) checkTag(tag);
		this.id = id;
		list[id] = this;
		this.tag = tag;
	}

	public MagazineFor(String tag) {
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
		return list.length-1;
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

	private static void checkTag(String tag) {
		for (int i = 0; i < list.length; i++)
			if (list[i] != null && list[i].tag == tag)
				System.out.println("!Duplicate: " + tag);
	}

	public static MagazineFor get(String tag) {
		if (tag != null)
			return list[getID_tag(tag)];
		return empty;
	}
	//--------------------------------------------------------
	public MagazineFor setName(String name) {
		this.name = name;
		return this;
	}

	public String getName() {
		return name == null ? "unnamed" : name;
	}

	public String getLocalizedName() {
		return StatCollector.translateToLocal("magazine." + getName() + ".name");
	}

	public MagazineFor setType(String type) {
		this.type = type;
		return this;
	}

	public String getType() {
		return type == null ? "untype" : type;
	}

	public String getLocalizedType() {
		return StatCollector.translateToLocal("type." + getType().toLowerCase() + ".name");
	}

	public MagazineFor setColors(int i) {
		color_hex1 = i;
		color_hex2 = i;
		return this;
	}

	public MagazineFor setColors(int i1, int i2) {
		color_hex1 = i1;
		color_hex2 = i2;
		return this;
	}

	public MagazineFor setColor1(int i) {
		color_hex1 = i;
		return this;
	}

	public int getColor1() {
		return color_hex1 == 0 ? 0xFFFFFF : color_hex1;
	}

	public MagazineFor setColor2(int i) {
		color_hex2 = i;
		return this;
	}

	public int getColor2() {
		return color_hex2 == 0 ? 0xFFFFFF : color_hex2;
	}

	public MagazineFor setTemperatures(float temp, float temp_min, float temp_max) {
		temperature = temp;
		temperature_min = temp_min;
		temperature_max = temp_max;
		return this;
	}

	public MagazineFor setTemperature(float f) {
		temperature = f;
		return this;
	}

	public float getTemperature() {
		return temperature == 0 ? 0.0F : temperature;
	}

	public MagazineFor setTemperatureMin(float f) {
		temperature_min = f;
		return this;
	}

	public float getTemperatureMin() {
		return temperature_min == 0 ? 0.0F : temperature_min;
	}

	public MagazineFor setTemperatureMax(float f) {
		temperature_max = f;
		return this;
	}

	public float getTemperatureMax() {
		return temperature_max == 0 ? 0.0F : temperature_max;
	}

	public MagazineFor setTextures(String str) {
		texture1 = str;
		texture2 = str + "_overlay";
		return this;
	}

	public MagazineFor setTextures(String str1, String str2) {
		texture1 = str1;
		texture2 = str2;
		return this;
	}

	public MagazineFor setTexture1(String str) {
		texture1 = str;
		return this;
	}

	public String getTexture1() {
		return texture1 == null ? getName() : texture1;
	}

	public MagazineFor setTexture2(String str) {
		texture2 = str;
		return this;
	}

	public String getTexture2() {
		return texture2 == null ? getTexture1() : texture2;
	}

	public MagazineFor setSize(int i) {
		size = i;
		return this;
	}

	public int getSize() {
		return size;
	}

	public MagazineFor setBullet(AmmoFor a) {
		bullet = a;
		return this;
	}

	public AmmoFor getBullet() {
		return bullet;
	}

}
