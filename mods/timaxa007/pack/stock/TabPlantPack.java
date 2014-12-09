package mods.timaxa007.pack.stock;

import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TabPlantPack extends CreativeTabs{

public TabPlantPack(int id, String name) {
super(id, name);
}

@SideOnly(Side.CLIENT)
public int getTabIconItemIndex() {
return PackStock.proxy.item_germination_plants.itemID;
}

}
