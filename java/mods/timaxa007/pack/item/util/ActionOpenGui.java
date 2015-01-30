package mods.timaxa007.pack.item.util;

import mods.timaxa007.pack.item.PackItems;
import net.minecraft.entity.player.EntityPlayer;

public class ActionOpenGui {
	//----------------------------------------------------------------------------------------
	public static void openGui(EntityPlayer player, int num) {
		player.openGui(PackItems.instance, num, player.worldObj, (int)player.posX, (int)player.posY, (int)player.posZ);
	}
	//----------------------------------------------------------------------------------------
}
