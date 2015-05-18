package timaxa007.pack.magic.tile;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import timaxa007.module.forbidden.api.ITileEntityOwner;
import timaxa007.smt.util.UtilString;

public class TileEntityMagicCauldron extends TileEntity implements ITileEntityOwner {

	private String owner;

	public TileEntityMagicCauldron() {
		owner = "";
	}

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
