package mods.timaxa007.pack.weapon.event;

import mods.timaxa007.pack.weapon.items.ItemWeapons;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;

import org.lwjgl.input.Mouse;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventPackWeapon {
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onFire(LivingUpdateEvent p) {
		if (Mouse.isButtonDown(0)) {
			ItemStack actHBI = ((EntityPlayer)p.entityLiving).getCurrentEquippedItem();
			if (actHBI != null && actHBI.getItem() instanceof ItemWeapons) {
				//System.out.println("onFire");
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onScope(LivingUpdateEvent p) {
		if (Mouse.isButtonDown(1)) {
			ItemStack actHBI = ((EntityPlayer)p.entityLiving).getCurrentEquippedItem();
			if (actHBI != null && actHBI.getItem() instanceof ItemWeapons) {
				//System.out.println("onScope");
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
}
