package mods.timaxa007.pack.furniture.te;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TEBoxParticles extends TileEntity {

	private int types;
	private int rot;

	public TEBoxParticles() {
		types = 0;
		rot = 0;
	}

	public void setTypes(int i) {
		types = i;
	}

	public void setRot(int i) {
		rot = i;
	}

	public int getTypes() {
		return types;
	}

	public int getRot() {
		return rot;
	}

	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		if (nbt.hasKey("Type")) types=nbt.getInteger("Type");
		if (nbt.hasKey("Rot")) rot=nbt.getInteger("Rot");
	}

	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setInteger("Type", types);
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
