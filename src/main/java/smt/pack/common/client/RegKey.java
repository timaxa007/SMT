package smt.pack.common.client;

import net.minecraft.client.settings.KeyBinding;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RegKey {

	private static final String CAT_NAME = "category.control_button.name";

	public static final KeyBinding
	use = new KeyBinding("key.use.name", Keyboard.KEY_F, CAT_NAME),

	reload = new KeyBinding("key.reload.name", Keyboard.KEY_R, CAT_NAME),

	charge = new KeyBinding("key.charge.name", Keyboard.KEY_T, CAT_NAME),

	mode = new KeyBinding("key.mode.name", Keyboard.KEY_G, CAT_NAME),
	mode_in = new KeyBinding("key.mode_in.name", Keyboard.KEY_EQUALS, CAT_NAME),
	mode_out = new KeyBinding("key.mode_out.name", Keyboard.KEY_MINUS, CAT_NAME),

	//action = new KeyBinding("key.action.name", Keyboard.KEY_G, CAT_NAME),

	booster = new KeyBinding("key.booster.name", Keyboard.KEY_B, CAT_NAME),
	grab = new KeyBinding("key.grab.name", Keyboard.KEY_V, CAT_NAME),
	lie = new KeyBinding("key.lie.name", Keyboard.KEY_C, CAT_NAME)
	;

	public static KeyBinding button_left;
	public static KeyBinding button_right;

	public static KeyBinding[] list_key;

	public static void preInit() {
		/*
		if (ModuleControlButton.button_left)
			button_left = new KeyBinding("key.button_left.name", -100, CAT_NAME);

		if (ModuleControlButton.button_right)
			button_right = new KeyBinding("key.button_right.name", -99, CAT_NAME);
		 */
		list_key = new KeyBinding[] {
				use,
				reload,
				charge,
				mode, mode_in, mode_out,
				//action,
				booster, grab, lie,
				button_left, button_right
		};

		for (KeyBinding key : list_key) if (key != null) ClientRegistry.registerKeyBinding(key);

	}

}
