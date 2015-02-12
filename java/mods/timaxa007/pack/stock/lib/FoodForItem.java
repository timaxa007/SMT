package mods.timaxa007.pack.stock.lib;

import mods.timaxa007.tms.Core;
import mods.timaxa007.tms.util.UtilString;
import net.minecraft.util.StatCollector;
/**
 * Use in <b>ItemFoods</b>.
 * @author timaxa007
 * @param 
 * @param 
 * @param 
 */
public class FoodForItem {

	public static final FoodForItem[] list = new FoodForItem[32767];

	public static final FoodForItem empty = new FoodForItem(0);

	public int id;
	public String tag;
	private String name;
	private String name_short;
	private String type;

	private int level;
	private float sat;
	private int spd_eat;

	private float temp;
	private float temp_min;
	private float temp_max;

	//private int pass_n = 4;
	private int[] color_hex = new int[] {0xFFFFFF, 0xFFFFFF, 0xFFFFFF, 0xFFFFFF};
	private String[] texture_name = new String[] {"empty", "empty", "empty", "empty"};
	private int[] clr_tmp = color_hex;
	private String[] txr_tmp = texture_name;

	/**It is not recommended to use this method.**/
	@Deprecated
	public FoodForItem() {
		id = nextID();
		list[id] = this;
	}

	/**It is not recommended to use this method.**/
	@Deprecated
	public FoodForItem(int id) {
		this.id = id;
		list[id] = this;
	}

	/**It is not recommended to use this method.**/
	@Deprecated
	public FoodForItem(int id, String tag) {
		if (Core.show_system_info_testing) checkTag(tag);
		this.id = id;
		list[id] = this;
		this.tag = tag;
	}

	public FoodForItem(String tag) {
		if (Core.show_system_info_testing) checkTag(tag);
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
		for (int i = 0; i < list.length; i++)
			if (tag.equalsIgnoreCase(list[i].tag))
				return true;
		return false;
	}

	public static int getID_tag(String tag) {
		for (int i = 0; i < list.length; i++)
			if (list[i] != null)
				if (tag.equalsIgnoreCase(list[i].tag))
					return i;
		return 0;
	}

	private static void checkTag(String tag) {
		for (int i = 0; i < list.length; i++)
			if (list[i] != null && list[i].tag == tag)
				System.out.println("!Duplicate: " + tag);
	}

	public static FoodForItem get(String tag) {
		if (UtilString.hasString(tag))
			return list[getID_tag(tag)];
		return empty;
	}
	//--------------------------------------------------------
	public FoodForItem setName(String name) {
		this.name = name;
		return this;
	}

	public String getName() {
		return UtilString.hasString(name) ? name : UtilString.hasString(tag) ? tag : "unname";
	}

	public String getLocalizedName() {
		return StatCollector.translateToLocal("food." + getName() + ".name");
	}

	public FoodForItem setShortName(String name_short) {
		this.name_short = name_short;
		return this;
	}

	public String getShortName() {
		return UtilString.hasString(name_short) ? name_short : "unnamed";
	}

	public String getLocalizedShortName() {
		return StatCollector.translateToLocal("food." + getShortName() + ".name");
	}

	public FoodForItem setType(String type) {
		this.type = type;
		return this;
	}

	public String getType() {
		return UtilString.hasString(type) ? type : "untype";
	}

	public String getLocalizedType() {
		return StatCollector.translateToLocal("type." + getType().toLowerCase() + ".name");
	}

	public FoodForItem setFoodStats(int i, float f) {
		level = i;
		sat = f;
		return this;
	}

	public FoodForItem setFoodLevel(int i) {
		level = i;
		return this;
	}

	public int getFoodLevel() {
		return level == 0 ? 0 : level;
	}

	public FoodForItem setFoodSaturation(float f) {
		sat = f;
		return this;
	}

	public float getFoodSaturation() {
		return sat == 0 ? 0.0F : sat;
	}

