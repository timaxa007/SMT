package timaxa007.smt;

import net.minecraft.world.World;

import org.apache.logging.log4j.Logger;

import timaxa007.gui.HandlerGui;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;

//dependencies = "required-before:01miningpack;required-before:06weaponpack"
@Mod(modid = CoreSMT.MODID, name = CoreSMT.MODNAME, version = CoreSMT.VERSION)

public class CoreSMT {

	public static final boolean OBFUSCATED = isObfuscated();
	public static final String MODID = "timaxa007";
	public static final String MODNAME = "Project SMT";
	public static final String VERSION = "0.3.0a";
	public static final String PATH_MODULE = "timaxa007.module";
	public static final String PATH_PACK = "timaxa007.pack";
	public static final String[] AUTHORS = new String[] {"timaxa007", "Dragon2488"};

	@Mod.Instance(CoreSMT.MODID) public static CoreSMT instance;
	@SidedProxy(modId = CoreSMT.MODID, clientSide = "timaxa007.smt.ProxyClient", serverSide = "timaxa007.smt.ProxyCommon")
	public static ProxyCommon proxy;
	public static Logger log;
	public static Config config;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		//--------------------------------------------------
		log = event.getModLog();
		//--------------------------------------------------
		log.info("Starting core " + CoreSMT.MODNAME + ".");
		config.core(event);
		//--------------------------------------------------
		log.info("Loading core modules.");
		config.module(event);
		//--------------------------------------------------
		log.info("Loading core packs.");
		config.pack(event);
		//--------------------------------------------------
		proxy.preInit();
		//--------------------------------------------------
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {proxy.init();}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {proxy.postInit();}

	private static boolean isObfuscated() {
		try {return !World.class.getName().endsWith("World");}catch(Exception e){return false;}
	}

}