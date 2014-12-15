package mods.timaxa007.tms;

import mods.timaxa007.lib.ListTextureModel;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
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

//@Mod (modid = ModInfo.MODID, name = ModInfo.MODNAME, version = ModInfo.VERSION, dependencies = "required-before:01miningpack;required-before:02pmfpack;required-before:03furniturepack;required-before:04technopack;required-before:05magicpack;required-before:06weaponpack")
@Mod (modid = Core.MODID, name = Core.MODNAME, version = Core.VERSION)
//@NetworkMod (clientSideRequired = true, serverSideRequired = true, versionBounds = ModInfo.VERSION)

public class Core {

public static final String MODID = "00tms";
public static final String MODNAME = "TMS";
public static final String VERSION = "0.1a";
public static final String AUTHOR = "timaxa007";

@Instance(Core.MODID) public static Core instance;
@SidedProxy(clientSide = "mods.timaxa007.tms.ProxyClient", serverSide = "mods.timaxa007.tms.ProxyServer")
public static ProxyServer proxy;

public static CreativeTabs tabTMS = new TabTMS("tabTMS");

public static boolean show_tip_info_testing;
public static boolean disable_sub_mod_furniture;
public static boolean disable_sub_mod_magic;
public static boolean disable_sub_mod_mining;
public static boolean disable_sub_mod_stock;
public static boolean disable_sub_mod_techno;
public static boolean disable_sub_mod_weapon;

public static Block block_test;

public static Item item_test;

@EventHandler
public void preInit(FMLPreInitializationEvent event) {
Configuration config = new Configuration(event.getSuggestedConfigurationFile());
config.load();

show_tip_info_testing = config.get("configs", "size_quest_items", false).getBoolean(false);

disable_sub_mod_furniture = config.get("configs", "disable_sub_mod_furniture", false).getBoolean(false);
disable_sub_mod_magic = config.get("configs", "disable_sub_mod_magic", false).getBoolean(false);
disable_sub_mod_mining = config.get("configs", "disable_sub_mod_mining", false).getBoolean(false);
disable_sub_mod_stock = config.get("configs", "disable_sub_mod_stock", false).getBoolean(false);
disable_sub_mod_techno = config.get("configs", "disable_sub_mod_techno", false).getBoolean(false);
disable_sub_mod_weapon = config.get("configs", "disable_sub_mod_weapon", false).getBoolean(false);

config.save();

new ListTextureModel();

block_test = new TestBlock();

item_test = new TestItem();

GameRegistry.registerBlock(block_test, "TestBlock");

GameRegistry.registerItem(item_test, "TestItem");

Recipes_TMS.list();

}

@EventHandler
public void init(FMLInitializationEvent event) {
proxy.regLoad();

}

@EventHandler
public void postInit(FMLPostInitializationEvent event) {

}

@EventHandler
public void serverStarting(FMLServerStartingEvent event) {

}

}
