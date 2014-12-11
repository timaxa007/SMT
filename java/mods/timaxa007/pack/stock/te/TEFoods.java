package mods.timaxa007.pack.stock.te;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TEFoods extends TileEntity {

private int foodID;
private int type;
private int color1;
private int color2;
private int rotate;

public TEFoods() {

}

public void setFoodID(int i) {foodID = i;}
public void setType(int i) {type = i;}
public void setColor1(int i) {color1 = i;}
public void setColor2(int i) {color2 = i;}
public void setRotate(int i) {rotate = i;}

public int getFoodID() {return foodID;}
public int getType() {return type;}
public int getColor1() {return color1;}
public int getColor2() {return color2;}
public int getRotate() {return rotate;}

@Override
public void readFromNBT(NBTTagCompound nbt) {
super.readFromNBT(nbt);
if (nbt.hasKey("FoodID")) {foodID = nbt.getInteger("FoodID");}
if (nbt.hasKey("Type")) {type = nbt.getInteger("Type");}
if (nbt.hasKey("Color1")) {color1 = nbt.getInteger("Color1");}
if (nbt.hasKey("Color2")) {color2 = nbt.getInteger("Color2");}
if (nbt.hasKey("Rotate")) {rotate = nbt.getInteger("Rotate");}
}

@Override
public void writeToNBT(NBTTagCompound nbt) {
super.writeToNBT(nbt);
nbt.setInteger("FoodID", foodID);
nbt.setInteger("Type", type);
nbt.setInteger("Color1", color1);
nbt.setInteger("Color2", color2);
nbt.setInteger("Rotate", rotate);
}

//public boolean canUpdate() {return false;}

public Packet getDescriptionPacket() {
NBTTagCompound nbt = new NBTTagCompound();
writeToNBT(nbt);
return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 0, nbt);
}

}
