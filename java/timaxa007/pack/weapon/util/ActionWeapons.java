package timaxa007.pack.weapon.util;

import timaxa007.pack.weapon.item.ItemWeapons;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ActionWeapons {

	public static void onFire(EntityPlayer player) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemWeapons) {
				((ItemWeapons)current.getItem()).onFire(current, player.worldObj, player);
			}
		}
	}

}
