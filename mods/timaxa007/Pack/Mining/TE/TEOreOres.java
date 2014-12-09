package mods.timaxa007.Pack.Mining.TE;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;

public class TEOreOres extends TileEntity {

private int type;
private int color_block;

public TEOreOres() {
type = 0;
color_block = 0xFFFFFF;
}

public int getType() {return type;}
public int getColorBlock() {return color_block;}

public void setType(int i) {type = i;}
public void setColorBlock(int i) {color_block = i;}

@Override
public void readFromNBT(NBTTagCompound nbt) {
super.readFromNBT(nbt);
if (nbt.hasKey("Type")) {type = (int)nbt.getByte("Type");}
if (nbt.hasKey("ColorBlock")) {color_block = nbt.getInteger("ColorBlock");}
}

@Override
public void writeToNBT(NBTTagCompound nbt) {
super.writeToNBT(nbt);
nbt.setByte("Type", (byte)type);
nbt.setInteger("ColorBlock", color_block);
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
