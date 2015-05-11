package timaxa007.tms;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.world.World;

import org.apache.logging.log4j.Logger;

import timaxa007.gui.HandlerGuiTMS;
import timaxa007.tms.lib.ListTextureModel;
import timaxa007.tms.packet.RegisterMessage;
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

//dependencies = "required-before:01miningpack;required-before:02pmfpack;required-before:03furniturepack;required-before:04technopack;required-before:05magicpack;required-before:06weaponpack"
@Mod (modid = CoreTMS.MODID, name = CoreTMS.MODNAME, version = CoreTMS.VERSION)

public class CoreTMS {

	public static final boolean OBFUSCATED = isObfuscated();
	public static final String MODID = "timaxa007";
	public static final String MODNAME = "TMS";
	public static final String VERSION = "0.2a";
	public static final String PATH_MODULE = "timaxa007.module";
	public static final String PATH_PACK = "timaxa007.pack";
	public static final String[] AUTHORS = new String[] {"timaxa007", "Dragon2488"};

	@Instance(CoreTMS.MODID) public static CoreTMS instance;
	@SidedProxy(modId = CoreTMS.MODID, clientSide = "timaxa007.tms.ProxyClient", serverSide = "timaxa007.tms.ProxyCommon")
	public static ProxyCommon proxy;
	public static Logger log;
	public static SimpleNetworkWrapper network;
	public static Config config;

	public static CreativeTabs tab_tms = new CreativeTabs("tab_tms") {
		@SideOnly(Side.CLIENT) public Item getTabIconItem() {return CoreTMS.item_test;}
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
		log.info("Starting core " + CoreTMS.MODNAME + ".");
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

		Recipes_TMS.list();

		network = NetworkRegistry.INSTANCE.newSimpleChannel(CoreTMS.MODID);
		RegisterMessage.init(network);

		proxy.preInit();
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {

		NetworkRegistry.INSTANCE.registerGuiHandler(CoreTMS.MODID, new HandlerGuiTMS());

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