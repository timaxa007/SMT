package timaxa007.gui.iinventory;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class InventoryEntityLivingChest implements IInventory {

	private Entity entity;
	public ItemStack[] inv = new ItemStack[(9 * 3)];
	private String name;

	public InventoryEntityLivingChest(Entity entity) {
		this.entity = entity;
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		return slot >= 0 && slot < inv.length ? inv[slot] : null;
	}

	@Override
	public ItemStack decrStackSize(int slot, int size) {
		if (inv[slot] != null) {
			ItemStack itemstack;

			if (inv[slot].stackSize <= size) {
				itemstack = inv[slot];
				inv[slot] = null;
				markDirty();
				return itemstack;
			} else {
				itemstack = inv[slot].splitStack(size);

				if (inv[slot].stackSize == 0) {
					inv[slot] = null;
				}

				markDirty();
				return itemstack;
			}
		} else {
			return null;
		}
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {
		if (inv[slot] != null) {
			ItemStack itemstack = inv[slot];
			inv[slot] = null;
			return itemstack;
		} else {
			return null;
		}
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack is) {
		inv[slot] = is;

		if (is != null && is.stackSize > getInventoryStackLimit()) {
			is.stackSize = getInventoryStackLimit();
		}

		markDirty();
	}

	@Override
	public int getSizeInventory() {
		return inv.length;
	}

	@Override
	public String getInventoryName() {
		return entity.getCommandSenderName();
	}

	@Override
	public boolean hasCustomInventoryName() {
		return name != null && name.length() < 0;
	}

	@Override
	public int getInventoryStackLimit() {return 64;}

	@Override
	public void markDirty() {
		/*
		if (field_70480_d != null) {
			for (int i = 0; i < field_70480_d.size(); ++i) {
				((IInvBasic)field_70480_d.get(i)).onInventoryChanged(this);
			}
		}
		 */
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {return true;}

	@Override
	public void openInventory() {}

	@Override
	public void closeInventory() {}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack is) {return true;}

}
