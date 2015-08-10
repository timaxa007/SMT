package timaxa007.module.control_button.util;

import net.minecraft.entity.player.EntityPlayer;
import timaxa007.gui.HandlerGuiSMT;
import timaxa007.gui.gui.GuiMA;

public class ActionMA {

	//private static boolean is_open_gui = false;

	public static void actionMA_TickClient(EntityPlayer player, int tick) {

	}

	public static void actionMA_Client(EntityPlayer player, boolean flag) {

		if (flag) {

		} else {
			HandlerGuiSMT.openGui(new GuiMA());
			/*if (!is_open_gui) {
				is_open_gui = true;
			}*/
		}

	}

}
