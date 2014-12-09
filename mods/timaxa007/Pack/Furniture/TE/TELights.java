package mods.timaxa007.Pack.Furniture.TE;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.Packet132TileEntityData;
import net.minecraft.tileentity.TileEntity;

public class TELights extends TileEntity {

private String type;
private int light_level;// 0 >= 16
private int color_hex1;

public TELights() {
type = "";
light_level = 0;
color_hex1 = 0xFFFFFF;
}

public void setType(String str) {type = str;}
/** <b>int</b> - 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16**/
public void setLightLevel(int i) {
if (light_level < 0) {light_level = 0;}
else if (light_level > 16) {light_level = 16;}
else {light_level = i;}
}
/** <b>float</b> - 0.0F, 0.0625F, 0.125F, 0.1875F, 0.25F, 0.3125F, 0.375F, 0.4375F, 
 * 0.5F, 0.5625F, 0.625F, 0.6875F, 0.75F, 0.8125F, 0.875F, 0.9375F, 1.0F
**/
public void setLightValue(float f) {setLightLevel((int)(f*16.0F));}
public void setColorHex1(int i) {color_hex1 = i;}

public String getType()	{return type;}
public int getLightLevel()		{return light_level;}
public float getLightValue()	{return ((float)light_level) / 16.0F;}
public int getColorHex1()	{return color_hex1;}

public boolean isGlow()	{return light_level != 0;}
public boolean isLit()	{if (light_level != 0) {return true;} else {return false;}}

public boolean canUpdate() {return false;}

@Override
public void readFromNBT(NBTTagCompound nbt) {
super.readFromNBT(nbt);
if (nbt.hasKey("Type")) {type = nbt.getString("Type");}
//if (nbt.hasKey("LigLvL")) {light_level = (int)nbt.getByte("LigLvL");}
if (nbt.hasKey("ColorHex1")) {color_hex1 = nbt.getInteger("ColorHex1");}
}

@Override
public void writeToNBT(NBTTagCompound nbt) {
super.writeToNBT(nbt);
nbt.setString("Type", type);
//nbt.setByte("LigLvL", (byte)light_level);
nbt.setInteger("ColorHex1", color_hex1);
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
