package timaxa007.pack.weapon.util;

import net.minecraft.util.StatCollector;
import timaxa007.smt.util.UtilString;

public class Ammo {

	private String tag;
	private String name;
	private String type;

	//private IIcon icon;

	public Ammo(String tag) {
		this.tag = tag;
	}

	public String getTag() {return tag;}

	public Ammo setName(String name) {
		this.name = name;
		return this;
	}

	public String getName() {
		return (UtilString.hasString(name) ? name : (UtilString.hasString(tag) ? getTag() : "unname"));
	}

	public String getLocalizedName() {
		return StatCollector.translateToLocal("ammo." + getName() + ".name");
	}

	public Ammo setType(String type) {
		this.type = type;
		return this;
	}

	public String getType() {
		return UtilString.hasString(type) ? type : "untype";
	}

	public String getLocalizedType() {
		return StatCollector.translateToLocal("type." + getType() + ".name");
	}

	public String toString() {
		return "Ammo: " + getTag() + ".";
	}

}
