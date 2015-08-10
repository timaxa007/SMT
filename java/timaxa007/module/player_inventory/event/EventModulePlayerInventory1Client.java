package timaxa007.module.player_inventory.event;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent;

public class EventModulePlayerInventory1Client {
	//--------------------------------------------------------------------------------------------------------------
	Minecraft mc = Minecraft.getMinecraft();
	@SubscribeEvent
	public void onKey(InputEvent.KeyInputEvent event) {
		EntityPlayer player = mc.thePlayer;
		//if (mc.gameSettings.keyBindInventory.isPressed()) {}
	}
	//--------------------------------------------------------------------------------------------------------------
}
