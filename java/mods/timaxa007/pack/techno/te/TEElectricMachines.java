package mods.timaxa007.pack.techno.te;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TEElectricMachines extends TileEntity implements ISidedInventory {

private int types;
private int rot;

public TEElectricMachines() {

}

public int getTypes() {return types;}
public int getRot() {return rot;}

public void setTypes(int i) {types=i;}
public void setRot(int i) {rot=i;}

public Packet getDescriptionPacket() {
NBTTagCompound nbt = new NBTTagCompound();
writeToNBT(nbt);
return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 0, nbt);
}

@Override
public int getSizeInventory() {
// TODO Auto-generated method stub
return 0;
}

@Override
public ItemStack getStackInSlot(int p_70301_1_) {
// TODO Auto-generated method stub
return null;
}

@Override
public ItemStack decrStackSize(int p_70298_1_, int p_70298_2_) {
// TODO Auto-generated method stub
return null;
}

@Override
public ItemStack getStackInSlotOnClosing(int p_70304_1_) {
// TODO Auto-generated method stub
return null;
}

@Override
public void setInventorySlotContents(int p_70299_1_, ItemStack p_70299_2_) {
// TODO Auto-generated method stub

}

@Override
public String getInventoryName() {
// TODO Auto-generated method stub
return null;
}

@Override
public boolean hasCustomInventoryName() {
// TODO Auto-generated method stub
return false;
}

@Override
public int getInventoryStackLimit() {
// TODO Auto-generated method stub
return 0;
}

@Override
public boolean isUseableByPlayer(EntityPlayer p_70300_1_) {
// TODO Auto-generated method stub
return false;
}

@Override
public void openInventory() {
// TODO Auto-generated method stub

}

@Override
public void closeInventory() {
// TODO Auto-generated method stub

}

@Override
public boolean isItemValidForSlot(int p_94041_1_, ItemStack p_94041_2_) {
// TODO Auto-generated method stub
return false;
}

@Override
public int[] getAccessibleSlotsFromSide(int p_94128_1_) {
// TODO Auto-generated method stub
return null;
}

@Override
public boolean canInsertItem(int p_102007_1_, ItemStack p_102007_2_,
		int p_102007_3_) {
// TODO Auto-generated method stub
return false;
}

@Override
public boolean canExtractItem(int p_102008_1_, ItemStack p_102008_2_,
		int p_102008_3_) {
// TODO Auto-generated method stub
return false;
}

}