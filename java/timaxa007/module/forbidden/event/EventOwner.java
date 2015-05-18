package timaxa007.module.forbidden.event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.event.world.BlockEvent.BreakEvent;
import timaxa007.module.forbidden.api.ITileEntityOwner;
import timaxa007.smt.util.UtilString;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventOwner {
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onBreak(BlockEvent.BreakEvent event) {
		EntityPlayer player = event.getPlayer();
		if (player != null && !player.capabilities.isCreativeMode)
			noBreak(event, player, event.world, event.x, event.y, event.z);
	}
	//--------------------------------------------------------------------------------------------------------------
	private static void noBreak(BreakEvent event, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(x, y, z);
		if (te != null) {
			//------------------------------------------------------------------------------------------------------
			if (te instanceof ITileEntityOwner) {
				ITileEntityOwner tile = (ITileEntityOwner)te;
				if (UtilString.hasString(tile.getOwner()) && !player.getCommandSenderName().equals(tile.getOwner()))
					event.setCanceled(true);
			}
			//------------------------------------------------------------------------------------------------------
		}

	}
	//--------------------------------------------------------------------------------------------------------------
}
