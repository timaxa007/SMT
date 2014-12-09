package mods.timaxa007.pack.furniture.gui;

import mods.timaxa007.pack.furniture.te.TEBookshelf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerBookshelf extends Container{

private TEBookshelf te;
private int numRows;
private int gridX=6;
private int gridY=4;

public ContainerBookshelf(EntityPlayer player, TEBookshelf par2TEBookshelf) {
this.te=par2TEBookshelf;
this.numRows=par2TEBookshelf.getSizeInventory()/gridX;
int i;
int j;

for(i=0;i<gridY;++i) {
for(j=0;j<gridX;++j) {
this.addSlotToContainer(new Slot(par2TEBookshelf, j+i*gridX, 35+j*18, -2+i*18));
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
public boolean canInteractWith(EntityPlayer player) {return this.te.isUseableByPlayer(player);}

@Override
public ItemStack transferStackInSlot(EntityPlayer player, int p2) {
ItemStack itemstack=null;
Slot slot=(Slot)this.inventorySlots.get(p2);

if(slot!=null&&slot.getHasStack()) {
ItemStack is1=slot.getStack();
itemstack=is1.copy();

if(p2<this.numRows*gridX) {if(!this.mergeItemStack(is1, this.numRows*gridX, this.inventorySlots.size(), true)) {return null;}}
else if(!this.mergeItemStack(is1, 0, this.numRows*gridX, false)) {return null;}

if(is1.stackSize==0) {slot.putStack((ItemStack)null);}else{slot.onSlotChanged();}
}

return itemstack;
}

}
