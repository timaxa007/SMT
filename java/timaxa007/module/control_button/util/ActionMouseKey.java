package timaxa007.module.control_button.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import timaxa007.module.control_button.CoreControlButton;
import timaxa007.module.control_button.packet.MessageMouseKey;

public class ActionMouseKey {
	//--------------------------------------------------------------------------------------------------------------
	public static void actionLeftClickTickClient(EntityPlayer player) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemActionMouse) {
				((ItemActionMouse)current.getItem()).onLeftClickTickClient(current, player.worldObj, player);
			}
			if (current.getItem() instanceof ItemArmorActionMouse) {
				((ItemArmorActionMouse)current.getItem()).onLeftClickTickClient(current, player.worldObj, player);
			}
		}
	}

	public static void actionLeftClickClient(EntityPlayer player, boolean buttonstate) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemActionMouse) {
				((ItemActionMouse)current.getItem()).isLeftClick = buttonstate;
				if (((ItemActionMouse)current.getItem()).onLeftClickClient(current, player.worldObj, player, buttonstate))
					CoreControlButton.network.sendToServer(new MessageMouseKey(1, buttonstate));
			}
			if (current.getItem() instanceof ItemArmorActionMouse) {
				((ItemArmorActionMouse)current.getItem()).isLeftClick = buttonstate;
				if (((ItemArmorActionMouse)current.getItem()).onLeftClickClient(current, player.worldObj, player, buttonstate))
					CoreControlButton.network.sendToServer(new MessageMouseKey(1, buttonstate));
			}
		}
	}

	public static void actionLeftClick(EntityPlayer player, boolean buttonstate) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemActionMouse) {
				((ItemActionMouse)current.getItem()).onLeftClick(current, player.worldObj, player, buttonstate);
			}
			if (current.getItem() instanceof ItemArmorActionMouse) {
				((ItemArmorActionMouse)current.getItem()).onLeftClick(current, player.worldObj, player, buttonstate);
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
			if (current.getItem() instanceof ItemArmorActionMouse) {
				((ItemArmorActionMouse)current.getItem()).onRightClickTickClient(current, player.worldObj, player);
			}
		}
	}

	public static void actionRightClickClient(EntityPlayer player, boolean buttonstate) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemActionMouse) {
				((ItemActionMouse)current.getItem()).isRightClick = buttonstate;
				if (((ItemActionMouse)current.getItem()).onRightClickClient(current, player.worldObj, player, buttonstate))
					CoreControlButton.network.sendToServer(new MessageMouseKey(2, buttonstate));
			}
			if (current.getItem() instanceof ItemArmorActionMouse) {
				((ItemArmorActionMouse)current.getItem()).isRightClick = buttonstate;
				if (((ItemArmorActionMouse)current.getItem()).onRightClickClient(current, player.worldObj, player, buttonstate))
					CoreControlButton.network.sendToServer(new MessageMouseKey(2, buttonstate));
			}
		}
	}

	public static void actionRightClick(EntityPlayer player, boolean buttonstate) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemActionMouse) {
				((ItemActionMouse)current.getItem()).onRightClick(current, player.worldObj, player, buttonstate);
			}
			if (current.getItem() instanceof ItemArmorActionMouse) {
				((ItemArmorActionMouse)current.getItem()).onRightClick(current, player.worldObj, player, buttonstate);
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
}
