package mods.timaxa007.pack.stock;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TabApis extends CreativeTabs {

public TabApis(String name) {
super(name);
}

@Override
public Item getTabIconItem() {
return PackStock.proxy.item_bees;
}

}
