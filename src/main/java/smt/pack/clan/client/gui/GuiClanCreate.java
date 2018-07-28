package smt.pack.clan.client.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import smt.pack.clan.SMTClan;
import smt.pack.clan.packet.MessageClanCreate;

public class GuiClanCreate extends GuiScreen {

	private static final ResourceLocation clanGuiTextures = new ResourceLocation(SMTClan.MODID, "textures/gui/clans.png");

	private int
	xSize = 234,
	ySize = 234
	;

	private GuiButton
	btn_close,
	btn_create
	;

	private GuiTextField clanName;

	public GuiClanCreate() {

	}

	@Override
	public void initGui() {
		Keyboard.enableRepeatEvents(true);
		int offsetX = (width - xSize) / 2;
		int offsetY = (height - ySize) / 2;
		/*StatCollector.translateToLocal(SMTTechnology.MODID + ".button.close")*/
		buttonList.clear();
		buttonList.add(btn_close = new GuiButton(0, offsetX + xSize - 20, offsetY, 20, 20, "x"));
		buttonList.add(btn_close = new GuiButton(1, offsetX + 20, offsetY + ySize - 20, 40, 20,
				StatCollector.translateToLocal(SMTClan.MODID + ".create")));


		clanName = new GuiTextField(fontRendererObj, offsetX + 28, offsetY + 11 + 11 * 1, 90, fontRendererObj.FONT_HEIGHT);
		clanName.setMaxStringLength(15);
		//clanName.setEnableBackgroundDrawing(false);
		//clanName.setText("");
		//clanName.setVisible(true);
		//clanName.setCanLoseFocus(false);
		//clanName.setFocused(true);
		//clanName.setVisible(false);
		clanName.setTextColor(16777215);


	}

	@Override
	public void onGuiClosed() {
		//super.onGuiClosed();
		Keyboard.enableRepeatEvents(false);
	}

	@Override
	public void updateScreen() {

	}

	@Override
	public void actionPerformed(GuiButton button) {
		if (button.enabled) {
			switch(button.id) {
			case 0:
				mc.displayGuiScreen((GuiScreen)null);
				break;
			case 1:
				MessageClanCreate mess = new MessageClanCreate();
				mess.clanName = clanName.getText();
				SMTClan.network.sendToServer(mess);
				break;
			}
		}
	}

	public boolean doesGuiPauseGame() {
		return false;
	}

	@Override
	public void keyTyped(char symbol, int key) {
		if (key == 1) mc.displayGuiScreen((GuiScreen)null);
		if (clanName.textboxKeyTyped(symbol, key)) {
			//this.updateCreativeSearch();
		} else {
			super.keyTyped(symbol, key);
		}
	}

	@Override
	public void mouseClicked(int mouseX, int mouseY, int button) {
		super.mouseClicked(mouseX, mouseY, button);
		clanName.mouseClicked(mouseX, mouseY, button);
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float parTick) {
		drawDefaultBackground();

		int offsetX = (width - xSize) / 2;
		int offsetY = (height - ySize) / 2;

		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.getTextureManager().bindTexture(clanGuiTextures);
		drawTexturedModalRect(offsetX, offsetY, 0, 0, xSize, ySize);

		clanName.drawTextBox();

		super.drawScreen(mouseX, mouseY, parTick);

		//RenderHelper.disableStandardItemLighting();
		drawCenteredString(fontRendererObj, (
				StatCollector.translateToLocal(SMTClan.MODID + ".clan.crete")
				), width / 2, offsetY + 4, 16777215);
		drawString(fontRendererObj, "001", offsetX + 9, offsetY + 11 + 11 * 1, 16777215);
		drawString(fontRendererObj, "002", offsetX + 9, offsetY + 11 + 11 * 2, 16777215);
		drawString(fontRendererObj, "003", offsetX + 9, offsetY + 11 + 11 * 3, 16777215);
		//RenderHelper.enableGUIStandardItemLighting();
	}

}
