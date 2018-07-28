package smt.pack.technology.entity;

import smt.pack.technology.SMTTechnology;
import cpw.mods.fml.common.registry.EntityRegistry;

public final class Entites {

	public static final void init() {
		int id = 0;
		EntityRegistry.registerModEntity(EntityRobot.class, "EntityRobot", id++, SMTTechnology.instance, 80, 3, true);
		EntityRegistry.registerModEntity(EntityLightningBolt2.class, "EntityLightningBolt2", id++, SMTTechnology.instance, 10, 1, true);
		EntityRegistry.registerModEntity(EntityPlatformDisplacement.class, "EntityPlatformDisplacement", id++, SMTTechnology.instance, 10, 1, true);
		EntityRegistry.registerModEntity(EntityTelephone.class, "EntityTelephone", id++, SMTTechnology.instance, 64, 20, true);
	}

}
