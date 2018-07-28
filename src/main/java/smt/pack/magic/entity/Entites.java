package smt.pack.magic.entity;

import smt.pack.technology.SMTTechnology;
import cpw.mods.fml.common.registry.EntityRegistry;

public final class Entites {

	public static final void init() {
		int id = 0;
		EntityRegistry.registerModEntity(EntitySparkl.class, "EntitySparkl", id++, SMTTechnology.instance, 80, 3, true);
		EntityRegistry.registerModEntity(EntityFireBall.class, "EntityFireBall", id++, SMTTechnology.instance, 80, 3, true);
		EntityRegistry.registerModEntity(EntityMagicChest.class, "EntityMagicChest", id++, SMTTechnology.instance, 80, 3, true);
	}

}
