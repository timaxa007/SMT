package smt.pack.magic.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import smt.pack.common.item.ItemBackpack;
import smt.pack.magic.tile.TileEntityDisenchanter;

public class ContainerDisenchanter extends net.minecraft.inventory.Container {

	final TileEntityDisenchanter tile;

	public ContainerDisenchanter(final EntityPlayer player, final TileEntityDisenchanter tile) {
		this.tile = tile;
		tile.getInventory().openInventory();
		int i = (1 - 4) * 18;
		int j;
		int k;

		for (int id = 0; id < tile.getInventory().getSizeInventory(); ++id) {
			addSlotToContainer(new Slot(tile.getInventory(), id, 8 + (id % 9) * 18, 18 + (id / 9) * 18));
		}

		//Слоты инвентаря игрока
		for (j = 0; j < 3; ++j) {
			for (k = 0; k < 9; ++k) {
				addSlotToContainer(new Slot(player.inventory, k + j * 9 + 9, 8 + k * 18, 103 + j * 18 + i));
			}
		}

		//Слоты хот-бара игрока
		for (j = 0; j < 9; ++j) {
			addSlotToContainer(new Slot(player.inventory, j, 8 + j * 18, 161 + i));
		}

	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return tile.isUseableByPlayer(player);
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slot_i) {
		ItemStack itemStack = null;
		Slot slot = (Slot)inventorySlots.get(slot_i);

		if (slot != null && slot.getHasStack()) {
			ItemStack itemStack1 = slot.getStack();
			itemStack = itemStack1.copy();

			if (itemStack1.getItem() instanceof ItemBackpack) return null;

			if (slot_i < tile.getInventory().getSizeInventory()) {
				if (!mergeItemStack(itemStack1, tile.getInventory().getSizeInventory(), inventorySlots.size(), true)) return null;
			} else if (!mergeItemStack(itemStack1, 0, tile.getInventory().getSizeInventory(), false))
				return null;

			if (itemStack1.stackSize == 0) slot.putStack((ItemStack)null);
			else slot.onSlotChanged();
		}

		return itemStack;
	}

	@Override
	public void onContainerClosed(EntityPlayer player) {
		super.onContainerClosed(player);
		tile.getInventory().closeInventory();
	}

}
