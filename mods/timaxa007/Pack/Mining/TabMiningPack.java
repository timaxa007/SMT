package mods.timaxa007.Pack.Mining;

import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TabMiningPack extends CreativeTabs {

public TabMiningPack(int id, String name) {
super(id, name);
}

@SideOnly(Side.CLIENT)
public int getTabIconItemIndex() {
return PackMining.proxy.items_for_mining.itemID;
}

}
