package smt.pack.common.client.gui.page;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import smt.pack.common.SMTCommon;
import smt.pack.common.client.gui.BookGui;
import smt.pack.common.registry.Knowledge;

public class PageMain extends Page {

	static final ResourceLocation
	texture = new ResourceLocation(SMTCommon.MODID, "textures/gui/test.png"),
	texture_back = new ResourceLocation(SMTCommon.MODID, "textures/gui/back.png");
	ArrayList<Knowledge> list_icon_element = new ArrayList<Knowledge>();
	int
	xSize = 230,
	ySize = 220,
	guiLeft,
	guiTop,
	offsetX = 150,
	offsetY = 90,
	last_mouseX,
	last_mouseY;
	ArrayList<GuiButton> buttonList = new ArrayList<GuiButton>();

	public PageMain(BookGui gui) {
		super(gui);
		initGui();
	}

	@Override
	public void initGui() {
		guiLeft = (gui.width - xSize) / 2;
		guiTop = (gui.height - ySize) / 2;

		buttonList.clear();
		//buttonList.add(new GuiButton(1, width / 2 - 3, height / 2 + 74, 80, 20, "02"));
		//buttonList.add(new GuiButton(2, width / 2 - 92, height / 2 + 74, 80, 20, "01"));
		buttonList.add(new GuiButton(1, guiLeft - 20, guiTop + 2, 20, 20, "01"));
		buttonList.add(new GuiButton(2, guiLeft - 20, guiTop + 22, 20, 20, "02"));

		list_icon_element.clear();
		list_icon_element.add(new Knowledge(new ItemStack(Blocks.crafting_table), 0, 0 - 40, "Руки не сломай."));
		list_icon_element.add(new Knowledge(new ItemStack(Blocks.grass), 0 + 30, 0 - 40, "Землю копал?"));
		list_icon_element.add(new Knowledge(new ItemStack(Blocks.sapling), 0 + 60, 0 - 40, "Дерево выростил?"));
		list_icon_element.add(new Knowledge(new ItemStack(Blocks.log), 0 + 90, 0 - 40, "Не будь бревном."));

		list_icon_element.add(new Knowledge(new ItemStack(Blocks.end_portal), 0 - 520, 0 - 440, "Что тут ты забыл?"));
		list_icon_element.add(new Knowledge(new ItemStack(Items.nether_star), 0 - 480, 0 - 440, "?"));
	}

	public int offsetX() {
		return offsetX;
	}

	public int offsetY() {
		return offsetY;
	}

	@Override
	public void mouseClicked(int mouseX, int mouseY, int state) {
		if (state == 0) {
			for (Knowledge icon : list_icon_element) {
				if (icon.mousePressed(icon.x + offsetX, icon.y + offsetY, mouseX, mouseY)) {
					gui.mc.getSoundHandler().playSound(PositionedSoundRecord.func_147674_a(new ResourceLocation("gui.button.press"), 1.0F));
					icon.action();
				}
			}
			for (GuiButton gb : buttonList)
				if (gb.mousePressed(gui.mc, mouseX, mouseY)) actionPerformed(gb);
		}
	}

	private void actionPerformed(GuiButton gb) {
		if (gb.enabled) {
			switch(gb.id) {
			case 0:
				gui.mc.displayGuiScreen(null);
				break;
			case 1:
				gui.page(new PageTest(gui));
				break;
			case 2:
				gui.page(new PageScroll(gui));
				break;
			}
		}
	}

	@Override
	public void handleMouseInput() {
		int i = Mouse.getEventDWheel();
		/*
		if (i != 0) {
			if (i > 0 && currentScroll > 0) currentScroll -= 10;
			if (i < 0 && currentScroll < 184 - 18) currentScroll += 10;
		}
		 */
	}

