package smt.pack.common.client.gui.creating_gui;

public abstract class ElementGui {

	protected CreatingGuiGui gui;

	void initGui(CreatingGuiGui gui) {
		this.gui = gui;
	}

	abstract void drawScreen(int mouseX, int mouseY, float parTick);

}
