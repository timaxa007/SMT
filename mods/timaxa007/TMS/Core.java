package mods.timaxa007.TMS;

import mods.timaxa007.Lib.LangLib;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.GameRegistry;

//@Mod (modid = ModInfo.MODID, name = ModInfo.MODNAME, version = ModInfo.VERSION, dependencies = "required-before:01miningpack;required-before:02pmfpack;required-before:03furniturepack;required-before:04technopack;required-before:05magicpack;required-before:06weaponpack")
@Mod (modid = ModInfo.MODID, name = ModInfo.MODNAME, version = ModInfo.VERSION)
@NetworkMod (clientSideRequired = true, serverSideRequired = true, versionBounds = ModInfo.VERSION)

public class Core {
@Instance(ModInfo.MODID) public static Core instance;
@SidedProxy(clientSide = "mods.timaxa007.TMS.ProxyClient", serverSide = "mods.timaxa007.TMS.ProxyServer")
public static ProxyServer proxy;

public static CreativeTabs tabTMS = new TabTMS(CreativeTabs.getNextID(), "tabTMS");

public static boolean show_tip_info_testing;
public static boolean disable_sub_mod_furniture;
public static boolean disable_sub_mod_magic;
public static boolean disable_sub_mod_mining;
public static boolean disable_sub_mod_stock;
public static boolean disable_sub_mod_techno;
public static boolean disable_sub_mod_weapon;

public static Block block_test;public static int block_test_blockID;

public static Item item_test;public static int item_test_itemID;


@EventHandler
public void init(FMLInitializationEvent event) {
proxy.regLoad();

block_test = new TestBlock(block_test_blockID);

item_test = new TestItem(item_test_itemID);

GameRegistry.registerBlock(block_test, "TestBlock");

GameRegistry.registerItem(item_test, "TestItem");

LangLib.registerLanguages();

Recipes_TMS.list();

}

@EventHandler
public void preInit(FMLPreInitializationEvent event) {
ConfigurationHandler configHandler = new ConfigurationHandler(event);
Configuration config = new Configuration(event.getSuggestedConfigurationFile());
config.load();

show_tip_info_testing = config.get("configs", "size_quest_items", false).getBoolean(false);

disable_sub_mod_furniture = config.get("configs", "disable_sub_mod_furniture", false).getBoolean(false);
disable_sub_mod_magic = config.get("configs", "disable_sub_mod_magic", false).getBoolean(false);
disable_sub_mod_mining = config.get("configs", "disable_sub_mod_mining", false).getBoolean(false);
disable_sub_mod_stock = config.get("configs", "disable_sub_mod_stock", false).getBoolean(false);
disable_sub_mod_techno = config.get("configs", "disable_sub_mod_techno", false).getBoolean(false);
disable_sub_mod_weapon = config.get("configs", "disable_sub_mod_weapon", false).getBoolean(false);

block_test_blockID = config.getBlock("block_test", 1999).getInt();

item_test_itemID = config.getItem("item_test", 4999).getInt();

config.save();
}

@EventHandler
public void postInit(FMLPostInitializationEvent event) {

}

@EventHandler
public void serverStarting(FMLServerStartingEvent event) {

}

}
