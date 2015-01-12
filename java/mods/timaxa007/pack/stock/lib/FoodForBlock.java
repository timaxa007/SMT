package mods.timaxa007.pack.stock.lib;

import mods.timaxa007.tms.Core;
import mods.timaxa007.tms.util.UtilTMS;
import net.minecraft.util.StatCollector;
/**
 * Use in <b>BlockFoods</b>.
 * @author timaxa007
 * @param 
 * @param 
 * @param 
 */
public class FoodForBlock {

	public static final FoodForBlock[] list = new FoodForBlock[4096];

	public static final FoodForBlock empty = new FoodForBlock(0);

	public int id;
	public String tag;
	private String name;
	private String type;

	private int level;
	private float saturation;

	private int color_hex1;
	private int color_hex2;
	private float temperature;
	private float temperature_min;
	private float temperature_max;

	private String texture1;
	private String texture2;

	/**It is not recommended to use this method.**/
	@Deprecated
	public FoodForBlock() {
		id = nextID();
		list[id] = this;
		color_hex1 = 0;
		color_hex2 = 0;
	}

	/**It is not recommended to use this method.**/
	@Deprecated
	public FoodForBlock(int id) {
		this.id = id;
		list[id] = this;
		color_hex1 = 0;
		color_hex2 = 0;
	}

	/**It is not recommended to use this method.**/
	@Deprecated
	public FoodForBlock(int id, String tag) {
		if (Core.show_system_info_testing) checkTag(tag);
		this.id = id;
		list[id] = this;
		this.tag = tag;
		color_hex1 = 0;
		color_hex2 = 0;
	}

	public FoodForBlock(String tag) {
		if (Core.show_system_info_testing) checkTag(tag);
		id = nextID();
		list[id] = this;
		this.tag = tag;
		color_hex1 = 0;
		color_hex2 = 0;
	}
	//--------------------------------------------------------
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

	private static void checkTag(String tag) {
		for (int i = 0; i < list.length; i++)
			if (list[i] != null && list[i].tag == tag)
				System.out.println("!Duplicate: " + tag);
	}

	public static FoodForBlock get(String tag) {
		if (UtilTMS.hasString(tag))
			return list[getID_tag(tag)];
		return empty;
	}
	//--------------------------------------------------------
	public FoodForBlock setName(String name) {
		this.name = name;
		return this;
	}

	public String getName() {
		return UtilTMS.hasString(name) ? name : UtilTMS.hasString(tag) ? tag : "unname";
	}

	public String getLocalizedName() {
		return StatCollector.translateToLocal("food." + getName() + ".name");
	}

	public FoodForBlock setType(String type) {
		this.type = type;
		return this;
	}

	public String getType() {
		return UtilTMS.hasString(type) ? type : "untype";
	}

	public String getLocalizedType() {
		return StatCollector.translateToLocal("type." + getType().toLowerCase() + ".name");
	}

	public FoodForBlock setFoodStats(int i, float f) {
		level = i;
		saturation = f;
		return this;
	}

	public FoodForBlock setFoodLevel(int i) {
		level = i;
		return this;
	}

	public int getFoodLevel() {
		return level == 0 ? 0 : level;
	}

	public FoodForBlock setFoodSaturation(float f) {
		saturation = f;
		return this;
	}

	public float getFoodSaturation() {
		return saturation == 0 ? 0.0F : saturation;
	}

	public FoodForBlock setColors(int color) {
		color_hex1 = color;
		color_hex2 = color;
		return this;
	}

	public FoodForBlock setColors(int color1, int color2) {
		color_hex1 = color1;
		color_hex2 = color2;
		return this;
	}

	public FoodForBlock setColor1(int color1) {
		color_hex1 = color1;
		return this;
	}

	public int getColor1() {
		return color_hex1 == 0 ? 0xFFFFFF : color_hex1;
	}

	public FoodForBlock setColor2(int color2) {
		color_hex2 = color2;
		return this;
	}

	public int getColor2() {
		return color_hex2 == 0 ? 0xFFFFFF : color_hex2;
	}

	public FoodForBlock setTemperatures(float temp, float temp_min, float temp_max) {
		temperature = temp;
		temperature_min = temp_min;
		temperature_max = temp_max;
		return this;
	}

	public FoodForBlock setTemperature(float f) {
		temperature = f;
		return this;
	}

	public float getTemperature() {
		return temperature == 0 ? 0.0F : temperature;
	}

	public FoodForBlock setTemperatureMin(float f) {
		temperature_min = f;
		return this;
	}

	public float getTemperatureMin() {
		return temperature_min == 0 ? 0.0F : temperature_min;
	}

	public FoodForBlock setTemperatureMax(float f) {
		temperature_max = f;
		return this;
	}

	public float getTemperatureMax() {
		return temperature_max == 0 ? 0.0F : temperature_max;
	}

	public FoodForBlock setTextures(String path) {
		texture1 = path;
		texture2 = path + "_overlay";
		return this;
	}

	public FoodForBlock setTextures(String path1, String path2) {
		texture1 = path1;
		texture2 = path2;
		return this;
	}

	public FoodForBlock setTexturesFood(String path) {
		texture1 = path;
		texture2 = path + "_overlay";
		return this;
	}

	public FoodForBlock setTexturesFood(String path1, String path2) {
		texture1 = path1;
		texture2 = path2;
		return this;
	}

	public FoodForBlock setTexture1(String path1) {
		texture1 = path1;
		return this;
	}

	public FoodForBlock setTexture1Food(String path1) {
		texture1 = path1;
		return this;
	}

	public String getTexture1() {
		return texture1 == null ? getName() : texture1;
	}

	public FoodForBlock setTexture2(String path2) {
		texture2 = path2;
		return this;
	}

	public FoodForBlock setTexture2Food(String path2) {
		texture2 = path2;
		return this;
	}

	public String getTexture2() {
		return texture2 == null ? getTexture1() : texture2;
	}

}

