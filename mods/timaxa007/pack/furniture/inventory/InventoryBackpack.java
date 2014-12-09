package mods.timaxa007.pack.furniture.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class InventoryBackpack implements IInventory{

public ItemStack[] slotsBackpack=new ItemStack[27];
private String customName;

public void readFromNBT(NBTTagCompound nbt) {
//super.readFromNBT(nbt);
NBTTagList nbttaglist=nbt.getTagList("Items");
this.slotsBackpack=new ItemStack[this.getSizeInventory()];

//if(nbt.hasKey("CustomName")) {this.customName=nbt.getString("CustomName");}

for (int i=0;i<nbttaglist.tagCount();++i) {
NBTTagCompound nbttagcompound1=(NBTTagCompound)nbttaglist.tagAt(i);
int j=nbttagcompound1.getByte("Slot")&255;

if(j>=0&&j<this.slotsBackpack.length) {
this.slotsBackpack[j]=ItemStack.loadItemStackFromNBT(nbttagcompound1);
}
}
}

public void writeToNBT(NBTTagCompound nbt) {
//super.writeToNBT(nbt);
NBTTagList nbttaglist=new NBTTagList();

for (int i=0;i<this.slotsBackpack.length;++i) {
if(this.slotsBackpack[i]!=null) {
NBTTagCompound nbttagcompound1=new NBTTagCompound();
nbttagcompound1.setByte("Slot", (byte)i);
this.slotsBackpack[i].writeToNBT(nbttagcompound1);
nbttaglist.appendTag(nbttagcompound1);
}
}

nbt.setTag("Items", nbttaglist);

//if(this.isInvNameLocalized()) {nbt.setString("CustomName", this.customName);}
}

@Override
public int getSizeInventory() {return 27;}

@Override
public ItemStack getStackInSlot(int i) {return slotsBackpack[i];}

@Override
public ItemStack decrStackSize(int i, int j) {
if(slotsBackpack[i]!=null) {
ItemStack is;

if(slotsBackpack[i].stackSize<=j) {
is=slotsBackpack[i];
slotsBackpack[i]=null;
this.onInventoryChanged();
return is;
}else{
is=slotsBackpack[i].splitStack(j);

if(slotsBackpack[i].stackSize==0) {
slotsBackpack[i]=null;
}

this.onInventoryChanged();
return is;
}
}else{
return null;
}
}

@Override
public ItemStack getStackInSlotOnClosing(int i) {
if(slotsBackpack[i]!=null) {
ItemStack itemstack=slotsBackpack[i];
slotsBackpack[i]=null;
return itemstack;
}else{
return null;
}
}

@Override
public void setInventorySlotContents(int i, ItemStack is) {
slotsBackpack[i]=is;
if(is!=null&&is.stackSize>this.getInventoryStackLimit()) {
is.stackSize=this.getInventoryStackLimit();
}
this.onInventoryChanged();
}

@Override
public String getInvName() {return this.isInvNameLocalized()?customName:"container.backpack";}

@Override
public boolean isInvNameLocalized() {return customName!=null&&customName.length()>0;}

@Override
public int getInventoryStackLimit() {return 64;}

@Override
public void onInventoryChanged() {

}

@Override
public boolean isUseableByPlayer(EntityPlayer player) {return true;}

@Override
public void openChest() {}

@Override
public void closeChest() {}

@Override
public boolean isItemValidForSlot(int i, ItemStack is) {return true;}

}
