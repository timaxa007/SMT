package mods.timaxa007.pack.mining;

import mods.timaxa007.pack.mining.packet.RegisterMessage;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;

@Mod (modid = PackMining.MODID, name = PackMining.MODNAME, version = PackMining.VERSION, dependencies = "required-after:timaxa007")

public class PackMining {

	public static final String MODID = "miningpack";
	public static final String MODNAME = "PackMining";
	public static final String VERSION = "0.1a";
	public static final String AUTHOR = "timaxa007";

	@Instance(PackMining.MODID) public static PackMining instance;
	@SidedProxy(modId = PackMining.MODID, clientSide = "mods.timaxa007.pack.mining.ProxyClient", serverSide = "mods.timaxa007.pack.mining.ProxyCommon")
	public static ProxyCommon proxy;
	public static Logger log;
	public static SimpleNetworkWrapper network;

	public static CreativeTabs tab_mining = new CreativeTabs("tab_mining") {
		public Item getTabIconItem() {
			return PackMining.proxy.item.items_for_mining;
		}
	};
	public static CreativeTabs tab_tools = new CreativeTabs("tab_tools") {
		public Item getTabIconItem() {
			return PackMining.proxy.item.items_for_mining;
		}
	};

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		log = event.getModLog();
		log.info("Starting sub-mod " + PackMining.MODNAME + ".");

		network = NetworkRegistry.INSTANCE.newSimpleChannel(PackMining.MODID);
		RegisterMessage.init(network);

		proxy.preInit(event);

	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init();

	}

}
