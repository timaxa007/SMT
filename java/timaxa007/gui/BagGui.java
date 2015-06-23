package timaxa007.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;

public class BagGui extends GuiContainer {

	public BagGui(EntityPlayer player) {
		super(new BagContainer(player));
	}

	@Override
	public void drawGuiContainerBackgroundLayer(float f, int j, int k) {

	}

}
