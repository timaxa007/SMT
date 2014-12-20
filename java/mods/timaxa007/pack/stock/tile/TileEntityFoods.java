package mods.timaxa007.pack.stock.tile;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityFoods extends TileEntity {

	private String tag;
	private int color1;
	private int color2;
	private int rotation;

	public TileEntityFoods() {
		tag = null;
		color1 = 0;
		color2 = 0;
		rotation = 0;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getTag() {
		return tag;
	}

	public void setColor1(int i) {
		color1 = i;
	}

	public int getColor1() {
		return color1;
	}

	public void setColor2(int i) {
		color2 = i;
	}

	public int getColor2() {
		return color2;
	}

	public void setRotation(int i) {
		rotation = i;
	}

	public int getRotation() {
		return rotation;
	}


	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		if (nbt.hasKey("NameID")) tag = nbt.getString("NameID");
		if (nbt.hasKey("Color1")) color1 = nbt.getInteger("Color1");
		if (nbt.hasKey("Color2")) color2 = nbt.getInteger("Color2");
		if (nbt.hasKey("Rotation")) rotation = nbt.getByte("Rotation");
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		if (tag == null) {
			worldObj.removeTileEntity(xCoord, yCoord, zCoord);
			worldObj.setBlockToAir(xCoord, yCoord, zCoord);
		}
		nbt.setString("NameID", tag);
		nbt.setInteger("Color1", color1);
		nbt.setInteger("Color2", color2);
		nbt.setByte("Rotation", (byte)rotation);
	}

	//public boolean canUpdate() {return false;}

	public Packet getDescriptionPacket() {
		NBTTagCompound nbt = new NBTTagCompound();
		writeToNBT(nbt);
		return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 0, nbt);
	}

	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet) {
		readFromNBT(packet.func_148857_g());
	}

}
