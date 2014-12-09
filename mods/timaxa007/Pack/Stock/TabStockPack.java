package mods.timaxa007.Pack.Stock;

import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TabStockPack extends CreativeTabs {

public TabStockPack(int id, String name) {
super(id, name);
}

@SideOnly(Side.CLIENT)
public int getTabIconItemIndex() {
return PackStock.proxy.items_for_stock.itemID;
}

}
