package mods.timaxa007.lib;

import mods.timaxa007.tms.Core;
import net.minecraft.util.StatCollector;
/**
 * @author timaxa007
 * @param 
 * @param 
 * @param 
 */
public class Effects {

	public static final Effects[] list = new Effects[2048];

	public static final Effects empty = new Effects(0);

	public static final Effects effect_move_fast = new Effects("move_fast");
	public static final Effects effect_move_slow = new Effects("move_slow");

	public static final Effects effect_mining_fast = new Effects("mining_fast");
	public static final Effects effect_mining_slow = new Effects("mining_slow");

	public static final Effects effect_digging_fast = new Effects("digging_fast");
	public static final Effects effect_digging_slow = new Effects("digging_slow");

	public static final Effects effect_chopping_fast = new Effects("chopping_fast");
	public static final Effects effect_chopping_slow = new Effects("chopping_slow");

	public static final Effects effect_trimming_fast = new Effects("trimming_fast");
	public static final Effects effect_trimming_slow = new Effects("trimming_slow");

	public static final Effects effect_strength_high = new Effects("strength_high");
	public static final Effects effect_strength_low = new Effects("strength_low");

	public static final Effects effect_damage = new Effects("damage");
	public static final Effects effect_protection_damage = new Effects("protection_damage");
	public static final Effects effect_resistance_damage = new Effects("resistance_damage");

	public static final Effects effect_poison = new Effects("poison");
	public static final Effects effect_protection_poison = new Effects("protection_poison");
	public static final Effects effect_resistance_poison = new Effects("resistance_poison");

	public static final Effects effect_jump = new Effects("jump");
	public static final Effects effect_confusion = new Effects("confusion");
	public static final Effects effect_regeneration = new Effects("regeneration");
	public static final Effects effect_resistance_fire = new Effects("resistance_fire");
	public static final Effects effect_water_breathing = new Effects("water_breathing");
	public static final Effects effect_invisibility = new Effects("invisibility");

	public static final Effects effect_blindness = new Effects("blindness");
	public static final Effects effect_night_vision = new Effects("night_vision");

	public static final Effects effect_hunger = new Effects("hunger");
	public static final Effects effect_weakness = new Effects("weakness");
	public static final Effects effect_wither = new Effects("wither");
	public static final Effects effect_potion_health_boost = new Effects("potion_health_boost");
	public static final Effects effect_potion_absoption = new Effects("potion_absoption");
	public static final Effects effect_potion_health = new Effects("potion_health");

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

	/**It is not recommended to use this method.**/
	@Deprecated
	public Effects() {
		id = nextID();
		list[id] = this;
	}

	/**It is not recommended to use this method.**/
	@Deprecated
	public Effects(int id) {
		this.id = id;
		list[id] = this;
	}

	/**It is not recommended to use this method.**/
	@Deprecated
	public Effects(int id, String tag) {
		if (Core.show_tip_info_testing) checkTag(tag);
		this.id = id;
		list[id] = this;
		this.tag = tag;
	}

	public Effects(String tag) {
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

	public Effects setName(String name) {
		this.name = name;
		return this;
	}

	public String getName() {
		return name == null ? tag == null ? "unname" : tag : name;
	}

	public String getLocalizedName() {
		return StatCollector.translateToLocal("effect." + getName() + ".name");
	}

	public Effects setType(String type) {
		this.type = type;
		return this;
	}

	public String getType() {
		return type == null ? "untype" : type;
	}

	public String getLocalizedType() {
		return StatCollector.translateToLocal("type." + getType().toLowerCase() + ".name");
	}

	public Effects setColors(int color) {
		color_hex1 = color;
		color_hex2 = color;
		return this;
	}

	public Effects setColors(int color1, int color2) {
		color_hex1 = color1;
		color_hex2 = color2;
		return this;
	}

	public Effects setColor1(int color1) {
		color_hex1 = color1;
		return this;
	}

	public int getColor1() {
		return color_hex1 == 0 ? 0xFFFFFF : color_hex1;
	}

	public Effects setColor2(int color2) {
		color_hex2 = color2;
		return this;
	}

	public int getColor2() {
		return color_hex2 == 0 ? 0xFFFFFF : color_hex2;
	}

	public Effects setTexture1(String path1) {
		texture1 = path1;
		return this;
	}

	public String getTexture1() {
		return texture1 == null ? getName() : texture1;
	}

	public Effects setTexture2(String path2) {
		texture2 = path2;
		return this;
	}

	public String getTexture2() {
		return texture2 == null ? getTexture1() : texture2;
	}

}
