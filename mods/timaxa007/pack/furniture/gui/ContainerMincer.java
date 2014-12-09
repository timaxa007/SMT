package mods.timaxa007.pack.furniture.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.timaxa007.gui.SlotBlocked;
import mods.timaxa007.pack.furniture.MincerRecipes;
import mods.timaxa007.pack.furniture.te.TEMincer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerMincer extends Container{

private TEMincer te;
private int lastCookTime;
private int lastBurnTime;
private int lastItemBurnTime;
private int numRows;
private int gridX=3;
private int gridY=1;

public ContainerMincer(EntityPlayer player, TEMincer par2TEMincer) {
this.te=par2TEMincer;
this.numRows=par2TEMincer.getSizeInventory()/gridX;
int i;
int j;

this.addSlotToContainer(new Slot(par2TEMincer, 0, 56, 17));
this.addSlotToContainer(new Slot(par2TEMincer, 1, 56, 53));
this.addSlotToContainer(new SlotBlocked(player, par2TEMincer, 2, 116, 35));
/*
for(i=0;i<gridY;++i) {
for(j=0;j<gridX;++j) {
this.addSlotToContainer(new Slot(par2TEMincer, j+i*gridX, 35+j*18, -2+i*18));
}
}
 */
for(i=0;i<3;++i) {
for(j=0;j<9;++j) {
this.addSlotToContainer(new Slot(player.inventory, j+i*9+9, 8+j*18, 84+i*18));
}
}

for(i=0;i<9;++i) {
this.addSlotToContainer(new Slot(player.inventory, i, 8+i*18, 142));
}
}

public void addCraftingToCrafters(ICrafting ic) {
super.addCraftingToCrafters(ic);
ic.sendProgressBarUpdate(this, 0, this.te.workingMakeTime);
ic.sendProgressBarUpdate(this, 1, this.te.workingTime);
ic.sendProgressBarUpdate(this, 2, this.te.itemWorkingTime);
}

public void detectAndSendChanges() {
super.detectAndSendChanges();

for(int i=0;i<this.crafters.size();++i) {
ICrafting icrafting=(ICrafting)this.crafters.get(i);

if(this.lastCookTime!=this.te.workingMakeTime) {
icrafting.sendProgressBarUpdate(this, 0, this.te.workingMakeTime);
}

if(this.lastBurnTime!=this.te.workingTime) {
icrafting.sendProgressBarUpdate(this, 1, this.te.workingTime);
}

if(this.lastItemBurnTime!=this.te.itemWorkingTime) {
icrafting.sendProgressBarUpdate(this, 2, this.te.itemWorkingTime);
}
}

this.lastCookTime=this.te.workingMakeTime;
this.lastBurnTime=this.te.workingTime;
this.lastItemBurnTime=this.te.itemWorkingTime;
}

@SideOnly(Side.CLIENT)
public void updateProgressBar(int par1, int par2) {
if(par1==0) {this.te.workingMakeTime=par2;}
if(par1==1) {this.te.workingTime=par2;}
if(par1==2) {this.te.itemWorkingTime=par2;}
}

@Override
public boolean canInteractWith(EntityPlayer player) {return this.te.isUseableByPlayer(player);}

@Override
public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2) {
ItemStack itemstack=null;
Slot slot=(Slot)this.inventorySlots.get(par2);

if(slot!=null&&slot.getHasStack()) {
ItemStack itemstack1=slot.getStack();
itemstack=itemstack1.copy();

if(par2 == 2) {
if(!this.mergeItemStack(itemstack1, 3, 39, true)) {return null;}

slot.onSlotChange(itemstack1, itemstack);
}
else if(par2!=1&&par2!=0) {
if(MincerRecipes.mince().getMinceResult(itemstack1)!=null) {
if(!this.mergeItemStack(itemstack1, 0, 1, false)) {
return null;
}
}
else if(TEMincer.isItemFuel(itemstack1)) {
if(!this.mergeItemStack(itemstack1, 1, 2, false)) {
return null;
}
}
else if(par2>=3&&par2<30) {
if(!this.mergeItemStack(itemstack1, 30, 39, false)) {
return null;
}
}
else if(par2>=30&&par2<39&&!this.mergeItemStack(itemstack1, 3, 30, false)) {
return null;
}
}
else if(!this.mergeItemStack(itemstack1, 3, 39, false)) {
return null;
}

if(itemstack1.stackSize == 0) {
slot.putStack((ItemStack)null);
}else{
slot.onSlotChanged();
}

if(itemstack1.stackSize == itemstack.stackSize) {
return null;
}

slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
}

return itemstack;
}

}