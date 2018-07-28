package smt.pack.privacy.event;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ChatComponentText;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;

public class EventsInit {

	//@SubscribeEvent
	public void findItem(TickEvent.PlayerTickEvent event) {
		if (event.player != null) {
			for (int i = 0; i < event.player.inventory.getSizeInventory(); ++i) {
				ItemStack slot = event.player.inventory.getStackInSlot(i);
				if (slot != null) {
					int EnchID = Enchantment.infinity.effectId;
					if (findEnchID(EnchID, slot)) {
						event.player.inventory.setInventorySlotContents(i, removeEnchID(EnchID, slot));
						event.player.addChatMessage(new ChatComponentText("Запрещенная магия запрещена для низших."));
					}
				}
			}
		}
	}

	private static boolean findEnchID(int findID, ItemStack itemStack) {
		NBTTagList nbttaglist = itemStack.getEnchantmentTagList();
		if (nbttaglist == null) return false;
		else {
			for (int i = 0; i < nbttaglist.tagCount(); ++i) {
				short id = nbttaglist.getCompoundTagAt(i).getShort("id");
				short lvl = nbttaglist.getCompoundTagAt(i).getShort("lvl");

				if (id == findID) return true;
			}
		}
		return false;
	}

	private static ItemStack removeEnchID(int findID, ItemStack itemStack) {
		NBTTagList nbttaglist = itemStack.getEnchantmentTagList();
		NBTTagList newnbttaglist = new NBTTagList();
		if (nbttaglist == null) return itemStack;
		else {
			if (nbttaglist.tagCount() <= 1) {
				itemStack.getTagCompound().removeTag("ench");
				return itemStack;
			}
			for (int i = 0; i < nbttaglist.tagCount(); ++i) {
				short id = nbttaglist.getCompoundTagAt(i).getShort("id");
				short lvl = nbttaglist.getCompoundTagAt(i).getShort("lvl");

				if (id != findID) {
					NBTTagCompound nbttagcompound = new NBTTagCompound();
					nbttagcompound.setShort("id", id);
					nbttagcompound.setShort("lvl", lvl);
					newnbttaglist.appendTag(nbttagcompound);
				}

			}
			NBTTagCompound nbt = itemStack.getTagCompound();
			nbt.setTag("ench", newnbttaglist);
			itemStack.setTagCompound(nbt);
		}
		return itemStack;
	}

}
