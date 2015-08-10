package timaxa007.gui.slot;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import timaxa007.api.IItemStorage;

public class StorageSlot extends Slot {

	public StorageSlot(IInventory inv, int id, int x, int y) {
		super(inv, id, x, y);
	}

	//Нельзя поставить в этот слот предмет с экземляром IItemStorage.
	//В дальшейшем я тут буду добавлять, чтобы нельяз из других модов вставлять предметы с хранением вещей.
	@Override
	public boolean isItemValid(ItemStack is) {
		return (is != null && is.getItem() instanceof IItemStorage) ? false : super.isItemValid(is);
	}

}
