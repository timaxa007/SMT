package timaxa007.pack.furniture.tile;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityCrystals extends TileEntity {

	private int amount;
	private int types;
	private int rot;

	public TileEntityCrystals() {
		amount = 8;
		types = 0;
		rot = 0;
	}

	public void setAmount(int i) {
		amount = i;
	}

	public void setTypes(int i) {
		types = i;
	}

	public void setRot(int i) {
		rot = i;
	}

	public int getAmount() {
		return amount;
	}

	public int getTypes() {
		return types;
	}

	public int getRot() {
		return rot;
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		if (nbt.hasKey("Amount")) amount = nbt.getInteger("Amount");
		if (nbt.hasKey("Type")) types = nbt.getInteger("Type");
		if (nbt.hasKey("Rot")) rot = nbt.getInteger("Rot");
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setInteger("Amount", amount);
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
