package mods.timaxa007.pack.techno.te;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;

public class TEChip extends TileEntity {

private int types;
//private int sizes;
private int rot;

public TEChip() {

}

public int getTypes() {return this.types;}
//public int getSize() {return this.sizes;}
public int getRotation() {return this.rot;}

public void setType(int i) {this.types=i;}
//public void setSize(int i) {this.sizes=i;}
public void setRotation(int i) {this.rot=i;}

@Override
public void readFromNBT(NBTTagCompound nbt) {
super.readFromNBT(nbt);
if(nbt.hasKey("Type")) {this.types=nbt.getInteger("Type");}
//if(nbt.hasKey("Size")) {this.sizes=nbt.getInteger("Size");}
if(nbt.hasKey("Rotation")) {this.rot=nbt.getInteger("Rotation");}
}

@Override
public void writeToNBT(NBTTagCompound nbt) {
super.writeToNBT(nbt);
nbt.setInteger("Type", types);
//nbt.setInteger("Size", sizes);
nbt.setInteger("Rotation", rot);
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
