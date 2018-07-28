package smt.pack.common.event;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import smt.pack.common.api.IItemStorage;
import smt.pack.common.inventory.ContainerItemStorage;

public class EventsFML {

	@SubscribeEvent
	public void onPlayerTickEvent(TickEvent.PlayerTickEvent event) {
		switch(event.phase) {
		case END:
			Container con = event.player.openContainer;
			if (con != null && con instanceof ContainerItemStorage) {
				ContainerItemStorage cis = (ContainerItemStorage)con;
				ItemStack current = event.player.getCurrentEquippedItem();
				//update
				if (event.side.isServer() && current != null) cis.update(event.player);
				//Закрытия окна, в случаи если предмета нет нужного нам предмета.
				if (current == null || !(current != null && current.getItem() instanceof IItemStorage))
					event.player.closeScreen();
			}
			break;
		default:break;
		}
	}

	/*
	static HashMap<EntityPlayer, Object302> map = new HashMap<EntityPlayer, Object302>();

	@SubscribeEvent
	public void onPlayerTickEventArmor(TickEvent.PlayerTickEvent event) {
		switch(event.phase) {
		case END:
			if (event.side.isServer()) {
				ItemStack head = event.player.getCurrentArmor(0);
				if (head == null || head.getItem() != Items.diamond_helmet) return;
				ItemStack body = event.player.getCurrentArmor(1);
				if (body == null || body.getItem() != Items.diamond_chestplate) return;
				ItemStack legs = event.player.getCurrentArmor(2);
				if (legs == null || legs.getItem() != Items.diamond_leggings) return;
				ItemStack feet = event.player.getCurrentArmor(3);
				if (feet == null || feet.getItem() != Items.diamond_boots) return;

				if (!map.containsKey(event.player))
					map.put(event.player, new Object302());

				Object302 obj302 = map.get(event.player);

				if (head.getItemDamage() == 0 && 
						body.getItemDamage() == 0 && 
						legs.getItemDamage() == 0 && 
						feet.getItemDamage() == 0) {
					obj302.turnA = true;
				} else {
					obj302.turnA = false;
				}
			}
			break;
		default:break;
		}
	}

	public static class Object302 {
		public boolean
		turnA = false,
		turnB = false;
	}
	 */
	//@SubscribeEvent
	public void messageServer(PlayerLoggedInEvent event) {
		if (FMLCommonHandler.instance().getSide().isServer()) {
			event.player.addChatMessage(new ChatComponentText("Hello on the Server!"));
		}
	}

}
