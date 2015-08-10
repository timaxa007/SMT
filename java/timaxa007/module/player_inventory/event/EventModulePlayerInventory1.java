package timaxa007.module.player_inventory.event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ContainerPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentText;
import timaxa007.module.player_inventory.ModulePlayerInventory;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.common.gameevent.TickEvent.Phase;
import cpw.mods.fml.relauncher.Side;

public class EventModulePlayerInventory1 {
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void playerLoggedIn(PlayerEvent.PlayerLoggedInEvent e) {
		EntityPlayer player = e.player;
		if (player != null) {}

	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void playerLoggedOut(PlayerEvent.PlayerLoggedOutEvent e) {
		//System.out.println("/***/ - " + e.player.getCommandSenderName());
	}
	//--------------------------------------------------------------------------------------------------------------
	private boolean open_con = false, open_con_last = false;

	@SubscribeEvent
	public void actiCon(TickEvent.PlayerTickEvent e) {
		if (e.phase == Phase.START && e.side == Side.SERVER) {
			EntityPlayer player = e.player;
			if (player != null) {

				if (player.openContainer instanceof ContainerPlayer || player.openContainer == null)
					open_con = false;
				else {
					open_con = true;
					openUpdateGui(player.openContainer);
				}

				if (!open_con_last && open_con) openGui(player.openContainer);
				if (open_con_last && !open_con) closedGui(player.openContainer);

				open_con_last = open_con;

			}
		}
	}

	private static void openUpdateGui(Container container) {
		//ModulePlayerInventory.log.info("openUpdateGui" + container.toString());

	}

	private static void openGui(Container container) {
		//ModulePlayerInventory.log.info("openGui" + container.toString());
		checkBlackList(container);
	}

	private static void closedGui(Container container) {
		//ModulePlayerInventory.log.info("closedGui" + container.toString());
		checkBlackList(container);
	}

	private static void checkBlackList(Container container) {
		for (int i = 0; i < container.getInventory().size(); i++) {
			Slot slot = container.getSlot(i);
			if (slot != null) {
				ItemStack is = slot.getStack();
				if (is != null) {
					if (is.getItem() == Item.getItemFromBlock(Blocks.tnt)) {
						slot.putStack(null);
						//slot.onSlotChanged();
					}
				}
			}
		}
	}
	//--------------------------------------------------------------------------------------------------------------
	private static boolean isTrueItem, isTrueItem_last;
	static {isTrueItem = isTrueItem_last = false;}

	@SubscribeEvent
	public void invPlayer(TickEvent.PlayerTickEvent e) {
		if (e.side == Side.SERVER) {
			EntityPlayer player = e.player;
			if (player != null) {
				for (ItemStack slot : player.inventory.mainInventory) {
					isTrueItem = checkItem(slot, Items.golden_apple);
					if (isTrueItem) break;
				}

				if (!isTrueItem_last && isTrueItem) itemTrue(player);
				if (isTrueItem_last && !isTrueItem) itemFalse(player);

				isTrueItem_last = isTrueItem;

			}
		}
	}

	private static boolean checkItem(ItemStack check, Item item) {
		if (check != null && check.getItem() == item) return true; else return false;
	}

	private static void itemTrue(EntityPlayer player) {
		player.addChatMessage(new ChatComponentText("You have is epic apple."));
	}

	private static void itemFalse(EntityPlayer player) {
		player.addChatMessage(new ChatComponentText("You lost is epic apple."));
	}
	//--------------------------------------------------------------------------------------------------------------
}
