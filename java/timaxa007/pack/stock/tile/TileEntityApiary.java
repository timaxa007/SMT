package timaxa007.pack.stock.tile;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import timaxa007.module.forbidden.api.ITileEntityOwner;
import timaxa007.smt.util.UtilString;

public class TileEntityApiary extends TileEntity implements ITileEntityOwner {

	private String name;
	private int type;
	private String owner;

	public TileEntityApiary(World world) {
		this.worldObj = world;
		name = "";
		type = 0;
		owner = "";
	}

	public void setName(String str) {name = str;}
	public String getName() {return name;}

	public void setType(int i) {type = i;}
	public int getType() {return type;}

	public void setOwner(String username) {owner = username;}
	public String getOwner() {return owner;}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		if (nbt.hasKey("NameID")) name = nbt.getString("NameID");
		if (nbt.hasKey("TypeID")) type = nbt.getInteger("TypeID");
		if (nbt.hasKey("Owner")) owner = nbt.getString("Owner");
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setString("NameID", name);
		nbt.setInteger("TypeID", type);
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
