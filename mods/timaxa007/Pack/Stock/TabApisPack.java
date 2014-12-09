package mods.timaxa007.Pack.Stock;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;

public class TabApisPack extends CreativeTabs {

public TabApisPack(int id, String name) {
super(id, name);
}

@SideOnly(Side.CLIENT)
public int getTabIconItemIndex() {
return PackStock.proxy.item_bees.itemID;
}

}
