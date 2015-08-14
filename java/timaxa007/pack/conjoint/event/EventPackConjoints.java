package timaxa007.pack.conjoint.event;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EntityDamageSource;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import timaxa007.pack.conjoint.item.ToolShield;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventPackConjoints {
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onShieldsBlock(LivingHurtEvent e) {
		if (e.source instanceof EntityDamageSource) {
			EntityDamageSource dmgSource = (EntityDamageSource)e.source;
			Entity from = dmgSource.getEntity();//Кто наносит урон,
			EntityLivingBase to = e.entityLiving;//Кому наноситься урон,

			if (from instanceof EntityLivingBase && to instanceof EntityPlayer) {
				//Если кто наносит урон являеться игрок и кому наноситься урон являеться игрок, то...

				EntityLivingBase entity_from = (EntityLivingBase)from;
				ItemStack current_from = entity_from.getEquipmentInSlot(0);//Что дерижит кто наносит урон

				EntityPlayer player_to = (EntityPlayer)to;
				ItemStack current_to = player_to.getCurrentEquippedItem();//Что дерижит кому наносится урон

				if (current_to != null && current_to.getItem() instanceof ToolShield && player_to.isUsingItem()) {
					//Если рука кому наноситься урон, непуста и находиться щит и приэтом типа ПКМ
					e.ammount = 0;//Урона нуль
					if (current_from != null && current_from.getItem() instanceof ItemSword) {
						//Если рука кто наносит урон не пуста, и имеет в руке меч
						current_from.damageItem(((ToolShield)current_to.getItem()).getDamage()*100, entity_from);
						//то предмет который в руке будет поврежаться.
					}

				}

			}

		}
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void actionArmor(LivingHurtEvent e) {
		EntityLivingBase to = e.entityLiving;//Кому наноситься урон,

		if (to instanceof EntityPlayer) {

			EntityPlayer player_to = (EntityPlayer)to;
			ItemStack current_to = player_to.getCurrentEquippedItem();//Что дерижит кому наносится урон
			ItemStack helm_to = player_to.getCurrentArmor(3);//Что в слоте шлема кому наносится урон
			ItemStack chest_to = player_to.getCurrentArmor(2);//Что в слоте нагрудника кому наносится урон
			ItemStack legs_to = player_to.getCurrentArmor(1);//Что в слоте штанов кому наносится урон
			ItemStack boot_to = player_to.getCurrentArmor(0);//Что в слоте ботинок кому наносится урон

			if (e.source.isExplosion()) {

			}

			if (e.source.isProjectile()) {

			}

			if (e.source.isFireDamage()) {

			}

			if (e.source.isDamageAbsolute()) {
				player_to.addChatMessage(new ChatComponentText("isDamageAbsolute"));
			}

			if (e.source.isMagicDamage()) {
				player_to.addChatMessage(new ChatComponentText("isMagicDamage"));
			}

			if (e.source.isUnblockable()) {

			}

			if (e.source.isDifficultyScaled()) {

			}

		}

	}
	//--------------------------------------------------------------------------------------------------------------
}
