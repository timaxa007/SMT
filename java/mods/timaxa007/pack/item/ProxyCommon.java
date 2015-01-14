package mods.timaxa007.pack.item;

import mods.timaxa007.pack.item.block.ListBlock;
import mods.timaxa007.pack.item.event.EventPackItems;
import mods.timaxa007.pack.item.gui.HandlerGuiPackItems;
import mods.timaxa007.pack.item.item.ListItem;
import mods.timaxa007.pack.item.lib.ListPackItems;
import mods.timaxa007.pack.item.recipe.RecipeArmorColor;
import mods.timaxa007.pack.item.recipe.Recipes_PackItems;
import mods.timaxa007.pack.item.render.RenderMain;
import mods.timaxa007.tms.util.IProxy;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class ProxyCommon implements IProxy {

	public static ListBlock block;
	public static ListItem item;
	public static RenderMain render;

	//GUI
	//public static int guiID = 0;
	public static int gui_items_machines = 1;

	public void preInit(FMLPreInitializationEvent event) {

		Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());
		cfg.load();
		//
		cfg.save();

		new ListPackItems();

		block.preInit();
		item.preInit();
		render.preInit();

		Recipes_PackItems.list();
		GameRegistry.addRecipe(new RecipeArmorColor());

		MinecraftForge.EVENT_BUS.register(new EventPackItems());

	}

	public void init() {

		NetworkRegistry.INSTANCE.registerGuiHandler(PackItems.MODID, new HandlerGuiPackItems());

	}

}
