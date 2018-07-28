package smt.pack.common.client.gui.creating_gui;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.gui.GuiScreen;

public class CreatingGuiGui extends GuiScreen {

	private final List<ElementGui> elements = new ArrayList<ElementGui>();

	@Override
	public void initGui() {
		elements.clear();
		elements.add(new ButtonSetupGui(-20, -10, 40, 20, 0xFFFF007F, Orientation.CENTER));

		for (ElementGui o : elements) o.initGui(this);

	}

	@Override
	public void keyTyped(char c, int key) {
		if (key == 1) {
			this.mc.displayGuiScreen((GuiScreen)null);
			this.mc.setIngameFocus();
		}
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float parTick) {
		fontRendererObj.drawStringWithShadow(this.width + " /" + this.height, 0, 0, 0xFFFFFF);

		for (ElementGui o : elements) o.drawScreen(mouseX, mouseY, parTick);

		super.drawScreen(mouseX, mouseY, parTick);
	}

}
