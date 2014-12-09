package mods.timaxa007.pack.techno.te;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;

public class TEModuleMovement extends TileEntity {

private int types;
private int rot;

public TEModuleMovement() {

}

public int getTypes() {return this.types;}
public int getRot() {return this.rot;}

public void setTypes(int i) {this.types=i;}
public void setRot(int i) {this.rot=i;}

public void readFromNBT(NBTTagCompound nbt) {
super.readFromNBT(nbt);
if(nbt.hasKey("Type")) {this.types=nbt.getInteger("Type");}
if(nbt.hasKey("Rot")) {this.rot=nbt.getInteger("Rot");}
}

public void writeToNBT(NBTTagCompound nbt) {
super.writeToNBT(nbt);
nbt.setInteger("Type", types);
nbt.setInteger("Rot", rot);
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
