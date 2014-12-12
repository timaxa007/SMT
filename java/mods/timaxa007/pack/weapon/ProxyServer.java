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

public class ProxyServer {

public static CreativeTabs tab_weapon_pack = new TabWeaponPack("tab_weapon_pack");

//Blocks
public static Block block_claymore;

//Items
public static Item items_for_weapon;
public static Item item_molotov_cocktail;
public static Item item_weapons;
public static Item item_ammos;
public static Item item_magazines;

public void preInit(FMLPreInitializationEvent event) {
Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());
cfg.load();

cfg.save();

new ListWeapon();

//Blocks
block_claymore = new BlockClaymore();

//Items
items_for_weapon = new ItemsWeapon();
item_molotov_cocktail = new MolotovCocktail();
item_weapons = new ItemWeapons();
item_ammos = new ItemAmmos();
item_magazines = new ItemMagazines();

//Blocks
GameRegistry.registerBlock(block_claymore, ItemBlockClaymore.class, "BlockClaymore");

//Items
GameRegistry.registerItem(items_for_weapon, "ItemsWeapon");
GameRegistry.registerItem(item_molotov_cocktail, "MolotovCocktail");
GameRegistry.registerItem(item_weapons, "ItemWeapons");
GameRegistry.registerItem(item_ammos, "ItemAmmos");
GameRegistry.registerItem(item_magazines, "ItemMagazines");

//Blocks
GameRegistry.registerTileEntity(TEClaymore.class, "TEClaymore");

MinecraftForge.EVENT_BUS.register(new EventPackWeapon());

Recipes_Weapon.list();

}

public void init() {

NetworkRegistry.INSTANCE.registerGuiHandler(PackWeapon.MODID, new HandlerGuiWeapons());

}

}
