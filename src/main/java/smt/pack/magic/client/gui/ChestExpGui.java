package smt.pack.magic.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import smt.pack.magic.tile.TileEntityChestExp;

public class ChestExpGui extends GuiContainer {

	final TileEntityChestExp tile;

	public ChestExpGui(final EntityPlayer player, final TileEntityChestExp te) {
		super(new smt.pack.magic.inventory.ChestExpContainer(player, te));
		tile = te;
	}

	@Override
	public void drawGuiContainerBackgroundLayer(float parTick, int mouseX, int mouseY) {

	}

}
