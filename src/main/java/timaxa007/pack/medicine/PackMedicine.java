package timaxa007.pack.medicine;

import timaxa007.pack.api.IPackSMT;
import timaxa007.pack.medicine.block.ListBlock;
import timaxa007.pack.medicine.config.Config;
import timaxa007.pack.medicine.item.ListItem;

/**Медицина.**/
public class PackMedicine implements IPackSMT {
	//-----------------------------------------------------------------------------------------------
	public static final String PACK_TAG = "medicine";
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
