package smt.pack.common.entity;

import smt.pack.common.SMTCommon;
import cpw.mods.fml.common.registry.EntityRegistry;

public final class Entites {

	public static final void init() {
		int id = 0;
		EntityRegistry.registerModEntity(EntityCorpse.class, "EntityCorpse", id++, SMTCommon.instance, 80, 3, true);
	}

}
