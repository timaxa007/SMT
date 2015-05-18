package timaxa007.pack.furniture.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.Constants;
import timaxa007.smt.util.UtilString;

public class InventoryBackpack implements IInventory {

	private String name = "Inventory Backpack";
	public static final int INV_SIZE = 27;
	private ItemStack[] inventory = new ItemStack[INV_SIZE];

	private final ItemStack invItem;

	public InventoryBackpack(ItemStack stack) {
		this.invItem = stack;

		if (!stack.hasTagCompound()) {
			stack.setTagCompound(new NBTTagCompound());
		}

		readFromNBT(stack.getTagCompound());
	}

	@Override
	public int getSizeInventory() {
		return inventory.length;
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		return inventory[slot];
	}

	@Override
	public ItemStack decrStackSize(int slot, int amount) {
		ItemStack is = getStackInSlot(slot);
		if(is != null) {
			if (is.stackSize > amount) {
				is = is.splitStack(amount);
				markDirty();
			} else
				setInventorySlotContents(slot, null);
		}
		return is;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {
		ItemStack is = getStackInSlot(slot);
		if (is != null) setInventorySlotContents(slot, null);
		return is;
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack is) {
		this.inventory[slot] = is;

		if (is != null && is.stackSize > this.getInventoryStackLimit()) {
			is.stackSize = this.getInventoryStackLimit();
		}

		markDirty();
	}


	@Override
	public String getInventoryName() {
		return name;
	}

	@Override
	public boolean hasCustomInventoryName() {
		return UtilString.hasString(name);
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public void markDirty() {
		for (int i = 0; i < getSizeInventory(); ++i) {
			if (getStackInSlot(i) != null && getStackInSlot(i).stackSize == 0)
				inventory[i] = null;
		}
		//be sure to write to NBT when the inventory changes!
		writeToNBT(invItem.getTagCompound());
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return player.getHeldItem() == invItem;
	}

	@Override
	public void openInventory() {

	}

	@Override
	public void closeInventory() {

	}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack is) {
		return !(is != null && is.getItem() instanceof IBackpack);
	}
	//-----------------------------------------------------------------
	public void readFromNBT(NBTTagCompound tagcompound) {
		NBTTagList items = tagcompound.getTagList("InventoryBackpack", Constants.NBT.TAG_COMPOUND);

		for (int i = 0; i < items.tagCount(); ++i) {
			NBTTagCompound item = (NBTTagCompound)items.getCompoundTagAt(i);
			byte slot = item.getByte("Slot");

			if (slot >= 0 && slot < getSizeInventory())
				inventory[slot] = ItemStack.loadItemStackFromNBT(item);

		}
	}

	public void writeToNBT(NBTTagCompound tagcompound) {
		NBTTagList items = new NBTTagList();

		for (int i = 0; i < getSizeInventory(); ++i) {
			if (getStackInSlot(i) != null) {
				NBTTagCompound item = new NBTTagCompound();
				item.setInteger("Slot", i);
				getStackInSlot(i).writeToNBT(item);
				items.appendTag(item);
			}
		}

		tagcompound.setTag("InventoryBackpack", items);
	}
	//-----------------------------------------------------------------
}
