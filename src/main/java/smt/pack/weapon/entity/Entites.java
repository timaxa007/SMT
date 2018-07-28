package smt.pack.weapon.entity;

import smt.pack.weapon.SMTWeapon;
import cpw.mods.fml.common.registry.EntityRegistry;

public final class Entites {

	public static final void init() {
		int id = 0;
		EntityRegistry.registerModEntity(EntityBullet.class, "EntityBullet", id++, SMTWeapon.instance, 120, 20, true);
		EntityRegistry.registerModEntity(EntityBlast.class, "EntityBlast", id++, SMTWeapon.instance, 120, 20, true);
		EntityRegistry.registerModEntity(EntityBall.class, "EntityBall", id++, SMTWeapon.instance, 80, 3, true);
		EntityRegistry.registerModEntity(EntityWeapon.class, "EntityWeapon", id++, SMTWeapon.instance, 80, 3, true);
		EntityRegistry.registerModEntity(EntityGrenade.class, "EntityGrenade", id++, SMTWeapon.instance, 80, 3, true);
	}

}
