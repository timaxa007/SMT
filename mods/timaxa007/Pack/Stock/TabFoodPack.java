package mods.timaxa007.Pack.Stock;

import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TabFoodPack extends CreativeTabs{

public TabFoodPack(int id, String name) {
super(id, name);
}

@SideOnly(Side.CLIENT)
public int getTabIconItemIndex() {
return PackStock.proxy.item_foods.itemID;
}

}
