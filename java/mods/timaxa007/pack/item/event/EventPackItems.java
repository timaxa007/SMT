package mods.timaxa007.pack.item.event;

import mods.timaxa007.pack.item.item.ToolShield;
import mods.timaxa007.pack.item.item.ToolSword;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EntityDamageSource;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventPackItems {
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onShields(LivingHurtEvent e) {
		if (e.source instanceof EntityDamageSource) {
			//EntityDamageSource dmgSource = (EntityDamageSource)e.source;
			Entity to = e.entityLiving;
			//Entity to = e.entity;
			if (to instanceof EntityPlayer) {
				EntityPlayer player = (EntityPlayer)to;
				ItemStack current_to = player.getCurrentEquippedItem();

				if (current_to != null) {
					if (current_to.getItem() instanceof ToolShield && player.getItemInUseDuration() > 0) {
						e.ammount = 0;
						e.setCanceled(true);
					}
				}

			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onSword(LivingHurtEvent e) {
		if (e.source instanceof EntityDamageSource) {
			EntityDamageSource dmgSource = (EntityDamageSource)e.source;
			Entity from = dmgSource.getEntity();
			//Entity to = e.entityLiving;
			//Entity to = e.entity;
			if (from instanceof EntityPlayer) {
				EntityPlayer player = (EntityPlayer)from;
				ItemStack current_from = player.getCurrentEquippedItem();

				if (current_from != null) {
					if (current_from.getItem() instanceof ToolSword && player.getItemInUseDuration() > 0) {
						current_from.damageItem(100, player);
						e.ammount = 100;
						e.setCanceled(true);
					}
				}

			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
}
