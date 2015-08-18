package timaxa007.gui.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import timaxa007.pack.magic.entity.EntityLivingChest;
//ContainerChest
public class EntityLivingChestContainer extends Container {

	private EntityPlayer player;
	private EntityLivingChest entity;
	private int numRows;

	public EntityLivingChestContainer(EntityPlayer playerp, EntityLivingChest entityp) {
		player = playerp;
		entity = entityp;
		if (entity != null && player != null) {
			entity.inventory.openInventory();

			numRows = entity.inventory.getSizeInventory() / 9;
			int i = (numRows - 4) * 18;
			int j;
			int k;

			for (j = 0; j < numRows; ++j) {
				for (k = 0; k < 9; ++k) {
					addSlotToContainer(new Slot(entity.inventory, k + j * 9, 8 + k * 18, 18 + j * 18));
				}
			}

			for (j = 0; j < 3; ++j) {
				for (k = 0; k < 9; ++k) {
					addSlotToContainer(new Slot(player.inventory, k + j * 9 + 9, 8 + k * 18, 103 + j * 18 + i));
				}
			}

			for (j = 0; j < 9; ++j) {
				addSlotToContainer(new Slot(player.inventory, j, 8 + j * 18, 161 + i));
			}

		}
	}

	public ItemStack transferStackInSlot(EntityPlayer player, int slot_i) {
		ItemStack itemstack = null;
		Slot slot = (Slot)inventorySlots.get(slot_i);

		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();

			if (slot_i < entity.inventory.getSizeInventory()) {
				if (!mergeItemStack(itemstack1, entity.inventory.getSizeInventory(), inventorySlots.size(), true))
					return null;
			} else if (!mergeItemStack(itemstack1, 0, entity.inventory.getSizeInventory(), false))
				return null;

			if (itemstack1.stackSize == 0)
				slot.putStack((ItemStack)null);
			else
				slot.onSlotChanged();
		}

		return itemstack;
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return entity != null ? entity.inventory.isUseableByPlayer(player) : false;
	}

	@Override
	public void onContainerClosed(EntityPlayer player) {
		super.onContainerClosed(player);
		if (entity != null) entity.inventory.closeInventory();
	}

}
