package timaxa007.module.status_player.util;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;

public class EventStatusPlayer {
	//-------------------------------------------------------------------------V
	public static class Player {

		@SubscribeEvent
		public void addPlayerConstructingWeight(EntityEvent.EntityConstructing event) {
			if (event.entity instanceof EntityPlayer)
				if (PlayerStatusPlayer.get((EntityPlayer)event.entity) == null)
					PlayerStatusPlayer.reg((EntityPlayer)event.entity);
		}

		@SubscribeEvent
		public void joinPlayer(EntityJoinWorldEvent event) {
			if (!event.entity.worldObj.isRemote && event.entity instanceof EntityPlayerMP)
				if (PlayerStatusPlayer.get((EntityPlayer)event.entity) != null) {
					//float weight = PlayerWeight.get((EntityPlayer)event.entity).getWeight();
					//float weight_max = PlayerStatusPlayer.get((EntityPlayer)event.entity).getWeightMax();
					//Fix for Client
					//CoreStatusPlayer.network.sendTo(new MessageEnvironment(weight_max), (EntityPlayerMP)event.entity);
				}
		}

	}
	//-------------------------------------------------------------------------V
	public static class Common {

		@SubscribeEvent(priority = EventPriority.LOWEST)
		public void updatePlayer(TickEvent.PlayerTickEvent event) {
			if (event.phase == TickEvent.Phase.START) {
				EntityPlayer player = event.player;
				//SystemWeight.sumMoving(player);
			}
		}

	}
	//-------------------------------------------------------------------------X
}
