package timaxa007.pack.furniture;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import org.apache.logging.log4j.Logger;

import timaxa007.api.IPackClass;
import timaxa007.pack.NodePack.PackNode;
import timaxa007.pack.furniture.block.ListBlock;
import timaxa007.pack.furniture.config.ConfigFurniture;
import timaxa007.pack.furniture.item.ListItem;
import timaxa007.pack.furniture.lib.ListFurniture;
import timaxa007.pack.furniture.packet.RegisterMessage;
import timaxa007.pack.furniture.recipe.FuelHandlerFurniture;
import timaxa007.pack.furniture.recipe.Recipes_Furniture;
import timaxa007.pack.furniture.render.RenderMain;
import timaxa007.pack.stock.PackStock;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@PackNode(moduleTag = PackFurniture.MODID, moduleName = PackFurniture.MODNAME, moduleVersion = PackFurniture.VERSION)
/**@author timaxa007**/
public class PackFurniture implements IPackClass {

	public static final String MODID = "furniturepack";
	public static final String MODNAME = "PackFurniture";
	public static final String VERSION = "0.334";

	public static final ConfigFurniture config = new ConfigFurniture();
	public static final ListBlock block = new ListBlock();
	public static final ListItem item = new ListItem();
	public static final RenderMain render = new RenderMain();
	public static Logger log;
	public static SimpleNetworkWrapper network;

	public static final CreativeTabs tab_furniture = new CreativeTabs("tab_furniture") {
		@SideOnly(Side.CLIENT) public Item getTabIconItem() {return PackFurniture.item.items_for_furniture;}
	};

	@Override
	public void preInit(FMLPreInitializationEvent event) {

		log = event.getModLog();
		log.info("Starting sub-mod " + PackFurniture.MODNAME + ", build: " + PackStock.VERSION + ".");

		config.main();

		network = NetworkRegistry.INSTANCE.newSimpleChannel(PackFurniture.MODID);
		RegisterMessage.init(network);

		ListFurniture.init();

		block.preInit();
		item.preInit();

		/*
		OreDictionary.registerOre("dyeBlack", new ItemStack(item_colored, 1, 0));
		OreDictionary.registerOre("dyeBlue", new ItemStack(item_colored, 1, 1));
		OreDictionary.registerOre("dyeBrown", new ItemStack(item_colored, 1, 2));
		OreDictionary.registerOre("dyeCyan", new ItemStack(item_colored, 1, 3));
		OreDictionary.registerOre("dyeGray", new ItemStack(item_colored, 1, 4));
		OreDictionary.registerOre("dyeGreen", new ItemStack(item_colored, 1, 5));
		OreDictionary.registerOre("dyeLightBlue", new ItemStack(item_colored, 1, 6));
		OreDictionary.registerOre("dyeLightGray", new ItemStack(item_colored, 1, 7));
		OreDictionary.registerOre("dyeLightGreen", new ItemStack(item_colored, 1, 8));
		OreDictionary.registerOre("dyeLime", new ItemStack(item_colored, 1, 8));
		OreDictionary.registerOre("dyeMagenta", new ItemStack(item_colored, 1, 9));
		OreDictionary.registerOre("dyeOrange", new ItemStack(item_colored, 1, 10));
		OreDictionary.registerOre("dyePink", new ItemStack(item_colored, 1, 11));
		OreDictionary.registerOre("dyePurple", new ItemStack(item_colored, 1, 12));
		OreDictionary.registerOre("dyeRed", new ItemStack(item_colored, 1, 13));
		OreDictionary.registerOre("dyeWhite", new ItemStack(item_colored, 1, 14));
		OreDictionary.registerOre("dyeYellow", new ItemStack(item_colored, 1, 15));
		 */
		//GameRegistry.addRecipe(new RecipesArmor());
		//GameRegistry.registerCraftingHandler(new CraftFurnitureHandler());

		GameRegistry.registerFuelHandler(new FuelHandlerFurniture());
		/*
		TickRegistry.registerTickHandler(new TickClientHandler(), Side.CLIENT);
		TickRegistry.registerTickHandler(new TickServerHandler(), Side.SERVER);
		 */
		Recipes_Furniture.list();

	}

}
