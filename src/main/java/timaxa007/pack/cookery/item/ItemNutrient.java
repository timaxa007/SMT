package timaxa007.pack.cookery.item;

import timaxa007.pack.cookery.PackCookery;

public class ItemNutrient extends timaxa007.core.object.ItemDummy {

	public ItemNutrient(String tag) {
		super(tag);
		setCreativeTab(PackCookery.tabCookery);
		setMaxDamage(1000);
		setHasSubtypes(false);
	}

}
