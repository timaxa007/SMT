package mods.timaxa007.pack.stock.te;

import mods.timaxa007.pack.stock.PackStock;
import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;

public class TEGerminationPlants extends TileEntity {

private int plant_id;
private String plant_type;
private int width;
private int height;
private int growth;
private int fertility;
private int resistance;

public TEGerminationPlants() {

}
/*
public void updateEntity() {
int updt = 1;

if (getTypePlant() == 1) {
if (worldObj.getWorldTime() % (20 * updt) == 0 && getGrowing() <= 8) {
setGrowing(getGrowing() + 1);
}
}
//-------------------------------------------------------------------------------
if (getTypePlant() == 2) {

if (worldObj.getWorldTime() % (20 * updt) == 0 && getHeight() < 16) {
setHeight(getHeight() + 1);
}

TileEntity teb = worldObj.getBlockTileEntity(xCoord, yCoord - 1, zCoord);

if (worldObj.getWorldTime() % (20 * 10 * updt) == 0 && getThickness() <= 8) {
if (teb != null && teb instanceof TEGerminationPlants) {
if (((TEGerminationPlants)teb).getThickness() > getThickness()) {
setThickness(getThickness() + 1);
}
} else if (teb == null) {
setThickness(getThickness() + 1);
} else {;}

}

if (!worldObj.isRemote && worldObj.getWorldTime() % (20 * updt) == 0 &&
(worldObj.isAirBlock(xCoord, yCoord + 1, zCoord) || worldObj.getBlockId(xCoord, yCoord + 1, zCoord) == Block.leaves.blockID) &&
getHeight() == 16) {
worldObj.setBlock(xCoord, yCoord + 1, zCoord, PackStock.proxy.block_germination_plants.blockID);
TEGerminationPlants tes = new TEGerminationPlants();
tes.setTypePlant(getTypePlant());
tes.setPlant(getPlant());
tes.setSticks(0);
tes.setHeight(1);
tes.setThickness(1);
worldObj.setBlockTileEntity(xCoord, yCoord + 1, zCoord, tes);
}

}
//-------------------------------------------------------------------------------
//if (!worldObj.isRemote) {}

}
*/
//public boolean canUpdate() {return false;}
/*
public int getGrowing() {return growing;}
public int getHeight() {return height;}
public int getThickness() {return thickness;}
public int getPlant() {return plant;}
public int getTypePlant() {return type_plant;}
public int getSticks() {return sticks;}
public int getGrowth() {return growth;}
public int getFertility() {return fertility;}
public int getResistance() {return resistance;}

public void setGrowing(int i) {if (i <= 1) {growing = 1;} else if (i >= 8) {growing = 8;} else {growing = i;}}
public void setHeight(int i) {if (i <= 1) {height = 1;} else if (i >= 16) {height = 16;} else {height = i;}}
public void setThickness(int i) {if (i <= 1) {thickness = 1;} else if (i >= 8) {thickness = 8;} else {thickness = i;}}
public void setPlant(int i) {plant = i;}
public void setTypePlant(int i) {type_plant = i;}
public void setSticks(int i) {sticks = i;}
public void setGrowth(int i) {
if (i >= Byte.MAX_VALUE) {growth = Byte.MAX_VALUE;}
else if (i <= 0) {growth = 0;}
else {growth = i;}
}
public void setFertility(int i) {
if (i >= Byte.MAX_VALUE) {fertility = Byte.MAX_VALUE;}
else if (i <= 0) {fertility = 0;}
else {fertility = i;}
}
public void setResistance(int i) {
if (i >= Byte.MAX_VALUE) {resistance = Byte.MAX_VALUE;}
else if (i <= 0) {resistance = 0;}
else {resistance = i;}
}
*/

public void setPlantID(int i) {plant_id = i;}
public void setPlantType(String i) {plant_type = i;}
public void setWidth(int i) {width = i;}
public void setHeight(int i) {if (i <= 1) {height = 1;} else if (i >= 8) {height = 8;} else {height = i;}}
public void setGrowth(int i) {growth = i;}
public void setFertility(int i) {fertility = i;}
public void setResistance(int i) {resistance = i;}

public int getPlantID() {return plant_id;}
public String getPlantType() {return plant_type;}
public int getWidth() {return width;}
public int getHeight() {return height;}
public int getGrowth() {return growth;}
public int getFertility() {return fertility;}
public int getResistance() {return resistance;}

public void updateEntity() {
int updt = 1;

if (worldObj.getWorldTime() % (20 * updt) == 0 && getHeight() <= 8) {
setHeight(getHeight() + 1);
}

//if (getPlantType() == "Tree") {System.out.println(" + ");}
}

@Override
public void readFromNBT(NBTTagCompound nbt) {
super.readFromNBT(nbt);
if (nbt.hasKey("PlantID")) {plant_id = nbt.getInteger("PlantID");}
if (nbt.hasKey("PlantType")) {plant_type = nbt.getString("PlantType");}
if (nbt.hasKey("Width")) {width = nbt.getInteger("Width");}
if (nbt.hasKey("Height")) {height = nbt.getInteger("Height");}
if (nbt.hasKey("Growth")) {growth = nbt.getInteger("Growth");}
if (nbt.hasKey("Fertility")) {fertility = nbt.getInteger("Fertility");}
if (nbt.hasKey("Resistance")) {resistance = nbt.getInteger("Resistance");}
}

@Override
public void writeToNBT(NBTTagCompound nbt) {
super.writeToNBT(nbt);
nbt.setInteger("PlantID", plant_id);
nbt.setString("PlantType", plant_type);
nbt.setInteger("Width", width);
nbt.setInteger("Height", height);
nbt.setInteger("Growth", growth);
nbt.setInteger("Fertility", fertility);
nbt.setInteger("Resistance", resistance);
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
