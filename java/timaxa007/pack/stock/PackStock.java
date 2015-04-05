package timaxa007.pack.stock;

import java.io.File;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityList;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;

import org.apache.logging.log4j.Logger;

import timaxa007.pack.api.IPackClass;
import timaxa007.pack.stock.block.ListBlock;
import timaxa007.pack.stock.entity.EntityTest;
import timaxa007.pack.stock.event.EventStock;
import timaxa007.pack.stock.item.ListItem;
import timaxa007.pack.stock.lib.ListStock;
import timaxa007.pack.stock.packet.RegisterMessage;
import timaxa007.pack.stock.recipe.Recipes_Stock;
import timaxa007.pack.stock.render.RenderMain;
import timaxa007.pack.stock.world.GeneratorPackStock;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class PackStock implements IPackClass {

	public static final String MODID = "stockpack";
	public static final String MODNAME = "PackStock";
	public static final String VERSION = "0.1a";
	public static final String[] AUTHORS = new String[] {"timaxa007"};

	public static Logger log;
	public static SimpleNetworkWrapper network;

	public static ListBlock block;
	public static ListItem item;
	public static RenderMain render;

	public static CreativeTabs tab_stock = new CreativeTabs("tab_stock") {
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {return PackStock.item.items_for_stock;}
	};
	public static CreativeTabs tab_plant = new CreativeTabs("tab_plant") {
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {return PackStock.item.germination_plants;}
	};
	public static CreativeTabs tab_food = new CreativeTabs("tab_food") {
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {return PackStock.item.foods;}
	};
	public static CreativeTabs tab_medical = new CreativeTabs("tab_medical") {
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {return PackStock.item.medicals;}
	};
	public static CreativeTabs tab_apis = new CreativeTabs("tab_apis") {
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {return PackStock.item.bees;}
	};

	public void preInit(FMLPreInitializationEvent event) {

		log = event.getModLog();
		log.info("Starting sub-mod " + PackStock.MODNAME + ".");

		Configuration cfg = new Configuration(new File("./config/tms/pack", PackStock.MODID + ".cfg"));
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

		network = NetworkRegistry.INSTANCE.newSimpleChannel(PackStock.MODID);
		RegisterMessage.init(network);

		new ListStock();

		block.preInit();
		item.preInit();

		EntityList.addMapping(EntityTest.class, "Test", 111, 0x0033FF, 0x00CCFF);

		GameRegistry.registerWorldGenerator(new GeneratorPackStock(), 0);

		//GameRegistry.addRecipe(new RecipeFoodsColors());

		Recipes_Stock.list();

		MinecraftForge.EVENT_BUS.register(new EventStock());

	}

}
