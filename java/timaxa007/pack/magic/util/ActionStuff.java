package timaxa007.pack.magic.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import timaxa007.pack.magic.item.ItemStuffs;

public class ActionStuff {

	public static void left(EntityPlayer player, boolean buttonstate) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemStuffs) {
				((ItemStuffs)current.getItem()).left(current, player.worldObj, player, buttonstate);
			}
		}
	}

	public static void right(EntityPlayer player, boolean buttonstate) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemStuffs) {
				((ItemStuffs)current.getItem()).right(current, player.worldObj, player, buttonstate);
			}
		}
	}

}
