package timaxa007.pack.stock;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;

import org.apache.logging.log4j.Logger;

import timaxa007.api.IPackClass;
import timaxa007.pack.NodePack.PackNode;
import timaxa007.pack.stock.block.ListBlock;
import timaxa007.pack.stock.config.ConfigStock;
import timaxa007.pack.stock.entity.ListEntity;
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

@PackNode(moduleTag = PackStock.MODID, moduleName = PackStock.MODNAME, moduleVersion = PackStock.VERSION)
/**@author timaxa007**/
public class PackStock implements IPackClass {

	public static final String MODID = "stockpack";
	public static final String MODNAME = "PackStock";
	public static final String VERSION = "0.245";

	public static final ConfigStock config = new ConfigStock();
	public static final ListBlock block = new ListBlock();
	public static final ListItem item = new ListItem();
	public static final RenderMain render = new RenderMain();
	public static Logger log;
	public static SimpleNetworkWrapper network;

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

		config.main();
		config.drop_vanilla_flowers();

		network = NetworkRegistry.INSTANCE.newSimpleChannel(PackStock.MODID);
		RegisterMessage.init(network);

		new ListStock();

		block.preInit();
		item.preInit();

		GameRegistry.registerWorldGenerator(new GeneratorPackStock(), 0);

		//GameRegistry.addRecipe(new RecipeFoodsColors());

		Recipes_Stock.list();
		ListEntity.regEntity();

		MinecraftForge.EVENT_BUS.register(new EventStock());

	}

}
