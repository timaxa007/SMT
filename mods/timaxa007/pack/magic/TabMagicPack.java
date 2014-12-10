package mods.timaxa007.pack.magic;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TabMagicPack extends CreativeTabs {

public TabMagicPack(String name) {
super(name);
}

@Override
public Item getTabIconItem() {
return PackMagic.proxy.toolMagicPickaxe;
}

}
