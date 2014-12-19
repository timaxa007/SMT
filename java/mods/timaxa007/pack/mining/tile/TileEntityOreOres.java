package mods.timaxa007.pack.mining.tile;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityOreOres extends TileEntity {

	private int type;
	private int color_block;

	public TileEntityOreOres() {
		type = 0;
		color_block = 0xFFFFFF;
	}

	public void setType(int i) {
		type = i;
	}

	public void setColorBlock(int i) {
		color_block = i;
	}

	public int getType() {
		return type;
	}

	public int getColorBlock() {
		return color_block;
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		if (nbt.hasKey("Type")) type = (int)nbt.getByte("Type");
		if (nbt.hasKey("ColorBlock")) color_block = nbt.getInteger("ColorBlock");
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setByte("Type", (byte)type);
		nbt.setInteger("ColorBlock", color_block);
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
