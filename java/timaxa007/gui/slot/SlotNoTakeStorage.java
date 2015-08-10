package timaxa007.gui.slot;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public class SlotNoTakeStorage extends Slot {

	public SlotNoTakeStorage(IInventory inv, int id, int x, int y) {
		super(inv, id, x, y);
	}

	@Override
	public boolean isItemValid(ItemStack is) {
		ItemStack is1 = inventory.getStackInSlot(getSlotIndex());
		if (is != null && is1 != null && is == is1) return false;
		return super.isItemValid(is);
	}

	@Override
	public boolean canTakeStack(EntityPlayer player) {
		ItemStack is = inventory.getStackInSlot(getSlotIndex());
		//if (is != null && is.getItem() instanceof ItemStorage) return false;
		if (is != null && is == player.getCurrentEquippedItem()) return false;
		return super.canTakeStack(player);
	}

}
