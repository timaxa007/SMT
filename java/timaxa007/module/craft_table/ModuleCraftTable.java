package timaxa007.module.craft_table;

import timaxa007.module.api.IModuleSMT;

public class ModuleCraftTable implements IModuleSMT {
	//-----------------------------------------------------------------------------------------------
	public static final String MODULE_TAG = "craft_table";
	public static final String VERSION = "0.001";
	//-----------------------------------------------------------------------------------------------
	public static final cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper network = 
			cpw.mods.fml.common.network.NetworkRegistry.INSTANCE.newSimpleChannel(MODULE_TAG);
	//-----------------------------------------------------------------------------------------------
	@Override
	public void preInit(cpw.mods.fml.common.event.FMLPreInitializationEvent event) {
		timaxa007.module.craft_table.packet.RegisterMessage.init(network);
	}
	//-----------------------------------------------------------------------------------------------
}
