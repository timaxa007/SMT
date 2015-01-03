package mods.timaxa007.tms.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ActionKey {
	//13
	public static void onBooster(EntityPlayer player) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null && current.getItem() instanceof IActionKeyPlayer) {
			((IActionKeyPlayer)current.getItem()).onBooster(current, player.worldObj, player);
		}
	}
	//14
	public static void onGrab(EntityPlayer player) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null && current.getItem() instanceof IActionKeyPlayer) {
			((IActionKeyPlayer)current.getItem()).onGrab(current, player.worldObj, player);
		}
	}
	//15
	public static void onLie(EntityPlayer player) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null && current.getItem() instanceof IActionKeyPlayer) {
			((IActionKeyPlayer)current.getItem()).onLie(current, player.worldObj, player);
		}
	}

}
