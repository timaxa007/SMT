package mods.timaxa007.pack.stock;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TabFood extends CreativeTabs {

	public TabFood(String name) {
		super(name);
	}

	@Override
	public Item getTabIconItem() {
		return PackStock.proxy.item_foods;
	}

}
