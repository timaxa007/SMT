package mods.timaxa007.tms.util;

import mods.timaxa007.tms.Core;
import mods.timaxa007.tms.packet.MessagePrimaryKey;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ActionPrimaryKey {
	//--------------------------------------------------------------------------------------------------------------
	public static void onReloadTickClient(EntityPlayer player) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemPrimaryKey) {
				((ItemPrimaryKey)current.getItem()).onReloadTickClient(current, player.worldObj, player);
				if (((ItemPrimaryKey)current.getItem()).onReloadTickClient(current, player.worldObj, player)) {
					Core.network.sendToServer(new MessagePrimaryKey(-1, true));
				}
			}
		}
	}

	public static void onReloadClient(EntityPlayer player, boolean isPress) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemPrimaryKey) {
				((ItemPrimaryKey)current.getItem()).onReloadClient(current, player.worldObj, player, isPress);
				((ItemPrimaryKey)current.getItem()).isReload = isPress;
				if (((ItemPrimaryKey)current.getItem()).onReloadClient(current, player.worldObj, player, isPress)) {
					Core.network.sendToServer(new MessagePrimaryKey(1, isPress));
				}
			}
		}
	}

	public static void onReloadTick(EntityPlayer player) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemPrimaryKey) {
				((ItemPrimaryKey)current.getItem()).onReloadTick(current, player.worldObj, player);
			}
		}
	}

	public static void onReload(EntityPlayer player, boolean isPress) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemPrimaryKey) {
				((ItemPrimaryKey)current.getItem()).onReload(current, player.worldObj, player, isPress);
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	public static void onChargeTickClient(EntityPlayer player) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemPrimaryKey) {
				((ItemPrimaryKey)current.getItem()).onChargeTickClient(current, player.worldObj, player);
				if (((ItemPrimaryKey)current.getItem()).onChargeTickClient(current, player.worldObj, player)) {
					Core.network.sendToServer(new MessagePrimaryKey(-2, true));
				}
			}
		}
	}

	public static void onChargeClient(EntityPlayer player, boolean isPress) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemPrimaryKey) {
				((ItemPrimaryKey)current.getItem()).onChargeClient(current, player.worldObj, player, isPress);
				((ItemPrimaryKey)current.getItem()).isCharge = isPress;
				if (((ItemPrimaryKey)current.getItem()).onChargeClient(current, player.worldObj, player, isPress)) {
					Core.network.sendToServer(new MessagePrimaryKey(2, isPress));
				}
			}
		}
	}

	public static void onChargeTick(EntityPlayer player) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemPrimaryKey) {
				((ItemPrimaryKey)current.getItem()).onChargeTick(current, player.worldObj, player);
			}
		}
	}

	public static void onCharge(EntityPlayer player, boolean isPress) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemPrimaryKey) {
				((ItemPrimaryKey)current.getItem()).onCharge(current, player.worldObj, player, isPress);
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	public static void onModeTickClient(EntityPlayer player) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemPrimaryKey) {
				((ItemPrimaryKey)current.getItem()).onModeTickClient(current, player.worldObj, player);
				if (((ItemPrimaryKey)current.getItem()).onModeTickClient(current, player.worldObj, player)) {
					Core.network.sendToServer(new MessagePrimaryKey(-3, true));
				}
			}
		}
	}

	public static void onModeClient(EntityPlayer player, boolean isPress) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemPrimaryKey) {
				((ItemPrimaryKey)current.getItem()).onModeClient(current, player.worldObj, player, isPress);
				((ItemPrimaryKey)current.getItem()).isMode = isPress;
				if (((ItemPrimaryKey)current.getItem()).onModeClient(current, player.worldObj, player, isPress)) {
					Core.network.sendToServer(new MessagePrimaryKey(3, isPress));
				}
			}
		}
	}

	public static void onModeTick(EntityPlayer player) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemPrimaryKey) {
				((ItemPrimaryKey)current.getItem()).onModeTick(current, player.worldObj, player);
			}
		}
	}

	public static void onMode(EntityPlayer player, boolean isPress) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemPrimaryKey) {
				((ItemPrimaryKey)current.getItem()).onMode(current, player.worldObj, player, isPress);
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	public static void onActionTickClient(EntityPlayer player) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemPrimaryKey) {
				((ItemPrimaryKey)current.getItem()).onActionTickClient(current, player.worldObj, player);
				if (((ItemPrimaryKey)current.getItem()).onActionTickClient(current, player.worldObj, player)) {
					Core.network.sendToServer(new MessagePrimaryKey(-4, true));
				}
			}
		}
	}

	public static void onActionClient(EntityPlayer player, boolean isPress) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemPrimaryKey) {
				((ItemPrimaryKey)current.getItem()).onActionClient(current, player.worldObj, player, isPress);
				((ItemPrimaryKey)current.getItem()).isAction = isPress;
				if (((ItemPrimaryKey)current.getItem()).onActionClient(current, player.worldObj, player, isPress)) {
					Core.network.sendToServer(new MessagePrimaryKey(4, isPress));
				}
			}
		}
	}

	public static void onActionTick(EntityPlayer player) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemPrimaryKey) {
				((ItemPrimaryKey)current.getItem()).onActionTick(current, player.worldObj, player);
			}
		}
	}

	public static void onAction(EntityPlayer player, boolean isPress) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemPrimaryKey) {
				((ItemPrimaryKey)current.getItem()).onAction(current, player.worldObj, player, isPress);
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	public static void onModeInTickClient(EntityPlayer player) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemPrimaryKey) {
				((ItemPrimaryKey)current.getItem()).onModeInTickClient(current, player.worldObj, player);
				if (((ItemPrimaryKey)current.getItem()).onModeInTickClient(current, player.worldObj, player)) {
					Core.network.sendToServer(new MessagePrimaryKey(-5, true));
				}
			}
		}
	}

	public static void onModeInClient(EntityPlayer player, boolean isPress) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemPrimaryKey) {
				((ItemPrimaryKey)current.getItem()).onModeInClient(current, player.worldObj, player, isPress);
				((ItemPrimaryKey)current.getItem()).isModeIn = isPress;
				if (((ItemPrimaryKey)current.getItem()).onModeInClient(current, player.worldObj, player, isPress)) {
					Core.network.sendToServer(new MessagePrimaryKey(5, isPress));
				}
			}
		}
	}

	public static void onModeInTick(EntityPlayer player) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemPrimaryKey) {
				((ItemPrimaryKey)current.getItem()).onModeInTick(current, player.worldObj, player);
			}
		}
	}

	public static void onModeIn(EntityPlayer player, boolean isPress) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemPrimaryKey) {
				((ItemPrimaryKey)current.getItem()).onModeIn(current, player.worldObj, player, isPress);
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	public static void onModeOutTickClient(EntityPlayer player) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemPrimaryKey) {
				((ItemPrimaryKey)current.getItem()).onModeOutTickClient(current, player.worldObj, player);
				if (((ItemPrimaryKey)current.getItem()).onModeOutTickClient(current, player.worldObj, player)) {
					Core.network.sendToServer(new MessagePrimaryKey(-6, true));
				}
			}
		}
	}

	public static void onModeOutClient(EntityPlayer player, boolean isPress) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemPrimaryKey) {
				((ItemPrimaryKey)current.getItem()).onModeOutClient(current, player.worldObj, player, isPress);
				((ItemPrimaryKey)current.getItem()).isModeOut = isPress;
				if (((ItemPrimaryKey)current.getItem()).onModeOutClient(current, player.worldObj, player, isPress)) {
					Core.network.sendToServer(new MessagePrimaryKey(6, isPress));
				}
			}
		}
	}

	public static void onModeOutTick(EntityPlayer player) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemPrimaryKey) {
				((ItemPrimaryKey)current.getItem()).onModeOutTick(current, player.worldObj, player);
			}
		}
	}

	public static void onModeOut(EntityPlayer player, boolean isPress) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemPrimaryKey) {
				((ItemPrimaryKey)current.getItem()).onModeOut(current, player.worldObj, player, isPress);
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
}
