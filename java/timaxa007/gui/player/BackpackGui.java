package timaxa007.gui.player;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;

public class BackpackGui extends GuiContainer {

	public BackpackGui(EntityPlayer player) {
		super(new BackpackContainer(player));
	}

	@Override
	public void drawGuiContainerBackgroundLayer(float f, int j, int k) {

	}

}
