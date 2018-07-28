package smt.pack.common.client.gui;

import java.util.List;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatAllowedCharacters;
import smt.pack.common.client.gui.page.Page;
import smt.pack.common.client.gui.page.PageMain;
import smt.pack.common.client.gui.page.PageTest;

@SideOnly(Side.CLIENT)
public class BookGui extends GuiScreen {

	public static final RenderItem renderitem = new RenderItem();
	Page page;

	@Deprecated
	public BookGui() {}

	public BookGui(Page page) {
		page(page);
	}

	public void page(Page page) {
		if (page == null) this.page = new PageMain(this);
		else this.page = page;
	}

	@Override
	public void initGui() {
		//Keyboard.enableRepeatEvents(true);
		if (page != null) page.initGui();

	}

	@Override
	public void onGuiClosed() {
		Keyboard.enableRepeatEvents(false);
	}

	@Override
	public void actionPerformed(GuiButton btn) {

	}

	@Override
	public void keyTyped(char character, int key) {
		super.keyTyped(character, key);
		switch (key) {
		case Keyboard.KEY_BACK:
			/*
			String s = this.func_146456_p();

			if (s.length() > 0) {
				this.func_146457_a(s.substring(0, s.length() - 1));
			}
			 */
			break;
		case Keyboard.KEY_RETURN:
		case Keyboard.KEY_NUMPADENTER:
			//this.func_146459_b("\n");
			break;
		default:
			//if (ChatAllowedCharacters.isAllowedCharacter(character)) {
				//this.func_146459_b(Character.toString(p_146463_1_));
			//}
			break;
		}

		if (page != null) page.keyTyped(character, key);
		//Keyboard.areRepeatEventsEnabled()
	}

	@Override
	public void mouseClicked(int mouseX, int mouseY, int state) {
		super.mouseClicked(mouseX, mouseY, state);
		if (page != null) page.mouseClicked(mouseX, mouseY, state);
	}

	@Override
	public void handleMouseInput() {
		super.handleMouseInput();
		if (page != null) page.handleMouseInput();
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float parTick) {
		drawDefaultBackground();
		if (page != null) {
			page.draw(mouseX, mouseY, parTick);
			super.drawScreen(mouseX, mouseY, parTick);
		}
	}

	@Override
	public boolean doesGuiPauseGame() {
		return true;
	}

	@Override
	public void renderToolTip(ItemStack itemStack, int mouseX, int mouseY) {
		super.renderToolTip(itemStack, mouseX, mouseY);
	}

	@Override
	public void drawHoveringText(List list, int mouseX, int mouseY, FontRenderer font) {
		super.drawHoveringText(list, mouseX, mouseY, font);
	}

	public float zLevel() {
		return zLevel;
	}

}
