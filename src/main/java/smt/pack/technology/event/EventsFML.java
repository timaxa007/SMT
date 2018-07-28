package smt.pack.technology.event;

import smt.pack.technology.registry.TelephoneCommunications;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;


public class EventsFML {
	/*
	@SubscribeEvent
	public void tickEventPlayer(TickEvent.PlayerTickEvent event) {
		if (event.player != null) {
			ItemStack current = event.player.getCurrentEquippedItem();
			if (current != null) {
				if (current.isItemDamaged()) {
					if (current.getMaxDamage() - current.getItemDamage() <= 100) {
						if (event.player.getActivePotionEffect(Potion.confusion) == null) {
							event.player.addPotionEffect(new PotionEffect(Potion.confusion.id, 20));
						}
					}
				}
			}
		}
	}
	 */
	/*
	@SubscribeEvent
	public void tickEventPlayerArmor(TickEvent.PlayerTickEvent event) {
		if (event.player != null) {
			ItemStack helmet = event.player.getCurrentArmor(3);
			ItemStack vest = event.player.getCurrentArmor(2);
			ItemStack pants = event.player.getCurrentArmor(1);
			ItemStack boot = event.player.getCurrentArmor(0);
		}
	}
	 */
	@SubscribeEvent
	public void tickWorld(TickEvent.WorldTickEvent event) {
		if (event.phase == TickEvent.Phase.END && !event.world.isRemote) {
			TelephoneCommunications data = TelephoneCommunications.INSTANCE;
			if (data != null) data.update(event.world);
		}
	}

}
