package mods.timaxa007.pack.furniture.te;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TETable extends TileEntity {

private int type;
private int sizes;
private int rotation;

public TETable() {

}

public int getType() {return type;}
public int getSize() {return sizes;}
public int getRotation() {return rotation;}

public void setType(int i) {type=i;}
public void setSize(int i) {sizes=i;}
public void setRotation(int i) {rotation=i;}

@Override
public void readFromNBT(NBTTagCompound nbt) {
super.readFromNBT(nbt);
if(nbt.hasKey("Type")) {type = nbt.getInteger("Type");}
if(nbt.hasKey("Size")) {sizes = nbt.getInteger("Size");}
if(nbt.hasKey("Rotation")) {rotation = nbt.getInteger("Rotation");}
}

@Override
public void writeToNBT(NBTTagCompound nbt) {
super.writeToNBT(nbt);
nbt.setInteger("Type", type);
nbt.setInteger("Size", sizes);
nbt.setInteger("Rotation", rotation);
}

public Packet getDescriptionPacket() {
NBTTagCompound nbt = new NBTTagCompound();
writeToNBT(nbt);
return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 0, nbt);
}

}
