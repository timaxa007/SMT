package smt.module.craft;

import cpw.mods.fml.relauncher.Side;

public class ModuleCraft implements smt.module.basic.IModule {

	public static final String TAG = "smt_craft";
	public static cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper network;

	@Override
	public String getNameModule() {
		return net.minecraft.util.StatCollector.translateToLocal("module.craft");
	}

	@Override
	public void preInit(cpw.mods.fml.common.event.FMLPreInitializationEvent event) {
		network = cpw.mods.fml.common.network.NetworkRegistry.INSTANCE.newSimpleChannel(TAG);
		int id = 0;
		network.registerMessage(MessageOpenGui.Handler.class, MessageOpenGui.class, id, Side.SERVER);
		network.registerMessage(MessageOpenGui.Handler.class, MessageOpenGui.class, id++, Side.CLIENT);
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
