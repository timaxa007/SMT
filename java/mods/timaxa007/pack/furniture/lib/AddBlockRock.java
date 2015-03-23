package mods.timaxa007.pack.furniture.lib;

import mods.timaxa007.tms.util.UtilString;

/**
 * Use in <b>BlockRock</b>.
 * @author timaxa007
 * @param 
 * @param 
 * @param 
 */
public class AddBlockRock {

	public static final AddBlockRock[] list = new AddBlockRock[127];

	public static final AddBlockRock empty = new AddBlockRock("");

	private int id;
	private String tag;
	private String name;
	private int color_hex;
	private String texture;

	/**It is not recommended to use this method.**/@Deprecated
	public AddBlockRock() {id = nextID();list[id] = this;color_hex = 0xFFFFFF;}

	/**It is not recommended to use this method.**/@Deprecated
	public AddBlockRock(int id) {
		checkID(this, id);this.id = id;list[id] = this;color_hex = 0xFFFFFF;
	}

	/**It is not recommended to use this method.**/@Deprecated
	public AddBlockRock(int id, String tag) {
		checkID(this, id);checkTag(this, tag);
		this.id = id;this.tag = tag;list[id] = this;color_hex = 0xFFFFFF;
	}

	public AddBlockRock(String tag) {
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
			for (AddBlockRock adding : list)
				if (adding != null && tag.equalsIgnoreCase(adding.tag))
					return true;
		return false;
	}

	public static int getID_tag(String tag) {
		if (UtilString.hasString(tag))
			for (AddBlockRock adding : list)
				if (adding != null && tag.equalsIgnoreCase(adding.tag))
					return adding.id;
		return empty.id;
	}

	private static void checkID(AddBlockRock addBlockRock, int id) {
		if (list[id] != null)
			throw new IllegalArgumentException("Duplicate id: " + id + " in " + addBlockRock.getClass() + ".");
	}

	private static void checkTag(AddBlockRock addBlockRock, String tag) {
		if (UtilString.hasString(tag))
			for (AddBlockRock adding : list)
				if (adding != null && adding.tag == tag)
					throw new IllegalArgumentException("Duplicate tag: " + tag + " in " + addBlockRock.getClass() + ".");
	}

	public static AddBlockRock get(String tag) {
		return list[getID_tag(tag)];
	}

	public static boolean isNull(String tag) {
		return isNull(get(tag));
	}

	public static boolean isNull(AddBlockRock addBlockRock) {
		return addBlockRock == null || addBlockRock == empty;
	}
	//--------------------------------------------------------
	public AddBlockRock setID(int id) {
		this.id = id;
		return this;
	}

	public int getID() {
		return id;
	}

	public AddBlockRock setTag(String tag) {
		this.tag = tag;
		return this;
	}

	public String getTag() {
		return tag;
	}

	public AddBlockRock setName(String name) {
		this.name = name;
		return this;}

	public String getName() {
		return name;
	}

	public AddBlockRock setColor(int color) {
		color_hex = color;
		return this;
	}

	public int getColor() {
		return color_hex;
	}

	public AddBlockRock setTexture(String path) {
		texture = path;
		return this;
	}

	public String getTexture() {
		return texture;
	}

}
