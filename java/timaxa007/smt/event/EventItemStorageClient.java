package timaxa007.smt.event;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import timaxa007.api.IItemStorage;
import timaxa007.gui.gui.ItemStorageGui;
import timaxa007.smt.util.UtilSMT;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.relauncher.Side;

public class EventItemStorageClient {

	//net.minecraft.client.Minecraft mc = ;
	//net.minecraft.client.entity.EntityClientPlayerMP player = UtilSMT.getPlayerClient();
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void closeGUI(TickEvent.PlayerTickEvent e) {
		if (e.side == Side.CLIENT) {
			EntityPlayer player = e.player;
			if (player != null) {
				ItemStack current = player.getCurrentEquippedItem();
				GuiScreen gui = UtilSMT.getClient().currentScreen;
				if (gui != null) {
					//System.out.println(gui.toString());
					//----------------------------------------------------------------------------------------------
					if (gui instanceof ItemStorageGui) {
						if (current == null || !(current != null && current.getItem() instanceof IItemStorage))
							player.closeScreen();
					}
					//----------------------------------------------------------------------------------------------
				}
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
}
