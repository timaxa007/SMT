package mods.timaxa007.tms.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ActionPrimaryKey {
	//-6
	public static void onZoomOutTick(EntityPlayer player) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null && current.getItem() instanceof IActionKeyPrimary) {
			((IActionKeyPrimary)current.getItem()).onZoomOutTick(current, player.worldObj, player);
		}
	}
	//-5
	public static void onZoomInTick(EntityPlayer player) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null && current.getItem() instanceof IActionKeyPrimary) {
			((IActionKeyPrimary)current.getItem()).onZoomInTick(current, player.worldObj, player);
		}
	}
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
			if (current.getItem() instanceof ItemActionKeyPrimary)
				((ItemActionKeyPrimary)current.getItem()).isReload = buttonstate;
			if (current.getItem() instanceof ItemActionBase)
				((ItemActionBase)current.getItem()).isReload = buttonstate;
		}
	}
	//2
	public static void onCharge(EntityPlayer player, boolean buttonstate) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof IActionKeyPrimary)
				((IActionKeyPrimary)current.getItem()).onCharge(current, player.worldObj, player, buttonstate);
			if (current.getItem() instanceof ItemActionKeyPrimary)
				((ItemActionKeyPrimary)current.getItem()).isCharge = buttonstate;
			if (current.getItem() instanceof ItemActionBase)
				((ItemActionBase)current.getItem()).isCharge = buttonstate;
		}
	}
	//3
	public static void onMode(EntityPlayer player, boolean buttonstate) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof IActionKeyPrimary)
				((IActionKeyPrimary)current.getItem()).onMode(current, player.worldObj, player, buttonstate);
			if (current.getItem() instanceof ItemActionKeyPrimary)
				((ItemActionKeyPrimary)current.getItem()).isMode = buttonstate;
			if (current.getItem() instanceof ItemActionBase)
				((ItemActionBase)current.getItem()).isMode = buttonstate;
		}
	}
	//4
	public static void onHook(EntityPlayer player, boolean buttonstate) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null && current.getItem() instanceof IActionKeyPrimary) {
			((IActionKeyPrimary)current.getItem()).onHook(current, player.worldObj, player, buttonstate);
			if (current.getItem() instanceof ItemActionKeyPrimary)
				((ItemActionKeyPrimary)current.getItem()).isHook = buttonstate;
			if (current.getItem() instanceof ItemActionBase)
				((ItemActionBase)current.getItem()).isHook = buttonstate;
		}
	}
	//5
	public static void onZoomIn(EntityPlayer player, boolean buttonstate) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null && current.getItem() instanceof IActionKeyPrimary) {
			((IActionKeyPrimary)current.getItem()).onZoomIn(current, player.worldObj, player, buttonstate);
			if (current.getItem() instanceof ItemActionKeyPrimary)
				((ItemActionKeyPrimary)current.getItem()).isZoomIn = buttonstate;
			if (current.getItem() instanceof ItemActionBase)
				((ItemActionBase)current.getItem()).isZoomIn = buttonstate;
		}
	}
	//6
	public static void onZoomOut(EntityPlayer player, boolean buttonstate) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null && current.getItem() instanceof IActionKeyPrimary) {
			((IActionKeyPrimary)current.getItem()).onZoomOut(current, player.worldObj, player, buttonstate);
			if (current.getItem() instanceof ItemActionKeyPrimary)
				((ItemActionKeyPrimary)current.getItem()).isZoomOut = buttonstate;
			if (current.getItem() instanceof ItemActionBase)
				((ItemActionBase)current.getItem()).isZoomOut = buttonstate;
		}
	}

}
