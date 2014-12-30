package mods.timaxa007.pack.furniture.tile;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityTable extends TileEntity {

	private String style;
	private int size;
	private int rotation;

	public TileEntityTable() {
		style = "";
		size = 0;
		rotation = 0;
	}

	public void setStyle(String i) {
		style = i;
	}

	public void setSize(int i) {
		size = i;
	}

	public void setRotation(int i) {
		rotation = i;
	}

	public String getStyle() {
		return style;
	}

	public int getSize() {
		return size;
	}

	public int getRotation() {
		return rotation;
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		if (nbt.hasKey("Style")) style = nbt.getString("Style");
		if (nbt.hasKey("Size")) size = nbt.getInteger("Size");
		if (nbt.hasKey("Rotation")) rotation = nbt.getInteger("Rotation");
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setString("Style", style);
		nbt.setInteger("Size", size);
		nbt.setInteger("Rotation", rotation);
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
