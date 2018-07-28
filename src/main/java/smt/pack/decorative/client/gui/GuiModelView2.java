package smt.pack.decorative.client.gui;

import org.lwjgl.input.Keyboard;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import smt.pack.decorative.SMTDecorative;
import smt.pack.decorative.network.MessageSyncModelView;
import smt.pack.decorative.tile.TileEntityModelView;

public class GuiModelView2 extends GuiScreen {

	final TileEntityModelView tile;
	final GuiTextField[] inputField = new GuiTextField[9];
	final char[] allow_char = new char[]{'0','1','2','3','4','5','6','7','8','9','.','-'};
	int actField = -1;
	GuiButton
	buttonDone,
	buttonCancel;

	public float
	old_translateX, old_translateY, old_translateZ,
	old_rotateX, old_rotateY, old_rotateZ,
	old_scaleX, old_scaleY, old_scaleZ;

	public GuiModelView2(TileEntityModelView tile) {
		this.tile = tile;
		old_translateX = tile.translateX;
		old_translateY = tile.translateY;
		old_translateZ = tile.translateZ;
		old_rotateX = tile.rotateX;
		old_rotateY = tile.rotateY;
		old_rotateZ = tile.rotateZ;
		old_scaleX = tile.scaleX;
		old_scaleY = tile.scaleY;
		old_scaleZ = tile.scaleZ;
	}

	@Override
	public void initGui() {
		Keyboard.enableRepeatEvents(true);

		inputField[0] = new GuiTextField(fontRendererObj, width - 70, 4 + 14 * 1, 68, 12);
		inputField[0].setMaxStringLength(10);
		inputField[0].setText(String.valueOf(tile.translateX));

		inputField[1] = new GuiTextField(fontRendererObj, width - 70, 4 + 14 * 2, 68, 12);
		inputField[1].setMaxStringLength(10);
		inputField[1].setText(String.valueOf(tile.translateY));

		inputField[2] = new GuiTextField(fontRendererObj, width - 70, 4 + 14 * 3, 68, 12);
		inputField[2].setMaxStringLength(10);
		inputField[2].setText(String.valueOf(tile.translateZ));


		inputField[3] = new GuiTextField(fontRendererObj, width - 70, 4 + 14 * 5, 68, 12);
		inputField[3].setMaxStringLength(10);
		inputField[3].setText(String.valueOf(tile.rotateX));

		inputField[4] = new GuiTextField(fontRendererObj, width - 70, 4 + 14 * 6, 68, 12);
		inputField[4].setMaxStringLength(10);
		inputField[4].setText(String.valueOf(tile.rotateY));

		inputField[5] = new GuiTextField(fontRendererObj, width - 70, 4 + 14 * 7, 68, 12);
		inputField[5].setMaxStringLength(10);
		inputField[5].setText(String.valueOf(tile.rotateZ));


		inputField[6] = new GuiTextField(fontRendererObj, width - 70, 4 + 14 * 9, 68, 12);
		inputField[6].setMaxStringLength(10);
		inputField[6].setText(String.valueOf(tile.scaleX));

		inputField[7] = new GuiTextField(fontRendererObj, width - 70, 4 + 14 * 10, 68, 12);
		inputField[7].setMaxStringLength(10);
		inputField[7].setText(String.valueOf(tile.scaleY));

		inputField[8] = new GuiTextField(fontRendererObj, width - 70, 4 + 14 * 11, 68, 12);
		inputField[8].setMaxStringLength(10);
		inputField[8].setText(String.valueOf(tile.scaleZ));

		buttonList.clear();
		buttonList.add(buttonDone = new GuiButton(0, width - 70, 4 + 190, 60, 20, "Save"));
		buttonList.add(buttonCancel = new GuiButton(1, width - 70, 4 + 220, 60, 20, "Cancel"));
	}

	@Override
	public void onGuiClosed() {
		Keyboard.enableRepeatEvents(false);
	}

	@Override
	public void updateScreen() {
		if (actField != -1) inputField[actField].updateCursorCounter();
	}

	@Override
	public void actionPerformed(GuiButton btn) {
		if (btn.enabled) {
			switch(btn.id) {
			case 0:
				/*if (
						tile.translateX != old_translateX &&
						tile.translateY != old_translateY &&
						tile.translateZ != old_translateZ &&
						tile.rotateX != old_rotateX &&
						tile.rotateY != old_rotateY &&
						tile.rotateZ != old_rotateZ &&
						tile.scaleX != old_scaleX &&
						tile.scaleY != old_scaleY &&
						tile.scaleZ != old_scaleZ)*/
				try {
					for (int i = 0; i < inputField.length; ++i) {
						try {
							float par = Float.valueOf(inputField[i].getText().trim()).floatValue();

							if (i == 0 && par == old_translateX) continue;
							else if (i == 1 && par == old_translateY) continue;
							else if (i == 2 && par == old_translateZ) continue;
							else if (i == 3 && par == old_rotateX) continue;
							else if (i == 4 && par == old_rotateY) continue;
							else if (i == 5 && par == old_rotateZ) continue;
							else if (i == 6 && par == old_scaleX) continue;
							else if (i == 7 && par == old_scaleY) continue;
							else if (i == 8 && par == old_scaleZ) continue;
							System.out.println(" - " + i + " - " + par + ".");
							MessageSyncModelView message = new MessageSyncModelView();
							message.x = tile.xCoord;
							message.y = tile.yCoord;
							message.z = tile.zCoord;
							message.act = (byte)i;
							message.par = par;
							SMTDecorative.network.sendToServer(message);
						} catch (NumberFormatException nfe) {}
					}
					/*
					message.translateX = Float.valueOf(inputField[0].getText().trim()).floatValue();
					message.translateY = Float.valueOf(inputField[1].getText().trim()).floatValue();
					message.translateZ = Float.valueOf(inputField[2].getText().trim()).floatValue();

					message.rotateX = Float.valueOf(inputField[3].getText().trim()).floatValue();
					message.rotateY = Float.valueOf(inputField[4].getText().trim()).floatValue();
					message.rotateZ = Float.valueOf(inputField[5].getText().trim()).floatValue();

					message.scaleX = Float.valueOf(inputField[6].getText().trim()).floatValue();
					message.scaleY = Float.valueOf(inputField[7].getText().trim()).floatValue();
					message.scaleZ = Float.valueOf(inputField[8].getText().trim()).floatValue();
					 */
					mc.displayGuiScreen(null);
					mc.setIngameFocus();
				} catch (NumberFormatException nfe) {}
				break;
			case 1:
				tile.translateX = old_translateX;
				tile.translateY = old_translateY;
				tile.translateZ = old_translateZ;
				tile.rotateX = old_rotateX;
				tile.rotateY = old_rotateY;
				tile.rotateZ = old_rotateZ;
				tile.scaleX = old_scaleX;
				tile.scaleY = old_scaleY;
				tile.scaleZ = old_scaleZ;
				mc.displayGuiScreen(null);
				mc.setIngameFocus();
				break;
			}
		}
	}

