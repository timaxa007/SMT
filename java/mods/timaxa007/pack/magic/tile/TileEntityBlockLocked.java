package mods.timaxa007.pack.magic.tile;

import mods.timaxa007.tms.util.UtilString;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityBlockLocked extends TileEntity {

	private int type;
	private String owner;

	public TileEntityBlockLocked() {
		type = 0;
		owner = "";
	}

	public void updateEntity() {

	}

	public void setType(int i) {
		type = i;
	}

	public void setOwner(String i) {
		owner = i;
	}

	public int getType() {
		return type;
	}

	public String getOwner() {
		return owner;
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		if (nbt.hasKey("Type")) type = nbt.getInteger("Type");
		if (nbt.hasKey("Owner")) owner = nbt.getString("Owner");
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setInteger("Type", type);
		if (UtilString.hasString(owner)) nbt.setString("Owner", owner);
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
