package mods.timaxa007.tms;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;

public class TabTMS extends CreativeTabs {

public TabTMS(int position, String tabID) {
super(position, tabID);
}

@SideOnly(Side.CLIENT)
public int getTabIIconItemIndex() {
return Core.item_test.itemID;
}

}
