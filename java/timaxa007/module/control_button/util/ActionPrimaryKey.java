package timaxa007.module.control_button.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ActionPrimaryKey {
	//--------------------------------------------------------------------------------------------------------------
	public static void actionReloadTickClient(EntityPlayer player, int tick_reload) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemPrimaryKey) {
				((ItemPrimaryKey)current.getItem()).onReloadTickClient(current, player.worldObj, player, tick_reload);
			}
			if (current.getItem() instanceof ItemArmorPrimaryKey) {
				((ItemArmorPrimaryKey)current.getItem()).onReloadTickClient(current, player.worldObj, player, tick_reload);
			}
		}
	}

	public static void actionReloadClient(EntityPlayer player, boolean buttonstate) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemPrimaryKey) {
				((ItemPrimaryKey)current.getItem()).isReload = buttonstate;
				((ItemPrimaryKey)current.getItem()).onReloadClient(current, player.worldObj, player, buttonstate);
			}
			if (current.getItem() instanceof ItemArmorPrimaryKey) {
				((ItemArmorPrimaryKey)current.getItem()).isReload = buttonstate;
				((ItemArmorPrimaryKey)current.getItem()).onReloadClient(current, player.worldObj, player, buttonstate);
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	public static void actionChargeTickClient(EntityPlayer player, int tick_charge) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemPrimaryKey) {
				((ItemPrimaryKey)current.getItem()).onChargeTickClient(current, player.worldObj, player, tick_charge);
			}
			if (current.getItem() instanceof ItemArmorPrimaryKey) {
				((ItemArmorPrimaryKey)current.getItem()).onChargeTickClient(current, player.worldObj, player, tick_charge);
			}
		}
	}

	public static void actionChargeClient(EntityPlayer player, boolean buttonstate) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemPrimaryKey) {
				((ItemPrimaryKey)current.getItem()).isCharge = buttonstate;
				((ItemPrimaryKey)current.getItem()).onChargeClient(current, player.worldObj, player, buttonstate);
			}
			if (current.getItem() instanceof ItemArmorPrimaryKey) {
				((ItemArmorPrimaryKey)current.getItem()).isCharge = buttonstate;
				((ItemArmorPrimaryKey)current.getItem()).onChargeClient(current, player.worldObj, player, buttonstate);
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	public static void actionModeTickClient(EntityPlayer player, int tick_mode) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemPrimaryKey) {
				((ItemPrimaryKey)current.getItem()).onModeTickClient(current, player.worldObj, player, tick_mode);
			}
			if (current.getItem() instanceof ItemArmorPrimaryKey) {
				((ItemArmorPrimaryKey)current.getItem()).onModeTickClient(current, player.worldObj, player, tick_mode);
			}
		}
	}

	public static void actionModeClient(EntityPlayer player, boolean buttonstate) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemPrimaryKey) {
				((ItemPrimaryKey)current.getItem()).isMode = buttonstate;
				((ItemPrimaryKey)current.getItem()).onModeClient(current, player.worldObj, player, buttonstate);
			}
			if (current.getItem() instanceof ItemArmorPrimaryKey) {
				((ItemArmorPrimaryKey)current.getItem()).isMode = buttonstate;
				((ItemArmorPrimaryKey)current.getItem()).onModeClient(current, player.worldObj, player, buttonstate);
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	public static void actionActionTickClient(EntityPlayer player, int tick_action) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemPrimaryKey) {
				((ItemPrimaryKey)current.getItem()).onActionTickClient(current, player.worldObj, player, tick_action);
			}
			if (current.getItem() instanceof ItemArmorPrimaryKey) {
				((ItemArmorPrimaryKey)current.getItem()).onActionTickClient(current, player.worldObj, player, tick_action);
			}
		}
	}

	public static void actionActionClient(EntityPlayer player, boolean buttonstate) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemPrimaryKey) {
				((ItemPrimaryKey)current.getItem()).isAction = buttonstate;
				((ItemPrimaryKey)current.getItem()).onActionClient(current, player.worldObj, player, buttonstate);
			}
			if (current.getItem() instanceof ItemArmorPrimaryKey) {
				((ItemArmorPrimaryKey)current.getItem()).isAction = buttonstate;
				((ItemArmorPrimaryKey)current.getItem()).onActionClient(current, player.worldObj, player, buttonstate);
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	public static void actionModeInTickClient(EntityPlayer player, int tick_mode_in) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemPrimaryKey) {
				((ItemPrimaryKey)current.getItem()).onModeInTickClient(current, player.worldObj, player, tick_mode_in);
			}
			if (current.getItem() instanceof ItemArmorPrimaryKey) {
				((ItemArmorPrimaryKey)current.getItem()).onModeInTickClient(current, player.worldObj, player, tick_mode_in);
			}
		}
	}

	public static void actionModeInClient(EntityPlayer player, boolean buttonstate) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemPrimaryKey) {
				((ItemPrimaryKey)current.getItem()).isModeIn = buttonstate;
				((ItemPrimaryKey)current.getItem()).onModeInClient(current, player.worldObj, player, buttonstate);
			}
			if (current.getItem() instanceof ItemArmorPrimaryKey) {
				((ItemArmorPrimaryKey)current.getItem()).isModeIn = buttonstate;
				((ItemArmorPrimaryKey)current.getItem()).onModeInClient(current, player.worldObj, player, buttonstate);
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	public static void actionModeOutTickClient(EntityPlayer player, int tick_mode_out) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemPrimaryKey) {
				((ItemPrimaryKey)current.getItem()).onModeOutTickClient(current, player.worldObj, player, tick_mode_out);
			}
			if (current.getItem() instanceof ItemArmorPrimaryKey) {
				((ItemArmorPrimaryKey)current.getItem()).onModeOutTickClient(current, player.worldObj, player, tick_mode_out);
			}
		}
	}

	public static void actionModeOutClient(EntityPlayer player, boolean buttonstate) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemPrimaryKey) {
				((ItemPrimaryKey)current.getItem()).isModeOut = buttonstate;
				((ItemPrimaryKey)current.getItem()).onModeOutClient(current, player.worldObj, player, buttonstate);
			}
			if (current.getItem() instanceof ItemArmorPrimaryKey) {
				((ItemArmorPrimaryKey)current.getItem()).isModeOut = buttonstate;
				((ItemArmorPrimaryKey)current.getItem()).onModeOutClient(current, player.worldObj, player, buttonstate);
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
}
