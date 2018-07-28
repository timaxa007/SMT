package smt.pack.privacy.registry;

import java.util.HashMap;
import java.util.Map;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import net.minecraft.world.WorldSavedData;
import net.minecraftforge.common.util.Constants.NBT;

public class InventoryData extends WorldSavedData {

	private static final String TAG = "InventoryData";
	public String temp;
	private Map<String, InventotyDummy> inventory_map = new HashMap<String, InventotyDummy>();

	public InventoryData() {
		super(TAG);
	}

	public InventoryData(String tag) {
		super(tag);
	}

	public Map getInventoryMap() {
		return inventory_map;
	}

	public InventotyDummy getInventory(String tag) {
		return inventory_map.get(tag);
	}

	public void setInventory(String tag, InventotyDummy inventoty_dummy) {
		inventory_map.put(tag, inventoty_dummy);
	}

	public void removeInventory(String tag) {
		inventory_map.remove(tag);
	}

	@Override
	public void readFromNBT(NBTTagCompound tag) {
		//if (!tag.hasKey(TAG)) return;
		inventory_map.clear();
		NBTTagList list = tag.getTagList(TAG, NBT.TAG_COMPOUND);
		for (int i = 0; i < list.tagCount(); i++) {
			NBTTagCompound nbtCompound = list.getCompoundTagAt(i);
			String name = nbtCompound.getString("Tag");
			InventotyDummy inventoty_dummy = new InventotyDummy(name);
			inventoty_dummy.readFromNBT(nbtCompound);
			inventory_map.put(name, inventoty_dummy);
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound tag) {
		NBTTagList list = new NBTTagList();
		for (Map.Entry<String, InventotyDummy> entry : inventory_map.entrySet()) {
			NBTTagCompound nbtCompound = new NBTTagCompound();
			nbtCompound.setString("Tag", entry.getKey());
			entry.getValue().writeToNBT(nbtCompound);
			list.appendTag(nbtCompound);
		}
		tag.setTag(TAG, list);
	}

	public static InventoryData createOrLoad(World world) {
		InventoryData data = (InventoryData)world.loadItemData(InventoryData.class, TAG);
		if (data == null) world.setItemData(TAG, data = new InventoryData(TAG));
		//data.markDirty();
		return data;
	}

	public static class InventotyDummy {

		private IInventory inventory;

		public InventotyDummy(String tag) {
			inventory = new InventoryBasic(tag, true, 9*3);
		}

		public InventotyDummy(String tag, boolean hasCustomInventoryName, int slotsCount) {
			inventory = new InventoryBasic(tag, hasCustomInventoryName, slotsCount);
		}

		public IInventory getInventory() {
			return inventory;
		}

		public void readFromNBT(NBTTagCompound nbt) {
			NBTTagList nbttaglist = nbt.getTagList(inventory.getInventoryName(), NBT.TAG_COMPOUND);
			int slotsCount = nbttaglist.tagCount();
			if (inventory.getSizeInventory() != slotsCount)
				inventory = new InventoryBasic(inventory.getInventoryName(), true, slotsCount);
			for (int i = 0; i < slotsCount; ++i) {
				NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
				byte b0 = nbttagcompound1.getByte("Slot");
				if (b0 >= 0 && b0 < inventory.getSizeInventory())
					inventory.setInventorySlotContents(b0, ItemStack.loadItemStackFromNBT(nbttagcompound1));
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

}
