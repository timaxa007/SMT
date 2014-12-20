package mods.timaxa007.pack.furniture.lib;

import mods.timaxa007.tms.Core;
import net.minecraft.util.StatCollector;
/**
 * Use in <b>ItemsFurniture</b>.
 * @author timaxa007
 * @param 
 * @param 
 * @param 
 */
public class ItemForFurniture {

	public static ItemForFurniture[] list = new ItemForFurniture[2048];

	public static ItemForFurniture empty = new ItemForFurniture(0);

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
	public ItemForFurniture() {
		id = nextID();
		list[id] = this;
	}

	/**It is not recommended to use this method.**/
	@Deprecated
	public ItemForFurniture(int id) {
		this.id = id;
		list[id] = this;
	}

	/**It is not recommended to use this method.**/
	@Deprecated
	public ItemForFurniture(int id, String tag) {
		this.id = id;
		list[id] = this;
		this.tag = tag;
		if (Core.show_tip_info_testing) checkTag(tag);//OFF
	}

	public ItemForFurniture(String tag) {
		id = nextID();
		list[id] = this;
		this.tag = tag;
		if (Core.show_tip_info_testing) checkTag(tag);//OFF
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

	public ItemForFurniture setName(String name) {
		this.name = name;
		return this;
	}

	public String getName() {
		return name == null ? "unnamed" : name;
	}

	public String getLocalizedName() {
		return StatCollector.translateToLocal("item." + getName() + ".name");
	}

	public ItemForFurniture setType(String type) {
		this.type = type;
		return this;
	}

	public String getType() {
		return type == null ? "untype" : type;
	}

	public String getLocalizedType() {
		return StatCollector.translateToLocal("type." + getType().toLowerCase() + ".name");
	}

	public ItemForFurniture setColors(int color) {
		color_hex1 = color;
		color_hex2 = color;
		return this;
	}

	public ItemForFurniture setColors(int color1, int color2) {
		color_hex1 = color1;
		color_hex2 = color2;
		return this;
	}

	public ItemForFurniture setColor1(int color1) {
		color_hex1 = color1;
		return this;
	}

	public int getColor1() {
		return color_hex1 == 0 ? 0xFFFFFF : color_hex1;
	}

	public ItemForFurniture setColor2(int color2) {
		color_hex2 = color2;
		return this;
	}

	public int getColor2() {
		return color_hex2 == 0 ? 0xFFFFFF : color_hex2;
	}

	public ItemForFurniture setTextures(String path) {
		texture1Name = path;
		texture2Name = path + "_overlay";
		return this;
	}

	public ItemForFurniture setTextures(String path1, String path2) {
		texture1Name = path1;
		texture2Name = path2;
		return this;
	}

	public ItemForFurniture setTexture1(String path1) {
		texture1Name = path1;
		return this;
	}

	public String getTexture1() {
		return texture1Name == null ? getName() : texture1Name;
	}

	public ItemForFurniture setTexture2(String path2) {
		texture2Name = path2;
		return this;
	}

	public String getTexture2() {
		return texture2Name == null ? getTexture1() : texture2Name;
	}

}

