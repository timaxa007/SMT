package mods.timaxa007.pack.stock;

import mods.timaxa007.pack.stock.block.ListBlock;
import mods.timaxa007.pack.stock.entity.EntityTest;
import mods.timaxa007.pack.stock.event.EventStock;
import mods.timaxa007.pack.stock.item.ListItem;
import mods.timaxa007.pack.stock.lib.ListStock;
import mods.timaxa007.pack.stock.recipe.RecipeFoodsColors;
import mods.timaxa007.pack.stock.recipe.Recipes_Stock;
import mods.timaxa007.pack.stock.render.RenderMain;
import mods.timaxa007.pack.stock.world.GeneratorPackStock;
import mods.timaxa007.tms.util.IProxy;
import net.minecraft.entity.EntityList;
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

		block.germination_plants_be = cfg.get("block", "germination_plants", true).getBoolean(true);
		block.foods_be = cfg.get("block", "foods", true).getBoolean(true);
		block.healing_be = cfg.get("block", "healing", true).getBoolean(true);
		block.apiary_be = cfg.get("block", "apiary", true).getBoolean(true);

		item.items_for_stock_be = cfg.get("item", "items_for_stock", true).getBoolean(true);
		item.germination_plants_be = cfg.get("item", "germination_plants", true).getBoolean(true);
		item.nature_product_be = cfg.get("item", "nature_product", true).getBoolean(true);
		item.foods_be = cfg.get("item", "foods", true).getBoolean(true);
		item.drinks_be = cfg.get("item", "drinks", true).getBoolean(true);
		item.medicals_be = cfg.get("item", "medicals", true).getBoolean(true);
		item.honeycombs_be = cfg.get("item", "honeycombs", true).getBoolean(true);
		item.bee_products_be = cfg.get("item", "bee_products", true).getBoolean(true);
		item.bees_be = cfg.get("item", "bees", true).getBoolean(true);
		//item.food_dog_be = cfg.get("item", "food_dog", true).getBoolean(true);

		cfg.save();

		new ListStock();

		block.preInit();
		item.preInit();
		render.preInit();

		EntityList.addMapping(EntityTest.class, "Test", 111, 0x0033FF, 0x00CCFF);

		GameRegistry.registerWorldGenerator(new GeneratorPackStock(), 0);

		GameRegistry.addRecipe(new RecipeFoodsColors());

		Recipes_Stock.list();

		MinecraftForge.EVENT_BUS.register(new EventStock());

	}

	public void init() {

	}

}
