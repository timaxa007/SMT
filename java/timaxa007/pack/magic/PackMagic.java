package timaxa007.pack.magic;

import timaxa007.pack.magic.packet.RegisterMessage;
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

@Mod (modid = PackMagic.MODID, name = PackMagic.MODNAME, version = PackMagic.VERSION, dependencies = "required-after:timaxa007")

public class PackMagic {

	public static final String MODID = "magicpack";
	public static final String MODNAME = "PackMagic";
	public static final String VERSION = "0.1a";
	public static final String[] AUTHORS = new String[] {"timaxa007"};

	@Instance(PackMagic.MODID) public static PackMagic instance;
	@SidedProxy(modId = PackMagic.MODID, clientSide = "timaxa007.pack.magic.ProxyClient", serverSide = "timaxa007.pack.magic.ProxyCommon")
	public static ProxyCommon proxy;
	public static Logger log;
	public static SimpleNetworkWrapper network;

	public static CreativeTabs tab_magic = new CreativeTabs("tab_magic") {
		public Item getTabIconItem() {
			return PackMagic.proxy.item.items_for_magic;
		}
	};

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		log = event.getModLog();
		log.info("Starting sub-mod " + PackMagic.MODNAME + ".");

		network = NetworkRegistry.INSTANCE.newSimpleChannel(PackMagic.MODID);
		RegisterMessage.init(network);

		proxy.preInit(event);

	}

	@EventHandler
	public void init(FMLInitializationEvent event) {
		proxy.init();
	}

}
