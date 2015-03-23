package mods.timaxa007.pack.furniture.lib;

import mods.timaxa007.tms.util.UtilString;

/**
 * Use in <b>BlockWood</b>.
 * @author timaxa007
 * @param 
 * @param 
 * @param 
 */
public class AddBlockWood {

	public static final AddBlockWood[] list = new AddBlockWood[127];

	public static final AddBlockWood empty = new AddBlockWood("");

	private int id;
	private String tag;
	private String name;
	private int color_hex;
	private String texture;

	/**It is not recommended to use this method.**/@Deprecated
	public AddBlockWood() {id = nextID();list[id] = this;color_hex = 0xFFFFFF;}

	/**It is not recommended to use this method.**/@Deprecated
	public AddBlockWood(int id) {
		checkID(this, id);this.id = id;list[id] = this;color_hex = 0xFFFFFF;
	}

	/**It is not recommended to use this method.**/@Deprecated
	public AddBlockWood(int id, String tag) {
		checkID(this, id);checkTag(this, tag);
		this.id = id;this.tag = tag;list[id] = this;color_hex = 0xFFFFFF;
	}

	public AddBlockWood(String tag) {
		checkTag(this, tag);
		id = nextID();
		list[id] = this;
		this.tag = tag;
		color_hex = 0xFFFFFF;
		texture = "";
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
			for (AddBlockWood adding : list)
				if (adding != null && tag.equalsIgnoreCase(adding.tag))
					return true;
		return false;
	}

	public static int getID_tag(String tag) {
		if (UtilString.hasString(tag))
			for (AddBlockWood adding : list)
				if (adding != null && tag.equalsIgnoreCase(adding.tag))
					return adding.id;
		return empty.id;
	}

	private static void checkID(AddBlockWood addBlockWood, int id) {
		if (list[id] != null)
			throw new IllegalArgumentException("Duplicate id: " + id + " in " + addBlockWood.getClass() + ".");
	}

	private static void checkTag(AddBlockWood addBlockWood, String tag) {
		if (UtilString.hasString(tag))
			for (AddBlockWood adding : list)
				if (adding != null && adding.tag == tag)
					throw new IllegalArgumentException("Duplicate tag: " + tag + " in " + addBlockWood.getClass() + ".");
	}

	public static AddBlockWood get(String tag) {
		return list[getID_tag(tag)];
	}

	public static boolean isNull(String tag) {
		return isNull(get(tag));
	}

	public static boolean isNull(AddBlockWood addBlockWood) {
		return addBlockWood == null || addBlockWood == empty;
	}
	//--------------------------------------------------------
	public AddBlockWood setID(int id) {
		this.id = id;
		return this;
	}

	public int getID() {
		return id;
	}

	public AddBlockWood setTag(String tag) {
		this.tag = tag;
		return this;
	}

	public String getTag() {
		return tag;
	}

	public AddBlockWood setName(String name) {
		this.name = name;
		return this;
	}

	public String getName() {
		return name;
	}

	public AddBlockWood setColor(int color) {
		color_hex = color;
		return this;
	}

	public int getColor() {
		return color_hex;
	}

	public AddBlockWood setTexture(String path) {
		texture = path;
		return this;
	}

	public String getTexture() {
		return texture;
	}

}
