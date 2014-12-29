package mods.timaxa007.pack.weapon.util;

import mods.timaxa007.tms.util.IWeapon;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ActionWeapons {

	public static void onFire(EntityPlayer player, boolean buttonstate) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null && current.getItem() instanceof IWeapon) {
			((IWeapon)current.getItem()).onFire(current, player.worldObj, player, buttonstate);
		}
	}

	public static void onScope(EntityPlayer player, boolean buttonstate) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null && current.getItem() instanceof IWeapon) {
			((IWeapon)current.getItem()).onScope(current, player.worldObj, player, buttonstate);
		}
	}

	public static void onReload(EntityPlayer player) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null && current.getItem() instanceof IWeapon) {
			((IWeapon)current.getItem()).onReload(current, player.worldObj, player);
		}
	}

	public static void onCharge(EntityPlayer player) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null && current.getItem() instanceof IWeapon) {
			((IWeapon)current.getItem()).onCharge(current, player.worldObj, player);
		}
	}

	public static void onMode(EntityPlayer player) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null && current.getItem() instanceof IWeapon) {
			((IWeapon)current.getItem()).onMode(current, player.worldObj, player);
		}
	}

}
