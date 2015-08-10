package timaxa007.smt.event;

import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import cpw.mods.fml.relauncher.Side;

public class EventSMT2 {
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void actiCon(TickEvent.PlayerTickEvent e) {
		if (e.phase == Phase.START && e.side == Side.SERVER) {
			EntityPlayer player = e.player;

			if (player != null) {
			}

		}
	}
	//--------------------------------------------------------------------------------------------------------------
}
