package timaxa007.core.event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import timaxa007.gui.IItemStorage;
import timaxa007.gui.container.ItemStorageContainer;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;

public class EventItemStorage {
	//-----------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void actiCon(TickEvent.PlayerTickEvent e) {
		EntityPlayer player = e.player;
		if (player != null) {
			ItemStack current = player.getCurrentEquippedItem();
			Container con = player.openContainer;
			if (con != null) {
				//-----------------------------------------------------------------------------------
				if (con instanceof ItemStorageContainer) {
					ItemStorageContainer bc = (ItemStorageContainer)con;
					ItemStack new_is = bc.update(player);
					if (new_is != null) current = new_is;
					//Закрытия окна, в случаи если предмета нет нужного нам предмета.
					if (new_is == null || !(new_is != null && new_is.getItem() instanceof IItemStorage))
						player.closeScreen();
				}
				//-----------------------------------------------------------------------------------
			}
		}
	}
	//-----------------------------------------------------------------------------------------------
}
