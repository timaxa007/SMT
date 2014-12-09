package mods.timaxa007.pack.furniture.te;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;

public class TEBookshelf extends TileEntity implements IInventory{

private ItemStack[] slotsContents=new ItemStack[24];

private Random dispenserRandom=new Random();
protected String customName;

private int type;
private int rotation;

public TEBookshelf() {

}

public int getType() {return this.type;}
public int getRotation() {return this.rotation;}

public void setType(int i) {this.type=i;}
public void setRotation(int i) {this.rotation=i;}

@Override
public int getSizeInventory() {return 24;}

@Override
public ItemStack getStackInSlot(int par1) {
return this.slotsContents[par1];
}

@Override
public ItemStack decrStackSize(int par1, int par2) {
if(this.slotsContents[par1]!=null) {
ItemStack is;

if(this.slotsContents[par1].stackSize<=par2) {
is=this.slotsContents[par1];
this.slotsContents[par1]=null;
this.onInventoryChanged();
return is;
}
else{
is=this.slotsContents[par1].splitStack(par2);

if(this.slotsContents[par1].stackSize==0) {
this.slotsContents[par1]=null;
}

this.onInventoryChanged();
return is;
}
}
else{
return null;
}
}

@Override
public ItemStack getStackInSlotOnClosing(int par1) {
if(this.slotsContents[par1]!=null) {
ItemStack itemstack=this.slotsContents[par1];
this.slotsContents[par1]=null;
return itemstack;
}
else{
return null;
}
}

public int getRandomStackFromInventory() {
int i=-1;
int j=1;

for(int k=0;k<this.slotsContents.length;++k) {
if(this.slotsContents[k]!=null&&this.dispenserRandom.nextInt(j++)==0) {
i=k;
}
}

return i;
}

@Override
public void setInventorySlotContents(int par1, ItemStack is) {
this.slotsContents[par1]=is;

if(is!=null&&is.stackSize>this.getInventoryStackLimit()) {
is.stackSize=this.getInventoryStackLimit();
}

this.onInventoryChanged();
}

public int addItem(ItemStack is) {
for(int i=0;i<this.slotsContents.length;++i) {
if(this.slotsContents[i]==null||this.slotsContents[i].itemID==0) {
this.setInventorySlotContents(i, is);
return i;
}
}

return -1;
}

@Override
public String getInvName() {
return this.isInvNameLocalized()?this.customName:"container.bookshelf";
}

public void setCustomName(String str) {this.customName=str;}

@Override
public boolean isInvNameLocalized() {return this.customName!=null;}

@Override
public void readFromNBT(NBTTagCompound nbt) {
super.readFromNBT(nbt);
NBTTagList nbttaglist=nbt.getTagList("Items");
this.slotsContents=new ItemStack[this.getSizeInventory()];

for(int i=0;i<nbttaglist.tagCount();++i) {
NBTTagCompound nbttagcompound1=(NBTTagCompound)nbttaglist.tagAt(i);
int j=nbttagcompound1.getByte("Slot")&255;

if(j>=0&&j<this.slotsContents.length) {
this.slotsContents[j]=ItemStack.loadItemStackFromNBT(nbttagcompound1);
}
}

if(nbt.hasKey("CustomName")) {this.customName=nbt.getString("CustomName");}

if(nbt.hasKey("Type")) {this.type=nbt.getInteger("Type");}
if(nbt.hasKey("Rotation")) {this.rotation=nbt.getInteger("Rotation");}

}

@Override
public void writeToNBT(NBTTagCompound nbt) {
super.writeToNBT(nbt);
NBTTagList nbttaglist=new NBTTagList();

for(int i=0;i<this.slotsContents.length;++i) {
if(this.slotsContents[i]!=null) {
NBTTagCompound nbttagcompound1=new NBTTagCompound();
nbttagcompound1.setByte("Slot", (byte)i);
this.slotsContents[i].writeToNBT(nbttagcompound1);
nbttaglist.appendTag(nbttagcompound1);
}
}

nbt.setTag("Items", nbttaglist);

if(this.isInvNameLocalized()) {nbt.setString("CustomName", this.customName);}

nbt.setInteger("Type", type);
nbt.setInteger("Rotation", rotation);

}

@Override
public int getInventoryStackLimit() {return 64;}

@Override
public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer) {
return this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord)!=this ? false : par1EntityPlayer.getDistanceSq((double)this.xCoord+0.5D, (double)this.yCoord+0.5D, (double)this.zCoord+0.5D)<=64.0D;
}

@Override
public void openChest() {}

@Override
public void closeChest() {}

@Override
public boolean isItemValidForSlot(int par1, ItemStack is) {
return true;
}

public Packet getDescriptionPacket() {
NBTTagCompound nbt=new NBTTagCompound();
writeToNBT(nbt);
return new Packet132TileEntityData(xCoord, yCoord, zCoord, 0, nbt);
}

public void onDataPacket(INetworkManager net, Packet132TileEntityData Packet) {
readFromNBT(Packet.data);
}

}
