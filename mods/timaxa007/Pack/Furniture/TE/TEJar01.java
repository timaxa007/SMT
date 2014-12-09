package mods.timaxa007.Pack.Furniture.TE;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;

public class TEJar01 extends TileEntity {

private int water_color;
//private int p2;
//private int p3;

public TEJar01() {

}

public int getColorWater() {return water_color;}
//public int getTypes() {return p2;}
//public int getRot() {return p3;}

public void setColorWater(int i) {water_color = i;}
//public void setTypes(int i) {p2 = i;}
//public void setRot(int i) {p3 = i;}
/*
@Override
public boolean canUpdate() {return false;}
*/
@Override
public void readFromNBT(NBTTagCompound nbt) {
super.readFromNBT(nbt);
if (nbt.hasKey("ColorWater")) {water_color = nbt.getInteger("ColorWater");}
//if (nbt.hasKey("Type")) {p2 = nbt.getInteger("Type");}
//if (nbt.hasKey("Rot")) {p3 = nbt.getInteger("Rot");}
}

@Override
public void writeToNBT(NBTTagCompound nbt) {
super.writeToNBT(nbt);
nbt.setInteger("ColorWater", water_color);
//nbt.setInteger("Type", p2);
//nbt.setInteger("Rot", p3);
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
