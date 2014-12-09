package mods.timaxa007.pack.furniture.te;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;

public class TEWardrobe extends TileEntity {

private int type;
private int rotation;

public TEWardrobe() {

}

public int getType() {return this.type;}
public int getRotation() {return this.rotation;}

public void setType(int i) {this.type=i;}
public void setRotation(int i) {this.rotation=i;}

@Override
public void readFromNBT(NBTTagCompound nbt) {
super.readFromNBT(nbt);
if(nbt.hasKey("Type")) {this.type=nbt.getInteger("Type");}
if(nbt.hasKey("Rotation")) {this.rotation=nbt.getInteger("Rotation");}
}

@Override
public void writeToNBT(NBTTagCompound nbt) {
super.writeToNBT(nbt);
nbt.setInteger("Type", type);
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
