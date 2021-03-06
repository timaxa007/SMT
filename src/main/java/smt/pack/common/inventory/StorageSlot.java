package smt.pack.common.inventory;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import smt.pack.common.api.IItemStorage;

public class StorageSlot extends Slot {

	public StorageSlot(IInventory inv, int id, int x, int y) {
		super(inv, id, x, y);
	}

	//Нельзя поставить в этот слот предмет с экземпляром IItemStorage.
	//В дальнейшем я тут буду добавлять, чтобы нельзя из других модов вставлять предметы с хранением вещей.
	@Override
	public boolean isItemValid(ItemStack itemStack) {
		return (itemStack != null && itemStack.getItem() instanceof IItemStorage) ? false : super.isItemValid(itemStack);
	}

}
