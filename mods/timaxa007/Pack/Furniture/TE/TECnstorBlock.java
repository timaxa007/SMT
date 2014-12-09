package mods.timaxa007.Pack.Furniture.TE;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;

public class TECnstorBlock extends TileEntity {

private int type;
private int color;

public TECnstorBlock() {

}

public int getType() {return type;}
public int getColor() {return color;}

public void setType(int i) {type = i;}
public void setColor(int i) {color = i;}

@Override
public void readFromNBT(NBTTagCompound nbt) {
super.readFromNBT(nbt);
if (nbt.hasKey("Type")) {type = nbt.getInteger("Type");}
if (nbt.hasKey("Color")) {color = nbt.getInteger("Color");}
}

@Override
public void writeToNBT(NBTTagCompound nbt) {
super.writeToNBT(nbt);
nbt.setInteger("Type", type);
nbt.setInteger("Color", color);
}

//public boolean canUpdate() {return false;}

public Packet getDescriptionPacket() {
NBTTagCompound nbt = new NBTTagCompound();
writeToNBT(nbt);
return new Packet132TileEntityData(xCoord, yCoord, zCoord, 0, nbt);
}

public void onDataPacket(INetworkManager net, Packet132TileEntityData Packet) {
readFromNBT(Packet.data);
}

}
