package mods.timaxa007.pack.furniture.te;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;

public class TETable extends TileEntity {

private int type;
private int sizes;
private int rotation;

public TETable() {

}

public int getType() {return this.type;}
public int getSize() {return this.sizes;}
public int getRotation() {return this.rotation;}

public void setType(int i) {this.type=i;}
public void setSize(int i) {this.sizes=i;}
public void setRotation(int i) {this.rotation=i;}

@Override
public void readFromNBT(NBTTagCompound nbt) {
super.readFromNBT(nbt);
if(nbt.hasKey("Type")) {this.type=nbt.getInteger("Type");}
if(nbt.hasKey("Size")) {this.sizes=nbt.getInteger("Size");}
if(nbt.hasKey("Rotation")) {this.rotation=nbt.getInteger("Rotation");}
}

@Override
public void writeToNBT(NBTTagCompound nbt) {
super.writeToNBT(nbt);
nbt.setInteger("Type", type);
nbt.setInteger("Size", sizes);
nbt.setInteger("Rotation", rotation);
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
