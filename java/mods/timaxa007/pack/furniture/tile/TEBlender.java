package mods.timaxa007.pack.furniture.tile;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TEBlender extends TileEntity {

	private int type;
	private int typeCap;
	private int typeHandler;
	private int typeBox;
	private int typeGlass;
	private int typeSize;
	private int size;
	private int rotation;

	public TEBlender() {
		type = 0;
		typeCap = 0;
		typeHandler = 0;
		typeBox = 0;
		typeGlass = 0;
		typeSize = 0;
		size = 0;
		rotation = 0;
	}

	public void setType(int i) {
		type = i;
	}

	public void setTypeCap(int i) {
		typeCap = i;
	}

	public void setTypeHandler(int i) {
		typeHandler = i;
	}

	public void setTypeBox(int i) {
		typeBox = i;
	}

	public void setTypeGlass(int i) {
		typeGlass = i;
	}

	public void setTypeSize(int i) {
		typeSize = i;
	}

	public void setSize(int i) {
		size = i;
	}

	public void setRotation(int i) {
		rotation = i;
	}

	public int getType() {
		return type;
	}

	public int getTypeCap() {
		return typeCap;
	}

	public int getTypeHandler() {
		return typeHandler;
	}

	public int getTypeBox() {
		return typeBox;
	}

	public int getTypeGlass() {
		return typeGlass;
	}

	public int getTypeSize() {
		return typeSize;
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
		if (nbt.hasKey("Type")) type = nbt.getInteger("Type");
		if (nbt.hasKey("TypeCap")) typeCap = nbt.getInteger("TypeCap");
		if (nbt.hasKey("TypeHandler")) typeHandler = nbt.getInteger("TypeHandler");
		if (nbt.hasKey("TypeBox")) typeBox = nbt.getInteger("TypeBox");
		if (nbt.hasKey("TypeGlass")) typeGlass = nbt.getInteger("TypeGlass");
		if (nbt.hasKey("TypeSize")) typeSize = nbt.getInteger("TypeSize");
		if (nbt.hasKey("Size")) size = nbt.getInteger("Size");
		if (nbt.hasKey("Rotation")) rotation = nbt.getInteger("Rotation");
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setInteger("Type", type);
		nbt.setInteger("TypeCap", typeCap);
		nbt.setInteger("TypeHandler", typeHandler);
		nbt.setInteger("TypeBox", typeBox);
		nbt.setInteger("TypeGlass", typeGlass);
		nbt.setInteger("TypeSize", typeSize);
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
