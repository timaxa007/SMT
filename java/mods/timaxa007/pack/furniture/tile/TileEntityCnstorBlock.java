package mods.timaxa007.pack.furniture.tile;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityCnstorBlock extends TileEntity {

	private String style;
	private int color_hex;

	public TileEntityCnstorBlock() {
		color_hex = 0xFFFFFF;
	}

	public String getStyle() {
		return style;
	}

	public int getColor() {
		return color_hex;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public void setColor(int color) {
		this.color_hex = color;
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		if (nbt.hasKey("Style")) style = nbt.getString("Style");
		if (nbt.hasKey("Color")) color_hex = nbt.getInteger("Color");
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setString("Style", style);
		nbt.setInteger("Color", color_hex);
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
