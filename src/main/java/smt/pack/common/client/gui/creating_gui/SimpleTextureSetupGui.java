package smt.pack.common.client.gui.creating_gui;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.Tessellator;

public class SimpleTextureSetupGui extends ElementGui {

	private CreatingGuiGui gui;
	private int offsetX = 0, offsetY = 0;
	private final int posX, posY, sizeX, sizeY, color;
	private final Orientation orientation;

	public SimpleTextureSetupGui(int posX, int posY, int sizeX, int sizeY, int color, Orientation orientation) {
		this.posX = posX;
		this.posY = posY;
		this.sizeX = sizeX;
		this.sizeY = sizeY;
		this.color = color;
		this.orientation = orientation;
	}

	@Override
	public void initGui(CreatingGuiGui gui) {
		super.initGui(gui);
		offsetX = (orientation.isLeft() ? 0 : orientation.isRight() ? gui.width : (gui.width / 2)) + posX;
		offsetY = (orientation.isTop() ? 0 : orientation.isBotton() ? gui.height : (gui.height / 2)) + posY;
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float parTick) {
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawingQuads();
		float alpha = (float)(color >> 24 & 255) / 255.0F;
		float red = (float)(color >> 16 & 255) / 255.0F;
		float green = (float)(color >> 8 & 255) / 255.0F;
		float blue = (float)(color & 255) / 255.0F;
		tessellator.setColorRGBA_F(red, green, blue, alpha);
		tessellator.addVertex(offsetX, offsetY + sizeY, 0.0D);
		tessellator.addVertex(offsetX + sizeX, offsetY + sizeY, 0.0D);
		tessellator.addVertex(offsetX + sizeX, offsetY, 0.0D);
		tessellator.addVertex(offsetX, offsetY, 0.0D);
		tessellator.draw();
		GL11.glEnable(GL11.GL_TEXTURE_2D);
	}

	public ButtonSetupActiveGui toButtonSetupGui() {
		ButtonSetupActiveGui gui = new ButtonSetupActiveGui();
		gui.posX = posX;
		gui.posY = posY;
		gui.sizeX = sizeX;
		gui.sizeY = sizeY;
		gui.color = color;
		gui.orientation = orientation;
		return gui;
	}

}
