package smt.module.basic;

import net.minecraft.util.StatCollector;
import smt.module.ListModules;

import com.google.common.collect.Lists;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.ModMetadata;

@Mod(modid = SMTBasicModule.MODID, name = SMTBasicModule.NAME, version = SMTBasicModule.VERSION, useMetadata = true)
public class SMTBasicModule {

	public static final String
	MODID = "smt_basic_module",
	NAME = "SMT: BasicModule",
	VERSION = "0.001";

	@Mod.Instance(MODID) public static SMTBasicModule instance;

	@Mod.EventHandler
	public void preInit(cpw.mods.fml.common.event.FMLPreInitializationEvent event) {
		ListModules.init();
		ModuleLoader.preInit(event);
		applyMetadata(event.getModMetadata());
	}

	@Mod.EventHandler
	public void preInit(cpw.mods.fml.common.event.FMLInitializationEvent event) {
		ModuleLoader.init();
	}

	@Mod.EventHandler
	public void preInit(cpw.mods.fml.common.event.FMLPostInitializationEvent event) {
		ModuleLoader.postInit();
	}

	@Mod.EventHandler
	public void serverStart(cpw.mods.fml.common.event.FMLServerStartingEvent event) {
		ModuleLoader.serverStart(event);
	}

	public void applyMetadata(ModMetadata meta) {
		meta.authorList = Lists.newArrayList("timaxa007");
		String description = "SMT: BasicModule.\n";
		java.util.List<String> list = ModuleLoader.getListNameModules();
		if (list != null) {
			description += "\n";
			description += StatCollector.translateToLocal("loaded.modules") + ":\n";
			for (String dsc : list) description += dsc + "\n";
			description += "\n";
		}
		meta.description = description;
		meta.logoFile = "/smt_basic_module_logo.png";
		meta.autogenerated = false;
	}

}
