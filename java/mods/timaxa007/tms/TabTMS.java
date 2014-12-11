package mods.timaxa007.tms;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TabTMS extends CreativeTabs {

public TabTMS(String tabID) {
super(tabID);
}

@Override
public Item getTabIconItem() {
return Core.item_test;
}

}
