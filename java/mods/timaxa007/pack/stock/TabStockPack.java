package mods.timaxa007.pack.stock;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TabStockPack extends CreativeTabs {

public TabStockPack(String name) {
super(name);
}

@Override
public Item getTabIconItem() {
return PackStock.proxy.items_for_stock;
}

}
