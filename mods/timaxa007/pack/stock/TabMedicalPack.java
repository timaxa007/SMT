package mods.timaxa007.pack.stock;

import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TabMedicalPack extends CreativeTabs{

public TabMedicalPack(int id, String name) {
super(id, name);
}

@SideOnly(Side.CLIENT)
public int getTabIconItemIndex() {
return PackStock.proxy.item_medicals.itemID;
}

}
