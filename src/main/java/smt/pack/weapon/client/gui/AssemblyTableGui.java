package smt.pack.weapon.client.gui;

import net.minecraft.entity.player.EntityPlayer;
import smt.pack.weapon.tile.TileEntityAssemblyTable;

public class AssemblyTableGui extends net.minecraft.client.gui.inventory.GuiContainer {

	final EntityPlayer player;
	final TileEntityAssemblyTable tile;

	public AssemblyTableGui(EntityPlayer player, TileEntityAssemblyTable tile) {
		super(new smt.pack.weapon.inventory.AssemblyTableContainer(player, tile));
		this.player = player;
		this.tile = tile;
	}

	@Override
	public void drawGuiContainerBackgroundLayer(float parTick, int mouseX, int mouseY) {

	}

}
