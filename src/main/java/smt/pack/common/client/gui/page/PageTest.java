package smt.pack.common.client.gui.page;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import smt.pack.common.client.gui.BookGui;

public class PageTest extends Page {

	static final ResourceLocation
	texture = new ResourceLocation("textures/gui/book.png");

	int
	xSize = 142 * 2,
	ySize = 181,
	guiLeft,
	guiTop;

	public PageTest(BookGui gui) {
		super(gui);
		initGui();
	}

	@Override
	public void initGui() {
		guiLeft = (gui.width - xSize) / 2;
		guiTop = (gui.height - ySize) / 2;
	}

	@Override
	public void handleMouseInput() {
		int i = Mouse.getEventDWheel();
		/*
		if (i != 0) {
			if (i > 0 && offsetY > 0) offsetY -= 10;
			if (i < 0 && offsetY < 184 - 18) offsetY += 10;
		}
		 */
	}

	@Override
	public void draw(int mouseX, int mouseY, float parTick) {
		/*
		boolean flag;
		int mouseXoffset = mouseX - guiLeft;
		int mouseYoffset = mouseY - guiTop;
		if (mouseXoffset >= 183 && mouseXoffset <= 183 + 12 && mouseYoffset >= 17 && mouseYoffset <= 17 + 173) {
			if (flag) isScrolling = true;
		}

		if (!flag) isScrolling = false;

		if (isScrolling && last_mouseY != 0) {
			offsetY -= last_mouseY - mouseY;
		}
		 */

		gui.mc.getTextureManager().bindTexture(texture);
		gui.drawTexturedModalRect(gui.width / 2, (gui.height - ySize) / 2, 24, 0, xSize / 2, ySize);

		float f = 0.00390625F;
		float f1 = 0.00390625F;
		Tessellator tessellator = Tessellator.instance;
		tessellator.startDrawingQuads();
		tessellator.addVertexWithUV((double)((gui.width / 2) - xSize / 2),	(double)((gui.height - ySize) / 2 + ySize),	(double)gui.zLevel(), (double)((float)(24 + xSize / 2) * f), (double)((float)(0 + ySize) * f1));
		tessellator.addVertexWithUV((double)(gui.width / 2),				(double)((gui.height - ySize) / 2 + ySize),	(double)gui.zLevel(), (double)((float)(24 + 0) * f), (double)((float)(0 + ySize) * f1));
		tessellator.addVertexWithUV((double)(gui.width / 2),				(double)((gui.height - ySize) / 2 + 0),		(double)gui.zLevel(), (double)((float)(24 + 0) * f), (double)((float)(0 + 0) * f1));
		tessellator.addVertexWithUV((double)((gui.width / 2) - xSize / 2),	(double)((gui.height - ySize) / 2 + 0),		(double)gui.zLevel(), (double)((float)(24 + xSize / 2) * f), (double)((float)(0 + 0) * f1));
		tessellator.draw();

		/*
		gui.drawTexturedModalRect(guiLeft + 183, guiTop + 17 + offsetY, 200, 0, 12, 7);

		if (offsetY <= 0) offsetY = 0;
		if (offsetY >= 184 - 18) offsetY = 184 - 18;
		 */
		GL11.glPushMatrix();
		//GL11.glTranslatef(0, offsetY, 0);

		RenderHelper.enableGUIStandardItemLighting();
		gui.renderitem.renderItemAndEffectIntoGUI(gui.mc.fontRenderer, gui.mc.getTextureManager(), new ItemStack(Items.stick), guiLeft + 16, guiTop + 38);
		gui.renderitem.renderItemAndEffectIntoGUI(gui.mc.fontRenderer, gui.mc.getTextureManager(), new ItemStack(Items.nether_star), guiLeft + 32, guiTop + 38);
		RenderHelper.disableStandardItemLighting();

		gui.mc.fontRenderer.drawString("Page Test", guiLeft + 16, guiTop + 16, 0x000000);
		//gui.mc.fontRenderer.drawString("offsetY = " + offsetY, guiLeft + 16, guiTop + 16 + 12, 0x000000);

		GL11.glPopMatrix();

	}

}
