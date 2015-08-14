package timaxa007.pack.conjoint.util;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import timaxa007.pack.conjoint.api.IInteractionWithEntity;

public class ActionInteractionEntity {

	public static void act1(EntityPlayer player, Entity entity) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null && current.getItem() instanceof IInteractionWithEntity)
			((IInteractionWithEntity)current.getItem()).interactionWithEntity(current, player.worldObj, player, entity);
		//if (current == null);
	}

}
