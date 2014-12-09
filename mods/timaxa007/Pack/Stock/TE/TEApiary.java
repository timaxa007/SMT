package mods.timaxa007.Pack.Stock.TE;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;

public class TEApiary extends TileEntity {

private String name;
private int type;

public TEApiary() {

}

public void setName(String str) {name = str;}
public void setType(int i) {type = i;}

public String getName() {return name;}
public int getType() {return type;}
/*
@Override
public boolean canUpdate() {return false;}
*/
@Override
public void readFromNBT(NBTTagCompound nbt) {
super.readFromNBT(nbt);
if (nbt.hasKey("NameID")) {name = nbt.getString("NameID");}
if (nbt.hasKey("TypeID")) {type = nbt.getInteger("TypeID");}
}

@Override
public void writeToNBT(NBTTagCompound nbt) {
super.writeToNBT(nbt);
nbt.setString("NameID", name);
nbt.setInteger("TypeID", type);
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
