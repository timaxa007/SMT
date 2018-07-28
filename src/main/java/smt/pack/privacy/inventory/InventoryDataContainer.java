package smt.pack.privacy.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import smt.pack.privacy.registry.InventoryData;

public class InventoryDataContainer extends net.minecraft.inventory.Container {

	private InventoryData.InventotyDummy inventoty_dummy;
	private int numRows;

	public InventoryDataContainer(EntityPlayer player) {
		InventoryData inventory_data = InventoryData.createOrLoad(player.worldObj);
		this.inventoty_dummy = inventory_data.getInventory(inventory_data.temp);
		int i;
		int j;

		if (inventoty_dummy != null) {
		}

		for (i = 0; i < 3; ++i) for (j = 0; j < 9; ++j)
			addSlotToContainer(new Slot(player.inventory, j + i * 9 + 9, 8 + j * 18, 140 + i * 18));

		for (i = 0; i < 9; ++i)
			addSlotToContainer(new Slot(player.inventory, i, 8 + i * 18, 198));

	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slot_id) {
		ItemStack itemstack = null;
		Slot slot = (Slot)this.inventorySlots.get(slot_id);

		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();

			if (slot_id < this.numRows * 9) {
				if (!this.mergeItemStack(itemstack1, this.numRows * 9, this.inventorySlots.size(), true)) {
					return null;
				}
			} else if (!this.mergeItemStack(itemstack1, 0, this.numRows * 9, false)) {
				return null;
			}

			if (itemstack1.stackSize == 0) {
				slot.putStack((ItemStack)null);
			} else {
				slot.onSlotChanged();
			}
		}

		return itemstack;
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		if (inventoty_dummy != null) {/*
			if (inventory instanceof TileEntityBlocksTechnology) {
				TileEntityBlocksTechnology te = (TileEntityBlocksTechnology)inventory;
				return te.isUseableByPlayer(player);
			} else if (inventory instanceof IInventory) {
				return ((IInventory)inventory).isUseableByPlayer(player);
			}*/
		}
		return false;
	}

	@Override
	public void onContainerClosed(EntityPlayer player) {
		super.onContainerClosed(player);
		//this.lowerChestInventory.closeInventory();
	}

}
