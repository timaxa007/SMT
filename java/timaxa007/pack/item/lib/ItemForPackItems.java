package timaxa007.pack.item.lib;

import timaxa007.tms.util.UtilString;
import net.minecraft.util.StatCollector;
/**
 * Use in <b>ItemsMagic</b>.
 * @author timaxa007
 * @param 
 * @param 
 * @param 
 */
public class ItemForPackItems {

	public static final ItemForPackItems[] list = new ItemForPackItems[2048];

	public static final ItemForPackItems empty = new ItemForPackItems("");

	public int id;
	public String tag;
	private String name;
	private String type;

	private int color_hex1;
	private int color_hex2;

	private String texture1;
	private String texture2;

	/**Не рекомендуется использовать этот метод.<br>
	 * It is not recommended to use this method.**/
	@Deprecated
	public ItemForPackItems() {id = nextID();list[id] = this;}

	/**Не рекомендуется использовать этот метод.<br>
	 * It is not recommended to use this method.**/
	@Deprecated
	public ItemForPackItems(int id) {checkID(this, id);this.id = id;list[id] = this;}

	/**Не рекомендуется использовать этот метод.<br>
	 * It is not recommended to use this method.**/
	@Deprecated
	public ItemForPackItems(int id, String tag) {
		checkID(this, id);checkTag(this, tag);
		this.id = id;this.tag = tag;list[id] = this;
	}

	public ItemForPackItems(String tag) {
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
			for (ItemForPackItems iteming : list)
				if (iteming != null && tag.equalsIgnoreCase(iteming.tag))
					return true;
		return false;
	}

	public static int getID_tag(String tag) {
		if (UtilString.hasString(tag))
			for (ItemForPackItems iteming : list)
				if (iteming != null && tag.equalsIgnoreCase(iteming.tag))
					return iteming.id;
		return empty.id;
	}

	private static void checkID(ItemForPackItems itemForPackItems, int id) {
		if (list[id] != null)
			throw new IllegalArgumentException("Duplicate id: " + id + " in " + itemForPackItems.getClass() + ".");
	}

	private static void checkTag(ItemForPackItems itemForPackItems, String tag) {
		if (UtilString.hasString(tag))
			for (ItemForPackItems iteming : list)
				if (iteming != null && iteming.tag == tag)
					throw new IllegalArgumentException("Duplicate tag: " + tag + " in " + itemForPackItems.getClass() + ".");
	}

	public static ItemForPackItems get(String tag) {
		return list[getID_tag(tag)];
	}

	public static boolean isNull(String tag) {
		return isNull(get(tag));
	}

	public static boolean isNull(ItemForPackItems ifpi) {
		return ifpi == null || ifpi == empty;
	}
	//--------------------------------------------------------
	public ItemForPackItems setName(String name) {
		this.name = name;
		return this;
	}

	public String getName() {
		return UtilString.hasString(name) ? name : UtilString.hasString(tag) ? tag : "unname";
	}

	public String getLocalizedName() {
		return StatCollector.translateToLocal("item." + getName() + ".name");
	}

	public ItemForPackItems setType(String type) {
		this.type = type;
		return this;
	}

	public String getType() {
		return UtilString.hasString(type) ? "untyped" : type;
	}

	public String getLocalizedType() {
		return StatCollector.translateToLocal("type." + getType().toLowerCase() + ".name");
	}

	public ItemForPackItems setColors(int color) {
		color_hex1 = color;
		color_hex2 = color;
		return this;
	}

	public ItemForPackItems setColors(int color1, int color2) {
		color_hex1 = color1;
		color_hex2 = color2;
		return this;
	}

	public ItemForPackItems setColor1(int color1) {
		color_hex1 = color1;
		return this;
	}

	public int getColor1() {
		return color_hex1 == 0 ? 0xFFFFFF : color_hex1;
	}

	public ItemForPackItems setColor2(int color2) {
		color_hex2 = color2;
		return this;
	}

	public int getColor2() {
		return color_hex2 == 0 ? 0xFFFFFF : color_hex2;
	}

	public ItemForPackItems setTextures(String path) {
		texture1 = path;
		texture2 = path + "_overlay";
		return this;
	}

	public ItemForPackItems setTextures(String path1, String path2) {
		texture1 = path1;
		texture2 = path2;
		return this;
	}

	public ItemForPackItems setTexture1(String path1) {
		texture1 = path1;
		return this;
	}

	public String getTexture1() {
		return texture1 == null ? getName() : texture1;
	}

	public ItemForPackItems setTexture2(String path2) {
		texture2 = path2;
		return this;
	}

	public String getTexture2() {
		return texture2 == null ? getTexture1() : texture2;
	}

}

