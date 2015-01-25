package mods.timaxa007.pack.item.event;

import mods.timaxa007.pack.item.item.ToolShield;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.EntityDamageSource;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventPackItems {
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onShieldsBlock(LivingHurtEvent e) {
		if (e.source instanceof EntityDamageSource) {
			EntityDamageSource dmgSource = (EntityDamageSource)e.source;
			Entity from = dmgSource.getEntity();//Кто наносит урон,
			EntityLivingBase to = e.entityLiving;//Кому наноситься урон,

			if (from instanceof EntityPlayer && to instanceof EntityPlayer) {
				//Если кто наносит урон являеться игрок и кому наноситься урон являеться игрок, то...

				EntityPlayer player_from = (EntityPlayer)from;
				ItemStack current_from = player_from.getCurrentEquippedItem();//Что дерижит кто наносит урон

				EntityPlayer player_to = (EntityPlayer)to;
				ItemStack current_to = player_to.getCurrentEquippedItem();//Что дерижит кому наносится урон

				if (current_to != null && current_to.getItem() instanceof ToolShield && player_to.getItemInUseDuration() > 0) {
					//Если рука кому наноситься урон, непуста и находиться щит и приэтом типа ПКМ
					e.ammount = 0;//Урона нуль
					if (current_from != null && current_from.getItem() instanceof ItemSword) {
						//Если рука кто наносит урон не пуста, и имеет в руке меч
						current_from.damageItem(((ToolShield)current_from.getItem()).getDamage(), player_from);
						//то предмет который в руке будет поврежаться.
					}

				}

			}

		}
	}
	//--------------------------------------------------------------------------------------------------------------
}
