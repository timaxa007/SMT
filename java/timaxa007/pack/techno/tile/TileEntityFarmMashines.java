package timaxa007.pack.techno.tile;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import timaxa007.tms.util.ITileEntityOwner;
import timaxa007.tms.util.UtilString;

public class TileEntityFarmMashines extends TileEntity implements ITileEntityOwner {

	private String style;
	private int type;
	private int color_hex;
	private int rot;
	private String owner;

	public TileEntityFarmMashines() {
		style = "";
		type = 0;
		color_hex = 0;
		rot = 0;
		owner = "";
	}

	public void setStyle(String style) {this.style = style;}
	public String getStyle() {return style;}

	public void setType(int type) {this.type = type;}
	public int getType() {return type;}

	public void setColor(int color_hex) {this.color_hex = color_hex;}
	public int getColor() {return color_hex;}

	public void setRot(int i) {this.rot = i;}
	public int getRot() {return rot;}

	public void setOwner(String username) {owner = username;}
	public String getOwner() {return owner;}

	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		if (nbt.hasKey("Style")) style = nbt.getString("Style");
		if (nbt.hasKey("Type")) type = nbt.getInteger("Type");
		if (nbt.hasKey("ColorHex")) color_hex = nbt.getInteger("ColorHex");
		if (nbt.hasKey("Rot")) rot = nbt.getInteger("Rot");
		if (nbt.hasKey("Owner")) owner = nbt.getString("Owner");
	}

	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		if (UtilString.hasString(style)) nbt.setString("Style", style);
		nbt.setInteger("Type", type);
		nbt.setInteger("ColorHex", color_hex);
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
