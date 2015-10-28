package timaxa007.core.event;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.GuiOpenEvent;
import timaxa007.gui.gui.GuiMainMenu;
import cpw.mods.fml.common.eventhandler.Event.Result;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventSMT_Client {

	Minecraft mc = Minecraft.getMinecraft();

	@SubscribeEvent
	public void onGUI(GuiOpenEvent e) {
		//if (e.gui != null) System.out.println("GuiOpenEvent:" + e.gui.toString() + ".");

		if (e.gui instanceof net.minecraft.client.gui.GuiMainMenu && !(e.gui instanceof GuiMainMenu)) {
			e.gui = new GuiMainMenu();
		}

		if (e.gui instanceof net.minecraft.client.gui.inventory.GuiCrafting) {
			//e.setCanceled(true);
		}

	}

}
