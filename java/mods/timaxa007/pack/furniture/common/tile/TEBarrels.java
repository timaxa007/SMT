package mods.timaxa007.pack.furniture.common.tile;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TEBarrels extends TileEntity {

	private int typeB;
	private int typeP;
	private int typeCD;
	private int rotation;
	private boolean lie;

	public TEBarrels() {

	}

	public void setTypeB(int i) {
		typeB = i;
	}

	public void setTypeP(int i) {
		typeP = i;
	}

	public void setTypeCD(int i) {
		typeCD = i;
	}

	public void setRotation(int i) {
		rotation = i;
	}

	public void setLie(boolean i) {
		lie = i;
	}

	public int getTypeB() {
		return typeB;
	}

	public int getTypeP() {
		return typeP;
	}

	public int getTypeCD() {
		return typeCD;
	}

	public int getRotation() {
		return rotation;
	}

	public boolean getLie() {
		return lie;
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		if (nbt.hasKey("TypeB")) typeB = nbt.getInteger("TypeB");
		if (nbt.hasKey("TypeP")) typeP = nbt.getInteger("TypeP");
		if (nbt.hasKey("TypeCD")) typeCD = nbt.getInteger("TypeCD");
		if (nbt.hasKey("Rotation")) rotation = nbt.getInteger("Rotation");
		if (nbt.hasKey("Lie")) lie = nbt.getBoolean("Lie");
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setInteger("TypeB", typeB);
		nbt.setInteger("TypeP", typeP);
		nbt.setInteger("TypeCD", typeCD);
		nbt.setInteger("Rotation", rotation);
		nbt.setBoolean("Lie", lie);
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
