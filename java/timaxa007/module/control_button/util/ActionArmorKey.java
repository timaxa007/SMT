package timaxa007.module.control_button.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import timaxa007.module.control_button.api.IActionArmor;

public class ActionArmorKey {
	//--------------------------------------------------------------------------------------------------------------
	public static void actionHelmetTickClient(EntityPlayer player, int tick_helmet) {
		ItemStack current = player.getCurrentArmor(3);
		if (current != null && current.getItem() instanceof IActionArmor)
			((IActionArmor)current.getItem()).onHelmetTickClient(current, player.worldObj, player, tick_helmet);
	}

	public static void actionHelmetClient(EntityPlayer player, boolean buttonstate) {
		ItemStack current = player.getCurrentArmor(3);
		if (current != null && current.getItem() instanceof IActionArmor)
			((IActionArmor)current.getItem()).onHelmetClient(current, player.worldObj, player, buttonstate);
	}
	//--------------------------------------------------------------------------------------------------------------
	public static void actionChestplateTickClient(EntityPlayer player, int tick_chest) {
		ItemStack current = player.getCurrentArmor(2);
		if (current != null && current.getItem() instanceof IActionArmor)
			((IActionArmor)current.getItem()).onChestplateTickClient(current, player.worldObj, player, tick_chest);
	}

	public static void actionChestplateClient(EntityPlayer player, boolean buttonstate) {
		ItemStack current = player.getCurrentArmor(2);
		if (current != null && current.getItem() instanceof IActionArmor)
			((IActionArmor)current.getItem()).onChestplateClient(current, player.worldObj, player, buttonstate);
	}
	//--------------------------------------------------------------------------------------------------------------
	public static void actionLeggingsTickClient(EntityPlayer player, int tick_leggin) {
		ItemStack current = player.getCurrentArmor(1);
		if (current != null && current.getItem() instanceof IActionArmor)
			((IActionArmor)current.getItem()).onLeggingsTickClient(current, player.worldObj, player, tick_leggin);
	}

	public static void actionLeggingsClient(EntityPlayer player, boolean buttonstate) {
		ItemStack current = player.getCurrentArmor(1);
		if (current != null && current.getItem() instanceof IActionArmor)
			((IActionArmor)current.getItem()).onLeggingsClient(current, player.worldObj, player, buttonstate);
	}
	//--------------------------------------------------------------------------------------------------------------
	public static void actionBootsTickClient(EntityPlayer player, int tick_boot) {
		ItemStack current = player.getCurrentArmor(0);
		if (current != null && current.getItem() instanceof IActionArmor)
			((IActionArmor)current.getItem()).onBootsTickClient(current, player.worldObj, player, tick_boot);
	}

	public static void actionBootsClient(EntityPlayer player, boolean buttonstate) {
		ItemStack current = player.getCurrentArmor(0);
		if (current != null && current.getItem() instanceof IActionArmor)
			((IActionArmor)current.getItem()).onBootsClient(current, player.worldObj, player, buttonstate);
	}
	//--------------------------------------------------------------------------------------------------------------
}
