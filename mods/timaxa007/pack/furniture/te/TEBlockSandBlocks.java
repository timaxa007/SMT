package mods.timaxa007.pack.furniture.te;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;

public class TEBlockSandBlocks extends TileEntity {

private int sub_id;
private int color_block;

public TEBlockSandBlocks() {
sub_id = 0;
color_block = 0xFFFFFF;
}

public int getSubID() {return sub_id;}
public int getColorBlock() {return color_block;}
/*
public void setSubID(int i) {
if (i >= Byte.MAX_VALUE) {
sub_id = Byte.MAX_VALUE;
} else if (i <= Byte.MIN_VALUE) {
sub_id = Byte.MIN_VALUE;
} else {
sub_id = i;
}
}
*/
public void setSubID(int i) {sub_id = i;}
public void setColorBlock(int i) {color_block = i;}

public boolean canUpdate() {return false;}

@Override
public void readFromNBT(NBTTagCompound nbt) {
super.readFromNBT(nbt);
if (nbt.hasKey("SubID")) {sub_id = (int)nbt.getByte("SubID");}
if (nbt.hasKey("ColorBlock")) {color_block = nbt.getInteger("ColorBlock");}
}

@Override
public void writeToNBT(NBTTagCompound nbt) {
super.writeToNBT(nbt);
nbt.setByte("SubID", (byte)sub_id);
nbt.setInteger("ColorBlock", color_block);
}

public Packet getDescriptionPacket() {
NBTTagCompound nbt = new NBTTagCompound();
writeToNBT(nbt);
return new Packet132TileEntityData(xCoord, yCoord, zCoord, 0, nbt);
}

public void onDataPacket(INetworkManager net, Packet132TileEntityData Packet) {
readFromNBT(Packet.data);
}

}
