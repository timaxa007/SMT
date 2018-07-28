package smt.pack.common.client.gui.creating_gui;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.Tessellator;

public class ButtonSetupActiveGui extends ElementGui {

	public int
	posX = 0,
	posY = 0,
	sizeX = 40,
	sizeY = 20,
	color = 0;
	public Orientation orientation = Orientation.CENTER;

	@Override
	public void initGui(CreatingGuiGui gui) {
		super.initGui(gui);
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float parTick) {
		//GL11.glDisable(GL11.GL_TEXTURE);
		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawingQuads();
        float f = (float)(color >> 24 & 255) / 255.0F;
        float f1 = (float)(color >> 16 & 255) / 255.0F;
        float f2 = (float)(color >> 8 & 255) / 255.0F;
        float f3 = (float)(color & 255) / 255.0F;
        tessellator.setColorRGBA_F(f1, f2, f3, f);
		int offsetX = (orientation.isLeft() ? 0 : orientation.isRight() ? gui.width : (gui.width / 2)) + posX;
		int offsetY = (orientation.isTop() ? 0 : orientation.isBotton() ? gui.height : (gui.height / 2)) + posY;
		tessellator.addVertex(offsetX, offsetY + sizeY, 0.0D);
		tessellator.addVertex(offsetX + sizeX, offsetY + sizeY, 0.0D);
		tessellator.addVertex(offsetX + sizeX, offsetY, 0.0D);
		tessellator.addVertex(offsetX, offsetY, 0.0D);
		tessellator.draw();
		//GL11.glEnable(GL11.GL_TEXTURE);
	}

	public ButtonSetupGui toButtonSetupGui() {
		return new ButtonSetupGui(posX, posY, sizeX, sizeY, color, orientation);
	}

}
