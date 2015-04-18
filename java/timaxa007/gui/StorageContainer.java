package timaxa007.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class StorageContainer extends Container {

	private IInventory storage_inventory;
	private IInventory lowerChestInventory;
	private int numRows;

	public StorageContainer(IInventory inv, EntityPlayer player) {

		storage_inventory = inv;
		lowerChestInventory = player.inventory;
		numRows = storage_inventory.getSizeInventory() / 9;
		storage_inventory.openInventory();

		int i = (numRows - 4) * 18;
		int j;
		int k;

		for (j = 0; j < numRows; ++j)
			for (k = 0; k < 9; ++k)
				addSlotToContainer(new Slot(storage_inventory, k + j * 9, 8 + k * 18, 18 + j * 18));

		for (j = 0; j < 3; ++j)
			for (k = 0; k < 9; ++k)
				addSlotToContainer(new Slot(player.inventory, k + j * 9 + 9, 8 + k * 18, 103 + j * 18 + i));

		for (j = 0; j < 9; ++j)
			addSlotToContainer(new Slot(player.inventory, j, 8 + j * 18, 161 + i));
	}

	public boolean canInteractWith(EntityPlayer player) {
		return storage_inventory.isUseableByPlayer(player);
	}

	/**
	 * Called when a player shift-clicks on a slot. You must override this or you will crash when someone does that.
	 */
	public ItemStack transferStackInSlot(EntityPlayer player, int i) {
		ItemStack itemstack = null;
		Slot slot = (Slot)inventorySlots.get(i);

		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();

			if (i < numRows * 9) {
				if (!mergeItemStack(itemstack1, numRows * 9, inventorySlots.size(), true))
					return null;
			} else if (!mergeItemStack(itemstack1, 0, numRows * 9, false))
				return null;

			if (itemstack1.stackSize == 0)
				slot.putStack((ItemStack)null);
			else
				slot.onSlotChanged();
		}

		return itemstack;
	}

	public IInventory getStorageInventory() {
		return storage_inventory;
	}

	public void onContainerClosed(EntityPlayer player) {
		super.onContainerClosed(player);
		storage_inventory.closeInventory();
	}

}
