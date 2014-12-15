package mods.timaxa007.pack.magic;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TabMagic extends CreativeTabs {

public TabMagic(String name) {
super(name);
}

@Override
public Item getTabIconItem() {
return PackMagic.proxy.items_for_magic;
}

}
