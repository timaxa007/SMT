package timaxa007.pack.item.util;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ActionInteractionBlock {

	public static void interactionWichEntityBlock(EntityPlayer player, int x, int y, int z) {
		ItemStack current = player.getCurrentEquippedItem();
		Block block = player.worldObj.getBlock(x, y, z);
		if (current != null) {
			if (current.getItem() instanceof IToolCraft) {
				((IToolCraft)current.getItem()).interactionWichEntityBlock(current, player.worldObj, player, block, x, y, z);
			}
		}
	}

}
