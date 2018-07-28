package smt.pack;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.Constants.NBT;

public class ActionInventory {

	public static void add(final IInventory inventory, final ItemStack itemStack) {
		if (itemStack != null) {
			for (int i = 0; i < inventory.getSizeInventory(); ++i) {
				ItemStack slot = inventory.getStackInSlot(i);
				if (slot != null && ItemStack.areItemStackTagsEqual(slot, itemStack) && (slot.getMaxStackSize() >= slot.stackSize + itemStack.stackSize)) {
					itemStack.stackSize += slot.stackSize;
					inventory.setInventorySlotContents(i, itemStack);
				} else if (slot == null) {
					inventory.setInventorySlotContents(i, itemStack);
					break;
				}
			}
		}
	}

	public static boolean isOccupiedSpace(final IInventory inventory) {
		for (int i = 0; i < inventory.getSizeInventory(); ++i) {
			if (inventory.getStackInSlot(i) != null) {
				return true;
			}
		}
		return false;
	}

	public static boolean isFreeSpace(final IInventory inventory) {
		for (int i = 0; i < inventory.getSizeInventory(); ++i) {
			if (inventory.getStackInSlot(i) == null) {
				return true;
			}
		}
		return false;
	}

	public static boolean isEmpty(final IInventory inventory) {
		int j = 0;
		for (int i = 0; i < inventory.getSizeInventory(); ++i) {
			if (inventory.getStackInSlot(i) != null) j += 1;
		}
		return j == inventory.getSizeInventory();
	}

	public static IInventory readFromNBT(final NBTTagCompound nbt, final IInventory inventory) {
		int sizeInventory = nbt.hasKey(inventory.getInventoryName() + "Size") ?
				(int)nbt.getByte(inventory.getInventoryName() + "Size") :
					inventory.getSizeInventory();
				IInventory inventory_new = new InventoryBasic(inventory.getInventoryName(), false, sizeInventory);
				NBTTagList nbttaglist = nbt.getTagList(inventory.getInventoryName(), NBT.TAG_COMPOUND);
				for (int i = 0; i < nbttaglist.tagCount(); ++i) {
					NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
					byte slot = nbttagcompound1.getByte("Slot");
					if (slot >= 0 && slot < inventory_new.getSizeInventory())
						inventory_new.setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(nbttagcompound1));
				}
				return inventory_new;
	}
	/*
	public static void writeToNBT(NBTTagCompound nbt, IInventory inventory) {
		writeToNBT(nbt, inventory, );
	}
	 */
	public static void writeToNBT(final NBTTagCompound nbt, final IInventory inventory) {
		nbt.setByte(inventory.getInventoryName() + "Size", (byte)inventory.getSizeInventory());
		NBTTagList nbttaglist = new NBTTagList();
		for (int i = 0; i < inventory.getSizeInventory(); ++i) {
			if (inventory.getStackInSlot(i) != null) {
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				nbttagcompound1.setByte("Slot", (byte)i);
				inventory.getStackInSlot(i).writeToNBT(nbttagcompound1);
				nbttaglist.appendTag(nbttagcompound1);
			}
		}
		nbt.setTag(inventory.getInventoryName(), nbttaglist);
	}

}
