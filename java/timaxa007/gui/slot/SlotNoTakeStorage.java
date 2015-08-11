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
	public boolean canTakeStack(EntityPlayer player) {
		ItemStack is = inventory.getStackInSlot(getSlotIndex());
		ItemStack current = player.getCurrentEquippedItem();
		if (is != null && current != null && is == current) return false;
		return super.canTakeStack(player);
	}

}
