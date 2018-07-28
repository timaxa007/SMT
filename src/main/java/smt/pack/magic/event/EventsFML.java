package smt.pack.magic.event;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import smt.pack.magic.world.SpellInWorld;

public class EventsFML {

	@SubscribeEvent
	public void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {

	}

	@SubscribeEvent
	public void tickPlayer(TickEvent.PlayerTickEvent event) {

	}
	/*
	@SubscribeEvent
	public void loggedEntityMagicChest(PlayerEvent.PlayerLoggedInEvent event) {
		if (event.player instanceof EntityPlayerMP) {
			List list = event.player.worldObj.getLoadedEntityList();
			for (int i = 0; i < list.size(); ++i) {
				if (list.get(i) instanceof EntityMagicChest) {
					EntityMagicChest entityMagicChest = (EntityMagicChest)list.get(i);
					SMTMagic.network.sendTo(entityMagicChest.getDescriptionPacket(), (EntityPlayerMP)event.player);
				} else continue;
			}
		}
	}
	 */
	/*
	@SubscribeEvent
	public void updateEntityMagicChestContainer(TickEvent.PlayerTickEvent event) {
		if (event.player instanceof EntityPlayerMP) {
			if (event.player.openContainer instanceof EntityMagicChestContainer) {
				//((EntityMagicChestContainer)event.player.openContainer).onUpdate(event.player, event.phase);
			}
		}
	}
	 */
	@SubscribeEvent
	public void tickWorld(TickEvent.WorldTickEvent event) {
		if (event.world.isRemote) return;
		switch (event.phase) {
		case END:
			//System.out.println(event.world.provider.dimensionId);
			SpellInWorld siw = SpellInWorld.get(event.world);
			if (siw != null) siw.update(event.world);
			break;
		default:return;
		}
	}

}
