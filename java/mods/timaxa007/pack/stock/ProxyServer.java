package mods.timaxa007.pack.stock;

import mods.timaxa007.pack.stock.block.BlockList;
import mods.timaxa007.pack.stock.event.EventStock;
import mods.timaxa007.pack.stock.item.ItemList;
import mods.timaxa007.pack.stock.lib.ListStock;
import mods.timaxa007.pack.stock.recipe.RecipeFoodsColors;
import mods.timaxa007.pack.stock.recipe.Recipes_Stock;
import mods.timaxa007.pack.stock.render.RenderMain;
import mods.timaxa007.pack.stock.world.GeneratorPackStock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

public class ProxyServer {

	public static BlockList block;
	public static ItemList item;
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
