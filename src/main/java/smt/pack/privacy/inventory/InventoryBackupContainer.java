package smt.pack.privacy.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;

public class InventoryBackupContainer extends Container {

	final InventoryBackup inventoryBackup;

	public InventoryBackupContainer(InventoryPlayer inventoryPlayer, InventoryBackup inventoryBackup) {
		this.inventoryBackup = inventoryBackup;
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return inventoryBackup.getInventory().isUseableByPlayer(player);
	}

}
