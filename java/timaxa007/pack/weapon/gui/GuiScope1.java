package timaxa007.pack.weapon.gui;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

public class GuiScope1 extends GuiScreen {

	private static final ResourceLocation scope = new ResourceLocation("timaxa007", "textures/gui/scope_blank_1.png");

	private int width_scope = 256;
	private int height_scope = 256;

	public GuiScope1(EntityPlayer player) {
		super();
	}

	public void drawScreen(int i1, int i2, float i3) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.getTextureManager().bindTexture(scope);
		int k1 = (width - width_scope) / 2;
		int k2 = (height - height_scope) / 2;
		byte b0 = 2;
		drawTexturedModalRect(k1, b0, 0, 0, width_scope, height_scope);

		super.drawScreen(i1, i2, i3);
	}

}
