package smt.module.basic;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class ModuleLoader {

	static List<String> list = new ArrayList<String>();
	static Map<String, String> map_config = new HashMap<String, String>();
	static Map<Class<? extends IModule>, IModule> map = new HashMap<Class<? extends IModule>, IModule>();

	static {
		//registerModule("smt.pack.basic.ModuleDummy");
		/*
		registerModule("smt.pack.basic.TestModule");
		registerModule("smt.pack.basic.TestModule");
		registerModule("smt.pack.basic.TestModule2");
		registerModule("smt.pack.basic.TestModule3");
		registerModule("smt.pack.bas.TestModule");
		 */
	}

	public static void preInit(cpw.mods.fml.common.event.FMLPreInitializationEvent event) {
		Configuration config = new Configuration(new File(event.getModConfigurationDirectory(), "/smt/Module.cfg"));
		config.load();

		String category = "modules";

		for (Map.Entry<String, Property> entry : config.getCategory(category).entrySet())
			map_config.put(entry.getKey(), entry.getValue().getString());

		for (IModule module : map.values()) {
			if (!map_config.isEmpty()) {
				String clasz = map_config.get(module.getClass().getName());
				if (clasz != null && clasz.equals("disable")) continue;
			}
			config.get(category, module.getClass().getName(), "enable");
			module.preInit(event);
		}

		config.save();

	}

	public static final void init() {
		for (IModule module : map.values()) {
			if (!map_config.isEmpty()) {
				String clasz = map_config.get(module.getClass().getName());
				if (clasz != null && clasz.equals("disable")) continue;
			}
			module.init();
		}
	}

	public static void postInit() {
		for (IModule module : map.values()) {
			if (!map_config.isEmpty()) {
				String clasz = map_config.get(module.getClass().getName());
				if (clasz != null && clasz.equals("disable")) continue;
			}
			module.postInit();
		}
	}

	public static void serverStart(cpw.mods.fml.common.event.FMLServerStartingEvent event) {
		for (IModule module : map.values()) {
			if (!map_config.isEmpty()) {
				String clasz = map_config.get(module.getClass().getName());
				if (clasz != null && clasz.equals("disable")) continue;
			}
			module.serverStart(event);
		}
	}

	public static void registerModule(String name_class) {
		if (list.contains(name_class)) {
			System.out.println(" ! " + name_class);
			return;
		}
		try {
			Class clazz = Class.forName(name_class);
			System.out.println(" + " + name_class);
			try {
				IModule module = (IModule)clazz.newInstance();
				list.add(name_class);
				map.put(clazz, module);
				return;
			}
			catch (InstantiationException e) {e.printStackTrace();}
			catch (IllegalAccessException e) {e.printStackTrace();}
		} catch (ClassNotFoundException e) {e.printStackTrace();}
	}

	public static boolean hasModule(String name_class) {
		if (list.contains(name_class)) return true;
		return false;
	}

	public static List<String> getListNameModules() {
		List<String> list = null;
		if (!map.isEmpty()) {
			list = new ArrayList<String>();
			for (IModule module : map.values())
				list.add(module.getNameModule());
		}
		return list;
	}

}
