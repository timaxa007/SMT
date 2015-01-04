package mods.timaxa007.pack.furniture.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ActionBackpack {

	public static void isGui(EntityPlayer player, boolean open_gui) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null && current.getItem() instanceof IBackpack) {
			if (open_gui) {
				((IBackpack)current.getItem()).openBackpackGui(current);
			} else {
				((IBackpack)current.getItem()).closeBackpackGui(current);
			}
		}
	}

	public static void isGuiTick(EntityPlayer player, boolean open_gui) {

	}

}
