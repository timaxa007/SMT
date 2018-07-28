package smt.pack.weapon.event;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import smt.pack.weapon.SMTWeapon;
import smt.pack.weapon.registry.WeaponSystem;

public class EventsForge {

	@SubscribeEvent
	public void addEntityConstructing(EntityEvent.EntityConstructing event) {
		if (event.entity instanceof EntityPlayer) {
			if (SMTWeapon.proxy.wpn_sys.get((EntityPlayer)event.entity) == null)
				SMTWeapon.proxy.wpn_sys.reg((EntityPlayer)event.entity);
		}
	}

	@SubscribeEvent
	public void onLivingEvent(LivingEvent.LivingUpdateEvent event) {
		if (event.entity instanceof EntityPlayer) {
			WeaponSystem pi = SMTWeapon.proxy.wpn_sys.get((EntityPlayer)event.entityLiving);
			if (pi != null) pi.onUpdate();
		}
	}

}
