package mods.timaxa007.pack.furniture.te;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TEBarrels extends TileEntity {

private int typeB;
private int typeP;
private int typeCD;
private int rotation;
private boolean lie;

public TEBarrels() {

}

public int getTypeB() {return this.typeB;}
public int getTypeP() {return this.typeP;}
public int getTypeCD() {return this.typeCD;}
public int getRotation() {return this.rotation;}
public boolean getLie() {return this.lie;}

public void setTypeB(int i) {this.typeB=i;}
public void setTypeP(int i) {this.typeP=i;}
public void setTypeCD(int i) {this.typeCD=i;}
public void setRotation(int i) {this.rotation=i;}
public void setLie(boolean i) {this.lie=i;}

@Override
public void readFromNBT(NBTTagCompound nbt) {
super.readFromNBT(nbt);
if(nbt.hasKey("TypeB")) {this.typeB=nbt.getInteger("TypeB");}
if(nbt.hasKey("TypeP")) {this.typeP=nbt.getInteger("TypeP");}
if(nbt.hasKey("TypeCD")) {this.typeCD=nbt.getInteger("TypeCD");}
if(nbt.hasKey("Rotation")) {this.rotation=nbt.getInteger("Rotation");}
if(nbt.hasKey("Lie")) {this.lie=nbt.getBoolean("Lie");}
}

@Override
public void writeToNBT(NBTTagCompound nbt) {
super.writeToNBT(nbt);
nbt.setInteger("TypeB", typeB);
nbt.setInteger("TypeP", typeP);
nbt.setInteger("TypeCD", typeCD);
nbt.setInteger("Rotation", rotation);
nbt.setBoolean("Lie", lie);
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
