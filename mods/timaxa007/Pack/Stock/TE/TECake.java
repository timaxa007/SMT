package mods.timaxa007.Pack.Stock.TE;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;

public class TECake extends TileEntity {

private int amount;
private int types;
private int rot;

public TECake() {

}

public int getAmount() {return amount;}
public int getTypes() {return types;}
public int getRot() {return rot;}

public void setAmount(int i) {amount = i;}
public void setTypes(int i) {types = i;}
public void setRot(int i) {rot = i;}

@Override
public void readFromNBT(NBTTagCompound nbt) {
super.readFromNBT(nbt);
if (nbt.hasKey("Amount")) {amount = nbt.getInteger("Amount");}
if (nbt.hasKey("Type")) {types = nbt.getInteger("Type");}
if (nbt.hasKey("Rot")) {rot = nbt.getInteger("Rot");}
}

@Override
public void writeToNBT(NBTTagCompound nbt) {
super.writeToNBT(nbt);
nbt.setInteger("Amount", amount);
nbt.setInteger("Type", types);
nbt.setInteger("Rot", rot);
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
