package timaxa007.pack.weapon.util;

import net.minecraft.util.StatCollector;
import timaxa007.smt.util.UtilString;

public class Weapon {

	private String tag;
	private String name;
	private String type;

	private int delay;
	private String[] sound_fire;
	private String[] sound_reload;

	private boolean has_own_clip;
	private Ammo ammo;
	private Clip clip;
	private int max_amount_ammo;

	//private IIcon icon;

	private String model;
	private String texture;
	//----------------------------------
	public Weapon(String tag) {
		this.tag = tag;
		this.delay = 1;
		this.has_own_clip = false;
		this.ammo = null;
		this.clip = null;
		this.max_amount_ammo = 1;
	}

	public Weapon(String tag, Clip clip) {
		this.tag = tag;
		this.delay = 1;
		this.has_own_clip = false;
		this.ammo = null;
		this.clip = clip;
		this.max_amount_ammo = clip.getMaxAmountAmmo();
	}

	public Weapon(String tag, Ammo ammo) {
		this.tag = tag;
		this.delay = 1;
		this.has_own_clip = true;
		this.ammo = ammo;
		this.clip = null;
		this.max_amount_ammo = 1;
	}

	public Weapon(String tag, Ammo ammo, int max_amount_ammo) {
		this.tag = tag;
		this.delay = 1;
		this.has_own_clip = true;
		this.ammo = ammo;
		this.clip = null;
		this.max_amount_ammo = max_amount_ammo;
	}
	//----------------------------------
	public String getTag() {return tag;}

	public Weapon setName(String name) {
		this.name = name;
		return this;
	}

	public String getName() {
		return (UtilString.hasString(name) ? name : (UtilString.hasString(tag) ? getTag() : "unname"));
	}

	public String getLocalizedName() {
		return StatCollector.translateToLocal("weapon." + getName() + ".name");
	}

	public Weapon setType(String type) {
		this.type = type;
		return this;
	}

	public String getType() {
		return UtilString.hasString(type) ? type : "untype";
	}

	public String getLocalizedType() {
		return StatCollector.translateToLocal("type." + getType() + ".name");
	}

	public int getMaxAmountAmmo() {return max_amount_ammo;}

	public Weapon setDelay(int delay) {
		this.delay = delay;
		return this;
	}

	public int getDelay() {
		return delay;
	}

	public Weapon setSoundFire(String[] sound_fire) {
		this.sound_fire = sound_fire;
		return this;
	}

	public Weapon setSoundFire(String sound_fire) {
		this.sound_fire = new String[1];
		this.sound_fire[0] = sound_fire;
		return this;
	}

	public String[] getSoundFire() {
		return sound_fire;
	}

	public Weapon setSoundReload(String[] sound_reload) {
		this.sound_reload = sound_reload;
		return this;
	}

	public Weapon setSoundReload(String sound_reload) {
		this.sound_reload = new String[1];
		this.sound_reload[0] = sound_reload;
		return this;
	}

	public String[] getSoundReload() {
		return sound_reload;
	}

	public String toString() {
		return "Weapon: " + getTag() + ".";
	}

}
