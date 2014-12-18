package mods.timaxa007.pack.stock;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TabStock extends CreativeTabs {

	public TabStock(String name) {
		super(name);
	}

	@Override
	public Item getTabIconItem() {
		return PackStock.proxy.items_for_stock;
	}

}
