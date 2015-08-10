package timaxa007.pack.techno.tile;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import timaxa007.module.forbidden.api.ITileEntityOwner;
import timaxa007.smt.util.UtilString;

public class TileEntityElectricWires extends TileEntity implements ITileEntityOwner {

	private String style;
	//private int type;
	private int size;
	private int color_hex;
	private String owner;

	public boolean up;
	public boolean down;
	public boolean north;
	public boolean south;
	public boolean west;
	public boolean east;

	public TileEntityElectricWires(World world) {
		this.worldObj = world;
		//type = 0;
		size = 0;
		color_hex = 0xFFFFFF;
		up = true;
		down = true;
		north = true;
		south = true;
		west = true;
		east = true;
		owner = "";
	}

	public void setStyle(String style) {this.style = style;}
	public String getStyle() {return style;}
	/*
	public void setType(int i) {type = i;}
	public int getType() {return type;}
	 */
	public void setSize(int i) {
		if (i <= 1) size = 1;
		else if (i >= 8) size = 8;
		else size = i;
	}

	public int getSize() {return size;}

	public void setColor(int color_hex) {this.color_hex = color_hex;}
	public int getColor() {return color_hex;}

	public void setOwner(String username) {owner = username;}
	public String getOwner() {return owner;}

	/*
	public void updateEntity() {
		if (worldObj.getTileEntity(xCoord, yCoord + 1, zCoord) instanceof TileEntityElectricWires) {up = true;} else {up = false;}
		if (worldObj.getTileEntity(xCoord, yCoord - 1, zCoord) instanceof TileEntityElectricWires) {down = true;} else {down = false;}
		if (worldObj.getTileEntity(xCoord + 1, yCoord, zCoord) instanceof TileEntityElectricWires) {north = true;} else {north = false;}
		if (worldObj.getTileEntity(xCoord - 1, yCoord, zCoord) instanceof TileEntityElectricWires) {south = true;} else {south = false;}
		if (worldObj.getTileEntity(xCoord, yCoord, zCoord + 1) instanceof TileEntityElectricWires) {west = true;} else {west = false;}
		if (worldObj.getTileEntity(xCoord, yCoord, zCoord - 1) instanceof TileEntityElectricWires) {east = true;} else {east = false;}
	}
	 */
	public void update() {
		blankUpdate(worldObj, xCoord, yCoord, zCoord);
	}

	public static void updateExtensively(World world, int x, int y, int z) {
		blankUpdate(world, x, y, z);//-
		blankUpdate(world, x, y + 1, z);
		blankUpdate(world, x, y - 1, z);
		blankUpdate(world, x + 1, y, z);
		blankUpdate(world, x - 1, y, z);
		blankUpdate(world, x, y, z + 1);
		blankUpdate(world, x, y, z - 1);
	}

	private static void blankUpdate(World world, int x, int y, int z) {
		TileEntity te_base = world.getTileEntity(x, y, z);
		if (te_base != null && te_base instanceof TileEntityElectricWires) {

			TileEntityElectricWires tile_base = (TileEntityElectricWires)te_base;

			TileEntity tile_up = world.getTileEntity(x, y + 1, z);
			TileEntity tile_down = world.getTileEntity(x, y - 1, z);
			TileEntity tile_north = world.getTileEntity(x + 1, y, z);
			TileEntity tile_south = world.getTileEntity(x - 1, y, z);
			TileEntity tile_west = world.getTileEntity(x, y, z + 1);
			TileEntity tile_east = world.getTileEntity(x, y, z - 1);

			if (tile_up != null && tile_up instanceof TileEntityElectricWires)
				tile_base.up = true; else tile_base.up = false;
			if (tile_down != null && tile_down instanceof TileEntityElectricWires)
				tile_base.down = true; else tile_base.down = false;
			if (tile_north != null && tile_north instanceof TileEntityElectricWires)
				tile_base.north = true; else tile_base.north = false;
			if (tile_south != null && tile_south instanceof TileEntityElectricWires)
				tile_base.south = true; else tile_base.south = false;
			if (tile_west != null && tile_west instanceof TileEntityElectricWires)
				tile_base.west = true; else tile_base.west = false;
			if (tile_east != null && tile_east instanceof TileEntityElectricWires)
				tile_base.east = true; else tile_base.east = false;

		}
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		if (nbt.hasKey("Style")) style = nbt.getString("Style");
		//if (nbt.hasKey("Type")) type = nbt.getInteger("Type");
		if (nbt.hasKey("Size")) size = nbt.getInteger("Size");
		if (nbt.hasKey("ColorHex")) color_hex = nbt.getInteger("ColorHex");
		if (nbt.hasKey("Owner")) owner = nbt.getString("Owner");
		if (nbt.hasKey("Stat")) {
			int stat = nbt.getByte("Stat");
			this.up = ((stat & 0x1) == 0 ? false : true);
			this.down = ((stat >> 1 & 0x1) == 0 ? false : true);
			this.north = ((stat >> 2 & 0x1) == 0 ? false : true);
			this.south = ((stat >> 3 & 0x1) == 0 ? false : true);
			this.west = ((stat >> 4 & 0x1) == 0 ? false : true);
			this.east = ((stat >> 5 & 0x1) == 0 ? false : true);
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		if (UtilString.hasString(style)) nbt.setString("Style", style);
		//nbt.setInteger("Type", type);
		nbt.setInteger("Size", size);
		nbt.setInteger("ColorHex", color_hex);
		if (UtilString.hasString(owner)) nbt.setString("Owner", owner);
		nbt.setByte("Stat", (byte) (
				(east ? 1 : 0) << 5 | 
				(west ? 1 : 0) << 4 | 
				(south ? 1 : 0) << 3 | 
				(north ? 1 : 0) << 2 | 
				(down ? 1 : 0) << 1 | 
				(up ? 1 : 0)
				));
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
