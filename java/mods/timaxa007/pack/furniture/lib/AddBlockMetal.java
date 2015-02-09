package mods.timaxa007.pack.furniture.lib;

import mods.timaxa007.tms.Core;
import mods.timaxa007.tms.util.UtilText;

/**
 * Use in <b>BlockMetal</b>.
 * @author timaxa007
 * @param 
 * @param 
 * @param 
 */
public class AddBlockMetal {

	public static final AddBlockMetal[] list = new AddBlockMetal[127];

	private int id;
	private String tag;
	private String name;
	private int color_hex;
	private String texture;

	/**It is not recommended to use this method.**/
	@Deprecated
	public AddBlockMetal() {
		id = nextID();
		list[id] = this;
		tag = "";
		color_hex = 0xFFFFFF;
		texture = "";
	}

	/**It is not recommended to use this method.**/
	@Deprecated
	public AddBlockMetal(int id) {
		this.id = id;
		list[id] = this;
		tag = "";
		color_hex = 0xFFFFFF;
		texture = "";
	}

	/**It is not recommended to use this method.**/
	@Deprecated
	public AddBlockMetal(int id, String tag) {
		if (Core.show_system_info_testing) checkTag(tag);
		this.id = id;
		list[id] = this;
		this.tag = tag;
		color_hex = 0xFFFFFF;
		texture = "";
	}

	public AddBlockMetal(String tag) {
		if (Core.show_system_info_testing) checkTag(tag);
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

	public static AddBlockMetal get(String tag) {
		if (UtilText.hasString(tag))
			return list[getID_tag(tag)];
		return list[0];
	}
	//--------------------------------------------------------
	public AddBlockMetal setID(int id) {
		this.id = id;
		return this;
	}

	public int getID() {
		return id;
	}

	public AddBlockMetal setTag(String tag) {
		this.tag = tag;
		return this;
	}

	public String getTag() {
		return tag;
	}

	public AddBlockMetal setName(String name) {
		this.name = name;
		return this;
	}

	public String getName() {
		return name;
	}

	public AddBlockMetal setColor(int color) {
		color_hex = color;
		return this;
	}

	public int getColor() {
		return color_hex;
	}

	public AddBlockMetal setTexture(String path) {
		texture = path;
		return this;
	}

	public String getTexture() {
		return texture;
	}

}
