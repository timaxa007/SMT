package smt.pack.common.client.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiOptionButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import smt.pack.common.SMTCommon;

@SideOnly(Side.CLIENT)
public class ProgressGUI extends GuiScreen {

	EntityPlayer player;

	private static final ResourceLocation
	texture = new ResourceLocation(SMTCommon.MODID, "textures/gui/a.png"),
	texture2 = new ResourceLocation(SMTCommon.MODID, "textures/gui/achievement_background.png");
	;

	static RenderItem renderitem = new RenderItem();
	public int width2 = 232;
	public int height2 = 232;
	public int last_mouseX;
	public int last_mouseY;
	public float scaleBackground = 1.0F;
	public double displayColumn1;
	public double displayRow1;
	public double displayColumn2;
	public double displayRow2;
	public double displayColumn3;
	public double displayRow3;
	private boolean lastClick;

	private int currentPage = -1;
	private GuiButton button;

	public ProgressGUI(EntityPlayer player) {
		this.player = player;
	}

	@Override
	public void initGui() {
		buttonList.clear();
		buttonList.add(new GuiOptionButton(1, width / 2 - 3, height / 2 + 74, 80, 20, "02"));
		buttonList.add(new GuiButton(2, width / 2 - 12 - 80, height / 2 + 74, 80, 20, "01"));
	}

	@Override
	public void actionPerformed(GuiButton btn) {
		if (btn.id == 1) {
			mc.displayGuiScreen(null);
		}

		if (btn.id == 2) {
			/*currentPage++;
			if (currentPage >= AchievementPage.getAchievementPages().size()) {
				currentPage = -1;
			}
			button.displayString = AchievementPage.getTitle(currentPage);*/
		}
	}

	@Override
	public void keyTyped(char character, int key) {
		if (key == mc.gameSettings.keyBindInventory.getKeyCode()) {
			mc.displayGuiScreen((GuiScreen)null);
			mc.setIngameFocus();
		} else {
			super.keyTyped(character, key);
		}
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float parTick) {
		int k;

		if (Mouse.isButtonDown(0)) {
			k = (width - width2) / 2;
			int l = (height - height2) / 2;
			int i1 = k + 8;
			int j1 = l + 17;

			if ((!lastClick || lastClick) && mouseX >= i1 && mouseX < i1 + 224 && mouseY >= j1 && mouseY < j1 + 155) {
				if (!lastClick) {
					lastClick = true;
				} else {
					displayColumn2 -= (double)((float)(mouseX - last_mouseX) * scaleBackground);
					displayRow2 -= (double)((float)(mouseY - last_mouseY) * scaleBackground);
					displayColumn3 = displayColumn1 = displayColumn2;
					displayRow3 = displayRow1 = displayRow2;
				}

				last_mouseX = mouseX;
				last_mouseY = mouseY;
			}
		} else {
			lastClick = false;
		}

		k = Mouse.getDWheel();
		float f4 = scaleBackground;

		if (k < 0) {
			scaleBackground += 0.25F;
		}
		else if (k > 0) {
			scaleBackground -= 0.25F;
		}

		scaleBackground = MathHelper.clamp_float(scaleBackground, 1.0F, 2.0F);

		if (scaleBackground != f4) {
			float f6 = f4 - scaleBackground;
			float f5 = f4 * (float)width2;
			float f1 = f4 * (float)height2;
			float f2 = scaleBackground * (float)width2;
			float f3 = scaleBackground * (float)height2;
			displayColumn2 -= (double)((f2 - f5) * 0.5F);
			displayRow2 -= (double)((f3 - f1) * 0.5F);
			displayColumn3 = displayColumn1 = displayColumn2;
			displayRow3 = displayRow1 = displayRow2;
		}

		drawDefaultBackground();
		func_146552_b(mouseX, mouseY, parTick);
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		func_146553_h();
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glEnable(GL11.GL_DEPTH_TEST);
	}

	@Override
	public void updateScreen() {
		displayColumn1 = displayColumn2;
		displayRow1 = displayRow2;
		double d0 = displayColumn3 - displayColumn2;
		double d1 = displayRow3 - displayRow2;

		if (d0 * d0 + d1 * d1 < 4.0D) {
			displayColumn2 += d0;
			displayRow2 += d1;
		} else {
			displayColumn2 += d0 * 0.85D;
			displayRow2 += d1 * 0.85D;
		}
	}

	public void func_146553_h() {
		int posX = (width - width2) / 2;
		int posY = (height - height2) / 2;
		fontRendererObj.drawString(I18n.format("gui.achievements", new Object[0]), posX + 15, posY + 5, 4210752);
	}

	public void func_146552_b(int mouseX, int mouseY, float parTick) {

		int posX = (width - width2) / 2;
		int posY = (height - height2) / 2;

		zLevel = 0.0F;
		GL11.glDepthFunc(GL11.GL_GEQUAL);
		GL11.glPushMatrix();

		//zLevel = -200.0F;
		GL11.glTranslatef(0, 0, -200);

		GL11.glEnable(GL11.GL_TEXTURE_2D);
		GL11.glDisable(GL11.GL_LIGHTING);


		mc.getTextureManager().bindTexture(texture2);
		drawTexturedModalRect(posX, posY, 0, 0, width2, height2);
		

		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glDepthFunc(GL11.GL_LEQUAL);
		mc.getTextureManager().bindTexture(texture);

		RenderHelper.enableGUIStandardItemLighting();
		GL11.glDisable(GL11.GL_LIGHTING);
		GL11.glEnable(GL12.GL_RESCALE_NORMAL);
		GL11.glEnable(GL11.GL_COLOR_MATERIAL);

		//
		mc.getTextureManager().bindTexture(texture2);
		drawTexturedModalRect(40 - 10, 40 - 10, 200, 0, 20, 40);
		drawTexturedModalRect(256 + 40 - 10, 160 + 40 - 10, 200, 0, 20, 40);
		//

		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glPopMatrix();
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.getTextureManager().bindTexture(texture);
		drawTexturedModalRect(posX, posY, 0, 0, width2, height2);
		zLevel = 0.0F;
		GL11.glDepthFunc(GL11.GL_LEQUAL);
		GL11.glDisable(GL11.GL_DEPTH_TEST);
		GL11.glEnable(GL11.GL_TEXTURE_2D);
		super.drawScreen(mouseX, mouseY, parTick);

		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glEnable(GL11.GL_LIGHTING);
		RenderHelper.disableStandardItemLighting();
	}

	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}

}
