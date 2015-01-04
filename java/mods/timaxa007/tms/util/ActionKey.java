package mods.timaxa007.tms.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ActionKey {
	//15
	public static void onLieTick(EntityPlayer player) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null && current.getItem() instanceof IActionKeyPlayer) {
			((IActionKeyPlayer)current.getItem()).onLieTick(current, player.worldObj, player);
		}
	}
	//14
	public static void onGrabTick(EntityPlayer player) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null && current.getItem() instanceof IActionKeyPlayer) {
			((IActionKeyPlayer)current.getItem()).onGrabTick(current, player.worldObj, player);
		}
	}
	//13
	public static void onBoosterTick(EntityPlayer player) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null && current.getItem() instanceof IActionKeyPlayer) {
			((IActionKeyPlayer)current.getItem()).onBoosterTick(current, player.worldObj, player);
		}
	}

	//13
	public static void onBooster(EntityPlayer player, boolean buttonstate) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null && current.getItem() instanceof IActionKeyPlayer) {
			((IActionKeyPlayer)current.getItem()).onBooster(current, player.worldObj, player, buttonstate);
		}
	}
	//14
	public static void onGrab(EntityPlayer player, boolean buttonstate) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null && current.getItem() instanceof IActionKeyPlayer) {
			((IActionKeyPlayer)current.getItem()).onGrab(current, player.worldObj, player, buttonstate);
		}
	}
	//15
	public static void onLie(EntityPlayer player, boolean buttonstate) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null && current.getItem() instanceof IActionKeyPlayer) {
			((IActionKeyPlayer)current.getItem()).onLie(current, player.worldObj, player, buttonstate);
		}
	}

}
