package mods.timaxa007.pack.techno.lib;

import net.minecraft.util.StatCollector;
/**
 * @author timaxa007
 * @param 
 * @param 
 * @param 
 */
public class ItemForTechno {

	public static final ItemForTechno[] item_list = new ItemForTechno[2048];

	public static ItemForTechno item_empty = new ItemForTechno(0);

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
	public ItemForTechno() {
		id = nextID();
		item_list[id] = this;
	}

	/**It is not recommended to use this method.**/
	@Deprecated
	public ItemForTechno(int id) {
		this.id = id;
		item_list[id] = this;
	}

	public ItemForTechno(String tag_name) {
		checkTag(tag_name);//OFF
		id = nextID();
		item_list[id] = this;
		tag = tag_name;
	}

	/**It is not recommended to use this method.**/
	@Deprecated
	public ItemForTechno(int id, String tag_name) {
		checkTag(tag_name);//OFF
		this.id = id;
		item_list[id] = this;
		tag = tag_name;
	}

	public static int nextID() {
		for (int i = 0; i < item_list.length; i++) {
			if (item_list[i] == null) {
				return i;
			}
		}
		return item_list.length - 1;
	}

	public static boolean hasTag(String str) {
		for (int i = 0; i < item_list.length; i++) {
			if (str.equalsIgnoreCase(item_list[i].tag)) {
				return true;
			}
		}
		return false;
	}

	public static int getID_name(String str) {
		for (int i = 0; i < item_list.length; i++) {
			if (str.equalsIgnoreCase(item_list[i].tag)) {
				return i;
			}
		}
		return 0;
	}

	private void checkTag(String str) {
		for (int i = 0; i < item_list.length; i++) {
			if (item_list[i] != null && item_list[i].tag == str) {
				System.out.println("!Duplicate: " + str);
			}
		}
	}

	public ItemForTechno setName(String str) {
		name = str;
		return this;
	}

	public String getName() {
		return name == null ? "unnamed" : name;
	}

	public String getLocalizedName() {
		return StatCollector.translateToLocal("item." + getName() + ".name");
	}

	public ItemForTechno setType(String str) {
		type = str;
		return this;
	}

	public String getType() {
		return type == null ? "untyped" : type;
	}

	public String getLocalizedType() {
		return StatCollector.translateToLocal("type." + getType().toLowerCase() + ".name");
	}

	public ItemForTechno setColors(int i) {
		color_hex1 = i;
		color_hex2 = i;
		return this;
	}

	public ItemForTechno setColors(int i1, int i2) {
		color_hex1 = i1;
		color_hex2 = i2;
		return this;
	}

	public ItemForTechno setColor1(int i) {
		color_hex1 = i;
		return this;
	}

	public int getColor1() {
		return color_hex1 == 0 ? 0xFFFFFF : color_hex1;
	}

	public ItemForTechno setColor2(int i) {
		color_hex2 = i;
		return this;
	}

	public int getColor2() {
		return color_hex2 == 0 ? 0xFFFFFF : color_hex2;
	}

	public ItemForTechno setTextures(String str) {
		texture1Name = str;
		texture2Name = str + "_overlay";
		return this;
	}

	public ItemForTechno setTextures(String str1, String str2) {
		texture1Name = str1;
		texture2Name = str2;
		return this;
	}

	public ItemForTechno setTexture1(String str) {
		texture1Name = str;
		return this;
	}

	public String getTexture1() {
		return texture1Name == null ? getName() : texture1Name;
	}

	public ItemForTechno setTexture2(String str) {
		texture2Name = str;
		return this;
	}

	public String getTexture2() {
		return texture2Name == null ? getTexture1() : texture2Name;
	}

}

