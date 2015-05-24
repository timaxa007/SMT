package timaxa007.smt.util;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import timaxa007.api.IInteractionWithBlock;

public class ActionInteractionBlock {

	public static void actBlock1(EntityPlayer player, int x, int y, int z) {
		ItemStack current = player.getCurrentEquippedItem();
		Block block = player.worldObj.getBlock(x, y, z);
		if (current != null && current.getItem() instanceof IInteractionWithBlock)
			((IInteractionWithBlock)current.getItem()).interactionWithBlock(current, player.worldObj, player, block, x, y, z);

	}

}
