package mods.timaxa007.Pack.Furniture.Gui;

import mods.timaxa007.Pack.Furniture.Inventory.InventoryBackpack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerBackpack extends Container{
private InventoryBackpack ib=new InventoryBackpack();

public ContainerBackpack(EntityPlayer player) {
int i;
int j;

for(i=0;i<3;++i) {
for(j=0;j<9;++j) {
this.addSlotToContainer(new Slot(ib, j+i*9, 8+j*18, 18+i*18));
}
}

for(i=0;i<3;++i) {
for(j=0;j<9;++j) {
this.addSlotToContainer(new Slot(player.inventory, j+i*9+9, 8+j*18, 84+i*18));
}
}

for(i=0;i<9;++i) {
this.addSlotToContainer(new Slot(player.inventory, i, 8+i*18, 142));
}
}

@Override
public boolean canInteractWith(EntityPlayer player) {return true;}
/*
@Override
public ItemStack transferStackInSlot(EntityPlayer player, int p2) {
ItemStack itemstack=null;
Slot slot=(Slot)this.inventorySlots.get(p2);

if(slot!=null&&slot.getHasStack()) {
ItemStack is1=slot.getStack();
itemstack=is1.copy();

if(p2<27) {if(!this.mergeItemStack(is1, 27, this.inventorySlots.size(), true)) {return null;}}
else if(!this.mergeItemStack(is1, 0, 27, false)) {return null;}

if(is1.stackSize==0) {slot.putStack((ItemStack)null);}else{slot.onSlotChanged();}
}

return itemstack;
}
*/

@Override
public ItemStack transferStackInSlot(EntityPlayer player, int par2) {
ItemStack is=null;
Slot slot=(Slot)this.inventorySlots.get(par2);

if(slot!=null&&slot.getHasStack()) {
ItemStack is1=slot.getStack();
is=is1.copy();

if(par2<3*9) {
if(!this.mergeItemStack(is1, 3*9, this.inventorySlots.size(), true)) {return null;}
}else if(!this.mergeItemStack(is1, 0, 3*9, false)) {return null;}

if(is1.stackSize==0) {slot.putStack((ItemStack)null);}else{slot.onSlotChanged();}
}

return is;
}


}
