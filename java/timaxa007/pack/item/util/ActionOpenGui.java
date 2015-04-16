package timaxa007.pack.item.util;

import net.minecraft.entity.player.EntityPlayer;
import timaxa007.tms.CoreTMS;

public class ActionOpenGui {
	//----------------------------------------------------------------------------------------
	public static void openGui(EntityPlayer player, int num) {
		player.openGui(CoreTMS.instance, num, player.worldObj, (int)player.posX, (int)player.posY, (int)player.posZ);
	}
	//----------------------------------------------------------------------------------------
}
