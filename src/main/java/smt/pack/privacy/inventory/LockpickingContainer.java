package smt.pack.privacy.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;

public class LockpickingContainer extends net.minecraft.inventory.Container {

	private TileEntity tile;

	public LockpickingContainer(TileEntity tile, EntityPlayer player) {
		this.tile = tile;
		int i;
		int j;

		if (tile != null) {/*
			if (tile instanceof TileEntityBlocksTechnology) {
				TileEntityBlocksTechnology te = (TileEntityBlocksTechnology)tile;

				for (i = 0; i < te.getInventoryIn().getSizeInventory(); ++i) {
					addSlotToContainer(new Slot(te.getInventoryIn(), i, 8 + i * 18, 8 + 1 * 18));
				}

				for (i = 0; i < te.getInventoryOut().getSizeInventory(); ++i) {
					addSlotToContainer(new Slot(te.getInventoryOut(), i, 8 + i * 18, 8 + 2 * 18){
						@Override public boolean isItemValid(ItemStack itemStack) {return false;}
					});
				}

				//addSlotToContainer(new Slot(te.getInventory(), 1, 56, 53));

			}*//*else if (tile instanceof IInventory) {}*/
		}

		for (i = 0; i < 3; ++i) for (j = 0; j < 9; ++j)
			addSlotToContainer(new Slot(player.inventory, j + i * 9 + 9, 8 + j * 18, 140 + i * 18));

		for (i = 0; i < 9; ++i)
			addSlotToContainer(new Slot(player.inventory, i, 8 + i * 18, 198));

	}

	@Override
	public ItemStack transferStackInSlot(EntityPlayer player, int slot_id) {
		ItemStack itemstack = null;
		Slot slot = (Slot)inventorySlots.get(slot_id);
		/*
		if (slot != null && slot.getHasStack()) {
			slot.onPickupFromSlot(player, itemstack1);
		}
		*/
		return itemstack;
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		if (tile != null) {/*
			if (tile instanceof TileEntityBlocksTechnology) {
				TileEntityBlocksTechnology te = (TileEntityBlocksTechnology)tile;
				return te.isUseableByPlayer(player);
			} else if (tile instanceof IInventory) {
				return ((IInventory)tile).isUseableByPlayer(player);
			}*/
		}
		return false;
	}

}
