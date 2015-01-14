package mods.timaxa007.pack.item;

import mods.timaxa007.pack.item.packet.RegisterPacket;
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

@Mod (modid = PackItems.MODID, name = PackItems.MODNAME, version = PackItems.VERSION, dependencies = "required-after:timaxa007")

public class PackItems {

	public static final String MODID = "itemspack";
	public static final String MODNAME = "PackItems";
	public static final String VERSION = "0.1a";
	public static final String AUTHOR = "timaxa007";

	@Instance(PackItems.MODID) public static PackItems instance;
	@SidedProxy(modId = PackItems.MODID, clientSide = "mods.timaxa007.pack.item.ProxyClient", serverSide = "mods.timaxa007.pack.item.ProxyCommon")
	public static ProxyCommon proxy;
	public static Logger log;
	public static SimpleNetworkWrapper network;

	public static CreativeTabs tab_items = new CreativeTabs("tab_items") {
		public Item getTabIconItem() {
			return PackItems.proxy.item.items_for_items;
		}
	};

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		log = event.getModLog();
		log.info("Startimg sub-mod " + PackItems.MODNAME + ".");

		network = NetworkRegistry.INSTANCE.newSimpleChannel(PackItems.MODID);
		RegisterPacket.init(network);

		proxy.preInit(event);

	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init();
	}

}
