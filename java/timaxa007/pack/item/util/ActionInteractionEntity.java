package timaxa007.pack.item.util;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ActionInteractionEntity {

	public static void interactionWichEntity(EntityPlayer player, Entity entity) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof IToolCraft) {
				((IToolCraft)current.getItem()).interactionWichEntity(current, player.worldObj, player, entity);
			}
		}
	}

}
