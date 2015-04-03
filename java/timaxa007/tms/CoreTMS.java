package timaxa007.tms;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraftforge.common.config.Configuration;

import org.apache.logging.log4j.Logger;

import timaxa007.tms.lib.ListTextureModel;
import timaxa007.tms.packet.RegisterMessage;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

//@Mod (modid = ModInfo.MODID, name = ModInfo.MODNAME, version = ModInfo.VERSION, dependencies = "required-before:01miningpack;required-before:02pmfpack;required-before:03furniturepack;required-before:04technopack;required-before:05magicpack;required-before:06weaponpack")
@Mod (modid = CoreTMS.MODID, name = CoreTMS.MODNAME, version = CoreTMS.VERSION)

public class CoreTMS {

	public static final boolean OBFUSCATED = isObfuscated();
	public static final String MODID = "timaxa007";
	public static final String MODNAME = "TMS";
	public static final String VERSION = "0.2a";
	public static final String[] AUTHORS = new String[] {"timaxa007", "Dragon2488"};

	@Instance(CoreTMS.MODID) public static CoreTMS instance;
	@SidedProxy(modId = CoreTMS.MODID, clientSide = "timaxa007.tms.ProxyClient", serverSide = "timaxa007.tms.ProxyCommon")
	public static ProxyCommon proxy;
	public static Logger log;
	public static SimpleNetworkWrapper network;

	public static CreativeTabs tab_tms = new CreativeTabs("tab_tms") {
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {return CoreTMS.item_test;}
	};

	public static boolean debug;
	public static boolean show_tip_info_testing;
	public static boolean show_system_info_testing;

	public static Block block_test;
	public static Item item_test;

	private static Configuration currectConfig;

	@EventHandler
	public void preInitialize(FMLPreInitializationEvent event) {

		log = event.getModLog();
		log.info("Starting core " + CoreTMS.MODNAME + ".");

		currectConfig = new Configuration(event.getSuggestedConfigurationFile());
		syncConfig(currectConfig);

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

	@EventHandler
	public void initialize(FMLInitializationEvent event) {
		proxy.init();
	}

	private static boolean isObfuscated() {
		try {
			return !World.class.getName().endsWith("World");
		} catch(Exception e) {
			return false;
		}
	}

	private static void syncConfig(Configuration config) {
		config.load();

		debug = config.get("debugging", "debug", false).getBoolean(false);
		show_tip_info_testing = config.get("debugging", "show_tip_info_testing", false).getBoolean(false);
		show_system_info_testing = config.get("debugging", "show_system_info_testing", false).getBoolean(false);

		config.save();
	}

}