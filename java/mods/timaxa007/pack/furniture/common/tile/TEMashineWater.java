package mods.timaxa007.pack.furniture.common.tile;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;


public class TEMashineWater extends TileEntity implements IInventory {

	private int color;
	private int type;
	private int rotation;
	private boolean part;

	public TEMashineWater() {
		color = 0;
		type = 0;
		rotation = 0;
		part = false;
	}

	public void setColor(int i) {
		color = i;
	}

	public void setType(int i) {
		type = i;
	}

	public void setRotation(int i) {
		rotation = i;
	}

	public void setPart(boolean b) {
		part = b;
	}

	public int getColor() {
		return color;
	}

	public int getType() {
		return type;
	}

	public int getRotation() {
		return rotation;
	}

	public boolean getPart() {
		return part;
	}


	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		if (nbt.hasKey("Color")) color = nbt.getInteger("Color");
		if (nbt.hasKey("Type")) type = nbt.getInteger("Type");
		if (nbt.hasKey("Rotation")) rotation = nbt.getInteger("Rotation");
		if (nbt.hasKey("Part")) part = nbt.getBoolean("Part");
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		nbt.setInteger("Color", color);
		nbt.setInteger("Type", type);
		nbt.setInteger("Rotation", rotation);
		nbt.setBoolean("Part", part);
	}

	public Packet getDescriptionPacket() {
		NBTTagCompound nbt = new NBTTagCompound();
		writeToNBT(nbt);
		return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 0, nbt);
	}

	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet) {
		readFromNBT(packet.func_148857_g());
	}

	@Override
	public int getSizeInventory() {
		return 64;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		return null;
	}

	@Override
	public ItemStack decrStackSize(int i, int j) {
		return null;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		return null;
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack is) {

	}

	@Override
	public int getInventoryStackLimit() {
		return 0;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return false;
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack is) {
		return false;
	}

	@Override
	public String getInventoryName() {
		return null;
	}

	@Override
	public boolean hasCustomInventoryName() {
		return false;
	}

	@Override
	public void openInventory() {

	}

	@Override
	public void closeInventory() {

	}

}
