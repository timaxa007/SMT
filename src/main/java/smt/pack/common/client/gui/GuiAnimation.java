package smt.pack.common.client.gui;

import java.util.ArrayList;
import java.util.Comparator;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.GuiTextField;
import smt.pack.common.animation.AnimationManager;
import smt.pack.common.animation.a3D.Animation3DCustom;
import smt.pack.common.animation.a3D.Animation3DCustom.KeyCustom;
import smt.pack.common.animation.a3D.Animation3DPlay;
import smt.pack.common.tile.TileEntityAnimation;

@SideOnly(Side.CLIENT)
public class GuiAnimation extends GuiScreen {

	final GuiTextField[] inputField = new GuiTextField[10];
	final char[] allow_char = new char[]{'0','1','2','3','4','5','6','7','8','9','.','-'};

	private TileEntityAnimation tile;
	Animation3DCustom animation;
	Animation3DPlay animation_play;

	int
	actField = -1
	;

	GuiButton
	buttonDone,
	buttonCancel,
	buttonDefault,
	buttonSet,
	buttonRemove,
	buttonPrev,
	buttonNext,
	buttonPlay,
	buttonPause
	;

	boolean
	showGUI = true
	;

	public GuiAnimation() {
		animation = new Animation3DCustom(100, false, null, null, null, null, null, null);
		animation_play = AnimationManager.playAnimation(animation);
	}

	public GuiAnimation(TileEntityAnimation tile) {
		this.tile = tile;
		this.animation = tile.animation;
		this.animation_play = tile.animation_play;
	}

	@Override
	public void initGui() {
		Keyboard.enableRepeatEvents(true);

		if (inputField[0] == null) {
			inputField[0] = new GuiTextField(fontRendererObj, width - 70, 14 * 1, 68, 12);
			inputField[0].setMaxStringLength(10);
			//inputField[0].setText(String.valueOf(tile.translateX));
		} else
			inputField[0].xPosition = width - 70;

		if (inputField[1] == null) {
			inputField[1] = new GuiTextField(fontRendererObj, width - 70, 14 * 2, 68, 12);
			inputField[1].setMaxStringLength(10);
			//inputField[1].setText(String.valueOf(tile.translateY));
		} else
			inputField[1].xPosition = width - 70;

		if (inputField[2] == null) {
			inputField[2] = new GuiTextField(fontRendererObj, width - 70, 14 * 3, 68, 12);
			inputField[2].setMaxStringLength(10);
			//inputField[2].setText(String.valueOf(tile.translateZ));
		} else
			inputField[2].xPosition = width - 70;

		if (inputField[3] == null) {
			inputField[3] = new GuiTextField(fontRendererObj, width - 70, 14 * 5, 68, 12);
			inputField[3].setMaxStringLength(10);
			//inputField[3].setText(String.valueOf(tile.rotateX));
		} else
			inputField[3].xPosition = width - 70;

		if (inputField[4] == null) {
			inputField[4] = new GuiTextField(fontRendererObj, width - 70, 14 * 6, 68, 12);
			inputField[4].setMaxStringLength(10);
			//inputField[4].setText(String.valueOf(tile.rotateY));
		} else
			inputField[4].xPosition = width - 70;

		if (inputField[5] == null) {
			inputField[5] = new GuiTextField(fontRendererObj, width - 70, 14 * 7, 68, 12);
			inputField[5].setMaxStringLength(10);
			//inputField[5].setText(String.valueOf(tile.rotateZ));
		} else
			inputField[5].xPosition = width - 70;

		if (inputField[6] == null) {
			inputField[6] = new GuiTextField(fontRendererObj, width - 70, 14 * 9, 68, 12);
			inputField[6].setMaxStringLength(10);
			//inputField[6].setText(String.valueOf(tile.scaleX));
		} else
			inputField[6].xPosition = width - 70;

		if (inputField[7] == null) {
			inputField[7] = new GuiTextField(fontRendererObj, width - 70, 14 * 10, 68, 12);
			inputField[7].setMaxStringLength(10);
			//inputField[7].setText(String.valueOf(tile.scaleY));
		} else
			inputField[7].xPosition = width - 70;

		if (inputField[8] == null) {
			inputField[8] = new GuiTextField(fontRendererObj, width - 70, 14 * 11, 68, 12);
			inputField[8].setMaxStringLength(10);
			//inputField[8].setText(String.valueOf(tile.scaleZ));
		} else
			inputField[8].xPosition = width - 70;

		if (inputField[9] == null) {
			inputField[9] = new GuiTextField(fontRendererObj, width / 2 - 100 / 2, 2, 100, 12);
			inputField[9].setMaxStringLength(10);
			inputField[9].setText("find");
		} else
			inputField[9].xPosition = width / 2 - 68 / 2;

		if (animation_play != null) {
			inputField[0].setText(String.valueOf(animation_play.get(animation.getTranslateX(), animation_play.translateX_id)));
			inputField[1].setText(String.valueOf(animation_play.get(animation.getTranslateY(), animation_play.translateY_id)));
			inputField[2].setText(String.valueOf(animation_play.get(animation.getTranslateZ(), animation_play.translateZ_id)));

			inputField[3].setText(String.valueOf(animation_play.get(animation.getRotateX(), animation_play.rotateX_id)));
			inputField[4].setText(String.valueOf(animation_play.get(animation.getRotateY(), animation_play.rotateY_id)));
			inputField[5].setText(String.valueOf(animation_play.get(animation.getRotateZ(), animation_play.rotateZ_id)));
		}

		buttonList.clear();

		buttonList.add(buttonPlay = new GuiButton(6, width / 2 - 83, height - 22, 40, 20, "Play"));
		buttonList.add(buttonPause = new GuiButton(7, width / 2 - 41, height - 22, 40, 20, "Pause"));
		buttonList.add(buttonPrev = new GuiButton(8, width / 2 + 1, height - 22, 40, 20, "Prev"));
		buttonList.add(buttonNext = new GuiButton(9, width / 2 + 43, height - 22, 40, 20, "Next"));

		buttonList.add(buttonSet = new GuiButton(4, width - 42 - 42, 170, 40, 20, "Set"));
		buttonList.add(buttonRemove = new GuiButton(5, width - 42, 170, 40, 20, "Remove"));

		buttonList.add(buttonDefault = new GuiButton(2, width - 42 - 42, 192, 40, 20, "Default"));
		//buttonList.add(buttonCancel = new GuiButton(3, width - 42, 192, 40, 20, "3"));

		buttonList.add(buttonDone = new GuiButton(0, width - 42 - 42, 214, 40, 20, "Save"));
		buttonList.add(buttonCancel = new GuiButton(1, width - 42, 214, 40, 20, "Cancel"));

		buttonList.add(new GuiButton(10, width - 102, 14 * 1, 20, 12, "Set"));
		buttonList.add(new GuiButton(11, width - 102, 14 * 2, 20, 12, "Set"));
		buttonList.add(new GuiButton(12, width - 102, 14 * 3, 20, 12, "Set"));
		buttonList.add(new GuiButton(13, width - 102, 14 * 5, 20, 12, "Set"));
		buttonList.add(new GuiButton(14, width - 102, 14 * 6, 20, 12, "Set"));
		buttonList.add(new GuiButton(15, width - 102, 14 * 7, 20, 12, "Set"));
	}

