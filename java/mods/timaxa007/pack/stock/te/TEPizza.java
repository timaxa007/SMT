package mods.timaxa007.pack.stock.te;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TEPizza extends TileEntity {

private int amount;
private int types;
private int rot;

public TEPizza() {

}

public int getAmount() {return this.amount;}
public int getTypes() {return this.types;}
public int getRot() {return this.rot;}

public void setAmount(int i) {this.amount=i;}
public void setTypes(int i) {this.types=i;}
public void setRot(int i) {this.rot=i;}
/*
@Override
public boolean canUpdate() {return false;}
*/
@Override
public void readFromNBT(NBTTagCompound nbt) {
super.readFromNBT(nbt);
if(nbt.hasKey("Amount")) {this.amount=nbt.getInteger("Amount");}
if(nbt.hasKey("Type")) {this.types=nbt.getInteger("Type");}
if(nbt.hasKey("Rot")) {this.rot=nbt.getInteger("Rot");}
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
return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 0, nbt);
}

}
