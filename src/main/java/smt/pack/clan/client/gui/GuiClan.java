package smt.pack.clan.client.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import smt.pack.clan.Clan;
import smt.pack.clan.SMTClan;
import smt.pack.clan.packet.MessageSyncClans;

public class GuiClan extends net.minecraft.client.gui.GuiScreen {

	private static final ResourceLocation clanGuiTextures = new ResourceLocation(SMTClan.MODID, "textures/gui/clans.png");

	private int
	xSize = 234,
	ySize = 234
	;

	private GuiButton
	btn_close,
	btn_create,
	btn_remove
	;

	private GuiTextField searchField;

	public GuiClan() {

	}

	@Override
	public void initGui() {
		buttonList.clear();
		int offsetX = (width - xSize) / 2;
		int offsetY = (height - ySize) / 2;
		/*StatCollector.translateToLocal(SMTTechnology.MODID + ".button.close")*/
		buttonList.add(btn_close = new GuiButton(0, offsetX + xSize - 20, offsetY, 20, 20, "x"));
		buttonList.add(btn_create = new GuiButton(1, offsetX + 20, offsetY + ySize - 20, 40, 20,
				StatCollector.translateToLocal(SMTClan.MODID + ".create")));
		buttonList.add(btn_remove = new GuiButton(2, offsetX + 60, offsetY + ySize - 20, 40, 20,
				StatCollector.translateToLocal(SMTClan.MODID + ".remove")));

		searchField = new GuiTextField(fontRendererObj, offsetX + (xSize - 90) / 2, offsetY + 10 + 11 * 1, 90, fontRendererObj.FONT_HEIGHT);
		searchField.setMaxStringLength(15);

		SMTClan.network.sendToServer(new MessageSyncClans());
	}

	@Override
	public void onGuiClosed() {

	}

	@Override
	public void updateScreen() {

	}

	@Override
	public void actionPerformed(GuiButton button) {
		if (button.enabled) {
			switch(button.id) {
			case 0:{
				mc.displayGuiScreen((GuiScreen)null);
				break;
			}
			case 1:{
				mc.displayGuiScreen(new GuiClanCreate());
				break;
			}
			case 2:{
				mc.displayGuiScreen(new GuiClanRemove());
				break;
			}
			}
		}
	}

	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}

	@Override
	public void keyTyped(char symbol, int key) {
		if (key == 1) mc.displayGuiScreen((GuiScreen)null);
	}

	@Override
	public void mouseClicked(int mouseX, int mouseY, int button) {
		super.mouseClicked(mouseX, mouseY, button);
		searchField.mouseClicked(mouseX, mouseY, button);
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float parTick) {
		drawDefaultBackground();

		int offsetX = (width - xSize) / 2;
		int offsetY = (height - ySize) / 2;

		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.getTextureManager().bindTexture(clanGuiTextures);
		drawTexturedModalRect(offsetX, offsetY, 0, 0, xSize, ySize);

		searchField.drawTextBox();

		super.drawScreen(mouseX, mouseY, parTick);

		//RenderHelper.disableStandardItemLighting();
		drawCenteredString(fontRendererObj, (
				StatCollector.translateToLocal(SMTClan.MODID + ".clans")
				), width / 2, offsetY + 4, 16777215);
		if (!Clan.INSTANCE.getClans().isEmpty()) {
			for (int i = 0; i < Clan.INSTANCE.getClans().size(); ++i) {
				Clan.ClanGroup clan_group = Clan.INSTANCE.getClans().get(i);
				drawString(fontRendererObj, clan_group.getClanName() + ", Commander \"" + (clan_group.getCommander() != null ? clan_group.getCommander().getName() : "None") + "\".", offsetX + 9, offsetY + 11 + 11 * (i + 2), 16777215);
			}
		} else 
			drawString(fontRendererObj, "Not", offsetX + 9, offsetY + 11 + 11 * 2, 16777215);
		//RenderHelper.enableGUIStandardItemLighting();

	}

}
