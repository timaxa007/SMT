package smt.pack.technology.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import smt.pack.technology.SMTTechnology;

public class ButtonP extends GuiButton {

	public static final ResourceLocation buttonTextures = new ResourceLocation(SMTTechnology.MODID, "textures/gui/telephone1.png");

	public ButtonP(int id, int x, int y, String name) {
		super(id, x, y, 30, 17, name);
	}

	public void drawButton(Minecraft mc, int mouseX, int mouseY) {
		if (visible) {
			FontRenderer fontrenderer = mc.fontRenderer;
			mc.getTextureManager().bindTexture(buttonTextures);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			field_146123_n = mouseX >= xPosition && mouseY >= yPosition && mouseX < xPosition + width && mouseY < yPosition + height;
			int k = getHoverState(field_146123_n);
			GL11.glEnable(GL11.GL_BLEND);
			OpenGlHelper.glBlendFunc(770, 771, 1, 0);
			GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
			drawTexturedModalRect(xPosition, yPosition, 108, (field_146123_n ? 17 : 0), width, height);
			mouseDragged(mc, mouseX, mouseY);
			int l = 14737632;

			if (packedFGColour != 0) {
				l = packedFGColour;
			} else if (!enabled) {
				l = 10526880;
			} else if (field_146123_n) {
				l = 16777120;
			}

			drawCenteredString(fontrenderer, displayString, xPosition + width / 2, yPosition + (height - 8) / 2, l);
		}
	}

}
