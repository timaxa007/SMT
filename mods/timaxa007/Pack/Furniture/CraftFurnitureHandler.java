package mods.timaxa007.Pack.Furniture;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.ICraftingHandler;

public class CraftFurnitureHandler implements ICraftingHandler {

@Override
public void onCrafting(EntityPlayer player, ItemStack is, IInventory craftMatrix) {
for (int j = 0; j < craftMatrix.getSizeInventory(); j++) {
for (int h = 0; h < craftMatrix.getSizeInventory(); h++) {
ItemStack cmj = craftMatrix.getStackInSlot(j);
ItemStack cmh = craftMatrix.getStackInSlot(h);
if (cmj != null && cmh != null) {
if (cmj.getItem() != cmh.getItem()) {

if (cmj.getItem() == new ItemStack(PackFurniture.proxy.item_filter_charcoal).getItem() && cmh.getItem() == new ItemStack(Item.potion).getItem()) {
player.inventory.addItemStackToInventory(new ItemStack(PackFurniture.proxy.item_filter_charcoal, 1 , craftMatrix.getStackInSlot(j).getItemDamage()+1));
}

}
}
}
/*
if (craftMatrix.getStackInSlot(i) != null && craftMatrix.getStackInSlot(i).getItem()==new ItemStack(PackFurniture.proxy.itemColored).getItem()) {
}
if (is != null && is.getItem()==new ItemStack(PackFurniture.proxy.toolAirBrush).getItem()) {
}
*/
}
}

@Override
public void onSmelting(EntityPlayer player, ItemStack is) {

}

}
