package timaxa007.module.control_button.event;

import net.minecraft.item.ItemStack;
import timaxa007.module.control_button.api.IUpdateClient;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.relauncher.Side;

public class EventUpdateClient {
	/*
	private IInventory inventory;

	@SubscribeEvent
	public void actionUpdateClient(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.START && event.side == Side.CLIENT) {
			List list = event.player.openContainer.getInventory();
			Minecraft.getMinecraft().c;
			for (int j = 0; j < list.size(); j ++) {
				ItemStack is = (ItemStack)list.get(j);
				if (is != null && is.getItem() instanceof IUpdateClient)
					((IUpdateClient)is.getItem()).updateClient(is, event.player.worldObj, event.player);
			}
			for (int i = 0; i < inventory.getSizeInventory(); i++) {
				ItemStack is = inventory.getStackInSlot(i);
				if (is != null && is.getItem() instanceof IUpdateClient)
					((IUpdateClient)is.getItem()).updateClient(is, event.player.worldObj, event.player);
			}
		}
	}
	 */
	@SubscribeEvent
	public void onUpdateClient(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.START && event.side == Side.CLIENT) {
			for (ItemStack is : event.player.inventory.mainInventory) {
				if (is != null && is.getItem() instanceof IUpdateClient)
					((IUpdateClient)is.getItem()).updateClient(is, event.player.worldObj, event.player);
			}
			for (ItemStack is : event.player.inventory.armorInventory) {
				if (is != null && is.getItem() instanceof IUpdateClient)
					((IUpdateClient)is.getItem()).updateClient(is, event.player.worldObj, event.player);
			}
		}
	}
}
