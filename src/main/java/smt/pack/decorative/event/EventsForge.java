package smt.pack.decorative.event;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventsForge {

	@SubscribeEvent
	public void renameSing(PlayerInteractEvent event) {
		if (event.action == PlayerInteractEvent.Action.RIGHT_CLICK_BLOCK) {
			Block block = event.world.getBlock(event.x, event.y, event.z);
			if (block != null && (block == Blocks.wall_sign || block == Blocks.standing_sign)) {
				//Open GUI
				event.useBlock = Result.ALLOW;
			}
		}
	}

}
