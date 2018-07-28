package smt.pack.decorative.entity;

import smt.pack.decorative.SMTDecorative;
import cpw.mods.fml.common.registry.EntityRegistry;

public final class Entites {

	public static final void init() {
		int id = 0;
		EntityRegistry.registerModEntity(EntitySit.class, "EntitySit", id++, SMTDecorative.instance, 80, 3, true);
		EntityRegistry.registerModEntity(EntityPogoStick.class, "EntityPogoStick", id++, SMTDecorative.instance, 80, 3, true);
	}

}
