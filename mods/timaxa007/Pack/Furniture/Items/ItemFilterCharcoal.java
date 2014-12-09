package mods.timaxa007.Pack.Furniture.Items;

import java.util.List;

import mods.timaxa007.Pack.Furniture.PackFurniture;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemFilterCharcoal extends Item {

public ItemFilterCharcoal(int id) {
super(id);
setMaxStackSize(1);
setMaxDamage(8);
//setCreativeTab(PackFurniture.proxy.tabFurniturePack);
//setTextureName(PackInfo.MODID+":filter_charcoal");
setTextureName("timaxa007:filter_charcoal");
setUnlocalizedName("filter_charcoal");
}

public void getSubItems(int id, CreativeTabs table, List list) {
list.add(new ItemStack(id, 1, 0));
}

}
