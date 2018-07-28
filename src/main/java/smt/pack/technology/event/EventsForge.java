package smt.pack.technology.event;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.world.ChunkEvent;
import net.minecraftforge.event.world.WorldEvent;
import smt.pack.technology.SMTTechnology;
import smt.pack.technology.entity.EntityTelephone;
import smt.pack.technology.registry.ElectricPowerNet;
import smt.pack.technology.registry.FurnaceMobile;
import smt.pack.technology.world.WorldEnergy;
import smt.pack.technology.world.WorldWireEnergy;

public class EventsForge {

	@SubscribeEvent
	public void addEntityConstructing(EntityEvent.EntityConstructing event) {
		if (event.entity != null)
			if (FurnaceMobile.get(event.entity) == null)
				FurnaceMobile.reg(event.entity);
	}

	@SubscribeEvent
	public void addEntityConstructing(LivingUpdateEvent event) {
		if (event.entity instanceof EntityPlayer) {
			FurnaceMobile fm = FurnaceMobile.get(event.entity);
			if (fm != null) fm.update();
		}
	}
/*
	@SubscribeEvent
	public void damageArmor(LivingHurtEvent event) {
		if (event.source.getDamageType().equals("fall")) {
			EntityLivingBase to = event.entityLiving;
			ItemStack boot = to.getEquipmentInSlot(1);
			System.out.println("LivingHurtEvent ammount = " + event.ammount);
			if (boot != null && boot.getItem() == SMTTechnology.item.armorBoots) {
				int dmg = (int)(event.ammount * 2F);
				int d = boot.getMaxDamage() - boot.getItemDamage() - dmg;
				boot.damageItem(dmg, to);
				System.out.println("boot.stackSize = " + boot.stackSize);
				if (d < 0) {
					event.ammount = (float)Math.abs(d) / 2F;
					//--boot.stackSize; в boot.damageItem делает отнимание stackSize
					to.setCurrentItemOrArmor(1, (boot.stackSize > 0 ? boot : null));
				}
				else event.ammount = 0F;
			}
		}
	}
*/
	@SubscribeEvent
	public void entityReplaceTelephone(EntityJoinWorldEvent event) {
		if (!event.world.isRemote) {
			if (!(event.entity instanceof EntityTelephone) && event.entity instanceof EntityItem) {
				EntityItem ei = (EntityItem)event.entity;
				if (ei.getEntityItem() != null && ei.getEntityItem().getItem() == SMTTechnology.item.telephone) {
					//EntityTelephone et = new EntityTelephone(ei.worldObj, ei.posX, ei.posY, ei.posZ, new ItemStack(Items.stick));
					EntityTelephone et = new EntityTelephone(event.world);
					et.setPosition(ei.posX, ei.posY, ei.posZ);
					NBTTagCompound nbt = new NBTTagCompound();
					ei.writeEntityToNBT(nbt);
					et.readEntityFromNBT(nbt);
					//et.setEntityItemStack(new ItemStack(SMTTechnology.item.telephone));
					et.delayBeforeCanPickup = 40;
					event.world.spawnEntityInWorld(et);
					ei.setDead();
				}
			}
		}
	}
	
	@SubscribeEvent
	public void loadWorldEvent(WorldEvent.Load event) {
		WorldEnergy.get(event.world);
		WorldWireEnergy.get(event.world);
	}

	@SubscribeEvent
	public void loadChunkEvent(ChunkEvent.Load event) {
		WorldEnergy.get(event.world).loadChunk(event.getChunk().xPosition, event.getChunk().zPosition);
		WorldWireEnergy.get(event.world).loadChunk(event.getChunk().xPosition, event.getChunk().zPosition);
	}

	@SubscribeEvent
	public void unloadChunkEvent(ChunkEvent.Unload event) {
		WorldEnergy.get(event.world).unloadChunk(event.getChunk().xPosition, event.getChunk().zPosition);
		WorldWireEnergy.get(event.world).unloadChunk(event.getChunk().xPosition, event.getChunk().zPosition);
	}

}
