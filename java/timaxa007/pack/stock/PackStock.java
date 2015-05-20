package timaxa007.pack.stock;

import java.io.File;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;

import org.apache.logging.log4j.Logger;

import timaxa007.api.IPackClass;
import timaxa007.pack.stock.block.ListBlock;
import timaxa007.pack.stock.event.EventStock;
import timaxa007.pack.stock.item.ListItem;
import timaxa007.pack.stock.lib.ListStock;
import timaxa007.pack.stock.packet.RegisterMessage;
import timaxa007.pack.stock.recipe.Recipes_Stock;
import timaxa007.pack.stock.render.RenderMain;
import timaxa007.pack.stock.world.GeneratorPackStock;
import timaxa007.smt.lib.Config;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**@author timaxa007**/
public class PackStock implements IPackClass {

	public static final String MODID = "stockpack";
	public static final String MODNAME = "PackStock";
	public static final String VERSION = "0.243";

	public static Logger log;
	public static SimpleNetworkWrapper network;

	public static ListBlock block;
	public static ListItem item;
	public static RenderMain render;

	public static String is_drop_vanilla_flowers;

	public static CreativeTabs tab_stock = new CreativeTabs("tab_stock") {
		@SideOnly(Side.CLIENT) public Item getTabIconItem() {return PackStock.item.items_for_stock;}
	};
	public static CreativeTabs tab_plant = new CreativeTabs("tab_plant") {
		@SideOnly(Side.CLIENT) public Item getTabIconItem() {return PackStock.item.plants;}
	};
	public static CreativeTabs tab_food = new CreativeTabs("tab_food") {
		@SideOnly(Side.CLIENT) public Item getTabIconItem() {return PackStock.item.foods;}
	};
	public static CreativeTabs tab_medical = new CreativeTabs("tab_medical") {
		@SideOnly(Side.CLIENT) public Item getTabIconItem() {return PackStock.item.medicals;}
	};
	public static CreativeTabs tab_apis = new CreativeTabs("tab_apis") {
		@SideOnly(Side.CLIENT) public Item getTabIconItem() {return PackStock.item.bees;}
	};

	@Override
	public void preInit(FMLPreInitializationEvent event) {

		log = event.getModLog();
		log.info("Starting sub-mod " + PackStock.MODNAME + ", build: " + PackStock.VERSION + ".");

		Configuration cfg = new Configuration(new File("./config/smt/pack", PackStock.MODID + ".cfg"));
		cfg.load();

		is_drop_vanilla_flowers = Config.getProperty(cfg, "config", "what_is_to_drop_of_vanilla_flowers", 
				"What is to drop of vanilla flowers?\n"
						+ "<default> - do not change drop in vanilla flowers.\n"
						+ "<vanilla_dye> - drop vanilla dye (not from the recipe, but in the recipe)-[with plus].\n"
						+ "<petals> - drop petals this mod.", 
				"default");

		block.plants_be = cfg.get("block", "plants", true).getBoolean();
		block.foods_be = cfg.get("block", "foods", true).getBoolean();
		block.healing_be = cfg.get("block", "healing", true).getBoolean();
		block.apiary_be = cfg.get("block", "apiary", true).getBoolean();
		block.petalled_be = cfg.get("block", "petalled", true).getBoolean();

		item.items_for_stock_be = cfg.get("item", "items_for_stock", true).getBoolean();
		item.plants_be = cfg.get("item", "plants", true).getBoolean();
		item.nature_product_be = cfg.get("item", "nature_product", true).getBoolean();
		item.foods_be = cfg.get("item", "foods", true).getBoolean();
		item.drinks_be = cfg.get("item", "drinks", true).getBoolean();
		item.medicals_be = cfg.get("item", "medicals", true).getBoolean();
		item.honeycombs_be = cfg.get("item", "honeycombs", true).getBoolean();
		item.bee_products_be = cfg.get("item", "bee_products", true).getBoolean();
		item.bees_be = cfg.get("item", "bees", true).getBoolean();
		item.petals_be = cfg.get("item", "petals", true).getBoolean();
		//item.food_dog_be = cfg.get("item", "food_dog", true).getBoolean();

		cfg.save();

		network = NetworkRegistry.INSTANCE.newSimpleChannel(PackStock.MODID);
		RegisterMessage.init(network);

		new ListStock();

		block.preInit();
		item.preInit();

		GameRegistry.registerWorldGenerator(new GeneratorPackStock(), 0);

		//GameRegistry.addRecipe(new RecipeFoodsColors());

		Recipes_Stock.list();

		MinecraftForge.EVENT_BUS.register(new EventStock());

	}
	//---------------------------------------------------------------------
	public static enum typeDropVanillaFlowers {
		DEFAULT,
		VANILLA_DYE,
		PETALS,
		OTHER;
	}

	public static typeDropVanillaFlowers geteDropVanillaFlowers() {
		if (is_drop_vanilla_flowers.equals("default"))
			return typeDropVanillaFlowers.DEFAULT;
		else if (is_drop_vanilla_flowers.equals("vanilla_dye"))
			return typeDropVanillaFlowers.VANILLA_DYE;
		else if (is_drop_vanilla_flowers.equals("petals"))
			return typeDropVanillaFlowers.PETALS;
		else return typeDropVanillaFlowers.OTHER;
	}
	//---------------------------------------------------------------------
}
