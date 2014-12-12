package mods.timaxa007.pack.mining;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TabToolsPack extends CreativeTabs{

public TabToolsPack(String name) {
super(name);
}

@Override
public Item getTabIconItem() {
return PackMining.proxy.items_for_mining;
}

}
