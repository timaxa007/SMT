package mods.timaxa007.tms;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.relauncher.FMLCorePlugin;
import cpw.mods.fml.relauncher.FMLLaunchHandler;
import mods.timaxa007.lib.ListTextureModel;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.classloading.FMLForgePlugin;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.registry.GameRegistry;

import java.io.IOException;

//@Mod (modid = ModInfo.MODID, name = ModInfo.MODNAME, version = ModInfo.VERSION, dependencies = "required-before:01miningpack;required-before:02pmfpack;required-before:03furniturepack;required-before:04technopack;required-before:05magicpack;required-before:06weaponpack")
@Mod (modid = Core.MODID, name = Core.MODNAME, version = Core.VERSION)
//@NetworkMod (clientSideRequired = true, serverSideRequired = true, versionBounds = ModInfo.VERSION)

public class Core {

	public static final boolean OBFUSCATED = isObfuscated();
	public static final String MODID = "00tms";
	public static final String MODNAME = "TMS";
	public static final String VERSION = "0.2a";
	public static final String[] AUTHORS = new String[] {"timaxa007", "Dragon2488"};

	@Instance(Core.MODID)
	public static Core instance;

	@SidedProxy(clientSide = "mods.timaxa007.tms.ProxyClient", serverSide = "mods.timaxa007.tms.ProxyServer")
	public static ProxyServer proxy;

	public static CreativeTabs tab_tms = new TabTMS("tab_tms");

	public static boolean debug;
	public static boolean show_tip_info_testing;
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
		currectConfig = new Configuration(event.getSuggestedConfigurationFile());
		syncConfig(currectConfig);

		new ListTextureModel();
		
		block_test = new TestBlock();
		item_test = new TestItem();
		
		GameRegistry.registerBlock(block_test, "TestBlock");
		GameRegistry.registerItem(item_test, "TestItem");
		
		Recipes_TMS.list();
	}

	@EventHandler
	public void initialize(FMLInitializationEvent event) {
		proxy.initialize();
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
		show_tip_info_testing = config.get("debugging", "size_quest_items", false).getBoolean(false);
		disable_sub_mod_furniture = config.get("configs", "disable_sub_mod_furniture", false).getBoolean(false);
		disable_sub_mod_magic = config.get("configs", "disable_sub_mod_magic", false).getBoolean(false);
		disable_sub_mod_mining = config.get("configs", "disable_sub_mod_mining", false).getBoolean(false);
		disable_sub_mod_stock = config.get("configs", "disable_sub_mod_stock", false).getBoolean(false);
		disable_sub_mod_techno = config.get("configs", "disable_sub_mod_techno", false).getBoolean(false);
		disable_sub_mod_weapon = config.get("configs", "disable_sub_mod_weapon", false).getBoolean(false);
		config.save();
	}
}