package timaxa007.module.control_button.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import timaxa007.module.control_button.api.IActionPrimaryKey;

public class ActionPrimaryKey {
	//--------------------------------------------------------------------------------------------------------------
	public static void actionReloadTickClient(EntityPlayer player, int tick_reload) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null && current.getItem() instanceof IActionPrimaryKey)
			((IActionPrimaryKey)current.getItem()).onReloadTickClient(current, player.worldObj, player, tick_reload);
	}

	public static void actionReloadClient(EntityPlayer player, boolean buttonstate) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null && current.getItem() instanceof IActionPrimaryKey)
			((IActionPrimaryKey)current.getItem()).onReloadClient(current, player.worldObj, player, buttonstate);
	}
	//--------------------------------------------------------------------------------------------------------------
	public static void actionChargeTickClient(EntityPlayer player, int tick_charge) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null && current.getItem() instanceof IActionPrimaryKey)
			((IActionPrimaryKey)current.getItem()).onChargeTickClient(current, player.worldObj, player, tick_charge);
	}

	public static void actionChargeClient(EntityPlayer player, boolean buttonstate) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null && current.getItem() instanceof IActionPrimaryKey)
			((IActionPrimaryKey)current.getItem()).onChargeClient(current, player.worldObj, player, buttonstate);
	}
	//--------------------------------------------------------------------------------------------------------------
	public static void actionModeTickClient(EntityPlayer player, int tick_mode) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null && current.getItem() instanceof IActionPrimaryKey)
			((IActionPrimaryKey)current.getItem()).onModeTickClient(current, player.worldObj, player, tick_mode);
	}

	public static void actionModeClient(EntityPlayer player, boolean buttonstate) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null && current.getItem() instanceof IActionPrimaryKey)
			((IActionPrimaryKey)current.getItem()).onModeClient(current, player.worldObj, player, buttonstate);
	}
	//--------------------------------------------------------------------------------------------------------------
	public static void actionActionTickClient(EntityPlayer player, int tick_action) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null && current.getItem() instanceof IActionPrimaryKey)
			((IActionPrimaryKey)current.getItem()).onActionTickClient(current, player.worldObj, player, tick_action);
	}

	public static void actionActionClient(EntityPlayer player, boolean buttonstate) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null && current.getItem() instanceof IActionPrimaryKey)
			((IActionPrimaryKey)current.getItem()).onActionClient(current, player.worldObj, player, buttonstate);
	}
	//--------------------------------------------------------------------------------------------------------------
	public static void actionModeInTickClient(EntityPlayer player, int tick_mode_in) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null && current.getItem() instanceof IActionPrimaryKey)
			((IActionPrimaryKey)current.getItem()).onModeInTickClient(current, player.worldObj, player, tick_mode_in);
	}

	public static void actionModeInClient(EntityPlayer player, boolean buttonstate) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null && current.getItem() instanceof IActionPrimaryKey)
			((IActionPrimaryKey)current.getItem()).onModeInClient(current, player.worldObj, player, buttonstate);
	}
	//--------------------------------------------------------------------------------------------------------------
	public static void actionModeOutTickClient(EntityPlayer player, int tick_mode_out) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null && current.getItem() instanceof IActionPrimaryKey)
			((IActionPrimaryKey)current.getItem()).onModeOutTickClient(current, player.worldObj, player, tick_mode_out);
	}

	public static void actionModeOutClient(EntityPlayer player, boolean buttonstate) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null && current.getItem() instanceof IActionPrimaryKey)
			((IActionPrimaryKey)current.getItem()).onModeOutClient(current, player.worldObj, player, buttonstate);
	}
	//--------------------------------------------------------------------------------------------------------------
}
