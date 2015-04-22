package timaxa007.pack.magic.item;

import timaxa007.pack.magic.PackMagic;
import timaxa007.tms.object.ModifiedItem;

public class ItemsMagic extends ModifiedItem {

	public ItemsMagic(String tag) {
		super(tag);
		setCreativeTab(PackMagic.tab_magic);
		setTextureName("timaxa007:icon/magic");
	}

}
