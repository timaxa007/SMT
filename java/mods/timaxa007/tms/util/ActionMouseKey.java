package mods.timaxa007.tms.util;

import mods.timaxa007.tms.Core;
import mods.timaxa007.tms.packet.MessageMouseKey;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ActionMouseKey {
	//--------------------------------------------------------------------------------------------------------------
	public static void onLeftClickTickClient(EntityPlayer player) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemActionMouse) {
				((ItemActionMouse)current.getItem()).onLeftClickTickClient(current, player.worldObj, player);
				if (((ItemActionMouse)current.getItem()).onLeftClickTickClient(current, player.worldObj, player)) {
					Core.network.sendToServer(new MessageMouseKey(-1, true));
				}
			}
		}
	}

	public static void onLeftClickClient(EntityPlayer player, boolean isPress) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemActionMouse) {
				((ItemActionMouse)current.getItem()).onLeftClickClient(current, player.worldObj, player, isPress);
				((ItemActionMouse)current.getItem()).isLeftClick = isPress;
				if (((ItemActionMouse)current.getItem()).onLeftClickClient(current, player.worldObj, player, isPress)) {
					Core.network.sendToServer(new MessageMouseKey(1, isPress));
				}
			}
		}
	}

	public static void onLeftClickTick(EntityPlayer player) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemActionMouse) {
				((ItemActionMouse)current.getItem()).onLeftClickTick(current, player.worldObj, player);
			}
		}
	}

	public static void onLeftClick(EntityPlayer player, boolean isPress) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemActionMouse) {
				((ItemActionMouse)current.getItem()).onLeftClick(current, player.worldObj, player, isPress);
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	public static void onRightClickTickClient(EntityPlayer player) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemActionMouse) {
				((ItemActionMouse)current.getItem()).onRightClickTickClient(current, player.worldObj, player);
				if (((ItemActionMouse)current.getItem()).onRightClickTickClient(current, player.worldObj, player)) {
					Core.network.sendToServer(new MessageMouseKey(-2, true));
				}
			}
		}
	}

	public static void onRightClickClient(EntityPlayer player, boolean isPress) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemActionMouse) {
				((ItemActionMouse)current.getItem()).onRightClickClient(current, player.worldObj, player, isPress);
				((ItemActionMouse)current.getItem()).isRightClick = isPress;
				if (((ItemActionMouse)current.getItem()).onRightClickClient(current, player.worldObj, player, isPress)) {
					Core.network.sendToServer(new MessageMouseKey(2, isPress));
				}
			}
		}
	}

	public static void onRightClickTick(EntityPlayer player) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemActionMouse) {
				((ItemActionMouse)current.getItem()).onRightClickTick(current, player.worldObj, player);
			}
		}
	}

	public static void onRightClick(EntityPlayer player, boolean isPress) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemActionMouse) {
				((ItemActionMouse)current.getItem()).onRightClick(current, player.worldObj, player, isPress);
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
}
