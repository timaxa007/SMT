package mods.timaxa007.Pack.Mining.TE;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;

public class TEBlockCristals extends TileEntity {

private int type;
private int color;
private int size;

public TEBlockCristals() {
type = 0;
color = 0;
size = 0;
}

public void setType(int i) {type = i;}
public void setColor(int i) {color = i;}
public void setSize(int i) {size = i;}

public int getType() {return type;}
public int getColor() {return color;}
public int getSize() {return size;}

public void readFromNBT(NBTTagCompound nbt) {
super.readFromNBT(nbt);
if (nbt.hasKey("Type")) {type = nbt.getInteger("Type");}
if (nbt.hasKey("Color")) {color = nbt.getInteger("Color");}
if (nbt.hasKey("Size")) {size = nbt.getInteger("Size");}
}

public void writeToNBT(NBTTagCompound nbt) {
super.writeToNBT(nbt);
nbt.setInteger("Type", type);
nbt.setInteger("Color", color);
nbt.setInteger("Size", size);
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
