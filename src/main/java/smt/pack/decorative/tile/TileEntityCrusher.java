package smt.pack.decorative.tile;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.Constants.NBT;

public class TileEntityCrusher extends TileEntity {

	private IInventory inventoryMain = new InventoryBasic("inventory_crasher", false, 2);
	public int timeWork = 0;

	public TileEntityCrusher() {

	}

	@Override
	public void updateEntity() {
		if (!worldObj.isRemote) {
		}
	}

	public boolean isUseableByPlayer(EntityPlayer player) {
		return worldObj.getTileEntity(xCoord, yCoord, zCoord) != this ? false : player.getDistanceSq((double)xCoord + 0.5D, (double)yCoord + 0.5D, (double)zCoord + 0.5D) <= 64.0D;
	}

	public IInventory getInventory() {
		return inventoryMain;
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);

		IInventory inventory_new = new InventoryBasic(getInventory().getInventoryName(), false,
				getInventory().getSizeInventory());
		NBTTagList nbttaglist = nbt.getTagList(getInventory().getInventoryName(), NBT.TAG_COMPOUND);
		for (int i = 0; i < nbttaglist.tagCount(); ++i) {
			NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
			byte slot = nbttagcompound1.getByte("Slot");
			if (slot >= 0 && slot < inventory_new.getSizeInventory())
				inventory_new.setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(nbttagcompound1));
		}

	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);

		NBTTagList nbttaglist = new NBTTagList();
		for (int i = 0; i < getInventory().getSizeInventory(); ++i) {
			if (getInventory().getStackInSlot(i) != null) {
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				nbttagcompound1.setByte("Slot", (byte)i);
				getInventory().getStackInSlot(i).writeToNBT(nbttagcompound1);
				nbttaglist.appendTag(nbttagcompound1);
			}
		}
		nbt.setTag(getInventory().getInventoryName(), nbttaglist);
	}
	/*
	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound nbt = new NBTTagCompound();
		writeToNBT(nbt);
		return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 0, nbt);
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet) {
		readFromNBT(packet.func_148857_g());
	}
	 */
}
