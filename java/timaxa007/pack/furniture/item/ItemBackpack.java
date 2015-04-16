package timaxa007.pack.furniture.item;

import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import timaxa007.pack.furniture.PackFurniture;
import timaxa007.pack.furniture.util.IBackpack;
import timaxa007.tms.CoreTMS;
import timaxa007.tms.util.ModifiedItem;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBackpack extends ModifiedItem implements IBackpack, IInventory {

	public static ItemStack[] list_slot = new ItemStack[27];

	public ItemBackpack(String tag) {
		super(tag);
		setMaxStackSize(1);
		setCreativeTab(PackFurniture.tab_furniture);
		setTextureName("timaxa007:backpack");
	}

	public ItemStack onItemRightClick(ItemStack is, World world, EntityPlayer player) {
		if (player.isSneaking()) {

		} else {
			player.openGui(CoreTMS.instance, PackFurniture.gui_backpack, world, (int)player.posX, (int)player.posY, (int)player.posZ);
		}
		return super.onItemRightClick(is, world, player);
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(Item id, CreativeTabs table, List list) {
		list.add(addNBT());
		//list.add(new ItemStack(id, 1, 0));
	}

	private ItemStack addNBT() {
		ItemStack is = new ItemStack(PackFurniture.item.backpack);
		NBTTagCompound nbt = new NBTTagCompound();
		writeToNBT(nbt);
		is.setTagCompound(nbt);
		return is;
	}

	public void readFromNBT(NBTTagCompound nbt) {
		NBTTagList nbttaglist = nbt.getTagList("Items", 10);
		list_slot = new ItemStack[getSizeInventory()];

		for (int i = 0; i < nbttaglist.tagCount(); ++i) {
			NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
			int j = nbttagcompound1.getByte("Slot") & 255;

			if (j >= 0 && j < list_slot.length) {
				list_slot[j] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
			}
		}

	}

	public void writeToNBT(NBTTagCompound nbt) {
		NBTTagList nbttaglist = new NBTTagList();
		for (int i = 0; i < list_slot.length; ++i) {
			if (list_slot[i] != null) {
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				nbttagcompound1.setByte("Slot", (byte)i);
				list_slot[i].writeToNBT(nbttagcompound1);
				nbttaglist.appendTag(nbttagcompound1);
			}
		}
		nbt.setTag("Items", nbttaglist);
	}

	@Override
	public void openBackpackGui(ItemStack is) {
		System.out.println("openBackpackGui");
		NBTTagCompound nbt = is.getTagCompound();
		if (nbt == null) nbt = new NBTTagCompound();

		NBTTagList nbttaglist = nbt.getTagList("Items", 10);
		list_slot = new ItemStack[getSizeInventory()];

		for (int i = 0; i < nbttaglist.tagCount(); ++i) {
			NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
			int j = nbttagcompound1.getByte("Slot") & 255;

			if (j >= 0 && j < list_slot.length) {
				list_slot[j] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
			}
		}

	}

	@Override
	public void closeBackpackGui(ItemStack is) {
		System.out.println("closeBackpackGui");
		NBTTagCompound nbt = is.getTagCompound();
		if (nbt == null) nbt = new NBTTagCompound();

		NBTTagList nbttaglist = new NBTTagList();
		for (int i = 0; i < list_slot.length; ++i) {
			if (list_slot[i] != null) {
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				nbttagcompound1.setByte("Slot", (byte)i);
				list_slot[i].writeToNBT(nbttagcompound1);
				nbttaglist.appendTag(nbttagcompound1);
			}
		}
		nbt.setTag("Items", nbttaglist);

		is.setTagCompound(nbt);
	}

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
		return "container.furniture_backpack";
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
		if (Minecraft.getMinecraft().theWorld != null) {

		}
	}

}
