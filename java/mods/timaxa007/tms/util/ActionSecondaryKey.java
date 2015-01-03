package mods.timaxa007.tms.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ActionSecondaryKey {
	//1
	public static void onUse(EntityPlayer player) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null && current.getItem() instanceof IActionKeySecondary) {
			((IActionKeySecondary)current.getItem()).onUse(current, player.worldObj, player);
		}
	}
	//2
	public static void onYawRight(EntityPlayer player) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null && current.getItem() instanceof IActionKeySecondary) {
			((IActionKeySecondary)current.getItem()).onYawRight(current, player.worldObj, player);
		}
	}
	//3
	public static void onUp(EntityPlayer player) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null && current.getItem() instanceof IActionKeySecondary) {
			((IActionKeySecondary)current.getItem()).onUp(current, player.worldObj, player);
		}
	}
	//4
	public static void onYawLeft(EntityPlayer player) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null && current.getItem() instanceof IActionKeySecondary) {
			((IActionKeySecondary)current.getItem()).onYawLeft(current, player.worldObj, player);
		}
	}
	//5
	public static void onMoveRight(EntityPlayer player) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null && current.getItem() instanceof IActionKeySecondary) {
			((IActionKeySecondary)current.getItem()).onMoveRight(current, player.worldObj, player);
		}
	}
	//6
	public static void onStop(EntityPlayer player) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null && current.getItem() instanceof IActionKeySecondary) {
			((IActionKeySecondary)current.getItem()).onStop(current, player.worldObj, player);
		}
	}
	//7
	public static void onMoveLeft(EntityPlayer player) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null && current.getItem() instanceof IActionKeySecondary) {
			((IActionKeySecondary)current.getItem()).onMoveLeft(current, player.worldObj, player);
		}
	}
	//8
	public static void onUse2(EntityPlayer player) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null && current.getItem() instanceof IActionKeySecondary) {
			((IActionKeySecondary)current.getItem()).onUse2(current, player.worldObj, player);
		}
	}
	//9
	public static void onDown(EntityPlayer player) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null && current.getItem() instanceof IActionKeySecondary) {
			((IActionKeySecondary)current.getItem()).onDown(current, player.worldObj, player);
		}
	}
	//10
	public static void onUse1(EntityPlayer player) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null && current.getItem() instanceof IActionKeySecondary) {
			((IActionKeySecondary)current.getItem()).onUse1(current, player.worldObj, player);
		}
	}

}
