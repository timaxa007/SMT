package smt.pack.common.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import smt.pack.common.api.IItemStorage;

public class ContainerItemStorage extends net.minecraft.inventory.Container {

	private InventoryItemStorage inv;
	private int numRows;

	public ContainerItemStorage(EntityPlayer player, InventoryItemStorage inventoryItemStorage) {
		inv = inventoryItemStorage;
		inv.openInventory();//Типа инициализируем открытия инвентаря
		numRows = inv.getSizeInventory() / 9;
		int i = (numRows - 4) * 18;
		int j;
		int k;

		//Слоты инвентаря Item Storage
		for (int id = 0; id < inv.getSizeInventory(); ++id) {
			addSlotToContainer(new StorageSlot(inv, id, 8 + (id % 9) * 18, 18 + (id / 9) * 18));
		}

		//Слоты инвентаря игрока
		for (j = 0; j < 3; ++j) {
			for (k = 0; k < 9; ++k) {
				addSlotToContainer(new SlotNoTakeStorage(player.inventory, k + j * 9 + 9, 8 + k * 18, 103 + j * 18 + i));
			}
		}

		//Слоты хот-бара игрока
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
		ItemStack itemStack = null;
		Slot slot = (Slot)inventorySlots.get(slot_i);

		if (slot != null && slot.getHasStack()) {
			ItemStack itemStack1 = slot.getStack();
			itemStack = itemStack1.copy();

			//Или иначе по шифт-клику можно было засунуть в наш рюкзак ещё один рюкзак.
			if (itemStack1.getItem() instanceof IItemStorage) return null;

			if (slot_i < inv.getSizeInventory()) {
				if (!mergeItemStack(itemStack1, inv.getSizeInventory(), inventorySlots.size(), true)) return null;
			} else if (!mergeItemStack(itemStack1, 0, inv.getSizeInventory(), false))
				return null;

			if (itemStack1.stackSize == 0) slot.putStack((ItemStack)null);
			else slot.onSlotChanged();
		}

		return itemStack;
	}

	@Override
	public ItemStack slotClick(int slot, int button, int modifier, EntityPlayer player) {
		if (modifier == 2) return null;//Блокируем возможность использование игроком цифровых кнопок, чтобы не было попытки подмены
		return super.slotClick(slot, button, modifier, player);
	}

	@Override
	public void onContainerClosed(EntityPlayer player) {
		super.onContainerClosed(player);
		inv.closeInventory();//Типа инициализируем закрытия инвентаря
	}

	public void update(EntityPlayer player) {
		if (inv != null) inv.update(player);
	}

}
