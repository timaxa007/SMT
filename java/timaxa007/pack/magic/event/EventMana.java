package timaxa007.pack.magic.event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import timaxa007.pack.magic.PackMagic;
import timaxa007.pack.magic.packet.MessageMana;
import timaxa007.pack.magic.util.PlayerMana;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;

public class EventMana {
	//-------------------------------------------------------------------------V
	public static class Player {

		@SubscribeEvent
		public void addPlayerConstructingWeight(EntityEvent.EntityConstructing event) {
			if (event.entity instanceof EntityPlayer)
				if (PlayerMana.get((EntityPlayer)event.entity) == null)
					PlayerMana.reg((EntityPlayer)event.entity);
		}

		@SubscribeEvent
		public void joinPlayer(EntityJoinWorldEvent event) {
			if (!event.entity.worldObj.isRemote && event.entity instanceof EntityPlayerMP)
				if (PlayerMana.get((EntityPlayer)event.entity) != null) {
					int mana = PlayerMana.get((EntityPlayer)event.entity).getMana();
					int mana_max = PlayerMana.get((EntityPlayer)event.entity).getManaMax();
					//Fix for Client
					PackMagic.network.sendTo(new MessageMana(mana, mana_max), (EntityPlayerMP)event.entity);
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
