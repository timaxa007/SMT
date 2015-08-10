package timaxa007.module.player_inventory.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;

//GuiInventory
public class GuiPlayerInventory extends GuiContainer {

	public GuiPlayerInventory() {
		super(new ContainerPlayerInventory());
	}

	public GuiPlayerInventory(EntityPlayer player) {
		super(new ContainerPlayerInventory(player));
	}

	@Override
	public void drawGuiContainerBackgroundLayer(float f, int i1, int i2) {

	}

}
