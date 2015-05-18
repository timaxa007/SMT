package timaxa007.pack.weapon.util;

import net.minecraft.util.StatCollector;
import timaxa007.smt.util.UtilString;

public class Clip {

	private String tag;
	private String name;
	private String type;

	//private IIcon icon;

	private Ammo ammo;
	private int max_amount_ammo;

	public Clip(String tag) {
		this.tag = tag;
		this.max_amount_ammo = 0;
	}

	public Clip(String tag, int max_amount) {
		this.tag = tag;
		this.max_amount_ammo = max_amount;
	}

	public String getTag() {return tag;}

	public Clip setName(String name) {
		this.name = name;
		return this;
	}

	public String getName() {
		return (UtilString.hasString(name) ? name : (UtilString.hasString(tag) ? getTag() : "unname"));
	}

	public String getLocalizedName() {
		return StatCollector.translateToLocal("clip." + getName() + ".name");
	}

	public Clip setType(String type) {
		this.type = type;
		return this;
	}

	public String getType() {
		return UtilString.hasString(type) ? type : "untype";
	}

	public String getLocalizedType() {
		return StatCollector.translateToLocal("type." + getType() + ".name");
	}

	public Clip setAmmo(Ammo ammo) {
		this.ammo = ammo;
		return this;
	}

	public Ammo getAmmo() {return ammo;}

	public Clip setMaxAmountAmmo(int max_amount) {
		this.max_amount_ammo = max_amount;
		return this;
	}

	public int getMaxAmountAmmo() {return max_amount_ammo;}

	public String toString() {
		return "Clip: " + getTag() + ".";
	}

}
