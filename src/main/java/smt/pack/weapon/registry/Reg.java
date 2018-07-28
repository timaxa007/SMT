package smt.pack.weapon.registry;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.entity.player.EntityPlayer;
import smt.pack.weapon.registry.reloading.DefaultReloading;
import smt.pack.weapon.registry.reloading.ReloadingDummy;
import smt.pack.weapon.registry.shooting.CollectingShooting;
import smt.pack.weapon.registry.shooting.DefaultShooting;
import smt.pack.weapon.registry.shooting.ShootingDummy;

public final class Reg {

	public static final HashMap<String, Bullet> bullets = new HashMap<String, Bullet>();
	public static final HashMap<String, Magazine> magazines = new HashMap<String, Magazine>();
	public static final HashMap<String, Weapon> weapons = new HashMap<String, Weapon>();

	public static String getBulletID(Bullet bullet) {
		for (Map.Entry<String, Bullet> entry : bullets.entrySet())
			if (entry.getValue() == bullet) return entry.getKey();
		return null;
	}

	public static String getMagazineID(Magazine magazine) {
		for (Map.Entry<String, Magazine> entry : magazines.entrySet())
			if (entry.getValue() == magazine) return entry.getKey();
		return null;
	}

	public static String getWeaponID(Weapon weapon) {
		for (Map.Entry<String, Weapon> entry : weapons.entrySet())
			if (entry.getValue() == weapon) return entry.getKey();
		return null;
	}
	public static ShootingDummy getShooting(final String id, final WeaponSystem wpn_sys, final EntityPlayer player) {
		if ("collecting".equalsIgnoreCase(id)) return new CollectingShooting(wpn_sys, player);
		return new DefaultShooting(wpn_sys, player);
	}

	public static ReloadingDummy getReloading(final String id, final WeaponSystem wpn_sys, final EntityPlayer player,
			final int slotID, final int delay_reload) {
		return new DefaultReloading(wpn_sys, player, slotID, delay_reload);
	}
	/*
	public static ShootingDummy instanseShooting(final WeaponSystem wpn_sys, final EntityPlayer player, final String id) {
		Class<? extends ShootingDummy> clazz = null;

		if (clazz == null) return null;
		try {
			//Да... Эм, я кажеться не совсем понимаю, что я хочу сделать.
			return (ShootingDummy)clazz
					.getConstructor(new Class[] {WeaponSystem.class, EntityPlayer.class})
					.newInstance(new Object[] {wpn_sys, player});
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | NoSuchMethodException | SecurityException e) {e.printStackTrace();}
		return null;
	}

	public static ReloadingDummy instanseReloading(final WeaponSystem wpn_sys, final EntityPlayer player,
			final String id, final int slotID, final int delay_reload) {
		Class<? extends ReloadingDummy> clazz = reloadings.get(id);
		if (clazz == null) return null;
		try {
			//Да... Эм, я кажеться не совсем понимаю, что я хочу сделать.
			return (ReloadingDummy)clazz
					.getConstructor(new Class[] {WeaponSystem.class, EntityPlayer.class, int.class, int.class})
					.newInstance(new Object[] {wpn_sys, player, slotID, delay_reload});
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | NoSuchMethodException | SecurityException e) {e.printStackTrace();}
		return null;
	}
	 */
	/*
	Weapon.AK27("ak27"),
	Weapon.EMPTY("");

	Magazine.BULLET27("bullet27", "bullet27"),
	Magazine.EMPTY("", "");

	Ammo.BULLET27("bullet27"),
	Ammo.EMPTY("");
	 */
}
