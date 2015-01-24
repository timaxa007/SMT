package mods.timaxa007.tms.util;

import mods.timaxa007.tms.Core;
import mods.timaxa007.tms.packet.MessageArmorKey;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ActionArmorKey {
	//--------------------------------------------------------------------------------------------------------------
	public static void actionHelmetTickClient(EntityPlayer player) {
		ItemStack current = player.getCurrentArmor(3);
		if (current != null) {
			if (current.getItem() instanceof ItemArmorAction) {
				((ItemArmorAction)current.getItem()).onHelmetTickClient(current, player.worldObj, player);
				//Core.network.sendToServer(new MessageArmorKey(-1, true));
			}
		}
	}

	public static void actionHelmetClient(EntityPlayer player, boolean buttonstate) {
		ItemStack current = player.getCurrentArmor(3);
		if (current != null) {
			if (current.getItem() instanceof ItemArmorAction) {
				((ItemArmorAction)current.getItem()).isHelmet = buttonstate;
				if (((ItemArmorAction)current.getItem()).onHelmetClient(current, player.worldObj, player, buttonstate))
					Core.network.sendToServer(new MessageArmorKey(1, buttonstate));
			}
		}
	}

	public static void actionHelmet(EntityPlayer player, boolean buttonstate) {
		ItemStack current = player.getCurrentArmor(3);
		if (current != null) {
			if (current.getItem() instanceof ItemArmorAction) {
				((ItemArmorAction)current.getItem()).onHelmet(current, player.worldObj, player, buttonstate);
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	public static void actionChestplateTickClient(EntityPlayer player) {
		ItemStack current = player.getCurrentArmor(2);
		if (current != null) {
			if (current.getItem() instanceof ItemArmorAction) {
				((ItemArmorAction)current.getItem()).onChestplateTickClient(current, player.worldObj, player);
				//Core.network.sendToServer(new MessageArmorKey(-2, true));
			}
		}
	}

	public static void actionChestplateClient(EntityPlayer player, boolean buttonstate) {
		ItemStack current = player.getCurrentArmor(2);
		if (current != null) {
			if (current.getItem() instanceof ItemArmorAction) {
				((ItemArmorAction)current.getItem()).isChestplate = buttonstate;
				if (((ItemArmorAction)current.getItem()).onChestplateClient(current, player.worldObj, player, buttonstate))
					Core.network.sendToServer(new MessageArmorKey(2, buttonstate));
			}
		}
	}

	public static void actionChestplate(EntityPlayer player, boolean buttonstate) {
		ItemStack current = player.getCurrentArmor(2);
		if (current != null) {
			if (current.getItem() instanceof ItemArmorAction) {
				((ItemArmorAction)current.getItem()).onChestplate(current, player.worldObj, player, buttonstate);
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	public static void actionLeggingsTickClient(EntityPlayer player) {
		ItemStack current = player.getCurrentArmor(1);
		if (current != null) {
			if (current.getItem() instanceof ItemArmorAction) {
				((ItemArmorAction)current.getItem()).onLeggingsTickClient(current, player.worldObj, player);
				//Core.network.sendToServer(new MessageArmorKey(-3, true));
			}
		}
	}

	public static void actionLeggingsClient(EntityPlayer player, boolean buttonstate) {
		ItemStack current = player.getCurrentArmor(1);
		if (current != null) {
			if (current.getItem() instanceof ItemArmorAction) {
				((ItemArmorAction)current.getItem()).isLeggings = buttonstate;
				if (((ItemArmorAction)current.getItem()).onLeggingsClient(current, player.worldObj, player, buttonstate))
					Core.network.sendToServer(new MessageArmorKey(3, buttonstate));
			}
		}
	}

	public static void actionLeggings(EntityPlayer player, boolean buttonstate) {
		ItemStack current = player.getCurrentArmor(1);
		if (current != null) {
			if (current.getItem() instanceof ItemArmorAction) {
				((ItemArmorAction)current.getItem()).onLeggings(current, player.worldObj, player, buttonstate);
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	public static void actionBootsTickClient(EntityPlayer player) {
		ItemStack current = player.getCurrentArmor(0);
		if (current != null) {
			if (current.getItem() instanceof ItemArmorAction) {
				((ItemArmorAction)current.getItem()).onBootsTickClient(current, player.worldObj, player);
				//Core.network.sendToServer(new MessageArmorKey(-4, true));
			}
		}
	}

	public static void actionBootsClient(EntityPlayer player, boolean buttonstate) {
		ItemStack current = player.getCurrentArmor(0);
		if (current != null) {
			if (current.getItem() instanceof ItemArmorAction) {
				((ItemArmorAction)current.getItem()).isBoots = buttonstate;
				if (((ItemArmorAction)current.getItem()).onBootsClient(current, player.worldObj, player, buttonstate))
					Core.network.sendToServer(new MessageArmorKey(4, buttonstate));
			}
		}
	}

	public static void actionBoots(EntityPlayer player, boolean buttonstate) {
		ItemStack current = player.getCurrentArmor(0);
		if (current != null) {
			if (current.getItem() instanceof ItemArmorAction) {
				((ItemArmorAction)current.getItem()).onBoots(current, player.worldObj, player, buttonstate);
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
}
