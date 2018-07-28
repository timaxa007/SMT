package smt.pack.technology.client.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import smt.pack.technology.SMTTechnology;
import smt.pack.technology.network.MessageOpenGui;
import smt.pack.technology.network.MessageSyncNbFurnaceMobile;
import smt.pack.technology.network.MessageTelephoneCall;
import smt.pack.technology.network.MessageTelephoneDrop;

public class ItemTelephoneGui extends GuiScreen {

	private static final ResourceLocation telephoneGuiTextures = new ResourceLocation(SMTTechnology.MODID, "textures/gui/telephone1.png");

	private int
	xSize = 108,
	ySize = 256
	;

	private ButtonC
	btn_center
	;

	private ButtonP
	btn_left, btn_right,
	btn_up, btn_down,
	btn_1, btn_2, btn_3,
	btn_4, btn_5, btn_6,
	btn_7, btn_8, btn_9,
	btn_i, btn_0, btn_o
	;

	ItemStack item = null;

	public ItemTelephoneGui(ItemStack item) {
		this.item = item;
	}

	@Override
	public void initGui() {
		//Keyboard.enableRepeatEvents(true);
		buttonList.clear();
		int offsetX = (width - xSize) / 2;
		int offsetY = (height - ySize) / 2;
		/*StatCollector.translateToLocal(SMTTechnology.MODID + ".button.close")*/
		buttonList.add(btn_center = new ButtonC(0, offsetX + 39, offsetY + 142, "x"));
		buttonList.add(btn_center = new ButtonC(1, offsetX + 39, offsetY + 142, "x"));
		buttonList.add(btn_center = new ButtonC(2, offsetX + 39, offsetY + 142, "x"));
		buttonList.add(btn_center = new ButtonC(3, offsetX + 39, offsetY + 142, "x"));
		buttonList.add(btn_center = new ButtonC(4, offsetX + 39, offsetY + 142, "x"));

		buttonList.add(btn_left = new ButtonP(5, offsetX + 7, offsetY + 139, "<"));
		buttonList.add(btn_right = new ButtonP(6, offsetX + 71, offsetY + 139, ">"));

		buttonList.add(btn_up = new ButtonP(7, offsetX + 7, offsetY + 139 + 19 * 1, "+"));
		buttonList.add(btn_down = new ButtonP(8, offsetX + 71, offsetY + 139 + 19 * 1, "-"));

		buttonList.add(btn_1 = new ButtonP(9, offsetX + 7, offsetY + 139 + 19 * 2, "1"));
		buttonList.add(btn_2 = new ButtonP(10, offsetX + 39, offsetY + 139 + 19 * 2, "2"));
		buttonList.add(btn_3 = new ButtonP(11, offsetX + 71, offsetY + 139 + 19 * 2, "3"));

		buttonList.add(btn_4 = new ButtonP(12, offsetX + 7, offsetY + 139 + 19 * 3, "4"));
		buttonList.add(btn_5 = new ButtonP(13, offsetX + 39, offsetY + 139 + 19 * 3, "5"));
		buttonList.add(btn_6 = new ButtonP(14, offsetX + 71, offsetY + 139 + 19 * 3, "6"));

		buttonList.add(btn_7 = new ButtonP(15, offsetX + 7, offsetY + 139 + 19 * 4, "7"));
		buttonList.add(btn_8 = new ButtonP(16, offsetX + 39, offsetY + 139 + 19 * 4, "8"));
		buttonList.add(btn_9 = new ButtonP(17, offsetX + 71, offsetY + 139 + 19 * 4, "9"));

		buttonList.add(btn_i = new ButtonP(18, offsetX + 7, offsetY + 139 + 19 * 5, "*"));
		buttonList.add(btn_0 = new ButtonP(19, offsetX + 39, offsetY + 139 + 19 * 5, "0"));
		buttonList.add(btn_o = new ButtonP(20, offsetX + 71, offsetY + 139 + 19 * 5, "#"));

	}

	@Override
	public void onGuiClosed() {
		//Keyboard.enableRepeatEvents(false);
	}

	@Override
	public void updateScreen() {

	}

	@Override
	public void actionPerformed(GuiButton button) {
		if (button.enabled) {
			switch(button.id) {
			case 0:{
				break;
			}
			case 1:{
				break;
			}
			case 5:{
				SMTTechnology.network.sendToServer(new MessageOpenGui(0));
				break;
			}
			case 6:{
				SMTTechnology.network.sendToServer(new MessageSyncNbFurnaceMobile());
				SMTTechnology.network.sendToServer(new MessageOpenGui(1));
				break;
			}
			case 7:{
				SMTTechnology.network.sendToServer(new MessageTelephoneCall(1234));
				break;
			}
			case 8:{
				SMTTechnology.network.sendToServer(new MessageTelephoneDrop());
				break;
			}
			}
		}
	}

	public boolean doesGuiPauseGame() {
		return false;
	}

	@Override
	public void keyTyped(char symbol, int key) {
		System.out.println(" - " + key + " - " + symbol);
		if (key == 1) mc.displayGuiScreen((GuiScreen)null);
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float parTick) {
		drawDefaultBackground();

		int offsetX = (width - xSize) / 2;
		int offsetY = (height - ySize) / 2;

		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		mc.getTextureManager().bindTexture(telephoneGuiTextures);
		drawTexturedModalRect(offsetX, offsetY, 0, 0, xSize, ySize);

		super.drawScreen(mouseX, mouseY, parTick);

		//RenderHelper.disableStandardItemLighting();
		drawCenteredString(fontRendererObj, (item != null ? item.getDisplayName():
			StatCollector.translateToLocal(SMTTechnology.MODID + ".text.item_for_scan_not_found")
				), width / 2, offsetY + 8, 16777215);
		drawString(fontRendererObj, "001", offsetX + 9, offsetY + 11 + 11 * 1, 16777215);
		drawString(fontRendererObj, "002", offsetX + 9, offsetY + 11 + 11 * 2, 16777215);
		drawString(fontRendererObj, "003", offsetX + 9, offsetY + 11 + 11 * 3, 16777215);
		//RenderHelper.enableGUIStandardItemLighting();

	}

}