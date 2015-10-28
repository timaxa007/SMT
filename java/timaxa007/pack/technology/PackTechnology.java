package timaxa007.pack.technology;

import timaxa007.pack.api.IPackSMT;
import timaxa007.pack.technology.block.ListBlock;
import timaxa007.pack.technology.config.Config;
import timaxa007.pack.technology.item.ListItem;

/**О Технологии.**/
public class PackTechnology implements IPackSMT {
	//-----------------------------------------------------------------------------------------------
	public static final String PACK_TAG = "technology";
	public static final String VERSION = "0.001a";
	//-----------------------------------------------------------------------------------------------
	public static final Config config = new Config();
	public static final ListBlock blocks = new ListBlock();
	public static final ListItem items = new ListItem();
	//-----------------------------------------------------------------------------------------------
	@Override
	public void preInit(cpw.mods.fml.common.event.FMLPreInitializationEvent event) {
		config.main();
		blocks.init();
		items.init();
	}
	//-----------------------------------------------------------------------------------------------
}
