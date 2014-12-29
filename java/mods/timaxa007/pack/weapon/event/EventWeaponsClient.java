package mods.timaxa007.pack.weapon.event;

import mods.timaxa007.pack.weapon.gui.WeaponsIngameGUI;
import net.minecraft.client.Minecraft;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventWeaponsClient {
	//--------------------------------------------------------------------------------------------------------------
	Minecraft mc = Minecraft.getMinecraft();
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void statusBullet(LivingUpdateEvent p) {
		if ((mc.ingameGUI != null) && (!(mc.ingameGUI instanceof WeaponsIngameGUI))) {
			mc.ingameGUI = new WeaponsIngameGUI(mc);
		}
	}
	//--------------------------------------------------------------------------------------------------------------
}
