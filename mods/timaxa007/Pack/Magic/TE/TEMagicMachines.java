package mods.timaxa007.Pack.Magic.TE;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import mods.timaxa007.Pack.Furniture.GrillsRecipes;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;

public class TEMagicMachines extends TileEntity implements ISidedInventory{

private static final int[] slots_top=new int[]{0};
private static final int[] slots_bottom=new int[]{2, 1};
private static final int[] slots_sides=new int[]{1};

private ItemStack[] slotCon=new ItemStack[12];

public int workingTime;
public int itemWorkingTime;
public int workingMakeTime;
private String customName;

private int types;
private int rot;

public TEMagicMachines() {

}

public int getTypes() {return this.types;}
public int getRot() {return this.rot;}

public void setTypes(int i) {this.types=i;}
public void setRot(int i) {this.rot=i;}

public int getSizeInventory() {return this.slotCon.length;}

public ItemStack getStackInSlot(int par1) {return this.slotCon[par1];}

public ItemStack decrStackSize(int par1, int par2) {
if(this.slotCon[par1]!=null) {
ItemStack itemstack;

if(this.slotCon[par1].stackSize<=par2) {
itemstack=this.slotCon[par1];
this.slotCon[par1]=null;
return itemstack;
}else{
itemstack=this.slotCon[par1].splitStack(par2);

if(this.slotCon[par1].stackSize==0) {
this.slotCon[par1]=null;
}

return itemstack;
}
}else{
return null;
}
}

public ItemStack getStackInSlotOnClosing(int par1) {
if(this.slotCon[par1]!=null) {
ItemStack itemstack=this.slotCon[par1];
this.slotCon[par1]=null;
return itemstack;
}else{
return null;
}
}

public void setInventorySlotContents(int par1, ItemStack is) {
this.slotCon[par1]=is;

if(is!=null&&is.stackSize>this.getInventoryStackLimit()) {
is.stackSize=this.getInventoryStackLimit();
}
}

public String getInvName() {return this.isInvNameLocalized()?this.customName:"container.furniture.Machines";}

public boolean isInvNameLocalized() {return this.customName!=null&&this.customName.length()>0;}

public void setGuiDisplayName(String str) {this.customName=str;}

public void readFromNBT(NBTTagCompound nbt) {
super.readFromNBT(nbt);
if(nbt.hasKey("Type")) {this.types=nbt.getInteger("Type");}
if(nbt.hasKey("Rot")) {this.rot=nbt.getInteger("Rot");}
NBTTagList nbttaglist=nbt.getTagList("Items");
this.slotCon=new ItemStack[this.getSizeInventory()];

for(int i=0;i<nbttaglist.tagCount();++i) {
NBTTagCompound nbttagcompound1=(NBTTagCompound)nbttaglist.tagAt(i);
byte b0=nbttagcompound1.getByte("Slot");

if(b0>=0&&b0<this.slotCon.length) {
this.slotCon[b0]=ItemStack.loadItemStackFromNBT(nbttagcompound1);
}
}

this.workingTime=nbt.getShort("BurnTime");
this.workingMakeTime=nbt.getShort("CookTime");
this.itemWorkingTime=getItemBurnTime(this.slotCon[0]);

if(nbt.hasKey("CustomName")) {this.customName=nbt.getString("CustomName");}

}

public void writeToNBT(NBTTagCompound nbt) {
super.writeToNBT(nbt);
nbt.setInteger("Type", types);
nbt.setInteger("Rot", rot);
nbt.setShort("BurnTime", (short)this.workingTime);
nbt.setShort("CookTime", (short)this.workingMakeTime);
NBTTagList nbttaglist=new NBTTagList();

for(int i=0;i<this.slotCon.length;++i) {
if(this.slotCon[i]!=null) {
NBTTagCompound nbttagcompound1=new NBTTagCompound();
nbttagcompound1.setByte("Slot", (byte)i);
this.slotCon[i].writeToNBT(nbttagcompound1);
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
this.itemWorkingTime=this.workingTime=getItemBurnTime(this.slotCon[0]);

if(this.workingTime>0) {
flag1=true;

if(this.slotCon[0]!=null) {
--this.slotCon[0].stackSize;

if(this.slotCon[0].stackSize==0) {
this.slotCon[0]=this.slotCon[0].getItem().getContainerItemStack(slotCon[1]);
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
if(this.slotCon[4]==null) {
return false;
}else{
ItemStack itemstack=GrillsRecipes.grill().getGrillsResult(this.slotCon[4]);
if(itemstack==null) return false;
if(this.slotCon[8]==null) return true;
if(!this.slotCon[8].isItemEqual(itemstack)) return false;
int result=slotCon[8].stackSize+itemstack.stackSize;
return (result<=getInventoryStackLimit()&&result<=itemstack.getMaxStackSize());
}
}

public void smeltItem() {
if(this.canSmelt()) {
ItemStack itemstack=GrillsRecipes.grill().getGrillsResult(this.slotCon[4]);

if(this.slotCon[8]==null) {
this.slotCon[8]=itemstack.copy();
}
else if(this.slotCon[8].isItemEqual(itemstack)) {
slotCon[8].stackSize+=itemstack.stackSize;
}

--this.slotCon[4].stackSize;

if(this.slotCon[4].stackSize<=0) {
this.slotCon[4]=null;
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
if(block==Block.coalBlock) {return 200*80;}
}

if(i==Item.coal.itemID) return 200*10;
if(i==Item.stick.itemID) return 100;
if(i==Item.paper.itemID) return 20;
return 0;
}
}

public static boolean isItemFuel(ItemStack is) {return getItemBurnTime(is)>0;}

public boolean isUseableByPlayer(EntityPlayer player) {
return this.worldObj.getBlockTileEntity(this.xCoord, this.yCoord, this.zCoord)!=this?false:player.getDistanceSq((double)this.xCoord+0.5D, (double)this.yCoord+0.5D, (double)this.zCoord+0.5D)<=64.0D;
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

public Packet getDescriptionPacket() {
NBTTagCompound nbt=new NBTTagCompound();
writeToNBT(nbt);
return new Packet132TileEntityData(xCoord, yCoord, zCoord, 0, nbt);
}

public void onDataPacket(INetworkManager net, Packet132TileEntityData Packet) {
readFromNBT(Packet.data);
}

}
