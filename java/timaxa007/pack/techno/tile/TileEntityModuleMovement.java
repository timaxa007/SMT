package timaxa007.pack.techno.tile;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import timaxa007.module.forbidden.api.ITileEntityOwner;
import timaxa007.smt.util.UtilString;

public class TileEntityModuleMovement extends TileEntity implements ITileEntityOwner {

	private int type;
	private int rot;
	private String owner;

	public TileEntityModuleMovement(World world) {
		this.worldObj = world;
		type = 0;
		rot = 0;
		owner = "";
	}

	public void setType(int i) {type = i;}
	public int getType() {return type;}

	public void setRot(int i) {rot = i;}
	public int getRot() {return rot;}

	public void setOwner(String username) {owner = username;}
	public String getOwner() {return owner;}

	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		if (nbt.hasKey("Type")) type = nbt.getInteger("Type");
		if (nbt.hasKey("Rot")) rot = nbt.getInteger("Rot");
		if (nbt.hasKey("Owner")) owner = nbt.getString("Owner");
	}

	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setInteger("Type", type);
		nbt.setInteger("Rot", rot);
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
