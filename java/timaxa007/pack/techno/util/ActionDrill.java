package timaxa007.pack.techno.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import timaxa007.pack.techno.item.ToolElectricDrills;

public class ActionDrill {

	public static void mode(EntityPlayer player) {
		ItemStack current = player.getCurrentEquippedItem();
		if (current != null) {
			if (current.getItem() instanceof ToolElectricDrills) {
				((ToolElectricDrills)current.getItem()).mode(current, player.worldObj, player);
			}
		}
	}

}
