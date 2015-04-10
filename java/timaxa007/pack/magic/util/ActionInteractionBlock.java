package timaxa007.pack.magic.util;

import timaxa007.pack.magic.item.ItemStuffs;
import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class ActionInteractionBlock {

	public static void actBlock1(EntityPlayer player, int x, int y, int z) {
		ItemStack current = player.getCurrentEquippedItem();
		Block block = player.worldObj.getBlock(x, y, z);
		if (current != null) {
			if (current.getItem() instanceof ItemStuffs) {
				((ItemStuffs)current.getItem()).actBlock1(current, player.worldObj, player, block, x, y, z);
			}
		}
	}

}
