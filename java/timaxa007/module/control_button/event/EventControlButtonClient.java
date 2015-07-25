package timaxa007.module.control_button.event;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.client.event.FOVUpdateEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import timaxa007.module.control_button.api.IScope;
import timaxa007.smt.util.UtilSMT;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventControlButtonClient {
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onZoom(FOVUpdateEvent e) {
		ItemStack current = e.entity.getCurrentEquippedItem();

		if (current != null && current.getItem() instanceof IScope) {
			NBTTagCompound nbt = current.getTagCompound();
			if (nbt != null && nbt.hasKey("Aim") && nbt.getBoolean("Aim")) {
				if (nbt.hasKey("ZoomFov"))
					e.newfov -= ((float)nbt.getByte("ZoomFov") / 127.0F);
				else 
					e.newfov -= 0.25F;
			}
		}

	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onRenderCrosshairs(RenderGameOverlayEvent.Pre e) {
		ItemStack current = UtilSMT.getPlayerClient().getCurrentEquippedItem();

		if (current != null && current.getItem() instanceof IScope) {
			NBTTagCompound nbt = current.getTagCompound();
			if (e.type.equals(ElementType.CROSSHAIRS)) {
				if (nbt != null && nbt.hasKey("Aim") && nbt.getBoolean("Aim")) {
					e.setCanceled(true);
				}
			}
		}

	}
	//--------------------------------------------------------------------------------------------------------------
}
