package mods.timaxa007.pack.magic;

import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TabMagicPack extends CreativeTabs {

public TabMagicPack(int id, String name) {
super(name);
}

@SideOnly(Side.CLIENT)
public int getTabIIconItemIndex() {
return PackMagic.proxy.toolMagicPickaxe.itemID;
}

}