	@Override
	public void onGuiClosed() {
		Keyboard.enableRepeatEvents(false);
	}

	@Override
	public void updateScreen() {
		if (actField != -1) inputField[actField].updateCursorCounter();
		if (!animation_play.pause) {
			inputField[0].setText(String.valueOf(animation_play.get(animation.getTranslateX(), animation_play.translateX_id)));
			inputField[1].setText(String.valueOf(animation_play.get(animation.getTranslateY(), animation_play.translateY_id)));
			inputField[2].setText(String.valueOf(animation_play.get(animation.getTranslateZ(), animation_play.translateZ_id)));

			inputField[3].setText(String.valueOf(animation_play.get(animation.getRotateX(), animation_play.rotateX_id)));
			inputField[4].setText(String.valueOf(animation_play.get(animation.getRotateY(), animation_play.rotateY_id)));
			inputField[5].setText(String.valueOf(animation_play.get(animation.getRotateZ(), animation_play.rotateZ_id)));
		}
	}

	@Override
	public void actionPerformed(GuiButton btn) {
		if (btn.enabled) {
			switch(btn.id) {
			case 0:
				//Save
				mc.displayGuiScreen(null);
				mc.setIngameFocus();
				break;
			case 1:
				//Cancel
				mc.displayGuiScreen(null);
				mc.setIngameFocus();
				break;
			case 2:
				//Default
				animation.translateX = null;
				animation.translateY = null;
				animation.translateZ = null;
				animation.rotateX = null;
				animation.rotateY = null;
				animation.rotateZ = null;
				animation_play.translateX_id = -1;
				animation_play.translateY_id = -1;
				animation_play.translateZ_id = -1;
				animation_play.rotateX_id = -1;
				animation_play.rotateY_id = -1;
				animation_play.rotateZ_id = -1;
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
			case 3:
				//3
				break;
			case 4:
				//Set
				break;
			case 10:
				try {
					float translateX = Float.valueOf(inputField[0].getText().trim()).floatValue();
					if (animation.translateX == null || animation.translateX.length <= 0) {
						animation.translateX = new KeyCustom[]{new KeyCustom(animation_play.time, translateX)};
					} else {

						for (int i = 0; i < animation.translateX.length; ++i) {
							KeyCustom key = animation.translateX[i];
							if (key.getTime() == animation_play.time) {
								key.field = translateX;
								return;
							}
						}

						ArrayList<KeyCustom> list = new ArrayList<KeyCustom>();
						for (KeyCustom key : animation.translateX) list.add(key);
						list.add(new KeyCustom(animation_play.time, translateX));
						list.sort(new Comparator<KeyCustom>(){
							@Override
							public int compare(KeyCustom o1, KeyCustom o2) {
								return o1.getTime() > o2.getTime() ? 1 : (o1.getTime() < o2.getTime()) ? -1 : 0;
							}
						});
						animation.translateX = list.toArray(new KeyCustom[]{});
						int id = 0;
						for (int i = 0; i < animation.translateX.length; ++i) {
							if (i + 1 < animation.translateX.length)
								if (animation.translateX[i + 1].getTime() <= animation_play.time)
									++id;
						}
						animation_play.translateX_id = id;
					}
				} catch (NumberFormatException nfe) {}
				break;
			case 11:
				try {
					float translateY = Float.valueOf(inputField[1].getText().trim()).floatValue();
					if (animation.translateY == null || animation.translateY.length <= 0) {
						animation.translateY = new KeyCustom[]{new KeyCustom(animation_play.time, translateY)};
					} else {

						for (int i = 0; i < animation.translateY.length; ++i) {
							KeyCustom key = animation.translateY[i];
							if (key.getTime() == animation_play.time) {
								key.field = translateY;
								return;
							}
						}

						ArrayList<KeyCustom> list = new ArrayList<KeyCustom>();
						for (KeyCustom key : animation.translateY) list.add(key);
						list.add(new KeyCustom(animation_play.time, translateY));
						list.sort(new Comparator<KeyCustom>(){
							@Override
							public int compare(KeyCustom o1, KeyCustom o2) {
								return o1.getTime() > o2.getTime() ? 1 : (o1.getTime() < o2.getTime()) ? -1 : 0;
							}
						});
						animation.translateY = list.toArray(new KeyCustom[]{});
						int id = 0;
						for (int i = 0; i < animation.translateY.length; ++i) {
							if (i + 1 < animation.translateY.length)
								if (animation.translateY[i + 1].getTime() <= animation_play.time)
									++id;
						}
						animation_play.translateY_id = id;
					}
				} catch (NumberFormatException nfe) {}
				break;
			case 12:
				try {
					float translateZ = Float.valueOf(inputField[2].getText().trim()).floatValue();
					if (animation.translateZ == null || animation.translateZ.length <= 0) {
						animation.translateZ = new KeyCustom[]{new KeyCustom(animation_play.time, translateZ)};
					} else {

						for (int i = 0; i < animation.translateZ.length; ++i) {
							KeyCustom key = animation.translateZ[i];
							if (key.getTime() == animation_play.time) {
								key.field = translateZ;
								return;
							}
						}

						ArrayList<KeyCustom> list = new ArrayList<KeyCustom>();
						for (KeyCustom key : animation.translateZ) list.add(key);
						list.add(new KeyCustom(animation_play.time, translateZ));
						list.sort(new Comparator<KeyCustom>(){
							@Override
							public int compare(KeyCustom o1, KeyCustom o2) {
								return o1.getTime() > o2.getTime() ? 1 : (o1.getTime() < o2.getTime()) ? -1 : 0;
							}
						});
						animation.translateZ = list.toArray(new KeyCustom[]{});
						int id = 0;
						for (int i = 0; i < animation.translateZ.length; ++i) {
							if (i + 1 < animation.translateZ.length)
								if (animation.translateZ[i + 1].getTime() <= animation_play.time)
									++id;
						}
						animation_play.translateZ_id = id;
					}
				} catch (NumberFormatException nfe) {}
				break;
			case 13:
				try {
					float rotateX = Float.valueOf(inputField[3].getText().trim()).floatValue();
					if (animation.rotateX == null || animation.rotateX.length <= 0) {
						animation.rotateX = new KeyCustom[]{new KeyCustom(animation_play.time, rotateX)};
					} else {

						for (int i = 0; i < animation.rotateX.length; ++i) {
							KeyCustom key = animation.rotateX[i];
							if (key.getTime() == animation_play.time) {
								key.field = rotateX;
								return;
							}
						}

						ArrayList<KeyCustom> list = new ArrayList<KeyCustom>();
						for (KeyCustom key : animation.rotateX) list.add(key);
						list.add(new KeyCustom(animation_play.time, rotateX));
						list.sort(new Comparator<KeyCustom>(){
							@Override
							public int compare(KeyCustom o1, KeyCustom o2) {
								return o1.getTime() > o2.getTime() ? 1 : (o1.getTime() < o2.getTime()) ? -1 : 0;
							}
						});
						animation.rotateX = list.toArray(new KeyCustom[]{});
						int id = 0;
						for (int i = 0; i < animation.rotateX.length; ++i) {
							if (i + 1 < animation.rotateX.length)
								if (animation.rotateX[i + 1].getTime() <= animation_play.time)
									++id;
						}
						animation_play.rotateX_id = id;
					}
				} catch (NumberFormatException nfe) {}
				break;
			case 14:
				try {
					float rotateY = Float.valueOf(inputField[4].getText().trim()).floatValue();
					if (animation.rotateY == null || animation.rotateY.length <= 0) {
						animation.rotateY = new KeyCustom[]{new KeyCustom(animation_play.time, rotateY)};
					} else {

						for (int i = 0; i < animation.rotateY.length; ++i) {
							KeyCustom key = animation.rotateY[i];
							if (key.getTime() == animation_play.time) {
								key.field = rotateY;
								return;
							}
						}

						ArrayList<KeyCustom> list = new ArrayList<KeyCustom>();
						for (KeyCustom key : animation.rotateY) list.add(key);
						list.add(new KeyCustom(animation_play.time, rotateY));
						list.sort(new Comparator<KeyCustom>(){
							@Override
							public int compare(KeyCustom o1, KeyCustom o2) {
								return o1.getTime() > o2.getTime() ? 1 : (o1.getTime() < o2.getTime()) ? -1 : 0;
							}
						});
						animation.rotateY = list.toArray(new KeyCustom[]{});
						int id = 0;
						for (int i = 0; i < animation.rotateY.length; ++i) {
							if (i + 1 < animation.rotateY.length)
								if (animation.rotateY[i + 1].getTime() <= animation_play.time)
									++id;
						}
						animation_play.translateY_id = id;
					}
				} catch (NumberFormatException nfe) {}
				break;
			case 15:
				try {
					float rotateZ = Float.valueOf(inputField[5].getText().trim()).floatValue();
					if (animation.rotateZ == null || animation.rotateZ.length <= 0) {
						animation.rotateZ = new KeyCustom[]{new KeyCustom(animation_play.time, rotateZ)};
					} else {

						for (int i = 0; i < animation.rotateZ.length; ++i) {
							KeyCustom key = animation.rotateZ[i];
							if (key.getTime() == animation_play.time) {
								key.field = rotateZ;
								return;
							}
						}

						ArrayList<KeyCustom> list = new ArrayList<KeyCustom>();
						for (KeyCustom key : animation.rotateZ) list.add(key);
						list.add(new KeyCustom(animation_play.time, rotateZ));
						list.sort(new Comparator<KeyCustom>(){
							@Override
							public int compare(KeyCustom o1, KeyCustom o2) {
								return o1.getTime() > o2.getTime() ? 1 : (o1.getTime() < o2.getTime()) ? -1 : 0;
							}
						});
						animation.rotateZ = list.toArray(new KeyCustom[]{});
						int id = 0;
						for (int i = 0; i < animation.rotateZ.length; ++i) {
							if (i + 1 < animation.rotateZ.length)
								if (animation.rotateZ[i + 1].getTime() <= animation_play.time)
									++id;
						}
						animation_play.translateZ_id = id;
					}
				} catch (NumberFormatException nfe) {}
				break;
			case 5:
				//Remove
				break;
			case 6:
				//Play
				animation_play.pause = false;
				if (animation_play.time == animation.time_line){
					animation_play.time = 0;
					animation_play.translateX_id = 0;
					animation_play.translateY_id = 0;
					animation_play.translateZ_id = 0;
					animation_play.rotateX_id = 0;
					animation_play.rotateY_id = 0;
					animation_play.rotateZ_id = 0;
				}
				break;
			case 7:
				//Pause
				animation_play.pause = true;
				break;
			case 8:
				//Prev
				--animation_play.time;
				break;
			case 9:
				//Next
				++animation_play.time;
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
		if (!showGUI) {

			return;
		}
		for (GuiTextField fild : inputField) fild.drawTextBox();

		/*
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
		 */

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

		mc.fontRenderer.drawStringWithShadow("time: " + animation_play.time + "/" + animation.getTimeLine(), 2, 2 + 14 * 0, 0xFFFFFF);
		if (animation.translateX != null && animation.translateX.length > 0) {
			mc.fontRenderer.drawStringWithShadow("list: ", 2, 2 + 14 * 1, 0xFFFFFF);
			for (int i = 0; i < animation.translateX.length; ++i)
				mc.fontRenderer.drawStringWithShadow("t: " + animation.translateX[i].time +  ", f: " + animation.translateX[i].field, 2, 2 + 14 * (2 + i), 0xFFFFFF);
		}

		super.drawScreen(mouseX, mouseY, parTick);
	}

	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}

}
