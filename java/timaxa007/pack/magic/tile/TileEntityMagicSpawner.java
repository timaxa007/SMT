package timaxa007.pack.magic.tile;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TileEntityMagicSpawner extends TileEntity {

	private String style;
	private int rotation;

	public TileEntityMagicSpawner(World world) {
		this.worldObj = world;
		style = "";
		rotation = 0;
	}

	public void updateEntity() {

	}

	public void setStyle(String i) {style = i;}
	public String getStyle() {return style;}

	public void setRotation(int i) {rotation = i;}
	public int getRotation() {return rotation;}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
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
