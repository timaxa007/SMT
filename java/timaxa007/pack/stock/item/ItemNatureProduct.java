package timaxa007.pack.stock.item;

import timaxa007.pack.stock.PackStock;
import timaxa007.tms.object.ModifiedItem;

public class ItemNatureProduct extends ModifiedItem {

	public ItemNatureProduct(String tag) {
		super(tag);
		setCreativeTab(PackStock.tab_food);
		setHasSubtypes(true);
		setMaxDamage(0);
	}

}
