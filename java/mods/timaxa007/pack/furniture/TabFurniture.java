package mods.timaxa007.pack.furniture;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TabFurniture extends CreativeTabs {

	public TabFurniture(String name) {
		super(name);
	}

	@Override
	public Item getTabIconItem() {
		return Item.getItemFromBlock(PackFurniture.proxy.block_cnstor_block);
	}

}
