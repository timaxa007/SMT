package timaxa007.pack.techno;

import timaxa007.pack.techno.packet.RegisterMessage;
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

@Mod (modid = PackTechno.MODID, name = PackTechno.MODNAME, version = PackTechno.VERSION, dependencies = "required-after:timaxa007")

public class PackTechno {

	public static final String MODID = "technopack";
	public static final String MODNAME = "PackTechno";
	public static final String VERSION = "0.1a";
	public static final String[] AUTHORS = new String[] {"timaxa007"};

	@Instance(PackTechno.MODID) public static PackTechno instance;
	@SidedProxy(modId = PackTechno.MODID, clientSide = "timaxa007.pack.techno.ProxyClient", serverSide = "timaxa007.pack.techno.ProxyCommon")
	public static ProxyCommon proxy;
	public static Logger log;
	public static SimpleNetworkWrapper network;

	public static CreativeTabs tab_techno = new CreativeTabs("tab_techno") {
		public Item getTabIconItem() {
			return PackTechno.proxy.item.items_for_techno;
		}
	};

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		log = event.getModLog();
		log.info("Starting sub-mod " + PackTechno.MODNAME + ".");

		network = NetworkRegistry.INSTANCE.newSimpleChannel(PackTechno.MODID);
		RegisterMessage.init(network);

		proxy.preInit(event);

	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init();
	}

}
