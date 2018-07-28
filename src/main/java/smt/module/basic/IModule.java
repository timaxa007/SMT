package smt.module.basic;

public interface IModule {

	String getNameModule();
	void preInit(cpw.mods.fml.common.event.FMLPreInitializationEvent event);
	void init();
	void postInit();
	void serverStart(cpw.mods.fml.common.event.FMLServerStartingEvent event);

}
