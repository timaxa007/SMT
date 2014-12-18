package mods.timaxa007.pack.magic;

import mods.timaxa007.pack.furniture.PackFurniture;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EntityDamageSource;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventMagic {
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onEntityUpdate(LivingUpdateEvent e) {
		ItemStack helmet = ((EntityPlayer)e.entityLiving).getCurrentArmor(0);
		ItemStack chestplate = ((EntityPlayer)e.entityLiving).getCurrentArmor(1);
		ItemStack leggings = ((EntityPlayer)e.entityLiving).getCurrentArmor(2);
		ItemStack boots = ((EntityPlayer)e.entityLiving).getCurrentArmor(3);
		ItemStack actHBI = ((EntityPlayer)e.entityLiving).getCurrentEquippedItem();//active HotBar Item
		ItemStack helmetI;
		ItemStack chestplateI;
		ItemStack leggingsI;
		ItemStack bootsI;
		if (helmet != null && chestplate != null && leggings != null && boots != null) {
			//--------------------------------------------------------------
			/*
			helmetI=new ItemStack(Item.bootsIron);
			chestplateI=new ItemStack(Item.legsIron);
			leggingsI=new ItemStack(Item.plateIron);
			bootsI=new ItemStack(Item.helmetIron);
			if ((boots.getItem()==helmetI.getItem())&&(leggings.getItem()==chestplateI.getItem())&&(chestplate.getItem()==leggingsI.getItem())&&(helmet.getItem()==bootsI.getItem())) {
				float health=e.entityLiving.getHealth();
				float baseRegen=0.2F;
				float regenStreght=3;
				float willRegen=baseRegen*regenStreght;
				e.entityLiving.setHealth(health+willRegen);
			}
			 */
			//--------------------------------------------------------------

			helmetI = new ItemStack(PackFurniture.proxy.armor_new_helmet);
			chestplateI = new ItemStack(PackFurniture.proxy.armor_new_chest);
			leggingsI = new ItemStack(PackFurniture.proxy.armor_new_leggin);
			bootsI = new ItemStack(PackFurniture.proxy.armor_new_boot);
			if (boots.getItem() == helmetI.getItem() && leggings.getItem() == chestplateI.getItem() && chestplate.getItem() == leggingsI.getItem() && helmet.getItem() == bootsI.getItem()) {

				if (e.entityLiving.isSneaking()) {

				}

				if (e.entityLiving.isAirBorne) {

				}

				if (e.entityLiving.isSprinting()) {
					e.entityLiving.addPotionEffect(new PotionEffect(Potion.moveSpeed.id, 20 * 1, 3));
				}

				if (e.entityLiving.isEating()) {
					e.entityLiving.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 20 * 1, 3));
				}

				e.entityLiving.fallDistance = e.entityLiving.fallDistance-0.1F;
			}

			//--------------------------------------------------------------

		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onHitEntity(LivingHurtEvent e) {
		if (e.source instanceof EntityDamageSource) {

			EntityDamageSource dmgSource = (EntityDamageSource)e.source;
			Entity ent = dmgSource.getEntity();
			if (ent instanceof EntityPlayer) {
				/*
				Random ran = new Random();
				int ran1 = ran.nextInt(100);*/
				EntityPlayer player = (EntityPlayer) ent;
				ItemStack weapon = player.getCurrentEquippedItem();

				if (weapon != null) {
					if (weapon.getItem() == Items.golden_sword) {
						//e.ammount=100;
					}

				}
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
}
