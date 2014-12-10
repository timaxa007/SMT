package mods.timaxa007.pack.weapon;

import mods.timaxa007.pack.weapon.blocks.*;
import mods.timaxa007.pack.weapon.gui.HandlerGuiWeapons;
import mods.timaxa007.pack.weapon.items.*;
import mods.timaxa007.pack.weapon.list.ListWeapon;
import mods.timaxa007.pack.weapon.te.*;
import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class ProxyServer {

public static CreativeTabs tabWeaponPack = new TabWeaponPack(CreativeTabs.getNextID(), "tabWeaponPack");

//Blocks
public static Block block_claymore;public static int block_claymore_blockID;

//Items
public static Item items_for_weapon;public static int items_for_weapon_itemID;
public static Item item_blaster;public static int item_blaster_itemID;
public static Item item_molotov_cocktail;public static int item_molotov_cocktail_itemID;
public static Item item_weapons;public static int item_weapons_itemID;
public static Item item_ammos;public static int item_ammos_itemID;
public static Item item_magazines;public static int item_magazines_itemID;

public void init() {
TickRegistry.registerTickHandler(new TickHandlerPackWeaponsServer(), Side.SERVER);

new ListWeapon();

//Blocks
block_claymore = new BlockClaymore(block_claymore_blockID);

//Items
items_for_weapon = new ItemsWeapon(items_for_weapon_itemID);
item_blaster = new Blaster(item_blaster_itemID);
item_molotov_cocktail = new MolotovCocktail(item_molotov_cocktail_itemID);
item_weapons = new ItemWeapons(item_weapons_itemID);
item_ammos = new ItemAmmos(item_ammos_itemID);
item_magazines = new ItemMagazines(item_magazines_itemID);

//Blocks
GameRegistry.registerBlock(block_claymore, ItemBlockClaymore.class, "BlockClaymore");

//Items
GameRegistry.registerItem(items_for_weapon, "ItemsWeapon");
GameRegistry.registerItem(item_blaster, "Blaster");
GameRegistry.registerItem(item_molotov_cocktail, "MolotovCocktail");
GameRegistry.registerItem(item_weapons, "ItemWeapons");
GameRegistry.registerItem(item_ammos, "ItemAmmos");
GameRegistry.registerItem(item_magazines, "ItemMagazines");

//Blocks
GameRegistry.registerTileEntity(TEClaymore.class, "TEClaymore");

MinecraftForge.EVENT_BUS.register(new EventPackWeapon());

NetworkRegistry.instance().registerGuiHandler(this, new HandlerGuiWeapons());

Recipes_Weapon.list();

}

public void preInit(FMLPreInitializationEvent event) {
Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());
cfg.load();
int idblock = 2500;
int iditem = 5500;
//Blocks
block_claymore_blockID = cfg.getBlock("claymore", idblock++).getInt();

//Items
items_for_weapon_itemID = cfg.getItem("items_for_weapon", iditem++).getInt();
item_blaster_itemID = cfg.getItem("blaster", iditem++).getInt();
item_molotov_cocktail_itemID = cfg.getItem("item_molotov_cocktail", iditem++).getInt();
item_weapons_itemID = cfg.getItem("item_weapons", iditem++).getInt();
item_ammos_itemID = cfg.getItem("item_ammos", iditem++).getInt();
item_magazines_itemID = cfg.getItem("item_magazines", iditem++).getInt();

cfg.save();
}

}
