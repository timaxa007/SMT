package smt.pack.vehicle.entity;

import cpw.mods.fml.common.registry.EntityRegistry;
import smt.pack.vehicle.SMTVehicle;

public final class Entites {

	public static final void init() {
		int id = 0;
		EntityRegistry.registerModEntity(EntityVehicle.class, "EntityVehicle", id++, SMTVehicle.instance, 80, 3, true);
		EntityRegistry.registerModEntity(VehiclePartEntity.class, "VehiclePartEntity", id++, SMTVehicle.instance, 80, 3, true);
	}

}
