package timaxa007.module.weight;

import net.minecraft.item.Item;

import org.apache.logging.log4j.Logger;

import timaxa007.module.api.IModuleClass;
import timaxa007.module.weight.util.ItemUpgradeWeight;
import timaxa007.module.weight.util.MessageWeight;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;

public class NodeWeight implements IModuleClass {

	public static final String MODID = "weight";
	public static final String MODNAME = "SystemWeight";
	public static final String VERSION = "0.2a";
	public static final String[] AUTHORS = new String[] {"timaxa007"};

	public static Logger log;
	public static SimpleNetworkWrapper network;

	public static Item upgradeWeight;

	public void preInit(FMLPreInitializationEvent event) {

		log = event.getModLog();
		log.info("Starting module " + NodeWeight.MODNAME + ", version: " + NodeWeight.VERSION + ".");

		upgradeWeight = new ItemUpgradeWeight();
		GameRegistry.registerItem(upgradeWeight, "ItemUpgradeWeight");

		network = NetworkRegistry.INSTANCE.newSimpleChannel(NodeWeight.MODID);
		network.registerMessage(MessageWeight.Handler.class, MessageWeight.class, 0, Side.CLIENT);

	}

}
