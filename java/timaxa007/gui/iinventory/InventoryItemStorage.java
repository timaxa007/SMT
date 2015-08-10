package timaxa007.gui.iinventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.Constants;
import timaxa007.smt.util.UtilString;
//InventoryBasic TileEntityChest
public class InventoryItemStorage implements IInventory {

	private ItemStack current;
	private ItemStack[] inventory;

	public InventoryItemStorage(ItemStack is) {
		if (!is.hasTagCompound()) is.setTagCompound(new NBTTagCompound());
		current = is;
		load(is);
	}

	@Override
	public int getSizeInventory() {return inventory.length;}

	@Override
	public ItemStack getStackInSlot(int slot) {
		return slot >= 0 && slot < inventory.length ? inventory[slot] : null;
	}

	@Override
	public ItemStack decrStackSize(int slot, int amount) {
		if (inventory[slot] != null) {
			ItemStack is;

			if (inventory[slot].stackSize <= amount) {
				is = inventory[slot];
				inventory[slot] = null;
				markDirty();
				return is;
			} else {
				is = inventory[slot].splitStack(amount);
				if (inventory[slot].stackSize == 0) inventory[slot] = null;

				markDirty();
				return is;
			}
		} else return null;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {
		if (inventory[slot] != null) {
			ItemStack itemstack = inventory[slot];
			inventory[slot] = null;
			return itemstack;
		} else return null;
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack is) {
		inventory[slot] = is;

		if (is != null && is.stackSize > getInventoryStackLimit())
			is.stackSize = getInventoryStackLimit();

		markDirty();
	}

	@Override
	public String getInventoryName() {return current.getDisplayName();}

	@Override
	public boolean hasCustomInventoryName() {return current.hasDisplayName();}

	@Override
	public int getInventoryStackLimit() {return 64;}

	@Override
	public void markDirty() {
		//save();
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {return true;}

	@Override
	public void openInventory() {
		//markDirty();
		load();
	}

	@Override
	public void closeInventory() {
		//markDirty();
		save();
	}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack is) {return true;}

	public void load() {load(current.getTagCompound());}

	public ItemStack load(ItemStack is) {
		NBTTagCompound nbt = load(is.getTagCompound());
		if (nbt != null) is.setTagCompound(nbt);
		return is;
	}

	public NBTTagCompound load(NBTTagCompound nbt) {
		if (nbt != null) {
			NBTTagList nbttaglist = nbt.getTagList("Items", Constants.NBT.TAG_COMPOUND);

			if (nbt.hasKey("CustomSize", Constants.NBT.TAG_BYTE))
				inventory = new ItemStack[nbt.getByte("CustomSize") & 255];
			else
				inventory = new ItemStack[(9 * 3)];

			for (int i = 0; i < nbttaglist.tagCount(); ++i) {
				NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
				int j = nbttagcompound1.getByte("Slot") & 255;

				if (j >= 0 && j < inventory.length)
					inventory[j] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
			}

		}
		return nbt;
	}

	public void save() {save(current.getTagCompound());}

	public ItemStack save(ItemStack is) {
		if (is != null && current != null) {
			NBTTagCompound nbt = save(current.getTagCompound());
			if (nbt != null) is.setTagCompound(nbt);
			return current;
		}
		return is;
	}

	public NBTTagCompound save(NBTTagCompound nbt) {
		if (nbt != null) {
			NBTTagList nbttaglist = new NBTTagList();

			nbt.setByte("CustomSize", (byte)getSizeInventory());

			for (int i = 0; i < inventory.length; ++i) {
				if (inventory[i] != null) {
					NBTTagCompound nbttagcompound1 = new NBTTagCompound();
					nbttagcompound1.setByte("Slot", (byte)i);
					inventory[i].writeToNBT(nbttagcompound1);
					nbttaglist.appendTag(nbttagcompound1);
				}
			}

			nbt.setTag("Items", nbttaglist);

		}
		return nbt;
	}

	public ItemStack update(EntityPlayer player) {
		return save(player.getCurrentEquippedItem());
	}

}
