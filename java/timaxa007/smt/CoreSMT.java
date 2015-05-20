package timaxa007.smt;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.world.World;

import org.apache.logging.log4j.Logger;

import timaxa007.gui.HandlerGuiSMT;
import timaxa007.smt.lib.Config;
import timaxa007.smt.lib.ListTextureModel;
import timaxa007.smt.packet.RegisterMessage;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

//dependencies = "required-before:01miningpack;required-before:06weaponpack"
@Mod (modid = CoreSMT.MODID, name = CoreSMT.MODNAME, version = CoreSMT.VERSION)

public class CoreSMT {

	public static final boolean OBFUSCATED = isObfuscated();
	public static final String MODID = "timaxa007";
	public static final String MODNAME = "Project SMT";
	public static final String VERSION = "0.2.7a";
	public static final String PATH_MODULE = "timaxa007.module";
	public static final String PATH_PACK = "timaxa007.pack";
	public static final String[] AUTHORS = new String[] {"timaxa007", "Dragon2488"};

	@Instance(CoreSMT.MODID) public static CoreSMT instance;
	@SidedProxy(modId = CoreSMT.MODID, clientSide = "timaxa007.smt.ProxyClient", serverSide = "timaxa007.smt.ProxyCommon")
	public static ProxyCommon proxy;
	public static Logger log;
	public static SimpleNetworkWrapper network;
	public static Config config;

	public static CreativeTabs tab_smt = new CreativeTabs("tab_smt") {
		@SideOnly(Side.CLIENT) public Item getTabIconItem() {return CoreSMT.item_test;}
	};

	public static Block block_test;
	public static Item item_test;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {

		log = event.getModLog();
		//--------------------------------------------------------------------------------------------
		log.info("Starting core modules.");
		config.module(event);
		//--------------------------------------------------------------------------------------------
		log.info("Starting core " + CoreSMT.MODNAME + ".");
		config.core(event);
		//--------------------------------------------------------------------------------------------
		log.info("Starting core packs.");
		config.pack(event);
		//--------------------------------------------------------------------------------------------
		new ListTextureModel();

		block_test = new TestBlock();
		GameRegistry.registerBlock(block_test, "block_test");

		item_test = new TestItem();
		GameRegistry.registerItem(item_test, "item_test");

		Recipes_SMT.list();

		network = NetworkRegistry.INSTANCE.newSimpleChannel(CoreSMT.MODID);
		RegisterMessage.init(network);

		proxy.preInit();
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {

		NetworkRegistry.INSTANCE.registerGuiHandler(CoreSMT.MODID, new HandlerGuiSMT());

		proxy.init();
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		proxy.postInit();
	}

	private static boolean isObfuscated() {
		try {return !World.class.getName().endsWith("World");}
		catch(Exception e) {return false;}
	}

}