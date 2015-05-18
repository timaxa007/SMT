package timaxa007.pack.weapon.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import timaxa007.smt.util.UtilString;

public class RegistryWeapons {
	//-------------------------------------------------------------------------------------------
	public static class RegistryWeapon {

		private static HashMap<String, Weapon> weapon_map = new HashMap<String, Weapon>();

		public static final String[] weapon_type = new String[] {
			"pistol", 
			"shotgun", 
			"avtomat", 
			"pulemet", 
			"sniper"
		};

		public static final Weapon EMPTY = new Weapon("empty");

		static {
			RegistryWeapons.RegistryWeapon.registerWeapon(EMPTY);
		}

		public static void registerWeapon(Weapon[] weapons) {
			for (Weapon weapon : weapons) if (weapon != null) registerWeapon(weapon);
		}

		public static void registerWeapon(Weapon weapon) {
			if (weapon != null && UtilString.hasString(weapon.getTag()))
				if (weapon_map.get(weapon.getTag()) == null)
					weapon_map.put(weapon.getTag(), weapon);
				else throw new IllegalArgumentException("Duplicate " + weapon);
			else throw new IllegalArgumentException("Error " + weapon);
		}

		public static Weapon getWeapon(String tag) {
			return (weapon_map.get(tag) != null ? weapon_map.get(tag) : EMPTY);
		}

		public static List getTagWeapons() {
			//List list = Lists.newArrayList();
			ArrayList<String> list = new ArrayList<String>();
			for (Entry<String, Weapon> entry : weapon_map.entrySet())
				list.add(entry.getKey().toString());
			return list;
		}

		public static boolean hasWeapon(Weapon weapon) {
			return !(weapon == null || weapon == EMPTY);
		}

		public static boolean hasWeapon(String tag) {
			return UtilString.hasString(tag) && hasWeapon(RegistryWeapon.getWeapon(tag));
		}

	}
	//-------------------------------------------------------------------------------------------
	public static class RegistryClip {

		private static HashMap<String, Clip> clip_map = new HashMap<String, Clip>();

		public static final Clip EMPTY = new Clip("empty");

		static {
			RegistryWeapons.RegistryClip.registerClip(EMPTY);
		}

		public static void registerWeapon(Clip[] clips) {
			for (Clip clip : clips) if (clip != null) registerClip(clip);
		}

		public static void registerClip(Clip clip) {
			if (clip != null && UtilString.hasString(clip.getTag()))
				if (clip_map.get(clip.getTag()) == null)
					clip_map.put(clip.getTag(), clip);
				else throw new IllegalArgumentException("Duplicate " + clip);
			else throw new IllegalArgumentException("Error " + clip);
		}

		public static Clip getClip(String tag) {
			return (clip_map.get(tag) != null ? clip_map.get(tag) : EMPTY);
		}

		public static List getTagClips() {
			//List list = Lists.newArrayList();
			ArrayList<String> list = new ArrayList<String>();
			for (Entry<String, Clip> entry : clip_map.entrySet())
				list.add(entry.getKey().toString());
			return list;
		}

		public static boolean hasClip(Clip clip) {
			return !(clip == null || clip == EMPTY);
		}

		public static boolean hasClip(String tag) {
			return UtilString.hasString(tag) && hasClip(RegistryClip.getClip(tag));
		}

	}
	//-------------------------------------------------------------------------------------------
	public static class RegistryAmmo {

		private static HashMap<String, Ammo> ammo_map = new HashMap<String, Ammo>();

		public static final Ammo EMPTY = new Ammo("empty");

		static {
			RegistryWeapons.RegistryAmmo.registerAmmo(EMPTY);
		}

		public static void registerWeapon(Ammo[] ammos) {
			for (Ammo ammo : ammos) if (ammo != null) registerAmmo(ammo);
		}

		public static void registerAmmo(Ammo ammo) {
			if (ammo != null && UtilString.hasString(ammo.getTag()))
				if (ammo_map.get(ammo.getTag()) == null)
					ammo_map.put(ammo.getTag(), ammo);
				else throw new IllegalArgumentException("Duplicate " + ammo);
			else throw new IllegalArgumentException("Error " + ammo);
		}

		public static Ammo getAmmo(String tag) {
			return (ammo_map.get(tag) != null ? ammo_map.get(tag) : EMPTY);
		}

		public static List getTagAmmo() {
			//List list = Lists.newArrayList();
			ArrayList<String> list = new ArrayList<String>();
			for (Entry<String, Ammo> entry : ammo_map.entrySet())
				list.add(entry.getKey().toString());
			return list;
		}

		public static boolean hasAmmo(Ammo ammo) {
			return !(ammo == null || ammo == EMPTY);
		}

		public static boolean hasAmmo(String tag) {
			return UtilString.hasString(tag) && hasAmmo(RegistryAmmo.getAmmo(tag));
		}

	}
	//-------------------------------------------------------------------------------------------
}
