package timaxa007.pack.furniture.tile;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityAngleMod extends TileEntity {

	private int type;
	private int size;
	private int rotation;
	private boolean uping;

	public TileEntityAngleMod(World world) {
		this.worldObj = world;
		type = 0;
		size = 0;
		rotation = 0;
		uping = false;
	}

	public void setType(int i) {
		type = i;
	}
	
	public void setSize(int i) {
		size = i;
	}
	
	public void setRotation(int i) {
		rotation = i;
	}
	
	public void setUPing(boolean i) {
		uping = i;
	}

	public int getType() {
		return type;
	}
	
	public int getSize() {
		return size;
	}
	
	public int getRotation() {
		return rotation;
	}
	
	public boolean getUPing() {
		return uping;
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		if (nbt.hasKey("Type")) type = nbt.getInteger("Type");
		if (nbt.hasKey("Size")) size = nbt.getInteger("Size");
		if (nbt.hasKey("Rotation")) rotation = nbt.getInteger("Rotation");
		if (nbt.hasKey("UPing")) uping = nbt.getBoolean("UPing");
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setInteger("Type", type);
		nbt.setInteger("Size", size);
		nbt.setInteger("Rotation", rotation);
		nbt.setBoolean("UPing", uping);
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
