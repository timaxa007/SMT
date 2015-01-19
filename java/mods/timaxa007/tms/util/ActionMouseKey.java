package mods.timaxa007.tms.util;

import mods.timaxa007.tms.Core;
import mods.timaxa007.tms.packet.MessageMouseKey;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ActionMouseKey {
	//--------------------------------------------------------------------------------------------------------------
	public static void actionLeftClickTickClient(EntityPlayer player) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemActionMouse) {
				((ItemActionMouse)current.getItem()).onLeftClickTickClient(current, player.worldObj, player);
			}
		}
	}

	public static void actionLeftClickClient(EntityPlayer player, boolean isPress) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemActionMouse) {
				((ItemActionMouse)current.getItem()).onLeftClickClient(current, player.worldObj, player, isPress);
				Core.network.sendToServer(new MessageMouseKey(1, isPress));
			}
		}
	}

	public static void actionLeftClick(EntityPlayer player, boolean isPress) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemActionMouse) {
				((ItemActionMouse)current.getItem()).onLeftClick(current, player.worldObj, player, isPress);
				((ItemActionMouse)current.getItem()).isLeftClick = isPress;
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	public static void actionRightClickTickClient(EntityPlayer player) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemActionMouse) {
				((ItemActionMouse)current.getItem()).onRightClickTickClient(current, player.worldObj, player);
			}
		}
	}

	public static void actionRightClickClient(EntityPlayer player, boolean isPress) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemActionMouse) {
				((ItemActionMouse)current.getItem()).onRightClickClient(current, player.worldObj, player, isPress);
				Core.network.sendToServer(new MessageMouseKey(2, isPress));
			}
		}
	}

	public static void actionRightClick(EntityPlayer player, boolean isPress) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemActionMouse) {
				((ItemActionMouse)current.getItem()).onRightClick(current, player.worldObj, player, isPress);
				((ItemActionMouse)current.getItem()).isRightClick = isPress;
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
}
