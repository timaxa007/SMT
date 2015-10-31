package timaxa007.pack.theurgy;

import timaxa007.pack.api.IPackSMT;
import timaxa007.pack.theurgy.block.ListBlock;
import timaxa007.pack.theurgy.config.Config;
import timaxa007.pack.theurgy.item.ListItem;

/**О магии.**/
public class PackTheurgy implements IPackSMT {
	//-----------------------------------------------------------------------------------------------
	public static final String PACK_TAG = "theurgy";
	public static final String VERSION = "0.001";
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
