package smt.pack.entity.entity;

import cpw.mods.fml.common.registry.EntityRegistry;
import smt.pack.entity.SMTEntity;

public final class Entites {

	public static final void init() {
		int id = 0;
		EntityRegistry.registerModEntity(EntityZombie.class, "EntityZombieSMT", id++, SMTEntity.instance, 80, 3, true);
	}

}
