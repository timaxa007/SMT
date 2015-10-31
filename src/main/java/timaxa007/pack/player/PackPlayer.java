package timaxa007.pack.player;

import timaxa007.pack.player.block.ListBlock;
import timaxa007.pack.player.config.Config;
import timaxa007.pack.player.item.ListItem;
import timaxa007.pack.api.IPackSMT;

/**О человеке.**/
public class PackPlayer implements IPackSMT {
	//-----------------------------------------------------------------------------------------------
	public static final String PACK_TAG = "player";
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
