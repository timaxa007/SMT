package mods.timaxa007.pack.weapon.te;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TEClaymore extends TileEntity {
/*
private int growing;
private int plant;
private int sticks;
*/
public TEClaymore() {

}
/*
public int getGrowing() {return this.growing;}
public int getPlant() {return this.plant;}
public int getSticks() {return this.sticks;}

public void setGrowing(int i) {this.growing=i;}
public void setPlant(int i) {this.plant=i;}
public void setSticks(int i) {this.sticks=i;}

@Override
public void readFromNBT(NBTTagCompound nbt) {
super.readFromNBT(nbt);
if(nbt.hasKey("Growing")) {this.growing=nbt.getInteger("Growing");}
if(nbt.hasKey("Plant")) {this.plant=nbt.getInteger("Plant");}
if(nbt.hasKey("Sticks")) {this.sticks=nbt.getInteger("Sticks");}
}

@Override
public void writeToNBT(NBTTagCompound nbt) {
super.writeToNBT(nbt);
nbt.setInteger("Growing", growing);
nbt.setInteger("Plant", plant);
nbt.setInteger("Sticks", sticks);
}

public Packet getDescriptionPacket() {
NBTTagCompound nbt = new NBTTagCompound();
writeToNBT(nbt);
return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 0, nbt);
}
*/
}