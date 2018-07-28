package smt.pack.common.client.gui.page;

import smt.pack.common.client.gui.BookGui;

public abstract class Page {

	final BookGui gui;

	public Page(BookGui gui) {
		this.gui = gui;
		//initGui();
	}

	public void initGui() {
		
	}

	public void keyTyped(char character, int key) {
		
	}

	public void mouseClicked(int mouseX, int mouseY, int state) {
		
	}

	public void handleMouseInput() {
		
	}

	public abstract void draw(int mouseX, int mouseY, float parTick);

}
