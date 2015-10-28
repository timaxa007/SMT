package timaxa007.core.event;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import timaxa007.gui.IItemStorage;
import timaxa007.gui.gui.ItemStorageGui;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.relauncher.Side;

public class EventItemStorageClient {
	//-----------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void closeGUI(TickEvent.PlayerTickEvent e) {
		if (e.side == Side.CLIENT) {//Данный метод для клиентской стороны
			EntityPlayer player = e.player;
			if (player != null) {
				ItemStack current = player.getCurrentEquippedItem();
				GuiScreen gui = FMLClientHandler.instance().getClient().currentScreen;
				if (gui != null) {
					//-------------------------------------------------------------------------------
					if (gui instanceof ItemStorageGui) {
						//Закрытия окна, в случаи если предмета нет нужного нам предмета.
						if (current == null || !(current != null && current.getItem() instanceof IItemStorage))
							player.closeScreen();
					}
					//-------------------------------------------------------------------------------
				}
			}
		}
	}
	//-----------------------------------------------------------------------------------------------
}