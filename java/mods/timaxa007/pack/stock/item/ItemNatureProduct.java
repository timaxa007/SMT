package mods.timaxa007.pack.stock.item;

import mods.timaxa007.pack.stock.PackStock;
import mods.timaxa007.tms.util.ItemFixReg;

public class ItemNatureProduct extends ItemFixReg {

	public ItemNatureProduct(String tag) {
		super(tag);
		setCreativeTab(PackStock.tab_food);
		setHasSubtypes(true);
		setMaxDamage(0);
	}

}
