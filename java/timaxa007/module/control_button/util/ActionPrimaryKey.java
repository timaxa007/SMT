package timaxa007.module.control_button.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import timaxa007.module.control_button.CoreControlButton;
import timaxa007.module.control_button.packet.MessagePrimaryKey;

public class ActionPrimaryKey {
	//--------------------------------------------------------------------------------------------------------------
	public static void actionReloadTickClient(EntityPlayer player) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemPrimaryKey) {
				((ItemPrimaryKey)current.getItem()).onReloadTickClient(current, player.worldObj, player);
			}
			if (current.getItem() instanceof ItemArmorPrimaryKey) {
				((ItemArmorPrimaryKey)current.getItem()).onReloadTickClient(current, player.worldObj, player);
			}
		}
	}

	public static void actionReloadClient(EntityPlayer player, boolean buttonstate) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemPrimaryKey) {
				((ItemPrimaryKey)current.getItem()).isReload = buttonstate;
				if (((ItemPrimaryKey)current.getItem()).onReloadClient(current, player.worldObj, player, buttonstate))
					CoreControlButton.network.sendToServer(new MessagePrimaryKey(1, buttonstate));
			}
			if (current.getItem() instanceof ItemArmorPrimaryKey) {
				((ItemArmorPrimaryKey)current.getItem()).isReload = buttonstate;
				if (((ItemArmorPrimaryKey)current.getItem()).onReloadClient(current, player.worldObj, player, buttonstate))
					CoreControlButton.network.sendToServer(new MessagePrimaryKey(1, buttonstate));
			}
		}
	}

	public static void actionReload(EntityPlayer player, boolean buttonstate) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemPrimaryKey) {
				((ItemPrimaryKey)current.getItem()).onReload(current, player.worldObj, player, buttonstate);
			}
			if (current.getItem() instanceof ItemArmorPrimaryKey) {
				((ItemArmorPrimaryKey)current.getItem()).onReload(current, player.worldObj, player, buttonstate);
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	public static void actionChargeTickClient(EntityPlayer player) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemPrimaryKey) {
				((ItemPrimaryKey)current.getItem()).onChargeTickClient(current, player.worldObj, player);
			}
			if (current.getItem() instanceof ItemArmorPrimaryKey) {
				((ItemArmorPrimaryKey)current.getItem()).onChargeTickClient(current, player.worldObj, player);
			}
		}
	}

	public static void actionChargeClient(EntityPlayer player, boolean buttonstate) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemPrimaryKey) {
				((ItemPrimaryKey)current.getItem()).isCharge = buttonstate;
				if (((ItemPrimaryKey)current.getItem()).onChargeClient(current, player.worldObj, player, buttonstate))
					CoreControlButton.network.sendToServer(new MessagePrimaryKey(2, buttonstate));
			}
			if (current.getItem() instanceof ItemArmorPrimaryKey) {
				((ItemArmorPrimaryKey)current.getItem()).isCharge = buttonstate;
				if (((ItemArmorPrimaryKey)current.getItem()).onChargeClient(current, player.worldObj, player, buttonstate))
					CoreControlButton.network.sendToServer(new MessagePrimaryKey(2, buttonstate));
			}
		}
	}

	public static void actionCharge(EntityPlayer player, boolean buttonstate) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemPrimaryKey) {
				((ItemPrimaryKey)current.getItem()).onCharge(current, player.worldObj, player, buttonstate);
			}
			if (current.getItem() instanceof ItemArmorPrimaryKey) {
				((ItemArmorPrimaryKey)current.getItem()).onCharge(current, player.worldObj, player, buttonstate);
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	public static void actionModeTickClient(EntityPlayer player) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemPrimaryKey) {
				((ItemPrimaryKey)current.getItem()).onModeTickClient(current, player.worldObj, player);
			}
			if (current.getItem() instanceof ItemArmorPrimaryKey) {
				((ItemArmorPrimaryKey)current.getItem()).onModeTickClient(current, player.worldObj, player);
			}
		}
	}

	public static void actionModeClient(EntityPlayer player, boolean buttonstate) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemPrimaryKey) {
				((ItemPrimaryKey)current.getItem()).isMode = buttonstate;
				if (((ItemPrimaryKey)current.getItem()).onModeClient(current, player.worldObj, player, buttonstate))
					CoreControlButton.network.sendToServer(new MessagePrimaryKey(3, buttonstate));
			}
			if (current.getItem() instanceof ItemArmorPrimaryKey) {
				((ItemArmorPrimaryKey)current.getItem()).isMode = buttonstate;
				if (((ItemArmorPrimaryKey)current.getItem()).onModeClient(current, player.worldObj, player, buttonstate))
					CoreControlButton.network.sendToServer(new MessagePrimaryKey(3, buttonstate));
			}
		}
	}

	public static void actionMode(EntityPlayer player, boolean buttonstate) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemPrimaryKey) {
				((ItemPrimaryKey)current.getItem()).onMode(current, player.worldObj, player, buttonstate);
			}
			if (current.getItem() instanceof ItemArmorPrimaryKey) {
				((ItemArmorPrimaryKey)current.getItem()).onMode(current, player.worldObj, player, buttonstate);
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	public static void actionActionTickClient(EntityPlayer player) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemPrimaryKey) {
				((ItemPrimaryKey)current.getItem()).onActionTickClient(current, player.worldObj, player);
			}
			if (current.getItem() instanceof ItemArmorPrimaryKey) {
				((ItemArmorPrimaryKey)current.getItem()).onActionTickClient(current, player.worldObj, player);
			}
		}
	}

	public static void actionActionClient(EntityPlayer player, boolean buttonstate) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemPrimaryKey) {
				((ItemPrimaryKey)current.getItem()).isAction = buttonstate;
				if (((ItemPrimaryKey)current.getItem()).onActionClient(current, player.worldObj, player, buttonstate))
					CoreControlButton.network.sendToServer(new MessagePrimaryKey(4, buttonstate));
			}
			if (current.getItem() instanceof ItemArmorPrimaryKey) {
				((ItemArmorPrimaryKey)current.getItem()).isAction = buttonstate;
				if (((ItemArmorPrimaryKey)current.getItem()).onActionClient(current, player.worldObj, player, buttonstate))
					CoreControlButton.network.sendToServer(new MessagePrimaryKey(4, buttonstate));
			}
		}
	}

	public static void actionAction(EntityPlayer player, boolean buttonstate) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemPrimaryKey) {
				((ItemPrimaryKey)current.getItem()).onAction(current, player.worldObj, player, buttonstate);
			}
			if (current.getItem() instanceof ItemArmorPrimaryKey) {
				((ItemArmorPrimaryKey)current.getItem()).onAction(current, player.worldObj, player, buttonstate);
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	public static void actionModeInTickClient(EntityPlayer player) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemPrimaryKey) {
				((ItemPrimaryKey)current.getItem()).onModeInTickClient(current, player.worldObj, player);
			}
			if (current.getItem() instanceof ItemArmorPrimaryKey) {
				((ItemArmorPrimaryKey)current.getItem()).onModeInTickClient(current, player.worldObj, player);
			}
		}
	}

	public static void actionModeInClient(EntityPlayer player, boolean buttonstate) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemPrimaryKey) {
				((ItemPrimaryKey)current.getItem()).isModeIn = buttonstate;
				if (((ItemPrimaryKey)current.getItem()).onModeInClient(current, player.worldObj, player, buttonstate))
					CoreControlButton.network.sendToServer(new MessagePrimaryKey(5, buttonstate));
			}
			if (current.getItem() instanceof ItemArmorPrimaryKey) {
				((ItemArmorPrimaryKey)current.getItem()).isModeIn = buttonstate;
				if (((ItemArmorPrimaryKey)current.getItem()).onModeInClient(current, player.worldObj, player, buttonstate))
					CoreControlButton.network.sendToServer(new MessagePrimaryKey(5, buttonstate));
			}
		}
	}

	public static void actionModeIn(EntityPlayer player, boolean buttonstate) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemPrimaryKey) {
				((ItemPrimaryKey)current.getItem()).onModeIn(current, player.worldObj, player, buttonstate);
			}
			if (current.getItem() instanceof ItemArmorPrimaryKey) {
				((ItemArmorPrimaryKey)current.getItem()).onModeIn(current, player.worldObj, player, buttonstate);
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	public static void actionModeOutTickClient(EntityPlayer player) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemPrimaryKey) {
				((ItemPrimaryKey)current.getItem()).onModeOutTickClient(current, player.worldObj, player);
			}
			if (current.getItem() instanceof ItemArmorPrimaryKey) {
				((ItemArmorPrimaryKey)current.getItem()).onModeOutTickClient(current, player.worldObj, player);
			}
		}
	}

	public static void actionModeOutClient(EntityPlayer player, boolean buttonstate) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemPrimaryKey) {
				((ItemPrimaryKey)current.getItem()).isModeOut = buttonstate;
				if (((ItemPrimaryKey)current.getItem()).onModeOutClient(current, player.worldObj, player, buttonstate))
					CoreControlButton.network.sendToServer(new MessagePrimaryKey(6, buttonstate));
			}
			if (current.getItem() instanceof ItemArmorPrimaryKey) {
				((ItemArmorPrimaryKey)current.getItem()).isModeOut = buttonstate;
				if (((ItemArmorPrimaryKey)current.getItem()).onModeOutClient(current, player.worldObj, player, buttonstate))
					CoreControlButton.network.sendToServer(new MessagePrimaryKey(6, buttonstate));
			}
		}
	}

	public static void actionModeOut(EntityPlayer player, boolean buttonstate) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemPrimaryKey) {
				((ItemPrimaryKey)current.getItem()).onModeOut(current, player.worldObj, player, buttonstate);
			}
			if (current.getItem() instanceof ItemArmorPrimaryKey) {
				((ItemArmorPrimaryKey)current.getItem()).onModeOut(current, player.worldObj, player, buttonstate);
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
}
