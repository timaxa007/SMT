package smt.pack.decorative.client.gui;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.nbt.NBTTagCompound;
import smt.pack.decorative.SMTDecorative;
import smt.pack.decorative.network.MessageSyncModelView2;
import smt.pack.decorative.tile.TileEntityModelView;

@SideOnly(Side.CLIENT)
public class GuiModelView extends GuiScreen {

	final TileEntityModelView tile;
	final GuiTextField[] inputField = new GuiTextField[9];
	final char[] allow_char = new char[]{'0','1','2','3','4','5','6','7','8','9','.','-'};
	int actField = -1;
	GuiButton
	buttonDefault,
	buttonDone,
	buttonCancel;

	public float
	old_translateX, old_translateY, old_translateZ,
	old_rotateX, old_rotateY, old_rotateZ,
	old_scaleX, old_scaleY, old_scaleZ;

	public GuiModelView(TileEntityModelView tile) {
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

		if (inputField[0] == null) {
			inputField[0] = new GuiTextField(fontRendererObj, width - 70, 14 * 1, 68, 12);
			inputField[0].setMaxStringLength(10);
			inputField[0].setText(String.valueOf(tile.translateX));
		} else
			inputField[0].xPosition = width - 70;

		if (inputField[1] == null) {
			inputField[1] = new GuiTextField(fontRendererObj, width - 70, 14 * 2, 68, 12);
			inputField[1].setMaxStringLength(10);
			inputField[1].setText(String.valueOf(tile.translateY));
		} else
			inputField[1].xPosition = width - 70;

		if (inputField[2] == null) {
			inputField[2] = new GuiTextField(fontRendererObj, width - 70, 14 * 3, 68, 12);
			inputField[2].setMaxStringLength(10);
			inputField[2].setText(String.valueOf(tile.translateZ));
		} else
			inputField[2].xPosition = width - 70;

		if (inputField[3] == null) {
			inputField[3] = new GuiTextField(fontRendererObj, width - 70, 14 * 5, 68, 12);
			inputField[3].setMaxStringLength(10);
			inputField[3].setText(String.valueOf(tile.rotateX));
		} else
			inputField[3].xPosition = width - 70;

		if (inputField[4] == null) {
			inputField[4] = new GuiTextField(fontRendererObj, width - 70, 14 * 6, 68, 12);
			inputField[4].setMaxStringLength(10);
			inputField[4].setText(String.valueOf(tile.rotateY));
		} else
			inputField[4].xPosition = width - 70;

		if (inputField[5] == null) {
			inputField[5] = new GuiTextField(fontRendererObj, width - 70, 14 * 7, 68, 12);
			inputField[5].setMaxStringLength(10);
			inputField[5].setText(String.valueOf(tile.rotateZ));
		} else
			inputField[5].xPosition = width - 70;

		if (inputField[6] == null) {
			inputField[6] = new GuiTextField(fontRendererObj, width - 70, 14 * 9, 68, 12);
			inputField[6].setMaxStringLength(10);
			inputField[6].setText(String.valueOf(tile.scaleX));
		} else
			inputField[6].xPosition = width - 70;

		if (inputField[7] == null) {
			inputField[7] = new GuiTextField(fontRendererObj, width - 70, 14 * 10, 68, 12);
			inputField[7].setMaxStringLength(10);
			inputField[7].setText(String.valueOf(tile.scaleY));
		} else
			inputField[7].xPosition = width - 70;

		if (inputField[8] == null) {
			inputField[8] = new GuiTextField(fontRendererObj, width - 70, 14 * 11, 68, 12);
			inputField[8].setMaxStringLength(10);
			inputField[8].setText(String.valueOf(tile.scaleZ));
		} else
			inputField[8].xPosition = width - 70;

		buttonList.clear();
		buttonList.add(buttonDefault = new GuiButton(2, width - 70, 170, 60, 20, "Default"));
		buttonList.add(buttonDone = new GuiButton(0, width - 70, 192, 60, 20, "Save"));
		buttonList.add(buttonCancel = new GuiButton(1, width - 70, 214, 60, 20, "Cancel"));
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
				MessageSyncModelView2 message = new MessageSyncModelView2();

				message.x = tile.xCoord;
				message.y = tile.yCoord;
				message.z = tile.zCoord;

				message.nbt = new NBTTagCompound();

				if (tile.translateX != old_translateX) message.nbt.setFloat("tX", tile.translateX);
				if (tile.translateY != old_translateY) message.nbt.setFloat("tY", tile.translateY);
				if (tile.translateZ != old_translateZ) message.nbt.setFloat("tZ", tile.translateZ);

				if (tile.rotateX != old_rotateX) message.nbt.setFloat("rX", tile.rotateX);
				if (tile.rotateY != old_rotateY) message.nbt.setFloat("rY", tile.rotateY);
				if (tile.rotateZ != old_rotateZ) message.nbt.setFloat("rZ", tile.rotateZ);

				if (tile.scaleX != old_scaleX) message.nbt.setFloat("sX", tile.scaleX);
				if (tile.scaleY != old_scaleY) message.nbt.setFloat("sY", tile.scaleY);
				if (tile.scaleZ != old_scaleZ) message.nbt.setFloat("sZ", tile.scaleZ);

				SMTDecorative.network.sendToServer(message);

				mc.displayGuiScreen(null);
				mc.setIngameFocus();
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
			case 2:
				inputField[0].setText("0.0");
				inputField[1].setText("0.0");
				inputField[2].setText("0.0");

				inputField[3].setText("0.0");
				inputField[4].setText("0.0");
				inputField[5].setText("0.0");

				inputField[6].setText("1.0");
				inputField[7].setText("1.0");
				inputField[8].setText("1.0");
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

		mc.fontRenderer.drawStringWithShadow("Translate", width - 70, 3 + 14 * 0, 0xFFFFFF);
		mc.fontRenderer.drawStringWithShadow("x", width - 70 - 10, 1 + 14 * 1, 0xFFFFFF);
		mc.fontRenderer.drawStringWithShadow("y", width - 70 - 10, 1 + 14 * 2, 0xFFFFFF);
		mc.fontRenderer.drawStringWithShadow("z", width - 70 - 10, 1 + 14 * 3, 0xFFFFFF);

		mc.fontRenderer.drawStringWithShadow("Rotate", width - 70, 3 + 14 * 4, 0xFFFFFF);
		mc.fontRenderer.drawStringWithShadow("x", width - 70 - 10, 1 + 14 * 5, 0xFFFFFF);
		mc.fontRenderer.drawStringWithShadow("y", width - 70 - 10, 1 + 14 * 6, 0xFFFFFF);
		mc.fontRenderer.drawStringWithShadow("z", width - 70 - 10, 1 + 14 * 7, 0xFFFFFF);

		mc.fontRenderer.drawStringWithShadow("Scale", width - 70, 3 + 14 * 8, 0xFFFFFF);
		mc.fontRenderer.drawStringWithShadow("x", width - 70 - 10, 1 + 14 * 9, 0xFFFFFF);
		mc.fontRenderer.drawStringWithShadow("y", width - 70 - 10, 1 + 14 * 10, 0xFFFFFF);
		mc.fontRenderer.drawStringWithShadow("z", width - 70 - 10, 1 + 14 * 11, 0xFFFFFF);

		super.drawScreen(mouseX, mouseY, parTick);
	}

	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}

}
