package timaxa007.module.control_button.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ActionMouseKey {
	//--------------------------------------------------------------------------------------------------------------
	public static void actionLeftClickTickClient(EntityPlayer player, int tick_lc) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemActionMouse) {
				((ItemActionMouse)current.getItem()).onLeftClickTickClient(current, player.worldObj, player, tick_lc);
			}
			if (current.getItem() instanceof ItemArmorActionMouse) {
				((ItemArmorActionMouse)current.getItem()).onLeftClickTickClient(current, player.worldObj, player, tick_lc);
			}
		}
	}

	public static void actionLeftClickClient(EntityPlayer player, boolean buttonstate) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemActionMouse) {
				((ItemActionMouse)current.getItem()).isLeftClick = buttonstate;
				((ItemActionMouse)current.getItem()).onLeftClickClient(current, player.worldObj, player, buttonstate);
			}
			if (current.getItem() instanceof ItemArmorActionMouse) {
				((ItemArmorActionMouse)current.getItem()).isLeftClick = buttonstate;
				((ItemArmorActionMouse)current.getItem()).onLeftClickClient(current, player.worldObj, player, buttonstate);
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	public static void actionRightClickTickClient(EntityPlayer player, int tick_rc) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemActionMouse) {
				((ItemActionMouse)current.getItem()).onRightClickTickClient(current, player.worldObj, player, tick_rc);
			}
			if (current.getItem() instanceof ItemArmorActionMouse) {
				((ItemArmorActionMouse)current.getItem()).onRightClickTickClient(current, player.worldObj, player, tick_rc);
			}
		}
	}

	public static void actionRightClickClient(EntityPlayer player, boolean buttonstate) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemActionMouse) {
				((ItemActionMouse)current.getItem()).isRightClick = buttonstate;
				((ItemActionMouse)current.getItem()).onRightClickClient(current, player.worldObj, player, buttonstate);
			}
			if (current.getItem() instanceof ItemArmorActionMouse) {
				((ItemArmorActionMouse)current.getItem()).isRightClick = buttonstate;
				((ItemArmorActionMouse)current.getItem()).onRightClickClient(current, player.worldObj, player, buttonstate);
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
}
