package timaxa007.pack.techno.tile;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityChip extends TileEntity {

	private int type;
	//private int size;
	private int rot;

	public TileEntityChip() {
		type = 0;
		//size = 0;
		rot = 0;
	}

	public void setType(int i) {
		type = i;
	}

	/*public void setSize(int i) {
		size = i;
	}*/

	public void setRotation(int i) {
		rot = i;
	}

	public int getType() {
		return type;
	}

	/*public int getSize() {
		return size;
	}*/

	public int getRotation() {
		return rot;
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		if (nbt.hasKey("Type")) type = nbt.getInteger("Type");
		//if (nbt.hasKey("Size")) size = nbt.getInteger("Size");
		if (nbt.hasKey("Rotation")) rot = nbt.getInteger("Rotation");
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setInteger("Type", type);
		//nbt.setInteger("Size", size);
		nbt.setInteger("Rotation", rot);
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
