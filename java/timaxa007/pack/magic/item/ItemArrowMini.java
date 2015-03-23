package timaxa007.pack.magic.item;

import timaxa007.pack.magic.PackMagic;
import timaxa007.tms.util.ModifiedItem;

public class ItemArrowMini extends ModifiedItem {

	public ItemArrowMini(String tag) {
		super(tag);
		setCreativeTab(PackMagic.tab_magic);
		setTextureName("arrow");
	}

}
