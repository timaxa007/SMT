package mods.timaxa007.pack.stock;

import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TabMedicalPack extends CreativeTabs{

public TabMedicalPack(int id, String name) {
super(name);
}

@SideOnly(Side.CLIENT)
public int getTabIIconItemIndex() {
return PackStock.proxy.item_medicals.getItem();
}

}
