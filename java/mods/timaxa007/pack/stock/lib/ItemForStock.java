package mods.timaxa007.pack.stock.lib;

import mods.timaxa007.tms.Core;
import net.minecraft.util.StatCollector;
/**
 * Use in <b>ItemsStock</b>.
 * @author timaxa007
 * @param 
 * @param 
 * @param 
 */
public class ItemForStock {

	public static final ItemForStock[] list = new ItemForStock[2048];

	public static ItemForStock empty = new ItemForStock(0);

	public int id;
	public String tag;
	private String name;
	private String type;

	private int color_hex1;
	private int color_hex2;

	protected String texture1Name;
	protected String texture2Name;

	/**It is not recommended to use this method.**/
	@Deprecated
	public ItemForStock() {
		id = nextID();
		list[id] = this;
		//tag = "";
	}

	/**It is not recommended to use this method.**/
	@Deprecated
	public ItemForStock(int id) {
		this.id = id;
		list[id] = this;
		//tag = "";
	}

	/**It is not recommended to use this method.**/
	@Deprecated
	public ItemForStock(int id, String tag) {
		this.id = id;
		list[id] = this;
		this.tag = tag;
		if (Core.show_tip_info_testing) checkTag(tag);//OFF
	}

	public ItemForStock(String tag) {
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

	public ItemForStock setName(String name) {
		this.name = name;
		return this;
	}

	public String getName() {
		return name == null ? "unnamed" : name;
	}

	public String getLocalizedName() {
		return StatCollector.translateToLocal("item." + getName() + ".name");
	}

	public ItemForStock setType(String type) {
		this.type = type;
		return this;
	}

	public String getType() {
		return type == null ? "untyped" : type;
	}

	public String getLocalizedType() {
		return StatCollector.translateToLocal("type." + getType().toLowerCase() + ".name");
	}

	public ItemForStock setColors(int color) {
		color_hex1 = color;
		color_hex2 = color;
		return this;
	}

	public ItemForStock setColors(int color1, int color2) {
		color_hex1 = color1;
		color_hex2 = color2;
		return this;
	}

	public ItemForStock setColor1(int color1) {
		color_hex1 = color1;
		return this;
	}

	public int getColor1() {
		return color_hex1 == 0 ? 0xFFFFFF : color_hex1;
	}

	public ItemForStock setColor2(int color2) {
		color_hex2 = color2;
		return this;
	}

	public int getColor2() {
		return color_hex2 == 0 ? 0xFFFFFF : color_hex2;
	}

	public ItemForStock setTextures(String path) {
		texture1Name = path;
		texture2Name = path + "_overlay";
		return this;
	}

	public ItemForStock setTextures(String path1, String path2) {
		texture1Name = path1;
		texture2Name = path2;
		return this;
	}

	public ItemForStock setTexture1(String path1) {
		texture1Name = path1;
		return this;
	}

	public String getTexture1() {
		return texture1Name == null ? getName() : texture1Name;
	}

	public ItemForStock setTexture2(String path2) {
		texture2Name = path2;
		return this;
	}

	public String getTexture2() {
		return texture2Name == null ? getTexture1() : texture2Name;
	}

}

