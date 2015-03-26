package timaxa007.module.control_button.event;

import net.minecraft.client.Minecraft;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.client.event.FOVUpdateEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import timaxa007.module.control_button.api.IScope;
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
					e.newfov -= ((127.0F + (float)nbt.getByte("ZoomFov")) / 127.0F);
				else 
					e.newfov -= 0.25F;
			}
		}

	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onRenderCrosshairs(RenderGameOverlayEvent.Pre e) {
		ItemStack current = Minecraft.getMinecraft().thePlayer.getCurrentEquippedItem();

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
