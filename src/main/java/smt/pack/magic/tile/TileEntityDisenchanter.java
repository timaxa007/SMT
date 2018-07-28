package smt.pack.magic.tile;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class TileEntityDisenchanter extends TileEntity implements ISidedInventory {

	InventoryBasic inventory = new InventoryBasic("inventoryDisenchanter", false, 4);

	public IInventory getInventory() {
		return inventory;
	}

	public boolean isUseableByPlayer(EntityPlayer player) {
		return true;
	}

	@Override
	public void markDirty() {
		super.markDirty();
		inventory.markDirty();
	}

	@Override
	public int getSizeInventory() {
		return inventory.getSizeInventory();
	}

	@Override
	public ItemStack getStackInSlot(int slotID) {
		return inventory.getStackInSlot(slotID);
	}

	@Override
	public ItemStack decrStackSize(int slotID, int size) {
		return inventory.decrStackSize(slotID, size);
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slotID) {
		return inventory.getStackInSlotOnClosing(slotID);
	}

	@Override
	public void setInventorySlotContents(int slotID, ItemStack itemStack) {
		inventory.setInventorySlotContents(slotID, itemStack);
	}

	@Override
	public String getInventoryName() {
		return inventory.getInventoryName();
	}

	@Override
	public boolean hasCustomInventoryName() {
		return inventory.hasCustomInventoryName();
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public void openInventory() {

	}

	@Override
	public void closeInventory() {

	}

	@Override
	public boolean isItemValidForSlot(int slotID, ItemStack itemStack) {
		return inventory.isItemValidForSlot(slotID, itemStack);
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int side) {
		return null;
	}

	@Override
	public boolean canInsertItem(int slotID, ItemStack itemStack, int side) {
		return false;
	}

	@Override
	public boolean canExtractItem(int slotID, ItemStack itemStack, int side) {
		return false;
	}

}
