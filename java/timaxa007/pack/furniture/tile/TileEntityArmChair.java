package timaxa007.pack.furniture.tile;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityArmChair extends TileEntity {

	private String type;
	private int size;
	private int rotation;

	public TileEntityArmChair(World world) {
		this.worldObj = world;
		type = "";
		size = 0;
		rotation = 0;
	}

	public void setType(String str) {
		type = str;
	}

	public void setSize(int i) {
		size = i;
	}

	public void setRotation(int i) {
		rotation = i;
	}

	public String getType() {
		return type;
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

	public Packet getDescriptionPacket() {
		NBTTagCompound nbt = new NBTTagCompound();
		writeToNBT(nbt);
		return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 0, nbt);
	}

	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet) {
		readFromNBT(packet.func_148857_g());
	}

}
