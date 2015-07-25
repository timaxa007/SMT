package timaxa007.module.weight.util;

import timaxa007.smt.util.UtilSMT;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;

public class ActionWeight {

	public static void setWeight(EntityPlayer player, float weight_max) {
		if (player == null) player = UtilSMT.getPlayerClient();
		if (player != null) {
			//PlayerWeight.get(player).setWeight(weight);
			PlayerWeight.get(player).setWeightMax(weight_max);
		}
	}

}
