package mods.timaxa007.Pack.Furniture.TE;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;

public class TEBlender extends TileEntity {

private int type;
private int typeCap;
private int typeHandler;
private int typeBox;
private int typeGlass;
private int typeSizes;
private int sizes;
private int rotation;

public TEBlender() {

}

public int getType() {return this.type;}
public int getTypeCap() {return this.typeCap;}
public int getTypeHandler() {return this.typeHandler;}
public int getTypeBox() {return this.typeBox;}
public int getTypeGlass() {return this.typeGlass;}
public int getTypeSize() {return this.typeSizes;}
public int getSize() {return this.sizes;}
public int getRotation() {return this.rotation;}

public void setType(int i) {this.type=i;}
public void setTypeCap(int i) {this.typeCap=i;}
public void setTypeHandler(int i) {this.typeHandler=i;}
public void setTypeBox(int i) {this.typeBox=i;}
public void setTypeGlass(int i) {this.typeGlass=i;}
public void setTypeSize(int i) {this.typeSizes=i;}
public void setSize(int i) {this.sizes=i;}
public void setRotation(int i) {this.rotation=i;}

@Override
public void readFromNBT(NBTTagCompound nbt) {
super.readFromNBT(nbt);
if(nbt.hasKey("Type")) {this.type=nbt.getInteger("Type");}
if(nbt.hasKey("TypeCap")) {this.typeCap=nbt.getInteger("TypeCap");}
if(nbt.hasKey("TypeHandler")) {this.typeHandler=nbt.getInteger("TypeHandler");}
if(nbt.hasKey("TypeBox")) {this.typeBox=nbt.getInteger("TypeBox");}
if(nbt.hasKey("TypeGlass")) {this.typeGlass=nbt.getInteger("TypeGlass");}
if(nbt.hasKey("TypeSize")) {this.typeSizes=nbt.getInteger("TypeSize");}
if(nbt.hasKey("Size")) {this.sizes=nbt.getInteger("Size");}
if(nbt.hasKey("Rotation")) {this.rotation=nbt.getInteger("Rotation");}
}

@Override
public void writeToNBT(NBTTagCompound nbt) {
super.writeToNBT(nbt);
nbt.setInteger("Type", type);
nbt.setInteger("TypeCap", typeCap);
nbt.setInteger("TypeHandler", typeHandler);
nbt.setInteger("TypeBox", typeBox);
nbt.setInteger("TypeGlass", typeGlass);
nbt.setInteger("TypeSize", typeSizes);
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
