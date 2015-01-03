package mods.timaxa007.tms.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ActionPrimaryKey {
	//1
	public static void onReload(EntityPlayer player) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof IActionKeyPrimary)
				((IActionKeyPrimary)current.getItem()).onReload(current, player.worldObj, player);
		}
	}
	//2
	public static void onCharge(EntityPlayer player) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof IActionKeyPrimary)
				((IActionKeyPrimary)current.getItem()).onCharge(current, player.worldObj, player);
		}
	}
	//3
	public static void onMode(EntityPlayer player) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof IActionKeyPrimary)
				((IActionKeyPrimary)current.getItem()).onMode(current, player.worldObj, player);
		}
	}
	//4
	public static void onHook(EntityPlayer player) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null && current.getItem() instanceof IActionKeyPrimary) {
			((IActionKeyPrimary)current.getItem()).onHook(current, player.worldObj, player);
		}
	}

}
