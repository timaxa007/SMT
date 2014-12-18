package mods.timaxa007.pack.stock;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TabPlant extends CreativeTabs {

	public TabPlant(String name) {
		super(name);
	}

	@Override
	public Item getTabIconItem() {
		return PackStock.proxy.item_germination_plants;
	}

}
