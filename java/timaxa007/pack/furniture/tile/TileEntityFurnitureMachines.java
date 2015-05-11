package timaxa007.pack.furniture.tile;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import timaxa007.tms.util.UtilString;

public class TileEntityFurnitureMachines extends TileEntity {

	private int type;
	private int rotation;
	private String owner;

	public TileEntityFurnitureMachines() {
		type = 0;
		rotation = 0;
		owner = "";
	}

	public void setType(int i) {type = i;}
	public int getType() {return type;}

	public void setRotation(int i) {rotation = i;}
	public int getRotation() {return rotation;}

	public void setOwner(String username) {owner = username;}
	public String getOwner() {return owner;}

	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		if (nbt.hasKey("Owner")) owner = nbt.getString("Owner");
	}

	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
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
