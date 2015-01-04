package mods.timaxa007.pack.furniture.gui;

import mods.timaxa007.pack.furniture.item.ItemBackpack;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class ContainerBackpack extends Container {

	ItemBackpack bp;
	private int num_rows;

	public ContainerBackpack(EntityPlayer player, ItemBackpack bp) {
		this.bp = bp;
		num_rows = bp.getSizeInventory() / 9;
		bp.openInventory();
		int i = (num_rows - 4) * 18;
		int j;
		int k;

		for (j = 0; j < num_rows; ++j) {
			for (k = 0; k < 9; ++k) {
				addSlotToContainer(new Slot(bp, k + j * 9, 8 + k * 18, 18 + j * 18));
			}
		}

		for (j = 0; j < 3; ++j) {
			for (k = 0; k < 9; ++k) {
				addSlotToContainer(new Slot(player.inventory, k + j * 9 + 9, 8 + k * 18, 103 + j * 18 + i));
			}
		}

		for (j = 0; j < 9; ++j) {
			addSlotToContainer(new Slot(player.inventory, j, 8 + j * 18, 161 + 8));
		}

	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return bp.isUseableByPlayer(player);
	}

	public ItemStack transferStackInSlot(EntityPlayer player, int i) {
		ItemStack is = null;
		Slot slot = (Slot)this.inventorySlots.get(i);

		if (slot != null && slot.getHasStack()) {
			ItemStack is1 = slot.getStack();
			is = is1.copy();

			if (i < this.num_rows * 9) {
				if (!this.mergeItemStack(is1, num_rows * 9, inventorySlots.size(), true)) {
					return null;
				}
			} else if (!this.mergeItemStack(is1, 0, num_rows * 9, false)) {
				return null;
			}

			if (is1.stackSize == 0) {
				slot.putStack((ItemStack)null);
			} else {
				slot.onSlotChanged();
			}
		}

		return is;
	}

	public void onContainerClosed(EntityPlayer player) {
		super.onContainerClosed(player);
		bp.closeInventory();
		/*ItemStack current = player.getCurrentEquippedItem();
		NBTTagCompound tag = current.getTagCompound();
		bp.writeToNBT(tag);*/
	}

}
