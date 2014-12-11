package mods.timaxa007.pack.stock;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TabPlantPack extends CreativeTabs{

public TabPlantPack(String name) {
super(name);
}

@Override
public Item getTabIconItem() {
return PackStock.proxy.item_germination_plants;
}

}
