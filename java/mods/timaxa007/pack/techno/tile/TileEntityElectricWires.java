package mods.timaxa007.pack.techno.tile;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityElectricWires extends TileEntity {

	private String style;
	//private int type;
	private int size;
	private int color;

	public boolean up;
	public boolean down;
	public boolean north;
	public boolean south;
	public boolean west;
	public boolean east;

	public TileEntityElectricWires() {
		//type = 0;
		size = 0;
		color = 0xFFFFFF;
		up = true;;
		down = true;;
		north = true;;
		south = true;;
		west = true;;
		east = true;;
	}

	public void setStyle(String i) {
		style = i;
	}

	public String getStyle() {
		return style;
	}
	/*
	public void setType(int i) {
		type = i;
	}

	public int getType() {
		return type;
	}
	 */
	public void setSize(int i) {
		if (i <= 1) {
			size = 1;
		} else if (i >= 8) {
			size = 8;
		} else {
			size = i;
		}
	}

	public int getSize() {
		return size;
	}

	public void setColor(int i) {
		color = i;
	}

	public int getColor() {
		return color;
	}

	public void updateEntity() {
		if (worldObj.getTileEntity(xCoord, yCoord + 1, zCoord) instanceof TileEntityElectricWires) {up = true;} else {up = false;}
		if (worldObj.getTileEntity(xCoord, yCoord - 1, zCoord) instanceof TileEntityElectricWires) {down = true;} else {down = false;}
		if (worldObj.getTileEntity(xCoord + 1, yCoord, zCoord) instanceof TileEntityElectricWires) {north = true;} else {north = false;}
		if (worldObj.getTileEntity(xCoord - 1, yCoord, zCoord) instanceof TileEntityElectricWires) {south = true;} else {south = false;}
		if (worldObj.getTileEntity(xCoord, yCoord, zCoord + 1) instanceof TileEntityElectricWires) {west = true;} else {west = false;}
		if (worldObj.getTileEntity(xCoord, yCoord, zCoord - 1) instanceof TileEntityElectricWires) {east = true;} else {east = false;}
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		if (nbt.hasKey("Style")) style = nbt.getString("Style");
		//if (nbt.hasKey("Type")) type = nbt.getInteger("Type");
		if (nbt.hasKey("Size")) size = nbt.getInteger("Size");
		if (nbt.hasKey("Color")) color = nbt.getInteger("Color");
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		if (style != null) nbt.setString("Style", style);
		//nbt.setInteger("Type", type);
		nbt.setInteger("Size", size);
		nbt.setInteger("Color", color);
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
