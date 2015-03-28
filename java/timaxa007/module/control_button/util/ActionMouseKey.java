package timaxa007.module.control_button.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import timaxa007.module.control_button.api.IActionMouse;

public class ActionMouseKey {
	//--------------------------------------------------------------------------------------------------------------
	public static void actionLeftClickTickClient(EntityPlayer player, int tick_lc) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null && current.getItem() instanceof IActionMouse)
			((IActionMouse)current.getItem()).onLeftClickTickClient(current, player.worldObj, player, tick_lc);
	}

	public static void actionLeftClickClient(EntityPlayer player, boolean buttonstate) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null && current.getItem() instanceof IActionMouse)
			((IActionMouse)current.getItem()).onLeftClickClient(current, player.worldObj, player, buttonstate);
	}
	//--------------------------------------------------------------------------------------------------------------
	public static void actionRightClickTickClient(EntityPlayer player, int tick_rc) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null && current.getItem() instanceof IActionMouse)
			((IActionMouse)current.getItem()).onRightClickTickClient(current, player.worldObj, player, tick_rc);
	}

	public static void actionRightClickClient(EntityPlayer player, boolean buttonstate) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null && current.getItem() instanceof IActionMouse)
			((IActionMouse)current.getItem()).onRightClickClient(current, player.worldObj, player, buttonstate);
	}
	//--------------------------------------------------------------------------------------------------------------
}
