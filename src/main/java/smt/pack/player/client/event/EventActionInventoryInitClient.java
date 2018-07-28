package smt.pack.player.client.event;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.ContainerPlayer;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.relauncher.Side;

public class EventActionInventoryInitClient {

	boolean kRestoreOneDown = false;

	@SubscribeEvent
	public void tickEvent(TickEvent.PlayerTickEvent event) {
		if (event.side == Side.CLIENT) {
			if (org.lwjgl.input.Keyboard.isKeyDown(/*kBindRestoreOne.getKeyCode()*/org.lwjgl.input.Keyboard.KEY_END)) {
				if (!kRestoreOneDown) {
					restoreInventoryOne(true);
				}
				kRestoreOneDown = true;
			} else {
				kRestoreOneDown = false;
			}
		}
	}

	public void restoreInventoryOne(boolean b) {
		EntityPlayerSP player = Minecraft.getMinecraft().thePlayer;
		if (player != null ) {
			net.minecraft.inventory.Container container = player.openContainer;
			if (container != null)
				if (container.getClass().getName() == "net.minecraft.inventory.ContainerPlayer") {
					ContainerPlayer conPlayer = (ContainerPlayer)container;
					InventoryPlayer invPlayer = player.inventory;
					InventoryCrafting invCraft = conPlayer.craftMatrix;

					ItemStack playerStack = invPlayer.getStackInSlot(0);
					if (playerStack != null) {
					Item item = playerStack.getItem();

					invCraft.setInventorySlotContents(0, new ItemStack(item, 7));
					invPlayer.setInventorySlotContents(0, null);
					}
				}
		}
	}

}
