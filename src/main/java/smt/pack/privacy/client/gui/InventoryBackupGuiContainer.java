package smt.pack.privacy.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import smt.pack.privacy.inventory.InventoryBackup;
import smt.pack.privacy.inventory.InventoryBackupContainer;

public class InventoryBackupGuiContainer extends GuiContainer {

	final InventoryBackup inventoryBackup;

	public InventoryBackupGuiContainer(InventoryPlayer inventoryPlayer, InventoryBackup inventoryBackup) {
		super(new InventoryBackupContainer(inventoryPlayer, inventoryBackup));
		this.inventoryBackup = inventoryBackup;
	}

	@Override
	public void drawGuiContainerBackgroundLayer(float parTick, int mouseX, int mouseY) {

	}

}
