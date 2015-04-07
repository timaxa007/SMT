package timaxa007.pack.magic.util;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import timaxa007.pack.magic.item.ItemStuffs;

public class ActionInteractionEntity {

	public static void act1(EntityPlayer player, Entity entity) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemStuffs) {
				((ItemStuffs)current.getItem()).act1(current, player.worldObj, player, entity);
			}
		}
	}

	public static void act2(EntityPlayer player, Entity entity) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ItemStuffs) {
				((ItemStuffs)current.getItem()).act2(current, player.worldObj, player, entity);
			}
		}
	}

}
