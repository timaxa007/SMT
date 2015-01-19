package mods.timaxa007.pack.weapon;

import mods.timaxa007.pack.weapon.block.ListBlock;
import mods.timaxa007.pack.weapon.event.EventWeapons;
import mods.timaxa007.pack.weapon.gui.HandlerGuiWeapons;
import mods.timaxa007.pack.weapon.item.ListItem;
import mods.timaxa007.pack.weapon.lib.ListWeapon;
import mods.timaxa007.pack.weapon.recipe.Recipes_Weapons;
import mods.timaxa007.pack.weapon.render.RenderMain;
import mods.timaxa007.tms.util.IProxy;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;

public class ProxyCommon implements IProxy {

	public static ListBlock block;
	public static ListItem item;
	public static RenderMain render;

	//GUI
	public static int gui_scope_1 = 1;
	public static int gui_modify = 19;

	public void preInit(FMLPreInitializationEvent event) {

		Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());
		cfg.load();

		block.claymore_be = cfg.get("block", "claymore", true).getBoolean(true);

		item.items_for_weapons_be = cfg.get("item", "items_for_weapons", true).getBoolean(true);
		item.molotov_cocktail_be = cfg.get("item", "molotov_cocktail", true).getBoolean(true);
		item.weapons_be = cfg.get("item", "weapons", true).getBoolean(true);
		item.ammos_be = cfg.get("item", "ammos", true).getBoolean(true);
		item.magazines_be = cfg.get("item", "magazines", true).getBoolean(true);

		cfg.save();

		new ListWeapon();

		block.preInit();
		item.preInit();
		render.preInit();

		Recipes_Weapons.list();

		MinecraftForge.EVENT_BUS.register(new EventWeapons());

	}

	public void init() {

		NetworkRegistry.INSTANCE.registerGuiHandler(PackWeapons.MODID, new HandlerGuiWeapons());

	}

}
