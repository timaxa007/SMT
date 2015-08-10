package timaxa007.module.control_button.event;

import timaxa007.module.control_button.util.ActionMA;
import timaxa007.module.control_button.util.RegKey;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.relauncher.Side;

public class EventActionArmorKey {
	//--------------------------------------------------------------------------------------------------------------
	private static boolean
	k_ma, k_ma_last
	;

	private static int
	tick_ma
	;

	static {
		k_ma = k_ma_last = false;
		tick_ma = 0;
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void actionMA(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.START && event.side == Side.CLIENT) {
			if (RegKey.movement_action.getIsKeyPressed()) {
				ActionMA.actionMA_TickClient(event.player, tick_ma);
				tick_ma += 1;
				k_ma = true;
				if (!k_ma_last && k_ma) ActionMA.actionMA_Client(event.player, true);//press down
				k_ma_last = k_ma;
			} else {
				tick_ma = 0;
				k_ma = false;
				if (k_ma_last && !k_ma) ActionMA.actionMA_Client(event.player, false);//unpress down
				k_ma_last = k_ma;
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
}
