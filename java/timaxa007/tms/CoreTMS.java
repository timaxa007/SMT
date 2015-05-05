package timaxa007.tms;

import java.io.File;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.world.World;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

import org.apache.logging.log4j.Logger;

import timaxa007.api.IModuleClass;
import timaxa007.api.IPackClass;
import timaxa007.gui.HandlerGuiTMS;
import timaxa007.tms.lib.ListTextureModel;
import timaxa007.tms.packet.RegisterMessage;
import cpw.mods.fml.common.Mod;
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
	public static final String PATH_MODULE = "timaxa007.module";
	public static final String PATH_PACK = "timaxa007.pack";
	public static final String[] AUTHORS = new String[] {"timaxa007", "Dragon2488"};

	@Instance(CoreTMS.MODID) public static CoreTMS instance;
	@SidedProxy(modId = CoreTMS.MODID, clientSide = "timaxa007.tms.ProxyClient", serverSide = "timaxa007.tms.ProxyCommon")
	public static ProxyCommon proxy;
	public static Logger log;
	public static SimpleNetworkWrapper network;

	public static CreativeTabs tab_tms = new CreativeTabs("tab_tms") {
		@SideOnly(Side.CLIENT) public Item getTabIconItem() {return CoreTMS.item_test;}
	};

	public static boolean debug;
	public static boolean show_tip_info_testing;
	public static boolean show_system_info_testing;

	public static IModuleClass
	control_button,
	environment,
	status_player,
	weight,
	effects,
	colors,
	fluids
	;

	public static boolean
	isNodeControlButton,
	isNodeEnvironment,
	isNodeStatusPlayer,
	isNodeWeight,
	isNodeEffect,
	isNodeColors,
	isNodeFluids
	;

	public static boolean
	disable_module_control_button,
	disable_module_environment,
	disable_module_status_player,
	disable_module_weight,
	disable_module_effects,
	disable_module_colors,
	disable_module_fluids
	;

	public static IPackClass
	furniture,
	item,
	magic,
	mining,
	stock,
	techno,
	weapon
	;

	public static boolean
	isPackFurniture,
	isPackItems,
	isPackMagic,
	isPackMining,
	isPackStock,
	isPackTechno,
	isPackWeapons
	;

	public static boolean
	disable_pack_furniture,
	disable_pack_item,
	disable_pack_magic,
	disable_pack_mining,
	disable_pack_stocks,
	disable_pack_techno,
	disable_pack_weapon
	;

	public static Block block_test;
	public static Item item_test;

	@Mod.EventHandler
	public void preInitialize(FMLPreInitializationEvent event) {

		log = event.getModLog();
		//--------------------------------------------------------------------------------------------
		log.info("Starting core modules.");

		Configuration cfg_module = new Configuration(new File("./config/tms", "node_module.cfg"));
		cfg_module.load();

		disable_module_control_button = cfg_module.get("disable_module", "control_button", false).getBoolean();
		disable_module_environment = cfg_module.get("disable_module", "environment", false).getBoolean();
		disable_module_status_player = cfg_module.get("disable_module", "status_player", false).getBoolean();
		disable_module_weight = cfg_module.get("disable_module", "weight", false).getBoolean();
		disable_module_effects = cfg_module.get("disable_module", "effects", false).getBoolean();
		disable_module_colors = cfg_module.get("disable_module", "colors", false).getBoolean();
		disable_module_fluids = cfg_module.get("disable_module", "fluids", false).getBoolean();

		cfg_module.save();

		verificationModule();

		if (isNodeControlButton) control_button.preInit(event);
		if (isNodeEnvironment) environment.preInit(event);
		if (isNodeStatusPlayer) status_player.preInit(event);
		if (isNodeWeight) weight.preInit(event);
		if (isNodeEffect) effects.preInit(event);
		if (isNodeColors) colors.preInit(event);
		if (isNodeFluids) fluids.preInit(event);
		//--------------------------------------------------------------------------------------------
		log.info("Starting core " + CoreTMS.MODNAME + ".");

		Configuration cfg = new Configuration(new File("./config/tms", "core_tms.cfg"));
		cfg.load();

		debug = cfg.get("debugging", "debug", false).getBoolean();

		show_tip_info_testing = getProperty(cfg, "debugging", "show_tip_info_testing", 
				"comment show_tip_info_testing", false);

		show_system_info_testing = getProperty(cfg, "debugging", "show_system_info_testing", 
				"comment show_system_info_testing", false);

		cfg.save();
		//--------------------------------------------------------------------------------------------
		log.info("Starting core packs.");

		Configuration cfg_pack = new Configuration(new File("./config/tms", "node_pack.cfg"));
		cfg_pack.load();

		disable_pack_furniture = cfg_pack.get("disable_pack", "furniture", false).getBoolean();
		disable_pack_item = cfg_pack.get("disable_pack", "item", false).getBoolean();
		disable_pack_magic = cfg_pack.get("disable_pack", "magic", false).getBoolean();
		disable_pack_mining = cfg_pack.get("disable_pack", "mining", false).getBoolean();
		disable_pack_stocks = cfg_pack.get("disable_pack", "stocks", false).getBoolean();
		disable_pack_techno = cfg_pack.get("disable_pack", "techno", false).getBoolean();
		disable_pack_weapon = cfg_pack.get("disable_pack", "weapon", false).getBoolean();

		cfg_pack.save();

		verificationPack();

		if (isPackFurniture) furniture.preInit(event);
		if (isPackItems) item.preInit(event);
		if (isPackMagic) magic.preInit(event);
		if (isPackMining) mining.preInit(event);
		if (isPackStock) stock.preInit(event);
		if (isPackTechno) techno.preInit(event);
		if (isPackWeapons) weapon.preInit(event);
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
	public void initialize(FMLInitializationEvent event) {

		NetworkRegistry.INSTANCE.registerGuiHandler(CoreTMS.MODID, new HandlerGuiTMS());

		proxy.init();
	}

	private static boolean getProperty(Configuration cfg, String category, String name, String comment, boolean flag) {
		Property show_system_info_testing_cfg = cfg.get(category, name, flag);
		show_system_info_testing_cfg.comment = comment;
		return show_system_info_testing_cfg.getBoolean();
	}

	private static boolean isObfuscated() {
		try {
			return !World.class.getName().endsWith("World");
		} catch(Exception e) {
			return false;
		}
	}

	public static void verificationModule() {

		if (!disable_module_control_button)
			control_button = checkModule(PATH_MODULE + ".control_button.ModuleControlButton");
		isNodeControlButton = control_button != null;

		if (!disable_module_environment)
			environment = checkModule(PATH_MODULE + ".environment.ModuleEnvironment");
		isNodeEnvironment = environment != null;

		if (!disable_module_status_player)
			status_player = checkModule(PATH_MODULE + ".status_player.ModuleStatusPlayer");
		isNodeStatusPlayer = status_player != null;

		if (!disable_module_weight)
			weight = checkModule(PATH_MODULE + ".weight.ModuleWeight");
		isNodeWeight = weight != null;

		if (!disable_module_effects)
			effects = checkModule(PATH_MODULE + ".effect.ModuleEffect");
		isNodeEffect = effects != null;

		if (!disable_module_colors)
			colors = checkModule(PATH_MODULE + ".colors.ModuleColors");
		isNodeColors = colors != null;

		if (!disable_module_fluids)
			fluids = checkModule(PATH_MODULE + ".fluids.ModuleFluids");
		isNodeFluids = colors != null;

	}

	public static IModuleClass checkModule(String node) {
		try {return (IModuleClass)Class.forName(node).newInstance();}
		catch (InstantiationException e) {e.printStackTrace();}
		catch (IllegalAccessException e) {e.printStackTrace();}
		catch (ClassNotFoundException e) {e.printStackTrace();}
		return null;
	}

	public static void verificationPack() {

		if (!disable_pack_furniture)
			furniture = checkPack(PATH_PACK + ".furniture.PackFurniture");
		isPackFurniture = furniture != null;

		if (!disable_pack_item)
			item = checkPack(PATH_PACK + ".item.PackItems");
		isPackItems = item != null;

		if (!disable_pack_magic)
			magic = checkPack(PATH_PACK + ".magic.PackMagic");
		isPackMagic = magic != null;

		if (!disable_pack_mining)
			mining = checkPack(PATH_PACK + ".mining.PackMining");
		isPackMining = mining != null;

		if (!disable_pack_stocks)
			stock = checkPack(PATH_PACK + ".stock.PackStock");
		isPackStock = stock != null;

		if (!disable_pack_techno)
			techno = checkPack(PATH_PACK + ".techno.PackTechno");
		isPackTechno = techno != null;

		if (!disable_pack_weapon)
			weapon = checkPack(PATH_PACK + ".weapon.PackWeapons");
		isPackWeapons = weapon != null;

	}

	public static IPackClass checkPack(String node) {
		try {return (IPackClass)Class.forName(node).newInstance();}
		catch (InstantiationException e) {e.printStackTrace();}
		catch (IllegalAccessException e) {e.printStackTrace();}
		catch (ClassNotFoundException e) {e.printStackTrace();}
		return null;
	}

}