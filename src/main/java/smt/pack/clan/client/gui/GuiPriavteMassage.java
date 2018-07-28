package smt.pack.clan.client.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.util.ChatAllowedCharacters;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import smt.pack.clan.SMTClan;
import smt.pack.clan.packet.MessagePriavteMassageSend;

public class GuiPriavteMassage extends net.minecraft.client.gui.GuiScreen {

	private static final ResourceLocation clanGuiTextures = new ResourceLocation(SMTClan.MODID, "textures/gui/clans.png");

	private int
	xSize = 234,
	ySize = 234
	;

	private GuiButton
	btn_close,
	btn_create
	;

	private GuiTextField username;
	private boolean isEditText;
	private String text = "";

	public GuiPriavteMassage() {

	}

	@Override
	public void initGui() {
		this.buttonList.clear();
		Keyboard.enableRepeatEvents(true);
		int offsetX = (width - xSize) / 2;
		int offsetY = (height - ySize) / 2;
		/*StatCollector.translateToLocal(SMTTechnology.MODID + ".button.close")*/
		buttonList.add(btn_close = new GuiButton(0, offsetX + xSize - 20, offsetY, 20, 20, "x"));
		buttonList.add(btn_close = new GuiButton(1, offsetX + 9, offsetY + ySize - 24, 40, 20,
				StatCollector.translateToLocal(SMTClan.MODID + ".private_message.send")));


		username = new GuiTextField(fontRendererObj, offsetX + 9, offsetY + 11 * 3, 90, fontRendererObj.FONT_HEIGHT);
		username.width = 218;
		username.setMaxStringLength(255);
		username.setTextColor(16777215);

		//text = new GuiTextField(fontRendererObj, offsetX + 9, offsetY + 11 * 5, 90, fontRendererObj.FONT_HEIGHT);

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
				MessagePriavteMassageSend mess = new MessagePriavteMassageSend();
				mess.username = username.getText();
				mess.text = text;
				SMTClan.network.sendToServer(mess);
				mc.displayGuiScreen((GuiScreen)null);
				break;
			}
		}
	}

	public boolean doesGuiPauseGame() {
		return false;
	}

	@Override
	public void keyTyped(char symbol, int key) {
		System.out.println(key);
		if (key == 1) mc.displayGuiScreen((GuiScreen)null);
		if (username.textboxKeyTyped(symbol, key)) {

		} else if (isEditText) {
			if (ChatAllowedCharacters.isAllowedCharacter(symbol)) {
				text = text + Character.toString(symbol);
			} else if (key == 28) {
				text += "\n\n";
			} else if (text.length() > 0 && key == 14) {
				text = text.substring(0, text.length() - 1);
			}
			if (key != 14 && text.length() % 36 == 0) text += "\n";
		} else super.keyTyped(symbol, key);
	}

	@Override
	public void mouseClicked(int mouseX, int mouseY, int button) {
		super.mouseClicked(mouseX, mouseY, button);

		int offsetX = (width - xSize) / 2;
		int offsetY = (height - ySize) / 2;

		username.mouseClicked(mouseX, mouseY, button);
		isEditText = mouseX >= offsetX + 9 && mouseX < offsetX + xSize - 9 && mouseY >= offsetY + 11 * 5 && mouseY < offsetY + ySize - 24;
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float parTick) {
		drawDefaultBackground();

		int offsetX = (width - xSize) / 2;
		int offsetY = (height - ySize) / 2;

		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.getTextureManager().bindTexture(clanGuiTextures);
		drawTexturedModalRect(offsetX, offsetY, 0, 0, xSize, ySize);

		username.drawTextBox();

		super.drawScreen(mouseX, mouseY, parTick);

		//RenderHelper.disableStandardItemLighting();
		drawCenteredString(fontRendererObj, (
				StatCollector.translateToLocal(SMTClan.MODID + ".private_message.crete_private_message")
				), width / 2, offsetY + 4, 16777215);
		drawString(fontRendererObj, "Username:", offsetX + 9, offsetY + 11 * 2, 16777215);
		drawString(fontRendererObj, "Text:", offsetX + 9, offsetY + 11 * 4, 16777215);
		String[] textsc = text.replace("\n\n", "\n").split("\n");
		for (int i = 0; i < textsc.length; ++i)
			drawString(fontRendererObj, textsc[i], offsetX + 9, offsetY + 11 * (5 + i), 16777215);
		//RenderHelper.enableGUIStandardItemLighting();
	}

}
