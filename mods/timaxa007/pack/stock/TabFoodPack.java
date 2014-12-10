package mods.timaxa007.pack.stock;

import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TabFoodPack extends CreativeTabs{

public TabFoodPack(int id, String name) {
super(name);
}

@SideOnly(Side.CLIENT)
public int getTabIIconItemIndex() {
return PackStock.proxy.item_foods.itemID;
}

}
