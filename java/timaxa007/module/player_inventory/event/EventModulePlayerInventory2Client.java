package timaxa007.module.player_inventory.event;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraftforge.client.event.GuiOpenEvent;
import timaxa007.module.player_inventory.ModulePlayerInventory;
import timaxa007.module.player_inventory.packet.MessageGui;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventModulePlayerInventory2Client {
	//--------------------------------------------------------------------------------------------------------------
	Minecraft mc = Minecraft.getMinecraft();

	@SubscribeEvent
	public void onGUI(GuiOpenEvent e) {
		//if (e.gui != null) ModulePlayerInventory.log.info("GuiOpenEvent:" + e.gui.toString() + ".");

		if (mc.thePlayer != null && e.gui instanceof GuiInventory) {
			//e.gui = new GuiPlayerInventory();//is not normal

			if (ModulePlayerInventory.getModeInventory() == ModulePlayerInventory.modeInventory.STYLE1)
				ModulePlayerInventory.network.sendToServer(new MessageGui(0));

			if (ModulePlayerInventory.getModeInventory() != ModulePlayerInventory.modeInventory.DEFAULT) e.setCanceled(true);
		}
	}
	//--------------------------------------------------------------------------------------------------------------
}
