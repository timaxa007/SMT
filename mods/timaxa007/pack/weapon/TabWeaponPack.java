package mods.timaxa007.pack.weapon;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TabWeaponPack extends CreativeTabs {

public TabWeaponPack(int id, String name) {
super(name);
}

@SideOnly(Side.CLIENT)
public int getTabIIconItemIndex() {
return Item.swordStone.itemID;
}

}
