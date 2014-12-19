package mods.timaxa007.pack.weapon;

import mods.timaxa007.pack.weapon.block.*;
import mods.timaxa007.pack.weapon.event.EventWeapon;
import mods.timaxa007.pack.weapon.gui.HandlerGuiWeapons;
import mods.timaxa007.pack.weapon.item.*;
import mods.timaxa007.pack.weapon.lib.ListWeapon;
import mods.timaxa007.pack.weapon.recipe.Recipes_Weapon;
import mods.timaxa007.pack.weapon.tile.*;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class ProxyServer {

	//Blocks
	public static Block block_claymore;

	//Items
	public static Item items_for_weapons;
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
		items_for_weapons = new ItemsWeapons();
		item_molotov_cocktail = new MolotovCocktail();
		item_weapons = new ItemWeapons();
		item_ammos = new ItemAmmos();
		item_magazines = new ItemMagazines();

		//Blocks
		GameRegistry.registerBlock(block_claymore, "BlockClaymore");

		//Items
		GameRegistry.registerItem(items_for_weapons, "ItemsWeapons");
		GameRegistry.registerItem(item_molotov_cocktail, "MolotovCocktail");
		GameRegistry.registerItem(item_weapons, "ItemWeapons");
		GameRegistry.registerItem(item_ammos, "ItemAmmos");
		GameRegistry.registerItem(item_magazines, "ItemMagazines");

		//Blocks
		GameRegistry.registerTileEntity(TileEntityClaymore.class, "TileEntityClaymore");

		Recipes_Weapon.list();

		MinecraftForge.EVENT_BUS.register(new EventWeapon());

	}

	public void init() {

		NetworkRegistry.INSTANCE.registerGuiHandler(PackWeapon.MODID, new HandlerGuiWeapons());

	}

}
