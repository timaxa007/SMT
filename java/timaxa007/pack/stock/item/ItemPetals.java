package timaxa007.pack.stock.item;

import timaxa007.pack.stock.PackStock;
import timaxa007.tms.object.ModifiedItem;

public class ItemPetals extends ModifiedItem {

	public ItemPetals(String tag) {
		super(tag);
		setCreativeTab(PackStock.tab_plant);
		setHasSubtypes(true);
		setMaxDamage(0);
		//setMaxStackSize(1);
		setTextureName("timaxa007:petals");
	}

}