	@Override
	public void keyTyped(char character, int key) {
		switch(key) {
		case Keyboard.KEY_ESCAPE:
			mc.displayGuiScreen((GuiScreen)null);
			mc.setIngameFocus();
			break;
		case Keyboard.KEY_TAB:
		case Keyboard.KEY_RETURN:
		case Keyboard.KEY_NUMPADENTER:
			++actField;
			if (actField >= inputField.length) actField = 0;
			for (int i = 0; i < inputField.length; ++i)
				inputField[i].setFocused(i == actField ? true : false);
			break;
		case Keyboard.KEY_UP:break;
		case Keyboard.KEY_DOWN:break;
		default:
			if (actField != -1) {

				if (inputField[actField].getText().equals("0")) inputField[actField].setText("");

				inputField[actField].textboxKeyTyped(character, key);

				if (inputField[actField].getText().length() > 0) {
					char[] chs = inputField[actField].getText().toCharArray();
					String text = "";
					for (char ch : chs)
						for (char c : allow_char)
							if (c == ch) text += ch;

					inputField[actField].setText(text);
				}

				if (inputField[actField].getText().length() <= 0) inputField[actField].setText("0");

			}
			break;
		}
	}

	@Override
	public void mouseClicked(int mouseX, int mouseY, int state) {
		int k = -1;
		for (int i = 0; i < inputField.length; ++i) {
			inputField[i].mouseClicked(mouseX, mouseY, state);
			boolean flag = mouseX >= inputField[i].xPosition && mouseX < inputField[i].xPosition + inputField[i].width && mouseY >= inputField[i].yPosition && mouseY < inputField[i].yPosition + inputField[i].height;
			if (flag) k = i;
		}
		actField = k;
		super.mouseClicked(mouseX, mouseY, state);
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float parTick) {
		for (GuiTextField fild : inputField) fild.drawTextBox();

		try {
			tile.translateX = Float.valueOf(inputField[0].getText().trim()).floatValue();
			tile.translateY = Float.valueOf(inputField[1].getText().trim()).floatValue();
			tile.translateZ = Float.valueOf(inputField[2].getText().trim()).floatValue();

			tile.rotateX = Float.valueOf(inputField[3].getText().trim()).floatValue();
			tile.rotateY = Float.valueOf(inputField[4].getText().trim()).floatValue();
			tile.rotateZ = Float.valueOf(inputField[5].getText().trim()).floatValue();

			tile.scaleX = Float.valueOf(inputField[6].getText().trim()).floatValue();
			tile.scaleY = Float.valueOf(inputField[7].getText().trim()).floatValue();
			tile.scaleZ = Float.valueOf(inputField[8].getText().trim()).floatValue();
		} catch (NumberFormatException nfe) {}

		mc.fontRenderer.drawStringWithShadow("Translate", width - 70, 7 + 14 * 0, 0xFFFFFF);
		mc.fontRenderer.drawStringWithShadow("x", width - 70 - 10, 5 + 14 * 1, 0xFFFFFF);
		mc.fontRenderer.drawStringWithShadow("y", width - 70 - 10, 5 + 14 * 2, 0xFFFFFF);
		mc.fontRenderer.drawStringWithShadow("z", width - 70 - 10, 5 + 14 * 3, 0xFFFFFF);

		mc.fontRenderer.drawStringWithShadow("Rotate", width - 70, 7 + 14 * 4, 0xFFFFFF);
		mc.fontRenderer.drawStringWithShadow("x", width - 70 - 10, 5 + 14 * 5, 0xFFFFFF);
		mc.fontRenderer.drawStringWithShadow("y", width - 70 - 10, 5 + 14 * 6, 0xFFFFFF);
		mc.fontRenderer.drawStringWithShadow("z", width - 70 - 10, 5 + 14 * 7, 0xFFFFFF);

		mc.fontRenderer.drawStringWithShadow("Scale", width - 70, 7 + 14 * 8, 0xFFFFFF);
		mc.fontRenderer.drawStringWithShadow("x", width - 70 - 10, 5 + 14 * 9, 0xFFFFFF);
		mc.fontRenderer.drawStringWithShadow("y", width - 70 - 10, 5 + 14 * 10, 0xFFFFFF);
		mc.fontRenderer.drawStringWithShadow("z", width - 70 - 10, 5 + 14 * 11, 0xFFFFFF);

		super.drawScreen(mouseX, mouseY, parTick);
	}

	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}

}
