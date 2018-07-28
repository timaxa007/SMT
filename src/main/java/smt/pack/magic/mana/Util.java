package smt.pack.magic.mana;

import net.minecraft.entity.Entity;

public class Util {

	public static void regManaEntity(Entity entity) {
		if (entity.worldObj.isRemote)
			entity.registerExtendedProperties(ManaEntity.TAG, new ManaEntity());
		else
			entity.registerExtendedProperties(ManaEntityServer.TAG, new ManaEntityServer());
	}

	public static ManaEntity getManaEntity(Entity entity) {
		return entity.worldObj.isRemote ?
				(ManaEntity)entity.getExtendedProperties(ManaEntity.TAG) :
				(ManaEntityServer)entity.getExtendedProperties(ManaEntityServer.TAG);
	}

}
