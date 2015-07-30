package timaxa007.pack.techno;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;

import org.apache.logging.log4j.Logger;

import timaxa007.api.IPackClass;
import timaxa007.pack.NodePack.PackNode;
import timaxa007.pack.techno.block.ListBlock;
import timaxa007.pack.techno.config.ConfigTechno;
import timaxa007.pack.techno.event.EventTechno;
import timaxa007.pack.techno.item.ListItem;
import timaxa007.pack.techno.lib.ListTechno;
import timaxa007.pack.techno.packet.RegisterMessage;
import timaxa007.pack.techno.recipe.Recipes_Techno;
import timaxa007.pack.techno.render.RenderMain;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@PackNode(moduleTag = PackTechno.MODID, moduleName = PackTechno.MODNAME, moduleVersion = PackTechno.VERSION)
/**@author timaxa007**/
public class PackTechno implements IPackClass {

	public static final String MODID = "technopack";
	public static final String MODNAME = "PackTechno";
	public static final String VERSION = "0.213";

	public static final ConfigTechno config = new ConfigTechno();
	public static final ListBlock block = new ListBlock();
	public static final ListItem item = new ListItem();
	public static final RenderMain render = new RenderMain();
	public static Logger log;
	public static SimpleNetworkWrapper network;

	public static final CreativeTabs tab_techno = new CreativeTabs("tab_techno") {
		@SideOnly(Side.CLIENT) public Item getTabIconItem() {return PackTechno.item.items_for_techno;}
	};
	public static final CreativeTabs tab_container_fluid = new CreativeTabs("tab_container_fluid") {
		@SideOnly(Side.CLIENT) public Item getTabIconItem() {return PackTechno.item.container_fluid;}
	};

	@Override
	public void preInit(FMLPreInitializationEvent event) {

		log = event.getModLog();
		log.info("Starting sub-mod " + PackTechno.MODNAME + ", build: " + PackTechno.VERSION + ".");

		config.main();

		network = NetworkRegistry.INSTANCE.newSimpleChannel(PackTechno.MODID);
		RegisterMessage.init(network);

		ListTechno.init();

		block.preInit();
		item.preInit();

		Recipes_Techno.list();

		MinecraftForge.EVENT_BUS.register(new EventTechno());

	}

}
