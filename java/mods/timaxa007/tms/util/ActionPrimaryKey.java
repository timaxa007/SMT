package mods.timaxa007.tms.util;

import mods.timaxa007.tms.Core;
import mods.timaxa007.tms.packet.MessagePrimaryKey;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ActionPrimaryKey {
	//--------------------------------------------------------------------------------------------------------------
	public static void actionReloadTickClient(EntityPlayer player) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemPrimaryKey) {
				((ItemPrimaryKey)current.getItem()).onReloadTickClient(current, player.worldObj, player);
			}
		}
	}

	public static void actionReloadClient(EntityPlayer player, boolean isPress) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemPrimaryKey) {
				((ItemPrimaryKey)current.getItem()).onReloadClient(current, player.worldObj, player, isPress);
				Core.network.sendToServer(new MessagePrimaryKey(1, isPress));
			}
		}
	}

	public static void actionReload(EntityPlayer player, boolean isPress) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemPrimaryKey) {
				((ItemPrimaryKey)current.getItem()).isReload = isPress;
				((ItemPrimaryKey)current.getItem()).onReload(current, player.worldObj, player, isPress);
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
		}
	}

	public static void actionChargeClient(EntityPlayer player, boolean isPress) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemPrimaryKey) {
				((ItemPrimaryKey)current.getItem()).onChargeClient(current, player.worldObj, player, isPress);
				Core.network.sendToServer(new MessagePrimaryKey(2, isPress));
			}
		}
	}

	public static void actionCharge(EntityPlayer player, boolean isPress) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemPrimaryKey) {
				((ItemPrimaryKey)current.getItem()).isCharge = isPress;
				((ItemPrimaryKey)current.getItem()).onCharge(current, player.worldObj, player, isPress);
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
		}
	}

	public static void actionModeClient(EntityPlayer player, boolean isPress) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemPrimaryKey) {
				((ItemPrimaryKey)current.getItem()).onModeClient(current, player.worldObj, player, isPress);
				Core.network.sendToServer(new MessagePrimaryKey(3, isPress));
			}
		}
	}

	public static void actionMode(EntityPlayer player, boolean isPress) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemPrimaryKey) {
				((ItemPrimaryKey)current.getItem()).isMode = isPress;
				((ItemPrimaryKey)current.getItem()).onMode(current, player.worldObj, player, isPress);
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
		}
	}

	public static void actionActionClient(EntityPlayer player, boolean isPress) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemPrimaryKey) {
				((ItemPrimaryKey)current.getItem()).onActionClient(current, player.worldObj, player, isPress);
				Core.network.sendToServer(new MessagePrimaryKey(4, isPress));
			}
		}
	}

	public static void actionAction(EntityPlayer player, boolean isPress) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemPrimaryKey) {
				((ItemPrimaryKey)current.getItem()).isAction = isPress;
				((ItemPrimaryKey)current.getItem()).onAction(current, player.worldObj, player, isPress);
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
		}
	}

	public static void actionModeInClient(EntityPlayer player, boolean isPress) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemPrimaryKey) {
				((ItemPrimaryKey)current.getItem()).onModeInClient(current, player.worldObj, player, isPress);
				Core.network.sendToServer(new MessagePrimaryKey(5, isPress));
			}
		}
	}

	public static void actionModeIn(EntityPlayer player, boolean isPress) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemPrimaryKey) {
				((ItemPrimaryKey)current.getItem()).isModeIn = isPress;
				((ItemPrimaryKey)current.getItem()).onModeIn(current, player.worldObj, player, isPress);
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
		}
	}

	public static void actionModeOutClient(EntityPlayer player, boolean isPress) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemPrimaryKey) {
				((ItemPrimaryKey)current.getItem()).onModeOutClient(current, player.worldObj, player, isPress);
				Core.network.sendToServer(new MessagePrimaryKey(6, isPress));
			}
		}
	}

	public static void actionModeOut(EntityPlayer player, boolean isPress) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemPrimaryKey) {
				((ItemPrimaryKey)current.getItem()).isModeOut = isPress;
				((ItemPrimaryKey)current.getItem()).onModeOut(current, player.worldObj, player, isPress);
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
}
