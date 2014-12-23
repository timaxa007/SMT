package mods.timaxa007.pack.furniture.item;

import java.util.List;

import mods.timaxa007.pack.furniture.PackFurniture;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemBackpack extends Item implements IInventory {

	public static ItemStack[] list_slot = new ItemStack[27];

	public ItemBackpack() {
		super();
		setCreativeTab(PackFurniture.tab_furniture);
		setTextureName("timaxa007:backpack");
		setUnlocalizedName("backpack");
	}

	public ItemStack onItemRightClick(ItemStack is, World world, EntityPlayer player) {
		if (player.isSneaking()) {

		} else {
			player.openGui(PackFurniture.instance, PackFurniture.proxy.gui_backpack, world, (int)player.posX, (int)player.posY, (int)player.posZ);
		}
		return is;
	}
	/*
	public boolean onItemUse(ItemStack is, EntityPlayer player, World world, int x, int y, int z, int meta, float hitX, float hitY, float hitZ) {
		if (player.isSneaking()) {
			return false;
		} else {
			player.openGui(PackFurniture.instance, PackFurniture.guiBackpack, world, x, y, z);
			return true;
		}
	}
	 */
	@SideOnly(Side.CLIENT)
	public void getSubItems(Item id, CreativeTabs table, List list) {
		list.add(addTag());
		list.add(new ItemStack(id, 1, 0));
	}

	private static ItemStack addTag() {
		ItemStack is = new ItemStack(PackFurniture.proxy.item.backpack);
		NBTTagCompound tag = new NBTTagCompound();
		NBTTagList nbttaglist = new NBTTagList();
		for (int i = 0; i < list_slot.length; ++i) {
			if (list_slot[i] != null) {
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				nbttagcompound1.setByte("Slot", (byte)i);
				list_slot[i].writeToNBT(nbttagcompound1);
				nbttaglist.appendTag(nbttagcompound1);
			}
		}
		tag.setTag("Items", nbttaglist);
		is.setTagCompound(tag);
		return is;
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

	}

	@Override
	public void closeInventory() {

	}

	@Override
	public boolean isItemValidForSlot(int i, ItemStack is) {
		return true;
	}

	@Override
	public void markDirty() {
		// TODO Auto-generated method stub
		
	}

}
