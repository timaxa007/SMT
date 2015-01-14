package mods.timaxa007.pack.stock;

import mods.timaxa007.pack.stock.block.ListBlock;
import mods.timaxa007.pack.stock.event.EventStock;
import mods.timaxa007.pack.stock.item.ListItem;
import mods.timaxa007.pack.stock.lib.ListStock;
import mods.timaxa007.pack.stock.recipe.RecipeFoodsColors;
import mods.timaxa007.pack.stock.recipe.Recipes_Stock;
import mods.timaxa007.pack.stock.render.RenderMain;
import mods.timaxa007.pack.stock.world.GeneratorPackStock;
import mods.timaxa007.tms.util.IProxy;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class ProxyCommon implements IProxy {

	public static ListBlock block;
	public static ListItem item;
	public static RenderMain render;

	public void preInit(FMLPreInitializationEvent event) {

		Configuration cfg = new Configuration(event.getSuggestedConfigurationFile());
		cfg.load();
		//
		cfg.save();

		new ListStock();

		block.preInit();
		item.preInit();
		render.preInit();

		//EntityList.addMapping(EntityTest.class, "Test", 111, 0x0033FF, 0x00CCFF);

		GameRegistry.registerWorldGenerator(new GeneratorPackStock(), 0);

		GameRegistry.addRecipe(new RecipeFoodsColors());

		Recipes_Stock.list();

		MinecraftForge.EVENT_BUS.register(new EventStock());

	}

	public void init() {

	}

}
