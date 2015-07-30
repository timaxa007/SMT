package timaxa007.pack.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import org.apache.logging.log4j.Logger;

import timaxa007.api.IPackClass;
import timaxa007.pack.NodePack.PackNode;
import timaxa007.pack.item.block.ListBlock;
import timaxa007.pack.item.config.ConfigItem;
import timaxa007.pack.item.item.ListItem;
import timaxa007.pack.item.lib.ListPackItem;
import timaxa007.pack.item.packet.RegisterMessage;
import timaxa007.pack.item.recipe.RecipeToolHammer;
import timaxa007.pack.item.recipe.Recipes_PackItem;
import timaxa007.pack.item.render.RenderMain;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@PackNode(moduleTag = PackItem.MODID, moduleName = PackItem.MODNAME, moduleVersion = PackItem.VERSION)
/**@author timaxa007**/
public class PackItem implements IPackClass {

	public static final String MODID = "itemspack";
	public static final String MODNAME = "PackItem";
	public static final String VERSION = "0.117";

	public static final ConfigItem config = new ConfigItem();
	public static final ListBlock block = new ListBlock();
	public static final ListItem item = new ListItem();
	public static final RenderMain render = new RenderMain();
	public static Logger log;
	public static SimpleNetworkWrapper network;

	public static final CreativeTabs tab_items = new CreativeTabs("tab_items") {
		@SideOnly(Side.CLIENT) public Item getTabIconItem() {return PackItem.item.items_for_items;}
	};

	@Override
	public void preInit(FMLPreInitializationEvent event) {

		log = event.getModLog();
		log.info("Starting sub-mod " + PackItem.MODNAME + ", build: " + PackItem.VERSION + ".");

		config.main();

		network = NetworkRegistry.INSTANCE.newSimpleChannel(PackItem.MODID);
		RegisterMessage.init(network);

		new ListPackItem();

		block.preInit();
		item.preInit();

		Recipes_PackItem.list();
		//GameRegistry.addRecipe(new RecipeArmorColor());
		GameRegistry.addRecipe(new RecipeToolHammer());

	}

	public void init(FMLInitializationEvent event) {

	}

}
