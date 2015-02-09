package mods.timaxa007.lib;

import mods.timaxa007.tms.util.ModifiedBlock;
import mods.timaxa007.tms.util.ModifiedItem;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;

/**WIP**/
public class SystemWeight {

	public static float getPlayerMaxWeight(EntityPlayer player) {
		//if (player instanceof PlayerWeight) ((PlayerWeight)player).getMaxWeight();
		return 0.0F;
	}

	public static float getEntityMaxWeight(EntityLivingBase entity) {
		//if (entity instanceof EntityWeight) ((EntityWeight)entity).getMaxWeight();
		return 0.0F;
	}

	public static float getWeight(Block block) {
		if (block instanceof ModifiedBlock)
			((ModifiedBlock)block).getWeight();
		return 0.0F;
	}

	public static float getWeight(Item item) {
		if (item instanceof ModifiedItem)
			((ModifiedItem)item).getWeight();
		return 0.0F;
	}

}
