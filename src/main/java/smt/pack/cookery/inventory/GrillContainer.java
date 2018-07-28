package smt.pack.cookery.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import smt.pack.common.api.IItemStorage;
import smt.pack.cookery.tile.TileEntityGrill;

public class GrillContainer extends Container {

	private TileEntityGrill tile;
	private int numRows;

	public GrillContainer(InventoryPlayer playerInventory, TileEntityGrill tile) {
		this.tile = tile;

		tile.openInventory();//Типа инициализируем открытия инвентаря

		numRows = tile.getSizeInventory() / 3;
		int i = (numRows - 4) * 18;
		int j;
		int k;

		//Слоты инвентаря Item Storage
		for (int id = 0; id < tile.getSizeInventory(); ++id) {
			addSlotToContainer(new Slot(tile, id, 8 + (id % 3) * 18, 18 + (id / 3) * 18));
		}

		//Слоты инвентаря игрока
		for (j = 0; j < 3; ++j) {
			for (k = 0; k < 9; ++k) {
				addSlotToContainer(new Slot(playerInventory, k + j * 9 + 9, 8 + k * 18, 103 + j * 18 + i));
			}
		}

		//Слоты хот-бара игрока
		for (j = 0; j < 9; ++j) {
			addSlotToContainer(new Slot(playerInventory, j, 8 + j * 18, 161 + i));
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

			if (slot_i < tile.getSizeInventory()) {
				if (!mergeItemStack(itemStack1, tile.getSizeInventory(), inventorySlots.size(), true)) return null;
			} else if (!mergeItemStack(itemStack1, 0, tile.getSizeInventory(), false))
				return null;

			if (itemStack1.stackSize == 0) slot.putStack((ItemStack)null);
			else slot.onSlotChanged();
		}

		return itemStack;
	}

	@Override
	public void onContainerClosed(EntityPlayer player) {
		super.onContainerClosed(player);
		tile.closeInventory();//Типа инициализируем закрытия инвентаря
	}

}
