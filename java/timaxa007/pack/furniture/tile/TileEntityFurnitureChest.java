package timaxa007.pack.furniture.tile;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityFurnitureChest extends TileEntity implements IInventory {

	private ItemStack[] list_slot = new ItemStack[36];

	private String tag;
	private String owner;
	private int rotation;
	private String custom_name;

	public TileEntityFurnitureChest() {

	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getTag() {
		return tag;
	}

	public void setOwner(String name) {
		owner = name;
	}

	public String getOwner() {
		return owner;
	}

	public boolean hasOwner() {
		return owner != null && owner.length() > 0;
	}

	public void setRotation(int rotation) {
		this.rotation = rotation;
	}

	public int getRotation() {
		return rotation;
	}

	public void setCustomName(String name) {
		custom_name = name;
	}

	public String getCustomName() {
		return custom_name;
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		NBTTagList nbttaglist = nbt.getTagList("Items", 10);
		list_slot = new ItemStack[getSizeInventory()];

		if (nbt.hasKey("CustomName", 8)) {
			custom_name = nbt.getString("CustomName");
		}

		for (int i = 0; i < nbttaglist.tagCount(); ++i) {
			NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
			int j = nbttagcompound1.getByte("Slot") & 255;

			if (j >= 0 && j < list_slot.length) {
				list_slot[j] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
			}
		}

		if (nbt.hasKey("NameID")) tag = nbt.getString("NameID");
		if (nbt.hasKey("Owner")) owner = nbt.getString("Owner");
		if (nbt.hasKey("Rotation")) rotation = (int)nbt.getByte("Rotation");
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		NBTTagList nbttaglist = new NBTTagList();

		for (int i = 0; i < list_slot.length; ++i) {
			if (list_slot[i] != null) {
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				nbttagcompound1.setByte("Slot", (byte)i);
				list_slot[i].writeToNBT(nbttagcompound1);
				nbttaglist.appendTag(nbttagcompound1);
			}
		}

		nbt.setTag("Items", nbttaglist);

		if (hasCustomInventoryName()) {
			nbt.setString("CustomName", custom_name);
		}

		if (tag != null) nbt.setString("NameID", tag);
		if (hasOwner()) nbt.setString("Owner", owner);
		nbt.setByte("Rotation", (byte)rotation);
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
		return list_slot.length;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		return list_slot[i];
	}

	@Override
	public ItemStack decrStackSize(int i1, int i2) {
		if (list_slot[i1] != null) {
			ItemStack itemstack;

			if (list_slot[i1].stackSize <= i2) {
				itemstack = list_slot[i1];
				list_slot[i1] = null;
				markDirty();
				return itemstack;
			} else {
				itemstack = list_slot[i1].splitStack(i2);

				if (list_slot[i1].stackSize == 0) {
					list_slot[i1] = null;
				}

				markDirty();
				return itemstack;
			}
		}
		else {
			return null;
		}
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		if (list_slot[i] != null) {
			ItemStack itemstack = list_slot[i];
			list_slot[i] = null;
			return itemstack;
		} else {
			return null;
		}
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack is) {
		list_slot[i] = is;

		if (is != null && is.stackSize > getInventoryStackLimit()) {
			is.stackSize = getInventoryStackLimit();
		}

		markDirty();
	}

	@Override
	public String getInventoryName() {
		return hasCustomInventoryName() ? custom_name : "container.furniture_chest";
	}

	@Override
	public boolean hasCustomInventoryName() {
		return custom_name != null && custom_name.length() > 0;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return worldObj.getTileEntity(xCoord, yCoord, zCoord) != this ? false : player.getDistanceSq((double)xCoord + 0.5D, (double)yCoord + 0.5D, (double)zCoord + 0.5D) <= 64.0D;
	}

	@Override
	public void openInventory() {

	}

	@Override
	public void closeInventory() {

	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack is) {
		return true;
	}

}
