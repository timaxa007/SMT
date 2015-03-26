package timaxa007.module.control_button.event;

import timaxa007.module.control_button.util.ActionArmorKey;
import timaxa007.module.control_button.util.RegKey;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.relauncher.Side;

public class EventActionArmorKey {
	//--------------------------------------------------------------------------------------------------------------
	boolean 
	k_helmet, k_helmet_last, 
	k_chest, k_chest_last, 
	k_leggin, k_leggin_last, 
	k_boot, k_boot_last
	= false;

	int 
	tick_helmet, 
	tick_chest, 
	tick_leggin, 
	tick_boot 
	= 0;
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void actionHelmet(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.START && event.side == Side.CLIENT) {
			if (RegKey.action_helmet.getIsKeyPressed()) {
				ActionArmorKey.actionHelmetTickClient(event.player, tick_helmet);
				tick_helmet += 1;
				k_helmet = true;
				if (!k_helmet_last && k_helmet) ActionArmorKey.actionHelmetClient(event.player, true);//press down
				k_helmet_last = k_helmet;
			} else {
				tick_helmet = 0;
				k_helmet = false;
				if (k_helmet_last && !k_helmet) ActionArmorKey.actionHelmetClient(event.player, false);//unpress down
				k_helmet_last = k_helmet;
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void actionChest(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.START && event.side == Side.CLIENT) {
			if (RegKey.action_chest.getIsKeyPressed()) {
				ActionArmorKey.actionChestplateTickClient(event.player, tick_chest);
				tick_chest += 1;
				k_chest = true;
				if (!k_chest_last && k_chest) ActionArmorKey.actionChestplateClient(event.player, true);//press down
				k_chest_last = k_chest;
			} else {
				tick_chest = 0;
				k_chest = false;
				if (k_chest_last && !k_chest) ActionArmorKey.actionChestplateClient(event.player, false);//unpress down
				k_chest_last = k_chest;
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void actionLeggin(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.START && event.side == Side.CLIENT) {
			if (RegKey.action_leggin.getIsKeyPressed()) {
				ActionArmorKey.actionLeggingsTickClient(event.player, tick_leggin);
				tick_leggin += 1;
				k_leggin = true;
				if (!k_leggin_last && k_leggin) ActionArmorKey.actionLeggingsClient(event.player, true);//press down
				k_leggin_last = k_leggin;
			} else {
				tick_leggin = 0;
				k_leggin = false;
				if (k_leggin_last && !k_leggin) ActionArmorKey.actionLeggingsClient(event.player, false);//unpress down
				k_leggin_last = k_leggin;
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void actionBoot(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.START && event.side == Side.CLIENT) {
			if (RegKey.action_boot.getIsKeyPressed()) {
				ActionArmorKey.actionBootsTickClient(event.player, tick_boot);
				tick_boot += 1;
				k_boot = true;
				if (!k_boot_last && k_boot) ActionArmorKey.actionBootsClient(event.player, true);//press down
				k_boot_last = k_boot;
			} else {
				tick_boot = 0;
				k_boot = false;
				if (k_boot_last && !k_boot) ActionArmorKey.actionBootsClient(event.player, false);//unpress down
				k_boot_last = k_boot;
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
}
