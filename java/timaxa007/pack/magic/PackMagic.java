package timaxa007.pack.magic;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import org.apache.logging.log4j.Logger;

import timaxa007.api.IPackClass;
import timaxa007.pack.NodePack.PackNode;
import timaxa007.pack.magic.block.ListBlock;
import timaxa007.pack.magic.config.ConfigMagic;
import timaxa007.pack.magic.item.ListItem;
import timaxa007.pack.magic.lib.ListMagic;
import timaxa007.pack.magic.packet.RegisterMessage;
import timaxa007.pack.magic.recipe.Recipes_Magic;
import timaxa007.pack.magic.render.RenderMain;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@PackNode(moduleTag = PackMagic.MODID, moduleName = PackMagic.MODNAME, moduleVersion = PackMagic.VERSION)
/**@author timaxa007**/
public class PackMagic implements IPackClass {

	public static final String MODID = "magicpack";
	public static final String MODNAME = "PackMagic";
	public static final String VERSION = "0.437";

	public static final ConfigMagic config = new ConfigMagic();
	public static final ListBlock block = new ListBlock();
	public static final ListItem item = new ListItem();
	public static final RenderMain render = new RenderMain();
	public static Logger log;
	public static SimpleNetworkWrapper network;

	public static final String[] elementsNames = new String[] {
		"Air", 
		"Earth", 
		"Fire", 
		"Water", 
		"Sound", 
		"6", 
		"Lightning", 
		"Liquid", 
		"Flame", 
		"10", 
		"11", 
		"12", 
		"13", 
		"14", 
		"15", 
		"16"
	};
	//ShardElements ~= gems

	public static CreativeTabs tab_magic = new CreativeTabs("tab_magic") {
		@SideOnly(Side.CLIENT) public Item getTabIconItem() {return PackMagic.item.items_for_magic;}
	};

	@Override
	public void preInit(FMLPreInitializationEvent event) {

		log = event.getModLog();
		log.info("Starting sub-mod " + PackMagic.MODNAME + ", build: " + PackMagic.VERSION + ".");

		config.main();

		network = NetworkRegistry.INSTANCE.newSimpleChannel(PackMagic.MODID);
		RegisterMessage.init(network);

		new ListMagic();

		block.preInit();
		item.preInit();

		Recipes_Magic.list();

	}

}
