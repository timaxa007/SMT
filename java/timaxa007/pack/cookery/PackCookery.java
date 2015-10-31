package timaxa007.pack.cookery;

import net.minecraft.creativetab.CreativeTabs;
import timaxa007.pack.api.IPackSMT;
import timaxa007.pack.cookery.block.ListBlock;
import timaxa007.pack.cookery.config.Config;
import timaxa007.pack.cookery.item.ListItem;

/**Кулинария.**/
public class PackCookery implements IPackSMT {
	//-----------------------------------------------------------------------------------------------
	public static final String PACK_TAG = "cookery";
	public static final String VERSION = "0.001";
	//-----------------------------------------------------------------------------------------------
	public static final Config config = new Config();
	public static final ListBlock blocks = new ListBlock();
	public static final ListItem items = new ListItem();
	//-----------------------------------------------------------------------------------------------
	public static final CreativeTabs tabCookery = new CreativeTabs("tabCookery") {
		@Override public net.minecraft.item.Item getTabIconItem() {return items.nutrient;}
	};
	//-----------------------------------------------------------------------------------------------
	@Override
	public void preInit(cpw.mods.fml.common.event.FMLPreInitializationEvent event) {
		config.main();
		blocks.init();
		items.init();
	}
	//-----------------------------------------------------------------------------------------------
}
