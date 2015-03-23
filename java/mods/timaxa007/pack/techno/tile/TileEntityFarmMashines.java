package mods.timaxa007.pack.techno.tile;

import mods.timaxa007.tms.util.UtilString;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityFarmMashines extends TileEntity {

	private String style;
	private int type;
	private int color;
	private int rot;

	public TileEntityFarmMashines() {
		style = "";
		type = 0;
		color = 0;
		rot = 0;
	}

	public void setStyle(String i) {style = i;}
	public String getStyle() {return style;}

	public void setType(int i) {type = i;}
	public int getType() {return type;}

	public void setColor(int i) {color = i;}
	public int getColor() {return color;}

	public void setRot(int i) {rot = i;}
	public int getRot() {return rot;}

	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		if (nbt.hasKey("Style")) style = nbt.getString("Style");
		if (nbt.hasKey("Type")) type = nbt.getInteger("Type");
		if (nbt.hasKey("Color")) color = nbt.getInteger("Color");
		if (nbt.hasKey("Rot")) rot = nbt.getInteger("Rot");
	}

	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		if (UtilString.hasString(style)) nbt.setString("Style", style);
		nbt.setInteger("Type", type);
		nbt.setInteger("Color", color);
		nbt.setInteger("Rot", rot);
	}

	public Packet getDescriptionPacket() {
		NBTTagCompound nbt = new NBTTagCompound();
		writeToNBT(nbt);
		return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 0, nbt);
	}

	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet) {
		readFromNBT(packet.func_148857_g());
	}

}
