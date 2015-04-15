package timaxa007.pack.magic.item;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.world.World;
import timaxa007.pack.magic.PackMagic;
import timaxa007.tms.util.ModifiedItem;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemMagicBag extends ModifiedItem {
	private static ItemStack[] list_slot = new ItemStack[36];

	public ItemMagicBag(String tag) {
		super(tag);
		setCreativeTab(PackMagic.tab_magic);
		setTextureName("timaxa007:icon/magic");
	}

	public ItemStack onItemRightClick(ItemStack is, World world, EntityPlayer player) {
		NBTTagCompound nbt = is.getTagCompound();
		if (nbt != null) {

			NBTTagList nbttaglist = new NBTTagList();

			for (int i = 0; i < list_slot.length; ++i) {
				if (list_slot[i] != null) {
					NBTTagCompound nbttagcompound1 = new NBTTagCompound();
					nbttagcompound1.setByte("Slot", (byte)i);
					if (i == 1)
						list_slot[i] = new ItemStack(Items.iron_ingot);
					list_slot[i].writeToNBT(nbttagcompound1);
					nbttaglist.appendTag(nbttagcompound1);
				}
			}

			nbt.setTag("Items", nbttaglist);

			is.setTagCompound(nbt);
			return is;
		}
		return super.onItemRightClick(is, world, player);
	}

	public void addInformation(ItemStack is, EntityPlayer player, List list, boolean flag) {
		NBTTagCompound nbt = is.getTagCompound();

		if (nbt != null) {

			NBTTagList nbttaglist = nbt.getTagList("Items", 10);

			for (int i = 0; i < nbttaglist.tagCount(); ++i) {
				NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
				int j = nbttagcompound1.getByte("Slot") & 255;

				if (j >= 0 && j < list_slot.length) {
					list_slot[j] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
					list.add("Slot " + j + " / " + list_slot[j].getDisplayName());
				}
			}

			if (nbt.hasKey("Active")) list.add("Active: " + nbt.getBoolean("Active") + ".");
		}
	}

	@SideOnly(Side.CLIENT)
	public void getSubItems(Item id, CreativeTabs table, List list) {
		list.add(addNBT());
	}

	public static ItemStack addNBT() {
		ItemStack is = new ItemStack(PackMagic.item.magic_bag);
		NBTTagCompound nbt = new NBTTagCompound();
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
		return is;
	}

}
