package mods.timaxa007.pack.magic.lib;

import mods.timaxa007.tms.Core;
import net.minecraft.util.StatCollector;
/**
 * Use in <b>ItemsMagic</b>.
 * @author timaxa007
 * @param 
 * @param 
 * @param 
 */
public class ItemForMagic {

	public static final ItemForMagic[] list = new ItemForMagic[2048];

	public static final ItemForMagic empty = new ItemForMagic(0);

	public int id;
	public String tag;
	private String name;
	private String type;

	private int color_hex1;
	private int color_hex2;

	private String texture1;
	private String texture2;

	/**It is not recommended to use this method.**/
	@Deprecated
	public ItemForMagic() {
		id = nextID();
		list[id] = this;
	}

	/**It is not recommended to use this method.**/
	@Deprecated
	public ItemForMagic(int id) {
		this.id = id;
		list[id] = this;
	}

	/**It is not recommended to use this method.**/
	@Deprecated
	public ItemForMagic(int id, String tag) {
		if (Core.show_tip_info_testing) checkTag(tag);
		this.id = id;
		list[id] = this;
		this.tag = tag;
	}

	public ItemForMagic(String tag) {
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

	public static ItemForMagic get(String tag) {
		if (tag != null && tag.length() > 0)
			return list[getID_tag(tag)];
		return empty;
	}
	//--------------------------------------------------------
	public boolean hasTag() {
		return tag != null && tag.length() > 0;
	}

	public ItemForMagic setName(String name) {
		this.name = name;
		return this;
	}

	public String getName() {
		return name == null ? "unnamed" : name;
	}

	public String getLocalizedName() {
		return StatCollector.translateToLocal("item." + getName() + ".name");
	}

	public ItemForMagic setType(String type) {
		this.type = type;
		return this;
	}

	public String getType() {
		return type == null ? "untyped" : type;
	}

	public String getLocalizedType() {
		return StatCollector.translateToLocal("type." + getType().toLowerCase() + ".name");
	}

	public ItemForMagic setColors(int color) {
		color_hex1 = color;
		color_hex2 = color;
		return this;
	}

	public ItemForMagic setColors(int color1, int color2) {
		color_hex1 = color1;
		color_hex2 = color2;
		return this;
	}

	public ItemForMagic setColor1(int color1) {
		color_hex1 = color1;
		return this;
	}

	public int getColor1() {
		return color_hex1 == 0 ? 0xFFFFFF : color_hex1;
	}

	public ItemForMagic setColor2(int color2) {
		color_hex2 = color2;
		return this;
	}

	public int getColor2() {
		return color_hex2 == 0 ? 0xFFFFFF : color_hex2;
	}

	public ItemForMagic setTextures(String path) {
		texture1 = path;
		texture2 = path + "_overlay";
		return this;
	}

	public ItemForMagic setTextures(String path1, String path2) {
		texture1 = path1;
		texture2 = path2;
		return this;
	}

	public ItemForMagic setTexture1(String path1) {
		texture1 = path1;
		return this;
	}

	public String getTexture1() {
		return texture1 == null ? getName() : texture1;
	}

	public ItemForMagic setTexture2(String path2) {
		texture2 = path2;
		return this;
	}

	public String getTexture2() {
		return texture2 == null ? getTexture1() : texture2;
	}

}

