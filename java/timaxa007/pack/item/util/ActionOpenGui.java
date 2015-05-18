package timaxa007.pack.item.util;

import net.minecraft.entity.player.EntityPlayer;
import timaxa007.smt.CoreSMT;

public class ActionOpenGui {
	//----------------------------------------------------------------------------------------
	public static void openGui(EntityPlayer player, int num) {
		player.openGui(CoreSMT.instance, num, player.worldObj, (int)player.posX, (int)player.posY, (int)player.posZ);
	}
	//----------------------------------------------------------------------------------------
}
