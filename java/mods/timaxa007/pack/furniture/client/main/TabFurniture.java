package mods.timaxa007.pack.furniture.client.main;

import mods.timaxa007.pack.furniture.common.main.PackFurniture;
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
