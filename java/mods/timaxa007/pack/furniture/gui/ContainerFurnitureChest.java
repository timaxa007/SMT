package mods.timaxa007.pack.furniture.gui;

import mods.timaxa007.pack.furniture.tile.TileEntityFurnitureChest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class ContainerFurnitureChest extends Container {

	TileEntityFurnitureChest te;
	private int num_rows;

	public ContainerFurnitureChest(EntityPlayer player, TileEntityFurnitureChest te) {
		this.te = te;
		num_rows = te.getSizeInventory() / 9;
		int i = (num_rows - 4) * 18;
		int j;
		int k;

		for (j = 0; j < num_rows; ++j) {
			for (k = 0; k < 9; ++k) {
				addSlotToContainer(new Slot(te, k + j * 9, 8 + k * 18, 18 + j * 18));
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
		return te.isUseableByPlayer(player);
	}

	public ItemStack transferStackInSlot(EntityPlayer player, int i) {
		ItemStack is = null;
		Slot slot = (Slot)inventorySlots.get(i);

		if (slot != null && slot.getHasStack()) {
			ItemStack is1 = slot.getStack();
			is = is1.copy();

			if (i < num_rows * 9) {
				if (!mergeItemStack(is1, num_rows * 9, inventorySlots.size(), true)) {
					return null;
				}
			} else if (!mergeItemStack(is1, 0, num_rows * 9, false)) {
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

}
