package mods.timaxa007.pack.techno.lib;

import mods.timaxa007.tms.Core;
import net.minecraft.util.StatCollector;
/**
 * Use in <b>ItemsTechno</b>.
 * @author timaxa007
 * @param 
 * @param 
 * @param 
 */
public class ItemForTechno {

	public static final ItemForTechno[] item_ = new ItemForTechno[2048];

	public static ItemForTechno empty = new ItemForTechno(0);

	public int id;
	public String tag;
	private String name;
	private String type;

	private int color_hex1;
	private int color_hex2;

	private String texture1Name;
	private String texture2Name;

	/**It is not recommended to use this method.**/
	@Deprecated
	public ItemForTechno() {
		id = nextID();
		item_[id] = this;
	}

	/**It is not recommended to use this method.**/
	@Deprecated
	public ItemForTechno(int id) {
		this.id = id;
		item_[id] = this;
	}

	/**It is not recommended to use this method.**/
	@Deprecated
	public ItemForTechno(int id, String tag) {
		if (Core.show_tip_info_testing) checkTag(tag);
		this.id = id;
		item_[id] = this;
		this.tag = tag;
	}

	public ItemForTechno(String tag) {
		if (Core.show_tip_info_testing) checkTag(tag);
		id = nextID();
		item_[id] = this;
		this.tag = tag;
	}

	public static int nextID() {
		for (int i = 0; i < item_.length; i++)
			if (item_[i] == null)
				return i;
		return item_.length - 1;
	}

	public static boolean hasTag(String tag) {
		for (int i = 0; i < item_.length; i++)
			if (tag.equalsIgnoreCase(item_[i].tag))
				return true;
		return false;
	}

	public static int getID_name(String tag) {
		for (int i = 0; i < item_.length; i++)
			if (tag.equalsIgnoreCase(item_[i].tag))
				return i;
		return 0;
	}

	private void checkTag(String tag) {
		for (int i = 0; i < item_.length; i++)
			if (item_[i] != null && item_[i].tag == tag)
				System.out.println("!Duplicate: " + tag);
	}

	public ItemForTechno setName(String name) {
		this.name = name;
		return this;
	}

	public String getName() {
		return name == null ? "unnamed" : name;
	}

	public String getLocalizedName() {
		return StatCollector.translateToLocal("item." + getName() + ".name");
	}

	public ItemForTechno setType(String type) {
		this.type = type;
		return this;
	}

	public String getType() {
		return type == null ? "untyped" : type;
	}

	public String getLocalizedType() {
		return StatCollector.translateToLocal("type." + getType().toLowerCase() + ".name");
	}

	public ItemForTechno setColors(int color) {
		color_hex1 = color;
		color_hex2 = color;
		return this;
	}

	public ItemForTechno setColors(int color1, int color2) {
		color_hex1 = color1;
		color_hex2 = color2;
		return this;
	}

	public ItemForTechno setColor1(int color1) {
		color_hex1 = color1;
		return this;
	}

	public int getColor1() {
		return color_hex1 == 0 ? 0xFFFFFF : color_hex1;
	}

	public ItemForTechno setColor2(int color2) {
		color_hex2 = color2;
		return this;
	}

	public int getColor2() {
		return color_hex2 == 0 ? 0xFFFFFF : color_hex2;
	}

	public ItemForTechno setTextures(String path) {
		texture1Name = path;
		texture2Name = path + "_overlay";
		return this;
	}

	public ItemForTechno setTextures(String path1, String path2) {
		texture1Name = path1;
		texture2Name = path2;
		return this;
	}

	public ItemForTechno setTexture1(String path1) {
		texture1Name = path1;
		return this;
	}

	public String getTexture1() {
		return texture1Name == null ? getName() : texture1Name;
	}

	public ItemForTechno setTexture2(String path2) {
		texture2Name = path2;
		return this;
	}

	public String getTexture2() {
		return texture2Name == null ? getTexture1() : texture2Name;
	}

}

