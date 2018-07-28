package smt.pack.common.client.gui.page;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import smt.pack.common.SMTCommon;
import smt.pack.common.client.gui.BookGui;
import smt.pack.common.util.UtilString;

public class PageScroll extends Page {

	static final ResourceLocation
	texture = new ResourceLocation(SMTCommon.MODID, "textures/gui/scroll.png");
	int
	xSize = 200,
	ySize = 200,
	guiLeft,
	guiTop,
	//offsetX = 0,
	offsetY = 0,
	//last_mouseX,
	last_mouseY;
	String text = "Hello World!\n\n"
	+ "\tTest messages to check the processing of this text. Blah blah blah... And so on. etc. I do not know what to add.\n\n"
	+ "\tТестовое сообщения для проверки обработки этого текста. Бла бла бла... И т.д. и т.п. Не знаю что ещё добавить.\n\n"
	+ "\tUh ... Well, how are you? Do you really want to read this text? Yes? Well, then good luck to you.\n\n"
	+ "\tЭм... Ну как дела? Ты действительно хочешь читать этот текст? Да? Ну, тогда удачи тебе.\n\n"
	+ "SPAM:\n"
	+ "* СПАМ!\n"
	+ "* SPAM\n"
	+ "* СПАМ!\n"
	+ "* SPAM\n"
	+ "* СПАМ!\n"
	+ "* SPAM\n"
	+ "* СПАМ!\n"
	+ "* SPAM\n"
	+ "* СПАМ!";
	List<String> sb = new ArrayList<String>();

	public PageScroll(BookGui gui) {
		super(gui);
		initGui();
	}

	@Override
	public void initGui() {
		guiLeft = (gui.width - xSize) / 2;
		guiTop = (gui.height - ySize) / 2;
		sb = UtilString.unname2(text, Minecraft.getMinecraft().fontRenderer, 170);
	}
	/*
	public int offsetX() {
		return offsetX;
	}
	 */
	public int offsetY() {
		return offsetY;
	}

	@Override
	public void mouseClicked(int mouseX, int mouseY, int state) {

	}

	@Override
	public void handleMouseInput() {
		int i = Mouse.getEventDWheel();

		if (i != 0) {
			if (i > 0) offsetY -= 10;
			if (i < 0) offsetY += 10;
		}

	}

	@Override
	public void draw(int mouseX, int mouseY, float parTick) {
		boolean flag = Mouse.isButtonDown(0);

		int mouseXoffset = mouseX - guiLeft;
		int mouseYoffset = mouseY - guiTop;

		if (mouseXoffset >= 184 && mouseXoffset <= 184 + 12 && mouseYoffset >= 17 && mouseYoffset <= 17 + 174) {
			if (flag) {
				offsetY -= last_mouseY - mouseY;
			}
		}

		/*
		if (offsetX <= -298) offsetX = -298;
		if (offsetX >= 298) offsetX = 298;
		 */
		if (offsetY < 0) offsetY = 0;
		//else if (offsetY >= 200) offsetY = 200;

		//last_mouseX = mouseX;
		last_mouseY = mouseY;

		//gui.mc.fontRenderer.drawStringWithShadow("offsetX = " + offsetX, 4, 4, 0xFFFFFF);
		gui.mc.fontRenderer.drawStringWithShadow("offsetY = " + offsetY, 4, 4 + 12, 0xFFFFFF);

		GL11.glPushMatrix();
		GL11.glDepthFunc(GL11.GL_GEQUAL);
		GL11.glPushMatrix();
		GL11.glTranslatef(0, 0, -200);

		//Основание на котором будут видны текстуры, а так-же это задний фон.
		gui.mc.getTextureManager().bindTexture(texture);
		//gui.drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		GL11.glDisable(GL11.GL_TEXTURE_2D);
		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawingQuads();
		tessellator.setColorOpaque_I(0x757575);
		tessellator.addVertex((double)guiLeft,				(double)(guiTop + ySize),	(double)gui.zLevel());
		tessellator.addVertex((double)(guiLeft + xSize),	(double)(guiTop + ySize),	(double)gui.zLevel());
		tessellator.addVertex((double)(guiLeft + xSize),	(double)guiTop,				(double)gui.zLevel());
		tessellator.addVertex((double)guiLeft,				(double)guiTop,				(double)gui.zLevel());
		tessellator.draw();
		GL11.glEnable(GL11.GL_TEXTURE_2D);

		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glDepthFunc(GL11.GL_LEQUAL);

		//Всякие эллементы, которые будут видны на заднем фоне (Текст не проподает)
		GL11.glPushMatrix();
		GL11.glTranslatef(/*offsetX*/0, -offsetY, 0);

		gui.mc.getTextureManager().bindTexture(texture);
		//drawTexturedModalRect(offsetX, offsetY, 0, 236, 20, 20);

		for (int i = 0; i < sb.size(); ++i) {
			gui.mc.fontRenderer.drawString(sb.get(i), guiLeft + 10, guiTop + 20 + (10 * i), 0xFFFFFF);
		}

		GL11.glPopMatrix();
		//

		GL11.glDisable(GL11.GL_DEPTH_TEST);

		gui.mc.getTextureManager().bindTexture(texture);
		GL11.glEnable(GL11.GL_BLEND);
		gui.drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		GL11.glDisable(GL11.GL_BLEND);
		gui.drawTexturedModalRect(guiLeft + 183, guiTop + 17 + offsetY, 200, 0, 12, 7);

		GL11.glPopMatrix();

		GL11.glDepthFunc(GL11.GL_LEQUAL);
		GL11.glDisable(GL11.GL_DEPTH_TEST);

		GL11.glPopMatrix();
	}

}
