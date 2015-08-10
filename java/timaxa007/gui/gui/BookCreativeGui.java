package timaxa007.gui.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import timaxa007.gui.container.BookCreativeContainer;

public class BookCreativeGui extends GuiContainer {

	public BookCreativeGui(EntityPlayer player) {
		super(new BookCreativeContainer(player));
	}

	@Override
	public void drawGuiContainerBackgroundLayer(float f, int i1, int i2) {

	}

}
