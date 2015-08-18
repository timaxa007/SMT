package timaxa007.pack.conjoint;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import org.apache.logging.log4j.Logger;

import timaxa007.api.IPackClass;
import timaxa007.gui.HandlerGui;
import timaxa007.pack.NodePack.PackNode;
import timaxa007.pack.conjoint.block.ListBlock;
import timaxa007.pack.conjoint.config.ConfigItem;
import timaxa007.pack.conjoint.item.ListItem;
import timaxa007.pack.conjoint.lib.ListPackConjoint;
import timaxa007.pack.conjoint.lib.ListTextureModel;
import timaxa007.pack.conjoint.packet.RegisterMessage;
import timaxa007.pack.conjoint.recipe.RecipeToolHammer;
import timaxa007.pack.conjoint.recipe.Recipes_PackConjoint;
import timaxa007.pack.conjoint.render.RenderMain;
import timaxa007.pack.mining.PackMining;
import timaxa007.smt.CoreSMT;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@PackNode(moduleTag = PackConjoint.MODID, moduleName = PackConjoint.MODNAME, moduleVersion = PackConjoint.VERSION)
/**@author timaxa007**/
public class PackConjoint implements IPackClass {

	public static final String MODID = "conjointpack";
	public static final String MODNAME = "PackConjoint";
	public static final String VERSION = "0.125";

	public static final ConfigItem config = new ConfigItem();
	public static final ListBlock block = new ListBlock();
	public static final ListItem item = new ListItem();
	public static final RenderMain render = new RenderMain();
	public static Logger log;
	public static SimpleNetworkWrapper network;

	public static final CreativeTabs tab_conjoint = new CreativeTabs("tab_conjoint") {
		@SideOnly(Side.CLIENT) public Item getTabIconItem() {return PackConjoint.item.items_for_conjoint;}
	};

	public static final CreativeTabs tab_tools = new CreativeTabs("tab_tools") {
		@SideOnly(Side.CLIENT) public Item getTabIconItem() {return PackMining.item.items_for_mining;}
	};

	@Override
	public void preInit(FMLPreInitializationEvent event) {

		log = event.getModLog();
		log.info("Starting sub-mod " + PackConjoint.MODNAME + ", build: " + PackConjoint.VERSION + ".");

		config.main();

		NetworkRegistry.INSTANCE.registerGuiHandler(CoreSMT.instance, new HandlerGui());

		network = NetworkRegistry.INSTANCE.newSimpleChannel(PackConjoint.MODID);
		RegisterMessage.init(network);

		new ListTextureModel();
		ListPackConjoint.main();

		block.preInit();
		item.preInit();

		Recipes_PackConjoint.main();
		//GameRegistry.addRecipe(new RecipeArmorColor());
		GameRegistry.addRecipe(new RecipeToolHammer());

	}

}
