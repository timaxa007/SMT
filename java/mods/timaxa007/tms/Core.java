package mods.timaxa007.tms;

import mods.timaxa007.tms.lib.ListTextureModel;
import mods.timaxa007.tms.packet.RegisterMessage;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraftforge.common.config.Configuration;

import org.apache.logging.log4j.Logger;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.GameRegistry;

//@Mod (modid = ModInfo.MODID, name = ModInfo.MODNAME, version = ModInfo.VERSION, dependencies = "required-before:01miningpack;required-before:02pmfpack;required-before:03furniturepack;required-before:04technopack;required-before:05magicpack;required-before:06weaponpack")
@Mod (modid = Core.MODID, name = Core.MODNAME, version = Core.VERSION)

public class Core {

	public static final boolean OBFUSCATED = isObfuscated();
	public static final String MODID = "timaxa007";
	public static final String MODNAME = "TMS";
	public static final String VERSION = "0.2a";
	public static final String[] AUTHORS = new String[] {"timaxa007", "Dragon2488"};

	@Instance(Core.MODID) public static Core instance;
	@SidedProxy(modId = Core.MODID, clientSide = "mods.timaxa007.tms.ProxyClient", serverSide = "mods.timaxa007.tms.ProxyCommon")
	public static ProxyCommon proxy;
	public static Logger log;
	public static SimpleNetworkWrapper network;

	public static CreativeTabs tab_tms = new CreativeTabs("tab_tms") {
		public Item getTabIconItem() {
			return Core.item_test;
		}
	};

	public static boolean debug;
	public static boolean show_tip_info_testing;
	public static boolean show_system_info_testing;
	public static boolean disable_sub_mod_furniture;
	public static boolean disable_sub_mod_magic;
	public static boolean disable_sub_mod_mining;
	public static boolean disable_sub_mod_stock;
	public static boolean disable_sub_mod_techno;
	public static boolean disable_sub_mod_weapon;

	public static Block block_test;
	public static Item item_test;

	private static Configuration currectConfig;

	@EventHandler
	public void preInitialize(FMLPreInitializationEvent event) {

		log = event.getModLog();
		log.info("Starting core " + Core.MODNAME + ".");

		currectConfig = new Configuration(event.getSuggestedConfigurationFile());
		syncConfig(currectConfig);

		new ListTextureModel();

		block_test = new TestBlock();
		GameRegistry.registerBlock(block_test, "block_test");

		item_test = new TestItem();
		GameRegistry.registerItem(item_test, "item_test");

		Recipes_TMS.list();

		network = NetworkRegistry.INSTANCE.newSimpleChannel(Core.MODID);
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

		disable_sub_mod_furniture = config.get("configs", "disable_sub_mod_furniture", false).getBoolean(false);
		disable_sub_mod_magic = config.get("configs", "disable_sub_mod_magic", false).getBoolean(false);
		disable_sub_mod_mining = config.get("configs", "disable_sub_mod_mining", false).getBoolean(false);
		disable_sub_mod_stock = config.get("configs", "disable_sub_mod_stock", false).getBoolean(false);
		disable_sub_mod_techno = config.get("configs", "disable_sub_mod_techno", false).getBoolean(false);
		disable_sub_mod_weapon = config.get("configs", "disable_sub_mod_weapon", false).getBoolean(false);

		config.save();
	}

}