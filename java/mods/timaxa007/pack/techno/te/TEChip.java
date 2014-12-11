package mods.timaxa007.pack.techno.te;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TEChip extends TileEntity {

private int types;
//private int sizes;
private int rot;

public TEChip() {

}

public int getTypes() {return types;}
//public int getSize() {return sizes;}
public int getRotation() {return rot;}

public void setType(int i) {types=i;}
//public void setSize(int i) {sizes=i;}
public void setRotation(int i) {rot=i;}

@Override
public void readFromNBT(NBTTagCompound nbt) {
super.readFromNBT(nbt);
if(nbt.hasKey("Type")) {types=nbt.getInteger("Type");}
//if(nbt.hasKey("Size")) {sizes=nbt.getInteger("Size");}
if(nbt.hasKey("Rotation")) {rot=nbt.getInteger("Rotation");}
}

@Override
public void writeToNBT(NBTTagCompound nbt) {
super.writeToNBT(nbt);
nbt.setInteger("Type", types);
//nbt.setInteger("Size", sizes);
nbt.setInteger("Rotation", rot);
}

public Packet getDescriptionPacket() {
NBTTagCompound nbt = new NBTTagCompound();
writeToNBT(nbt);
return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 0, nbt);
}

}
