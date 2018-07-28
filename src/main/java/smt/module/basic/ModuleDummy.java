package smt.module.basic;

public class ModuleDummy implements IModule {

	@Override
	public String getNameModule() {
		return net.minecraft.util.StatCollector.translateToLocal("module.dummy");
	}

	@Override
	public void preInit(cpw.mods.fml.common.event.FMLPreInitializationEvent event) {

	}

	@Override
	public void init() {

	}

	@Override
	public void postInit() {

	}

	@Override
	public void serverStart(cpw.mods.fml.common.event.FMLServerStartingEvent event) {

	}

}
