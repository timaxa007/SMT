package smt.pack.technology.tile.machine;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.Constants.NBT;
import smt.pack.technology.SMTTechnology;
import smt.pack.technology.network.MessageSyncSize;

public class ElectricBigBufferItem extends ElectricMachine implements IInventory {

	final ItemStack[] inventory = new ItemStack[9];
	public final int[] stackSizeLarge = new int[inventory.length];
	final int[] stackSizeLargeLast = new int[inventory.length];
	final int maxStackSize = Short.MAX_VALUE;

	public ElectricBigBufferItem(smt.pack.technology.tile.TileEntityElectricMachine tile) {
		super(tile);
		tile.setInventoryOutput(getInventory());
	}

	@Override
	public void update() {
		//addInventory(new ItemStack(Items.stick));
		for (int i = 0; i < stackSizeLargeLast.length; ++i) {
			if (stackSizeLargeLast[i] != stackSizeLarge[i]) {
				stackSizeLargeLast[i] = stackSizeLarge[i];
				MessageSyncSize message = new MessageSyncSize();
				message.x = tile.xCoord;
				message.y = tile.yCoord;
				message.z = tile.zCoord;
				message.i = (byte)i;
				message.size = (short)stackSizeLarge[i];
				SMTTechnology.network.sendToAll(message);
			}
		}
	}

	public IInventory getInventory() {
		return this;
	}

	public ItemStack addInventory(ItemStack itemStack) {
		if (getInventory() == null) return itemStack;
		for (int i = 0; i < getInventory().getSizeInventory(); ++i) {
			ItemStack slot = getInventory().getStackInSlot(i);
			if (slot == null) {
				if (maxStackSize >= itemStack.stackSize) {
					getInventory().setInventorySlotContents(i, itemStack);
					return null;
				} else {
					ItemStack itemStackCopy = itemStack.copy();
					itemStackCopy.stackSize = maxStackSize;
					getInventory().setInventorySlotContents(i, itemStackCopy);
					itemStack.stackSize -= maxStackSize;
					return itemStack;
				}
			} else if (slot.isItemEqual(itemStack) && ItemStack.areItemStackTagsEqual(slot, itemStack)) {
				if (maxStackSize < stackSizeLarge[i] + itemStack.stackSize) {
					itemStack.stackSize = maxStackSize - stackSizeLarge[i];
					stackSizeLarge[i] = maxStackSize;
				} else {
					stackSizeLarge[i] = stackSizeLarge[i] + itemStack.stackSize;
					return null;
				}
			}

		}
		return itemStack;
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		NBTTagList nbttaglist = nbt.getTagList(getInventory().getInventoryName(), NBT.TAG_COMPOUND);
		for (int i = 0; i < nbttaglist.tagCount(); ++i) {
			NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
			stackSizeLarge[i] = nbttagcompound1.getShort("stackSize");
			byte slot = nbttagcompound1.getByte("Slot");
			if (slot >= 0 && slot < getInventory().getSizeInventory())
				getInventory().setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(nbttagcompound1));
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		NBTTagList nbttaglist = new NBTTagList();
		for (int i = 0; i < getInventory().getSizeInventory(); ++i) {
			if (getInventory().getStackInSlot(i) != null) {
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				nbttagcompound1.setShort("stackSize", (short)stackSizeLarge[i]);
				nbttagcompound1.setByte("Slot", (byte)i);
				getInventory().getStackInSlot(i).writeToNBT(nbttagcompound1);
				nbttaglist.appendTag(nbttagcompound1);
			}
		}
		nbt.setTag(getInventory().getInventoryName(), nbttaglist);
	}

	@Override
	public int getSizeInventory() {
		return inventory.length;
	}

	@Override
	public ItemStack getStackInSlot(int index) {
		return inventory[index];
	}

	@Override
	public ItemStack decrStackSize(int index, int stackSize) {
		if (inventory[index] != null) {
			ItemStack itemStack;

			if (stackSizeLarge[index] <= stackSize) {
				itemStack = inventory[index];
				itemStack.stackSize = stackSizeLarge[index];
				getInventory().setInventorySlotContents(index, null);
				return itemStack;
			} else {
				itemStack = inventory[index].copy()/*splitStack(stackSize)*/;
				itemStack.stackSize = stackSize;
				stackSizeLarge[index] -= stackSize;
				return itemStack;
			}
		} else return null;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int index) {
		if (inventory[index] != null) {
			ItemStack itemstack = inventory[index];
			inventory[index] = null;
			return itemstack;
		} else {
			return null;
		}
	}

	@Override
	public void setInventorySlotContents(int index, ItemStack itemStack) {
		inventory[index] = itemStack;
		if (inventory[index] != null) {
			stackSizeLarge[index] = inventory[index].stackSize;
			inventory[index].stackSize = 1;
		} else {
			stackSizeLarge[index] = 0;
		}
		/*
		if (itemStack != null && itemStack.stackSize > getInventoryStackLimit()) {
			itemStack.stackSize = getInventoryStackLimit();
		}
		 */
		markDirty();
	}

	@Override
	public String getInventoryName() {
		return null;
	}

	@Override
	public boolean hasCustomInventoryName() {
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		return maxStackSize;
	}

	@Override
	public void markDirty() {
		/*if (field_70480_d != null) {
			for (int i = 0; i < field_70480_d.size(); ++i)
				((IInvBasic)field_70480_d.get(i)).onInventoryChanged(this);
		}*/
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return true;
	}

	@Override
	public void openInventory() {

	}

	@Override
	public void closeInventory() {

	}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack itemStack) {
		return true;
	}

}
