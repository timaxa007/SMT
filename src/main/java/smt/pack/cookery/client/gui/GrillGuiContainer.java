package smt.pack.cookery.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import smt.pack.cookery.inventory.GrillContainer;
import smt.pack.cookery.tile.TileEntityGrill;

public class GrillGuiContainer extends GuiContainer {

	private TileEntityGrill tile;

	public GrillGuiContainer(InventoryPlayer playerInventory, TileEntityGrill tile) {
		super(new GrillContainer(playerInventory, tile));
		this.tile = tile;
	}

	@Override
	public void drawGuiContainerBackgroundLayer(float parTick, int mouseX, int mouseY) {

	}

}
