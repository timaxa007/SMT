package timaxa007.gui.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import timaxa007.gui.iinventory.InventoryItemStorage;
import timaxa007.gui.slot.SlotNoTakeStorage;
import timaxa007.gui.slot.StorageSlot;
//ContainerChest
public class ItemStorageContainer extends Container {

	private InventoryItemStorage inv;
	private int numRows;

	public ItemStorageContainer(EntityPlayer player, InventoryItemStorage inventoryItemStorage) {
		inv = inventoryItemStorage;
		inv.openInventory();//Типа инцилизируем открытия инвентаря
		numRows = inv.getSizeInventory() / 9;
		int i = (numRows - 4) * 18;
		int j;
		int k;

		//Слоты инвентаря Item Storage
		for (j = 0; j < numRows; ++j) {
			for (k = 0; k < 9; ++k) {
				addSlotToContainer(new StorageSlot(inv, k + j * 9, 8 + k * 18, 18 + j * 18));
			}
		}

		//Слоты инвентаря игрока
		for (j = 0; j < 3; ++j) {
			for (k = 0; k < 9; ++k) {
				addSlotToContainer(new SlotNoTakeStorage(player.inventory, k + j * 9 + 9, 8 + k * 18, 103 + j * 18 + i));
			}
		}

		//Слоты хотбара игрока
		for (j = 0; j < 9; ++j) {
			addSlotToContainer(new SlotNoTakeStorage(player.inventory, j, 8 + j * 18, 161 + i));
		}

	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return inv.isUseableByPlayer(player);
	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slot_i) {
		ItemStack is = null;
		Slot slot = (Slot)inventorySlots.get(slot_i);

		if (slot != null && slot.getHasStack()) {
			ItemStack is1 = slot.getStack();
			is = is1.copy();

			if (slot_i < inv.getSizeInventory()) {
				if (!mergeItemStack(is1, inv.getSizeInventory(), inventorySlots.size(), true)) return null;
			} else if (!mergeItemStack(is1, 0, inv.getSizeInventory(), false))
				return null;

			if (is1.stackSize == 0) slot.putStack((ItemStack)null);
			else slot.onSlotChanged();
		}

		return is;
	}

	@Override
	public ItemStack slotClick(int slot, int button, int modifier, EntityPlayer player) {
		if (player == null) return null;
		//System.out.println(" - slot:" + slot + ", button:" + button + ", modifier:" + modifier + ".");//своеобразный для debug
		if (modifier == 2) return null;//Блокируем возможность использование игроком цифровых кнопок, чтобы небыло попытки подмены
		return super.slotClick(slot, button, modifier, player);
	}

	@Override
	public void onContainerClosed(EntityPlayer player) {
		super.onContainerClosed(player);
		inv.closeInventory();//Типа инцилизируем закрытия инвентаря
	}

	public ItemStack update(EntityPlayer player) {
		return (inv != null && player.getCurrentEquippedItem() != null) ? inv.update(player) : null;
	}

}
