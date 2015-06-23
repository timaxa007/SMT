package timaxa007.module.information.event;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import timaxa007.module.information.api.ISeeLook;
import timaxa007.smt.util.UtilSMT;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventClientInformation {
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onRenderCrosshairs(RenderGameOverlayEvent.Pre e) {
		EntityClientPlayerMP player = Minecraft.getMinecraft().thePlayer;
		WorldClient world = Minecraft.getMinecraft().theWorld;
		ItemStack current = player.getCurrentEquippedItem();
		MovingObjectPosition mop = UtilSMT.LookOBJ.look(true);

		if ((current != null && current.getItem() instanceof ISeeLook) || (current == null)) {
			if (mop != null) {
				//------------------------------
				//if (mop.entityHit != null && mop.typeOfHit == MovingObjectType.ENTITY) {
				//else if (mop.typeOfHit == MovingObjectType.BLOCK) {

				//if (current != null && current.getItem() instanceof ISeeLook)
				//((ISeeLook)current.getItem()).send(player, mop);
				//------------------------------
				if (e.type.equals(RenderGameOverlayEvent.ElementType.CROSSHAIRS)) {
					if (mop.entityHit != null && mop.typeOfHit == MovingObjectPosition.MovingObjectType.ENTITY && 
							mop.entityHit instanceof EntityItem) {
						e.setCanceled(true);
					}
				}
				//------------------------------
			}
		}

	}
	//--------------------------------------------------------------------------------------------------------------
}
