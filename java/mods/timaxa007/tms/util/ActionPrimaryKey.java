package mods.timaxa007.tms.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ActionPrimaryKey {
	//-4
	public static void onHookTick(EntityPlayer player) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null && current.getItem() instanceof IActionKeyPrimary) {
			((IActionKeyPrimary)current.getItem()).onHookTick(current, player.worldObj, player);
		}
	}
	//-3
	public static void onModeTick(EntityPlayer player) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof IActionKeyPrimary)
				((IActionKeyPrimary)current.getItem()).onModeTick(current, player.worldObj, player);
		}
	}
	//-2
	public static void onChargeTick(EntityPlayer player) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof IActionKeyPrimary)
				((IActionKeyPrimary)current.getItem()).onChargeTick(current, player.worldObj, player);
		}
	}
	//-1
	public static void onReloadTick(EntityPlayer player) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof IActionKeyPrimary)
				((IActionKeyPrimary)current.getItem()).onReloadTick(current, player.worldObj, player);
		}
	}
	//1
	public static void onReload(EntityPlayer player, boolean buttonstate) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof IActionKeyPrimary)
				((IActionKeyPrimary)current.getItem()).onReload(current, player.worldObj, player, buttonstate);
		}
	}
	//2
	public static void onCharge(EntityPlayer player, boolean buttonstate) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof IActionKeyPrimary)
				((IActionKeyPrimary)current.getItem()).onCharge(current, player.worldObj, player, buttonstate);
		}
	}
	//3
	public static void onMode(EntityPlayer player, boolean buttonstate) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof IActionKeyPrimary)
				((IActionKeyPrimary)current.getItem()).onMode(current, player.worldObj, player, buttonstate);
		}
	}
	//4
	public static void onHook(EntityPlayer player, boolean buttonstate) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null && current.getItem() instanceof IActionKeyPrimary) {
			((IActionKeyPrimary)current.getItem()).onHook(current, player.worldObj, player, buttonstate);
		}
	}

}
