package mods.timaxa007.tms.event;

import mods.timaxa007.tms.util.IActionKeyPrimary;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.client.event.FOVUpdateEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;


public class EventClientTMS {
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onZoom(FOVUpdateEvent e) {
		ItemStack current = e.entity.inventory.getCurrentItem();
		if (current != null && current.getItem() instanceof IActionKeyPrimary) {
			NBTTagCompound tag = current.getTagCompound();
			if (tag != null && tag.hasKey("Aim")) {
				if (tag.getBoolean("Aim")) e.newfov -= 0.5F;
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
}
