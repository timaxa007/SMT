package smt.pack.technology.client.gui;

import net.minecraft.entity.player.EntityPlayer;
import smt.pack.technology.tile.TileEntityElectricMachine;
import smt.pack.technology.tile.machine.ElectricBigBufferItem;

public class ElectricMachineGui extends net.minecraft.client.gui.inventory.GuiContainer {

	final TileEntityElectricMachine tile;

	public ElectricMachineGui(EntityPlayer player, TileEntityElectricMachine tile) {
		super(new smt.pack.technology.inventory.ElectricMachineContainer(player, tile));
		this.tile = tile;
	}

	@Override
	public void drawGuiContainerBackgroundLayer(float parTick, int mouseX, int mouseY) {

		if (tile.getElectricMachine() instanceof ElectricBigBufferItem) {
			ElectricBigBufferItem ebbi = (ElectricBigBufferItem)tile.getElectricMachine();
			for (int i = 0; i < ebbi.stackSizeLarge.length; ++i) {
				mc.fontRenderer.drawString(String.valueOf(ebbi.stackSizeLarge[i]), guiLeft + 8 + (i % 9) * 18, guiTop + 18 + (i / 9) * 18, 0xFFFFFF);

			}
		}

	}

}
