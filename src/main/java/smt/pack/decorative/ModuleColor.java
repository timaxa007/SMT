package smt.pack.decorative;

public class ModuleColor implements smt.module.basic.IModule {

	@Override
	public String getNameModule() {
		return "Module Color";
	}

	@Override
	public void preInit(cpw.mods.fml.common.event.FMLPreInitializationEvent event) {
		System.out.println("000preInit");
	}

	@Override
	public void init() {
		System.out.println("000init");
	}

	@Override
	public void postInit() {
		System.out.println("000postInit");
	}

	@Override
	public void serverStart(cpw.mods.fml.common.event.FMLServerStartingEvent event) {
		System.out.println("000serverStart");
	}

}
