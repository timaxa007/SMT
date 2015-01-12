package mods.timaxa007.tms.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ActionMouseKey {
	//-2
	public static void onRightClickTick(EntityPlayer player) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof IActionMouseKey)
				((IActionMouseKey)current.getItem()).onRightClickTick(current, player.worldObj, player);
		}
	}
	//-1
	public static void onLeftClickTick(EntityPlayer player) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof IActionMouseKey)
				((IActionMouseKey)current.getItem()).onLeftClickTick(current, player.worldObj, player);
		}
	}
	//1
	public static void onLeftClick(EntityPlayer player, boolean buttonstate) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof IActionMouseKey)
				((IActionMouseKey)current.getItem()).onLeftClick(current, player.worldObj, player, buttonstate);
			if (current.getItem() instanceof ItemActionMouseKey)
				((ItemActionMouseKey)current.getItem()).isLeftClick = buttonstate;
			if (current.getItem() instanceof ItemActionBase)
				((ItemActionBase)current.getItem()).isLeftClick = buttonstate;
		}
	}
	//2
	public static void onRightClick(EntityPlayer player, boolean buttonstate) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof IActionMouseKey)
				((IActionMouseKey)current.getItem()).onRightClick(current, player.worldObj, player, buttonstate);
			if (current.getItem() instanceof ItemActionMouseKey)
				((ItemActionMouseKey)current.getItem()).isRightClick = buttonstate;
			if (current.getItem() instanceof ItemActionBase)
				((ItemActionBase)current.getItem()).isRightClick = buttonstate;
		}
	}

}
