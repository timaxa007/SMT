package timaxa007.pack.furniture.tile;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityPipes extends TileEntity {

	private String style;
	private int size;
	private int color_hex;
	public boolean up;
	public boolean down;
	public boolean north;
	public boolean south;
	public boolean west;
	public boolean east;

	public TileEntityPipes(World world) {
		this.worldObj = world;
		style = "";
		size = 0;
		color_hex = 0;
		up = true;
		down = true;
		north = true;
		south = true;
		west = true;
		east = true;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public void setSize(int i) {
		if (i <= 1) {
			size = 1;
		} else if (i >= 8) {
			size = 8;
		} else {
			size = i;
		}
	}

	public void setColor(int color) {
		color_hex = color;
	}

	public void updateEntity() {
		if (worldObj.getTileEntity(xCoord, yCoord + 1, zCoord) instanceof TileEntityPipes) {up = true;} else {up = false;}
		if (worldObj.getTileEntity(xCoord, yCoord - 1, zCoord) instanceof TileEntityPipes) {down = true;} else {down = false;}
		if (worldObj.getTileEntity(xCoord + 1, yCoord, zCoord) instanceof TileEntityPipes) {north = true;} else {north = false;}
		if (worldObj.getTileEntity(xCoord - 1, yCoord, zCoord) instanceof TileEntityPipes) {south = true;} else {south = false;}
		if (worldObj.getTileEntity(xCoord, yCoord, zCoord + 1) instanceof TileEntityPipes) {west = true;} else {west = false;}
		if (worldObj.getTileEntity(xCoord, yCoord, zCoord - 1) instanceof TileEntityPipes) {east = true;} else {east = false;}
	}

	public String getStyle() {
		return style;
	}

	public int getSize() {
		return size;
	}

	public int getColor() {
		return color_hex;
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		if (nbt.hasKey("Style")) style = nbt.getString("Style");
		if (nbt.hasKey("Size")) size = nbt.getInteger("Size");
		if (nbt.hasKey("Color")) color_hex = nbt.getInteger("Color");
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setString("Style", style);
		nbt.setInteger("Size", size);
		nbt.setInteger("Color", color_hex);
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