	public FoodForItem setSpeedOfEating(int i) {
		spd_eat = i;
		return this;
	}

	public int getSpeedOfEating() {
		return spd_eat == 0 ? 32 : spd_eat;
	}

	public FoodForItem setTemperatures(float f, float f1, float f2) {
		temp = f;
		temp_min = f1;
		temp_max = f2;
		return this;
	}

	public FoodForItem setTemperature(float f) {
		temp = f;
		return this;
	}

	public float getTemperature() {
		return temp;
	}

	public FoodForItem setTemperatureMin(float f1) {
		temp_min = f1;
		return this;
	}

	public float getTemperatureMin() {
		return temp_min;
	}

	public FoodForItem setTemperatureMax(float f2) {
		temp_max = f2;
		return this;
	}

	public float getTemperatureMax() {
		return temp_max;
	}

	public FoodForItem setColors(int[] i) {
		color_hex = i;
		return this;
	}

	public FoodForItem setColors(int i1) {
		color_hex[0] = i1;
		return this;
	}

	public FoodForItem setColors(int i1, int i2) {
		color_hex[0] = i1;
		color_hex[1] = i2;
		return this;
	}

	/*public FoodForItem setColors(int i1, int i2, int i3) {
	color_hex[0] = i1;
	color_hex[1] = i2;
	color_hex[2] = i3;
	return this;
	}*/

	//public FoodForItem setColors(int i1, int i2, int i3, int i4) {color_hex[0] = i1;color_hex[1] = i2;color_hex[2] = i3;color_hex[3] = i4;return this;}

	public int[] getColor() {
		return color_hex;
	}

	public int getColor(int i) {
		return i < color_hex.length && i >= 0 ? color_hex[i] : 0xFFFFFF;
	}

	/*public int getColor(int i) {
		return color_hex[i];
	}*/

	public FoodForItem setTexture(String[] str) {
		for (int i = 0; i < str.length; i++) {
			if (str[i] == "0" || str[i] == "foods/0") {
				str[i] = "empty";
			}
			if (str[i] == "O") {
				str[i] = str[i - 1] + "_overlay";
			}
			if (str[i] == "foods/O") {
				str[i] = "foods/" + str[i - 1] + "_overlay";
			}
		}
		texture_name = str;
		return this;
	}
	public FoodForItem setTexture(String str1) {
		texture_name[0] = str1;
		return this;
	}

	public FoodForItem setTexture(String str1, String str2) {
		txr_tmp[0] = str1;
		txr_tmp[1] = str2;
		setTexture(txr_tmp);
		/*if (str2 == "0") {str2 = "empty";}
		if (str2 == "O") {
		str2 = str1 + "_overlay";
		}
		texture_name[0] = str1;
		texture_name[1] = str2;
		 */
		return this;
	}

	public FoodForItem setTextureFood(String[] str) {
		for (int i = 0; i < str.length; i++) {
			if (str[i] == "0" || str[i] == "foods/0") {
				str[i] = "empty";
			}
			if (str[i] == "O") {
				str[i] = str[i - 1] + "_overlay";
			}
			txr_tmp[i] = "foods/" + str[i];
		}
		texture_name = txr_tmp;
		return this;
	}
	public FoodForItem setTextureFood(String str1) {
		setTexture("foods/" + str1);
		return this;
	}

	public FoodForItem setTextureFood(String str1, String str2) {
		txr_tmp[0] = "foods/" + str1;
		txr_tmp[1] = str2 == "O" ? "foods/" + str1 + "_overlay" : "foods/" + str2 + str2;
		setTexture(txr_tmp);
		//setTexture("foods/" + str1, str2 == "O" ? "foods/" + str1 + "_overlay" : "foods/" + str2);
		return this;
	}

	public String[] getTexture() {
		return texture_name;
	}

	public String getTexture(int i) {
		return i < texture_name.length && i >= 0 ? texture_name[i] : "empty";
	}

}

