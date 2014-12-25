package mods.timaxa007.pack.weapon;

import mods.timaxa007.pack.weapon.block.BlockList;
import mods.timaxa007.pack.weapon.event.EventWeapon;
import mods.timaxa007.pack.weapon.gui.HandlerGuiWeapons;
import mods.timaxa007.pack.weapon.item.ItemList;
import mods.timaxa007.pack.weapon.lib.ListWeapon;
import mods.timaxa007.pack.weapon.recipe.Recipes_Weapons;
import mods.timaxa007.pack.weapon.render.RenderMain;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;

public class ProxyServer {

	public static BlockList block;
	public static ItemList item;
	public static RenderMain render;

	public void preInit(FMLPreInitializationEvent event) {

		Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());
		cfg.load();
		//
		cfg.save();

		new ListWeapon();

		block.list();
		item.list();
		render.preInit();

		Recipes_Weapons.list();

		MinecraftForge.EVENT_BUS.register(new EventWeapon());

	}

	public void init() {

		NetworkRegistry.INSTANCE.registerGuiHandler(PackWeapon.MODID, new HandlerGuiWeapons());

	}

}
