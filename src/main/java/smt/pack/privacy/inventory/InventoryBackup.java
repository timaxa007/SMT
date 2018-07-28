package smt.pack.privacy.inventory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.Constants.NBT;
import smt.pack.ActionInventory;

public class InventoryBackup {

	public static final InventoryBasic inventory = new InventoryBasic("InventoryBackup", false, 9 * 3);

	public InventoryBackup(EntityPlayer player) {

	}

	public final InventoryBasic getInventory() {
		return inventory;
	}

	public void readFromNBT(NBTTagCompound nbt) {
		NBTTagList nbttaglist = nbt.getTagList(inventory.getInventoryName(), NBT.TAG_COMPOUND);
		for (int i = 0; i < nbttaglist.tagCount(); ++i) {
			NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
			byte slot = nbttagcompound1.getByte("Slot");
			inventory.setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(nbttagcompound1));
		}
	}

	public void writeToNBT(NBTTagCompound nbt) {
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
