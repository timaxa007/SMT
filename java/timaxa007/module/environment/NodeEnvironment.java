package timaxa007.module.environment;

import net.minecraft.item.Item;

import org.apache.logging.log4j.Logger;

import timaxa007.module.api.IModuleClass;
import timaxa007.module.environment.util.ItemEnvironment;
import timaxa007.module.environment.util.MessageEnvironment;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;

public class NodeEnvironment implements IModuleClass {

	public static final String MODID = "environment";
	public static final String MODNAME = "Environment";
	public static final String VERSION = "0.2a";
	public static final String[] AUTHORS = new String[] {"timaxa007"};

	public static Logger log;
	public static SimpleNetworkWrapper network;

	public static Item upgradeWeight;

	public void preInit(FMLPreInitializationEvent event) {

		log = event.getModLog();
		log.info("Starting module " + NodeEnvironment.MODNAME + ", version: " + NodeEnvironment.VERSION + ".");

		upgradeWeight = new ItemEnvironment();
		GameRegistry.registerItem(upgradeWeight, "ItemEnvironment");

		network = NetworkRegistry.INSTANCE.newSimpleChannel(NodeEnvironment.MODID);
		network.registerMessage(MessageEnvironment.Handler.class, MessageEnvironment.class, 0, Side.CLIENT);

	}

}