	@Override
	public void draw(int mouseX, int mouseY, float parTick) {
		boolean flag = Mouse.isButtonDown(0);

		int mouseXoffset = mouseX - guiLeft;
		int mouseYoffset = mouseY - guiTop;

		if (mouseXoffset >= 8 && mouseXoffset <= xSize - 8 * 2 && mouseYoffset >= 8 && mouseYoffset <= ySize - 8 * 2) {
			if (flag) {
				offsetX -= last_mouseX - mouseX;
				offsetY -= last_mouseY - mouseY;
			}
		}
		/*
		if (offsetX <= -298) offsetX = -298;
		if (offsetX >= 298) offsetX = 298;

		if (offsetY <= -309) offsetY = -309;
		if (offsetY >= 309) offsetY = 309;
		 */
		last_mouseX = mouseX;
		last_mouseY = mouseY;

		gui.mc.fontRenderer.drawStringWithShadow("offsetX = " + offsetX, 4, 4, 0xFFFFFF);
		gui.mc.fontRenderer.drawStringWithShadow("offsetY = " + offsetY, 4, 4 + 12, 0xFFFFFF);

		GL11.glPushMatrix();
		GL11.glDepthFunc(GL11.GL_GEQUAL);
		GL11.glPushMatrix();
		GL11.glTranslatef(0, 0, -200);

		//Основание на котором будут видны текстуры, а так-же это задний фон.
		gui.mc.getTextureManager().bindTexture(texture);
		gui.drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glDepthFunc(GL11.GL_LEQUAL);

		//Всякие эллементы, которые будут видны на заднем фоне (Текст не проподает)
		GL11.glPushMatrix();
		//GL11.glTranslatef(width / 2, height / 2, 0);
		GL11.glPushMatrix();
		//GL11.glTranslatef(((float)offsetX / 2F) + (((float)mouseX / (float)width) * 10F), ((float)offsetY / 2F) + (((float)mouseY / (float)height) * 10F), 0);
		GL11.glTranslatef((float)offsetX / 2F, (float)offsetY / 2F, 0);

		gui.mc.getTextureManager().bindTexture(texture_back);
		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawingQuads();
		tessellator.addVertexWithUV(-256D, 256D, (double)gui.zLevel(), 0D, 1D);
		tessellator.addVertexWithUV(256D, 256D, (double)gui.zLevel(), 1D, 1D);
		tessellator.addVertexWithUV(256D, -256D, (double)gui.zLevel(), 1D, 0D);
		tessellator.addVertexWithUV(-256D, -256D, (double)gui.zLevel(), 0D, 0D);
		tessellator.draw();
		GL11.glPopMatrix();

		GL11.glPushMatrix();
		GL11.glTranslatef(offsetX, offsetY, 0);

		gui.mc.getTextureManager().bindTexture(texture);
		//drawTexturedModalRect(offsetX, offsetY, 0, 236, 20, 20);

		for (Knowledge icon : list_icon_element) {
			icon.hover = mouseX >= icon.x + offsetX && mouseY >= icon.y + offsetY && mouseX < icon.x + offsetX + 20 && mouseY < icon.y + offsetY + 20;
			int k = icon.getHoverState(icon.hover);
			gui.mc.getTextureManager().bindTexture(texture);
			gui.drawTexturedModalRect(icon.x, icon.y, 0 + k * 20, 236, 20, 20);
		}

		for (Knowledge icon : list_icon_element) {
			GL11.glDisable(GL11.GL_LIGHTING);
			gui.renderitem.renderItemAndEffectIntoGUI(gui.mc.fontRenderer, gui.mc.getTextureManager(), icon.icon, icon.x + 2, icon.y + 2);
			GL11.glDisable(GL11.GL_LIGHTING);
		}

		gui.mc.fontRenderer.drawString("Hello World!", 0, 0, 0xFFFFFF);
		gui.mc.fontRenderer.drawString("Ни чего умного не смог придумать.", 0, 16, 0xFFFFFF);
		gui.mc.fontRenderer.drawString("А ты на что смотришь?", 0, 26, 0xFFFFFF);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
		//

		GL11.glDisable(GL11.GL_DEPTH_TEST);

		gui.mc.getTextureManager().bindTexture(texture);
		gui.drawTexturedModalRect(guiLeft, guiTop, 0, 220, xSize, 8);//Передний фон, рамка (верх)
		gui.drawTexturedModalRect(guiLeft, guiTop + ySize - 8, 0, 228, xSize, 8);//Передний фон, рамка (низ)
		gui.drawTexturedModalRect(guiLeft, guiTop + 8, 230, 0, 8, ySize - 8 * 2);//Передний фон, рамка (лево)
		gui.drawTexturedModalRect(guiLeft + xSize - 8, guiTop + 8, 238, 0, 8, ySize - 8 * 2);//Передний фон, рамка (право)

		for (Knowledge icon : list_icon_element) {
			if (icon.hover) {
				gui.drawHoveringText(icon.getDisplayString(), mouseX, mouseY, gui.mc.fontRenderer);
			}
		}
		GL11.glDisable(GL11.GL_LIGHTING);

		GL11.glEnable(GL11.GL_BLEND);
		GL11.glPopMatrix();

		GL11.glDepthFunc(GL11.GL_LEQUAL);
		GL11.glDisable(GL11.GL_DEPTH_TEST);

		//super.drawScreen(mouseX, mouseY, parTick);
		for (GuiButton gb : this.buttonList)
			gb.drawButton(gui.mc, mouseX, mouseY);

		GL11.glPopMatrix();
	}

}
