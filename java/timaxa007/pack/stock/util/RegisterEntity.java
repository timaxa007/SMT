package timaxa007.pack.stock.util;

import net.minecraft.entity.Entity;
import timaxa007.pack.stock.entity.EntityTest;
import timaxa007.smt.CoreSMT;
import cpw.mods.fml.common.registry.EntityRegistry;

public class RegisterEntity {

	private static int id;

	static {
		int id = 0;
	}

	public static void register() {
		registerMale(EntityTest.class, "test");
		registerFemale(EntityTest.class, "test");
	}

	public static void registerMale(Class<? extends Entity> entityClass, String entityName) {
		registerEntity(entityClass, entityName + "_male");
	}

	public static void registerFemale(Class<? extends Entity> entityClass, String entityName) {
		registerEntity(entityClass, entityName + "_female");
	}

	/**WIP**/
	public static void registerEntity(Class<? extends Entity> entityClass, String entityName) {
		//EntityList.addMapping(entityClass, entityName, id, 0x0033FF, 0x00CCFF);
		EntityRegistry.registerModEntity(entityClass, entityName, id++, CoreSMT.instance, 64, 1, true);
		//EntityRegistry.addSpawn
	}

}
