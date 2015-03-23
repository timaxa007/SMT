package mods.timaxa007.pack.magic.event;

import mods.timaxa007.pack.magic.lib.PlayerMana;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityEvent;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.relauncher.Side;

public class EventMana {
	//-------------------------------------------------------------------------V
	public static class Player {

		@SubscribeEvent
		public void addPlayerConstructingWeight(EntityEvent.EntityConstructing event) {
			if (event.entity instanceof EntityPlayer)
				if (PlayerMana.get((EntityPlayer)event.entity) == null)
					PlayerMana.reg((EntityPlayer)event.entity);
		}

	}
	//-------------------------------------------------------------------------V
	public static class Client {
		//---------------------------
		@SubscribeEvent(priority = EventPriority.LOWEST)
		public void updatePlayer(TickEvent.PlayerTickEvent event) {
			if (event.phase == TickEvent.Phase.START && event.side == Side.CLIENT) {
				EntityPlayer player = event.player;
				EventMana.updateMana(player);
			}
		}
		//---------------------------
	}
	//-------------------------------------------------------------------------V
	public static class Server {
		//---------------------------
		@SubscribeEvent(priority = EventPriority.LOWEST)
		public void updatePlayer(TickEvent.PlayerTickEvent event) {
			if (event.phase == TickEvent.Phase.START && event.side == Side.SERVER) {
				EntityPlayer player = event.player;
				EventMana.updateMana(player);
			}
		}
		//---------------------------
	}
	//-------------------------------------------------------------------------V
	public static void updateMana(EntityPlayer player) {

	}
	//-------------------------------------------------------------------------X
}
