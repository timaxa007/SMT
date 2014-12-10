package mods.timaxa007.pack.furniture.te;

import mods.timaxa007.pack.furniture.MincerRecipes;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class TEMincer extends TileEntity implements ISidedInventory{

private static final int[] slots_top=new int[]{0};
private static final int[] slots_bottom=new int[]{2, 1};
private static final int[] slots_sides=new int[]{1};

private ItemStack[] mincerItemStacks=new ItemStack[3];

public int workingTime;
public int itemWorkingTime;
public int workingMakeTime;
private String customName;

public TEMincer() {

}

public int getSizeInventory() {return this.mincerItemStacks.length;}

public ItemStack getStackInSlot(int par1) {return this.mincerItemStacks[par1];}

public ItemStack decrStackSize(int par1, int par2) {
if(this.mincerItemStacks[par1]!=null) {
ItemStack itemstack;

if(this.mincerItemStacks[par1].stackSize<=par2) {
itemstack=this.mincerItemStacks[par1];
this.mincerItemStacks[par1]=null;
return itemstack;
}else{
itemstack=this.mincerItemStacks[par1].splitStack(par2);

if(this.mincerItemStacks[par1].stackSize==0) {
this.mincerItemStacks[par1]=null;
}

return itemstack;
}
}else{
return null;
}
}

public ItemStack getStackInSlotOnClosing(int par1) {
if(this.mincerItemStacks[par1]!=null) {
ItemStack itemstack=this.mincerItemStacks[par1];
this.mincerItemStacks[par1]=null;
return itemstack;
}else{
return null;
}
}

public void setInventorySlotContents(int par1, ItemStack is) {
this.mincerItemStacks[par1]=is;

if(is!=null&&is.stackSize>this.getInventoryStackLimit()) {
is.stackSize=this.getInventoryStackLimit();
}
}

public String getInvName() {return this.isInvNameLocalized()?this.customName:"container.mincer";}

public boolean isInvNameLocalized() {return this.customName!=null&&this.customName.length()>0;}

public void setGuiDisplayName(String str) {this.customName=str;}

public void readFromNBT(NBTTagCompound nbt) {
super.readFromNBT(nbt);
NBTTagList nbttaglist=nbt.getTagList("Items");
this.mincerItemStacks=new ItemStack[this.getSizeInventory()];

for(int i=0;i<nbttaglist.tagCount();++i) {
NBTTagCompound nbttagcompound1=(NBTTagCompound)nbttaglist.tagAt(i);
byte b0=nbttagcompound1.getByte("Slot");

if(b0>=0&&b0<this.mincerItemStacks.length) {
this.mincerItemStacks[b0]=ItemStack.loadItemStackFromNBT(nbttagcompound1);
}
}

this.workingTime=nbt.getShort("BurnTime");
this.workingMakeTime=nbt.getShort("CookTime");
this.itemWorkingTime=getItemBurnTime(this.mincerItemStacks[1]);

if(nbt.hasKey("CustomName")) {this.customName=nbt.getString("CustomName");}

}

public void writeToNBT(NBTTagCompound nbt) {
super.writeToNBT(nbt);
nbt.setShort("BurnTime", (short)this.workingTime);
nbt.setShort("CookTime", (short)this.workingMakeTime);
NBTTagList nbttaglist=new NBTTagList();

for(int i=0;i<this.mincerItemStacks.length;++i) {
if(this.mincerItemStacks[i]!=null) {
NBTTagCompound nbttagcompound1=new NBTTagCompound();
nbttagcompound1.setByte("Slot", (byte)i);
this.mincerItemStacks[i].writeToNBT(nbttagcompound1);
nbttaglist.appendTag(nbttagcompound1);
}
}

nbt.setTag("Items", nbttaglist);

if(this.isInvNameLocalized()) {nbt.setString("CustomName", this.customName);}

}

public int getInventoryStackLimit() {return 64;}

@SideOnly(Side.CLIENT)
public int getCookProgressScaled(int par1) {return this.workingMakeTime*par1/200;}

@SideOnly(Side.CLIENT)
public int getBurnTimeRemainingScaled(int par1) {
if(this.itemWorkingTime==0) {this.itemWorkingTime=200;}
return this.workingTime*par1/this.itemWorkingTime;
}

public boolean isBurning() {return this.workingTime>0;}

public void updateEntity() {
boolean flag=this.workingTime>0;
boolean flag1=false;

if(this.workingTime>0) {--this.workingTime;}

if(!this.worldObj.isRemote) {
if(this.workingTime==0&&this.canSmelt()) {
this.itemWorkingTime=this.workingTime=getItemBurnTime(this.mincerItemStacks[1]);

if(this.workingTime>0) {
flag1=true;

if(this.mincerItemStacks[1]!=null) {
--this.mincerItemStacks[1].stackSize;

if(this.mincerItemStacks[1].stackSize==0) {
this.mincerItemStacks[1]=this.mincerItemStacks[1].getItem().getContainerItemStack(mincerItemStacks[1]);
}
}
}
}

if(this.isBurning()&&this.canSmelt()) {
++this.workingMakeTime;

if(this.workingMakeTime==200) {
this.workingMakeTime=0;
this.smeltItem();
flag1=true;
}
}else{
this.workingMakeTime=0;
}

if(flag!=this.workingTime>0) {
flag1=true;
//BlockMincer.updateFurnaceBlockState(this.furnaceBurnTime>0, this.worldObj, this.xCoord, this.yCoord, this.zCoord);
}
}

if(flag1) {this.onInventoryChanged();}
}

private boolean canSmelt() {
if(this.mincerItemStacks[0]==null) {
return false;
}else{
ItemStack itemstack=MincerRecipes.mince().getMinceResult(this.mincerItemStacks[0]);
if(itemstack==null) return false;
if(this.mincerItemStacks[2]==null) return true;
if(!this.mincerItemStacks[2].isItemEqual(itemstack)) return false;
int result=mincerItemStacks[2].stackSize+itemstack.stackSize;
return (result<=getInventoryStackLimit()&&result<=itemstack.getMaxStackSize());
}
}

public void smeltItem() {
if(this.canSmelt()) {
ItemStack itemstack=MincerRecipes.mince().getMinceResult(this.mincerItemStacks[0]);

if(this.mincerItemStacks[2]==null) {
this.mincerItemStacks[2]=itemstack.copy();
}
else if(this.mincerItemStacks[2].isItemEqual(itemstack)) {
mincerItemStacks[2].stackSize+=itemstack.stackSize;
}

--this.mincerItemStacks[0].stackSize;

if(this.mincerItemStacks[0].stackSize<=0) {
this.mincerItemStacks[0]=null;
}
}
}

public static int getItemBurnTime(ItemStack is) {
if(is==null) {return 0;}
else{
int i=is.getItem().itemID;
Item item=is.getItem();

if(is.getItem() instanceof ItemBlock&&Block.blocksList[i]!=null) {
Block block=Block.blocksList[i];
if(block==Block.blockRedstone) {return 200*9;}
}

if(i==Item.redstone.itemID) return 200;
return 0;
}
}

public static boolean isItemFuel(ItemStack is) {return getItemBurnTime(is)>0;}

public boolean isUseableByPlayer(EntityPlayer player) {
return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord)!=this?false:player.getDistanceSq((double)this.xCoord+0.5D, (double)this.yCoord+0.5D, (double)this.zCoord+0.5D)<=64.0D;
}

public void openChest() {}
public void closeChest() {}

public boolean isItemValidForSlot(int par1, ItemStack is) {
return par1==2?false:(par1==1?isItemFuel(is):true);
}

public int[] getAccessibleSlotsFromSide(int par1) {
return par1==0?slots_bottom:(par1==1?slots_top:slots_sides);
}

public boolean canInsertItem(int par1, ItemStack is, int par3) {
return this.isItemValidForSlot(par1, is);
}

public boolean canExtractItem(int par1, ItemStack is, int par3) {
return par3!=0||par1!=1||is.itemID==Item.bucketEmpty.itemID;
}

}
