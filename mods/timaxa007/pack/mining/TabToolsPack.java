package mods.timaxa007.pack.mining;

import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TabToolsPack extends CreativeTabs{

public TabToolsPack(int id, String name) {
super(name);
}

@SideOnly(Side.CLIENT)
public int getTabIIconItemIndex() {
return PackMining.proxy.toolPickaxe.itemID;
}

}
