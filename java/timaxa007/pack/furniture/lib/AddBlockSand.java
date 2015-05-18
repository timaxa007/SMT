package timaxa007.pack.furniture.lib;

import timaxa007.smt.util.UtilString;

/**
 * Use in <b>BlockSand</b>.
 * @author timaxa007
 * @param 
 * @param 
 * @param 
 */
public class AddBlockSand {

	public static final AddBlockSand[] list = new AddBlockSand[127];

	public static final AddBlockSand empty = new AddBlockSand("");

	private int id;
	private String tag;
	private String name;
	private int color_hex;
	private String texture;

	/**Не рекомендуется использовать этот метод.<br>
	 * It is not recommended to use this method.**/
	@Deprecated
	public AddBlockSand() {id = nextID();list[id] = this;color_hex = 0xFFFFFF;}

	/**Не рекомендуется использовать этот метод.<br>
	 * It is not recommended to use this method.**/
	@Deprecated
	public AddBlockSand(int id) {
		checkID(this, id);this.id = id;list[id] = this;color_hex = 0xFFFFFF;
	}

	/**Не рекомендуется использовать этот метод.<br>
	 * It is not recommended to use this method.**/
	@Deprecated
	public AddBlockSand(int id, String tag) {
		checkID(this, id);checkTag(this, tag);
		this.id = id;this.tag = tag;list[id] = this;color_hex = 0xFFFFFF;
	}

	public AddBlockSand(String tag) {
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
			for (AddBlockSand adding : list)
				if (adding != null && tag.equalsIgnoreCase(adding.tag))
					return true;
		return false;
	}

	public static int getID_tag(String tag) {
		if (UtilString.hasString(tag))
			for (AddBlockSand adding : list)
				if (adding != null && tag.equalsIgnoreCase(adding.tag))
					return adding.id;
		return empty.id;
	}

	private static void checkID(AddBlockSand addBlockSand, int id) {
		if (list[id] != null)
			throw new IllegalArgumentException("Duplicate id: " + id + " in " + addBlockSand.getClass() + ".");
	}

	private static void checkTag(AddBlockSand addBlockSand, String tag) {
		if (UtilString.hasString(tag))
			for (AddBlockSand adding : list)
				if (adding != null && adding.tag == tag)
					throw new IllegalArgumentException("Duplicate tag: " + tag + " in " + addBlockSand.getClass() + ".");
	}

	public static AddBlockSand get(String tag) {
		return list[getID_tag(tag)];
	}

	public static boolean isNull(String tag) {
		return isNull(get(tag));
	}

	public static boolean isNull(AddBlockSand addBlockSand) {
		return addBlockSand == null || addBlockSand == empty;
	}
	//--------------------------------------------------------
	public AddBlockSand setID(int id) {
		this.id = id;
		return this;
	}

	public int getID() {
		return id;
	}

	public AddBlockSand setTag(String tag) {
		this.tag = tag;
		return this;
	}

	public String getTag() {
		return tag;
	}

	public AddBlockSand setName(String name) {
		this.name = name;
		return this;
	}

	public String getName() {
		return name;
	}

	public AddBlockSand setColor(int color) {
		color_hex = color;
		return this;
	}

	public int getColor() {
		return color_hex;
	}

	public AddBlockSand setTexture(String path) {
		texture = path;
		return this;
	}

	public String getTexture() {
		return texture;
	}

}
