package timaxa007.gui.slot;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import timaxa007.gui.iinventory.ListAccess;
import timaxa007.pack.conjoint.api.IItemStorage;

public class StorageSlot extends Slot {

	public StorageSlot(IInventory inv, int id, int x, int y) {
		super(inv, id, x, y);
	}

	@Override
	public boolean isItemValid(ItemStack is) {
		if (ListAccess.blackForStorage(is)) return false;
		return super.isItemValid(is);
	}

}
