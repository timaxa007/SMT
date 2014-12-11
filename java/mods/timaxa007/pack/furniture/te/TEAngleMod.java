package mods.timaxa007.pack.furniture.te;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TEAngleMod extends TileEntity {

private int type;
private int size;
private int rotation;
private boolean uping;

public TEAngleMod() {

}

public int getType() {return type;}
public int getSize() {return size;}
public int getRotation() {return rotation;}
public boolean getUPing() {return uping;}

public void setType(int i) {type=i;}
public void setSize(int i) {size=i;}
public void setRotation(int i) {rotation=i;}
public void setUPing(boolean i) {uping=i;}

@Override
public void readFromNBT(NBTTagCompound nbt) {
super.readFromNBT(nbt);
if (nbt.hasKey("Type")) {type = nbt.getInteger("Type");}
if (nbt.hasKey("Size")) {size = nbt.getInteger("Size");}
if (nbt.hasKey("Rotation")) {rotation = nbt.getInteger("Rotation");}
if (nbt.hasKey("UPing")) {uping = nbt.getBoolean("UPing");}
}

@Override
public void writeToNBT(NBTTagCompound nbt) {
super.writeToNBT(nbt);
nbt.setInteger("Type", type);
nbt.setInteger("Size", size);
nbt.setInteger("Rotation", rotation);
nbt.setBoolean("UPing", uping);
}

public Packet getDescriptionPacket() {
NBTTagCompound nbt = new NBTTagCompound();
writeToNBT(nbt);
return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 0, nbt);
}

}
