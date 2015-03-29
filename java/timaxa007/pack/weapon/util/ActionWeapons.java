package timaxa007.pack.weapon.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import timaxa007.pack.weapon.item.ItemWeapons;

public class ActionWeapons {

	public static void onFire(EntityPlayer player) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null && current.getItem() instanceof ItemWeapons)
			((ItemWeapons)current.getItem()).fire(current, player.worldObj, player);
	}

	public static void onScope(EntityPlayer player, boolean buttonstate) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null && current.getItem() instanceof ItemWeapons)
			((ItemWeapons)current.getItem()).scope(current, player.worldObj, player, buttonstate);
	}

	public static void onReload(EntityPlayer player) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null && current.getItem() instanceof ItemWeapons)
			((ItemWeapons)current.getItem()).reload(current, player.worldObj, player);
	}

	public static void onMode(EntityPlayer player) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null && current.getItem() instanceof ItemWeapons)
			((ItemWeapons)current.getItem()).mode(current, player.worldObj, player);
	}

	public static void zoomIn(EntityPlayer player) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null && current.getItem() instanceof ItemWeapons)
			((ItemWeapons)current.getItem()).zoomIn(current, player.worldObj, player);
	}

	public static void zoomOut(EntityPlayer player) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null && current.getItem() instanceof ItemWeapons)
			((ItemWeapons)current.getItem()).zoomOut(current, player.worldObj, player);
	}

}
