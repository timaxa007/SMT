package mods.timaxa007.pack.furniture.tile;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityGrills extends TileEntity {

	private String style;
	private int rot;

	public TileEntityGrills() {
		style = "";
		rot = 0;
	}

	public String getStyle() {
		return style;
	}

	public int getRot() {
		return rot;
	}

	public void setStyle(String i) {
		style = i;
	}

	public void setRot(int i) {
		rot = i;
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
