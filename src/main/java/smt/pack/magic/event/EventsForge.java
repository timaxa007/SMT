package smt.pack.magic.event;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.world.EnumDifficulty;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.world.WorldEvent;
import smt.pack.magic.SMTMagic;
import smt.pack.magic.mana.ManaEntity;
import smt.pack.magic.mana.Util;
import smt.pack.magic.network.MessageMana;
import smt.pack.magic.network.MessageManaMax;
import smt.pack.magic.world.ChunkPower;
import smt.pack.magic.world.SpellInWorld;

public class EventsForge {
	/*
	@SubscribeEvent
	public void death(LivingDeathEvent event) {
		Entity from = event.source.getSourceOfDamage();
		EntityLivingBase to = event.entityLiving;
		if (from instanceof EntityPlayer && to != null) {
			System.out.println(" Игрок " + from.getCommandSenderName() + " убил " + to.getCommandSenderName() + ".");
		}
	}
	 */

	@SubscribeEvent
	public void addEntityConstructing(EntityEvent.EntityConstructing event) {
		if (event.entity != null)
			//if (ManaEntity.get(event.entity) == null) ManaEntity.reg(event.entity);
			if (Util.getManaEntity(event.entity) == null) Util.regManaEntity(event.entity);
	}

	@SubscribeEvent
	public void cloneManaEntity(PlayerEvent.Clone event) {
		//System.out.println("cloneManaEntity");
		//Если мир не был в хард сложности, то из старого игрока в нового игрока будут переданы нужные значения.
		if (event.original.worldObj.difficultySetting != EnumDifficulty.HARD) {
			ManaEntity mana_entity = Util.getManaEntity((EntityPlayer)event.original);
			if (mana_entity != null) {
				ManaEntity new_mana_entity = Util.getManaEntity((EntityPlayer)event.entityPlayer);
				if (new_mana_entity != null) {
					new_mana_entity.setLevel(mana_entity.getLevel());
					new_mana_entity.setMana(mana_entity.getMana());
					new_mana_entity.setManaMax(mana_entity.getManaMax());
				}
			}
		}
	}
	/*
	@SubscribeEvent
	public void syncInventoryEntityMagicChest(EntityJoinWorldEvent event) {
		if (!event.world.isRemote)
			if (event.entity instanceof EntityMagicChest) {
				EntityMagicChest entityMagicChest = (EntityMagicChest)event.entity;
				SMTMagic.network.sendToDimension(entityMagicChest.getDescriptionPacket(), entityMagicChest.dimension);
			}
	}
	 */
	@SubscribeEvent
	public void onEntityJoinWorld(EntityJoinWorldEvent event) {
		if (event.entity instanceof EntityPlayerMP) {
			ManaEntity mana_entity = Util.getManaEntity(event.entity);
			if (mana_entity != null) {
				SMTMagic.network.sendTo(new MessageMana(mana_entity.getMana()), (EntityPlayerMP)event.entity);
				SMTMagic.network.sendTo(new MessageManaMax(mana_entity.getManaMax()), (EntityPlayerMP)event.entity);
			}
		}
	}

	@SubscribeEvent(priority=EventPriority.HIGH)
	public void addEntityConstructing(LivingEvent.LivingUpdateEvent event) {
		if (event.entityLiving != null && !event.entityLiving.worldObj.isRemote) {
			ManaEntity mana_entity = Util.getManaEntity(event.entityLiving);
			if (mana_entity != null) mana_entity.update(event.entityLiving);
		}
	}

	@SubscribeEvent
	public void changeCountUseManaEntity(CountUseManaEntityEvent event) {
		//Если Entity в полёте использует ману, на 2 маны использует больше.
		//If the Entity in flight uses mana, on 2 mana uses more.
		if (event.entity.isAirBorne) event.count_use_mana += 2;
	}

	@SubscribeEvent
	public void changeItemWithChance(ItemWithChanceEvent event) {
		//Добавляем, с помощью эвента, "предмет с шансом".
		//Adding through event, "item with chance".
		event.addItemWithChance(15F, Items.nether_star);

		//Алмаз(-ы) будет(-ут) убран(-ы).
		//Diamond(-s) will be removed.
		if (!event.list_drops.isEmpty())
			for (int i = 0; i < event.list_drops.size(); ++i) {
				ItemWithChanceEvent.ItemWithChance iwc = event.list_drops.get(i);
				if (iwc.getItem() != null && iwc.getItem().getItem() != null) {
					if (iwc.getItem().getItem() == Items.diamond) {
					event.list_drops.remove(i);
					--i;
					}
				}
			}

		//Если игрок будет в воде, то эвент будет отменён.
		//If a player is in water, then the event will be canceled.
		if (event.entityPlayer.isInWater()) event.setCanceled(true);
	}

	@SubscribeEvent
	public void handleWorldLoad(WorldEvent.Load event) {
		System.out.println("handleWorldLoad - " + event.world.provider.dimensionId);
		ChunkPower.get(event.world);
		SpellInWorld.get(event.world);
	}

}
