package timaxa007.pack.magic.util;

import timaxa007.pack.magic.item.ItemStuffs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ActionPuff {

	public static void puff1(EntityPlayer player, double cord_x, double cord_y, double cord_z) {
		World world = player.worldObj;
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemStuffs) {
				((ItemStuffs)current.getItem()).puff1(player.worldObj, cord_x, cord_y, cord_z);
			}
		}
	}

}
