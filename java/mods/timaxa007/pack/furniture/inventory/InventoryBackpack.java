package mods.timaxa007.pack.furniture.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class InventoryBackpack implements IInventory {

	public static ItemStack[] list_slot = new ItemStack[27];

	@Override
	public int getSizeInventory() {
		return list_slot.length;
	}

	@Override
	public ItemStack getStackInSlot(int i) {
		return list_slot[i];
	}

	@Override
	public ItemStack decrStackSize(int i1, int i2) {
		if (list_slot[i1] != null) {
			ItemStack itemstack;

			if (list_slot[i1].stackSize <= i2) {
				itemstack = list_slot[i1];
				list_slot[i1] = null;
				markDirty();
				return itemstack;
			} else {
				itemstack = list_slot[i1].splitStack(i2);

				if (list_slot[i1].stackSize == 0) {
					list_slot[i1] = null;
				}

				markDirty();
				return itemstack;
			}
		}
		else {
			return null;
		}
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		if (list_slot[i] != null) {
			ItemStack itemstack = list_slot[i];
			list_slot[i] = null;
			return itemstack;
		} else {
			return null;
		}
	}

	@Override
	public void setInventorySlotContents(int i, ItemStack is) {
		list_slot[i] = is;

		if (is != null && is.stackSize > getInventoryStackLimit()) {
			is.stackSize = getInventoryStackLimit();
		}

		markDirty();
	}

	@Override
	public String getInventoryName() {
		return "container.furniture_chest";
	}

	@Override
	public boolean hasCustomInventoryName() {
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return true;
	}

	@Override
	public void openInventory() {
		System.out.println("openInventory ItemBackpack");
	}

	@Override
	public void closeInventory() {
		System.out.println("closeInventory ItemBackpack");
	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack is) {
		return true;
	}

	@Override
	public void markDirty() {
		
	}

}
