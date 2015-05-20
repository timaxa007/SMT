package timaxa007.pack.stock.util;

import net.minecraft.entity.Entity;
import timaxa007.pack.stock.entity.EntityTest;
import timaxa007.smt.CoreSMT;
import cpw.mods.fml.common.registry.EntityRegistry;

public class RegisterLivingEntity {
	
	private static int id = 0;

	public static void registerMale() {
		registerEntity(EntityTest.class, "test");
	}

	public static void registerFemale() {

	}

	/**WIP**/
	public static void registerEntity(Class<? extends Entity> entityClass, String entityName) {
		//EntityList.addMapping(entityClass, entityName, id, 0x0033FF, 0x00CCFF);
		EntityRegistry.registerModEntity(entityClass, entityName, id++, CoreSMT.instance, 64, 1, true);
	}

}
