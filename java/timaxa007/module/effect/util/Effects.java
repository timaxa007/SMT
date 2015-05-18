package timaxa007.module.effect.util;

import net.minecraft.util.StatCollector;
import timaxa007.smt.util.UtilString;
/**
 * @author timaxa007
 * @param 
 * @param 
 * @param 
 */
public class Effects {

	private String tag;
	private String name;
	private String type;

	private int color_hex;
	private int color_hex2;

	private String texture;
	private String texture2;

	public Effects(String tag) {
		this.tag = tag;
	}
	//--------------------------------------------------------
	public String getTag() {
		return tag;
	}

	public Effects setName(String name) {
		this.name = name;
		return this;
	}

	public String getName() {
		return UtilString.hasString(name) ? name : UtilString.hasString(tag) ? tag : "unname";
	}

	public String getLocalizedName() {
		return StatCollector.translateToLocal("effect." + getName() + ".name");
	}

	public Effects setType(String type) {
		this.type = type;
		return this;
	}

	public String getType() {
		return UtilString.hasString(type) ? type : "untype";
	}

	public String getLocalizedType() {
		return StatCollector.translateToLocal("type." + getType().toLowerCase() + ".name");
	}

	public Effects setColors(int color) {
		color_hex = color;
		color_hex2 = color;
		return this;
	}

	public Effects setColors(int color1, int color2) {
		color_hex = color1;
		color_hex2 = color2;
		return this;
	}

	public Effects setColor1(int color1) {
		color_hex = color1;
		return this;
	}

	public int getColor1() {
		return color_hex;
	}

	public Effects setColor2(int color2) {
		color_hex2 = color2;
		return this;
	}

	public int getColor2() {
		return color_hex2 == 0 ? 0xFFFFFF : color_hex2;
	}

	public Effects setTexture1(String path1) {
		texture = path1;
		return this;
	}

	public String getTexture1() {
		return texture == null ? getName() : texture;
	}

	public Effects setTexture2(String path2) {
		texture2 = path2;
		return this;
	}

	public String getTexture2() {
		return texture2 == null ? getTexture1() : texture2;
	}

	public String toString() {
		return "Effect: " + getTag() + ".";
	}

}
