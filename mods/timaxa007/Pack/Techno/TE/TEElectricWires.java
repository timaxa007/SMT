package mods.timaxa007.Pack.Techno.TE;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;

public class TEElectricWires extends TileEntity {

private int type;
private int size;
private int color;
public boolean up;
public boolean down;
public boolean north;
public boolean south;
public boolean west;
public boolean east;

public TEElectricWires() {

}

public void updateEntity() {
if (worldObj.getBlockTileEntity(xCoord, yCoord + 1, zCoord) instanceof TEElectricWires) {up = true;} else {up = false;}
if (worldObj.getBlockTileEntity(xCoord, yCoord - 1, zCoord) instanceof TEElectricWires) {down = true;} else {down = false;}
if (worldObj.getBlockTileEntity(xCoord + 1, yCoord, zCoord) instanceof TEElectricWires) {north = true;} else {north = false;}
if (worldObj.getBlockTileEntity(xCoord - 1, yCoord, zCoord) instanceof TEElectricWires) {south = true;} else {south = false;}
if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord + 1) instanceof TEElectricWires) {west = true;} else {west = false;}
if (worldObj.getBlockTileEntity(xCoord, yCoord, zCoord - 1) instanceof TEElectricWires) {east = true;} else {east = false;}
}

public int getType() {return type;}
public int getSize() {return size;}
public int getColor() {return color;}

public void setType(int i) {type = i;}
public void setSize(int i) {if (i <= 1) {size = 1;} else if (i >= 8) {size = 8;} else {size = i;}}
public void setColor(int i) {color = i;}

@Override
public void readFromNBT(NBTTagCompound nbt) {
super.readFromNBT(nbt);
if (nbt.hasKey("Type")) {type = nbt.getInteger("Type");}
if (nbt.hasKey("Size")) {size = nbt.getInteger("Size");}
if (nbt.hasKey("Color")) {color = nbt.getInteger("Color");}
}

@Override
public void writeToNBT(NBTTagCompound nbt) {
super.writeToNBT(nbt);
nbt.setInteger("Type", type);
nbt.setInteger("Size", size);
nbt.setInteger("Color", color);
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
