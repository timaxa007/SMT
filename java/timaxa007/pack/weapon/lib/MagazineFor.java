package timaxa007.pack.weapon.lib;

import timaxa007.tms.util.UtilString;
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

	public static final MagazineFor empty = new MagazineFor("");

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

	/**Не рекомендуется использовать этот метод.<br>
	 * It is not recommended to use this method.**/
	@Deprecated
	public MagazineFor() {id = nextID();list[id] = this;}

	/**Не рекомендуется использовать этот метод.<br>
	 * It is not recommended to use this method.**/
	@Deprecated
	public MagazineFor(int id) {checkID(this, id);this.id = id;list[id] = this;}

	/**Не рекомендуется использовать этот метод.<br>
	 * It is not recommended to use this method.**/
	@Deprecated
	public MagazineFor(int id, String tag) {
		checkID(this, id);checkTag(this, tag);
		this.id = id;this.tag = tag;list[id] = this;
	}

	public MagazineFor(String tag) {
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
			for (MagazineFor iteming : list)
				if (iteming != null && tag.equalsIgnoreCase(iteming.tag))
					return true;
		return false;
	}

	public static int getID_tag(String tag) {
		if (UtilString.hasString(tag))
			for (MagazineFor iteming : list)
				if (iteming != null && tag.equalsIgnoreCase(iteming.tag))
					return iteming.id;
		return empty.id;
	}

	private static void checkID(MagazineFor magazineFor, int id) {
		if (list[id] != null)
			throw new IllegalArgumentException("Duplicate id: " + id + " in " + magazineFor.getClass() + ".");
	}

	private static void checkTag(MagazineFor magazineFor, String tag) {
		if (UtilString.hasString(tag))
			for (MagazineFor iteming : list)
				if (iteming != null && iteming.tag == tag)
					throw new IllegalArgumentException("Duplicate tag: " + tag + " in " + magazineFor.getClass() + ".");
	}

	public static MagazineFor get(String tag) {
		return list[getID_tag(tag)];
	}

	public static boolean isNull(String tag) {
		return isNull(get(tag));
	}

	public static boolean isNull(MagazineFor spell) {
		return spell == null || spell == empty;
	}
	//--------------------------------------------------------
	public MagazineFor setName(String name) {
		this.name = name;
		return this;
	}

	public String getName() {
		return UtilString.hasString(name) ? name : UtilString.hasString(tag) ? tag : "unname";
	}

	public String getLocalizedName() {
		return StatCollector.translateToLocal("magazine." + getName() + ".name");
	}

	public MagazineFor setType(String type) {
		this.type = type;
		return this;
	}

	public String getType() {
		return UtilString.hasString(type) ? type : "untype";
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
