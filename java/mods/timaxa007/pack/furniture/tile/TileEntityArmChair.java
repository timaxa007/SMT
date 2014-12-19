package mods.timaxa007.pack.furniture.tile;

import mods.timaxa007.lib.tile.IDataUser;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityArmChair extends TileEntity implements IDataUser {

	private String type;
	private int size;
	private int rotation;

	public String getType() {
		return type;
	}

	public int getSize() {
		return size;
	}
	public int getRotation() {
		return rotation;
	}

	public void setType(String i) {
		type = i;
	}

	public void setSize(int i) {
		size = i;
	}

	public void setRotation(int i) {
		rotation = i;
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		if (nbt.hasKey("Type")) type = nbt.getString("Type");
		if (nbt.hasKey("Size")) size = nbt.getInteger("Size");
		if (nbt.hasKey("Rotation")) rotation = nbt.getInteger("Rotation");
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setString("Type", type);
		nbt.setInteger("Size", size);
		nbt.setInteger("Rotation", rotation);
	}
}
