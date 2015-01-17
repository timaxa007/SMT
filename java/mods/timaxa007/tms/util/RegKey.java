package mods.timaxa007.tms.util;

import net.minecraft.client.settings.KeyBinding;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.registry.ClientRegistry;

public class RegKey {

	public static final KeyBinding reload = new KeyBinding("key.reload.name", Keyboard.KEY_R, "category.tms.name");//1
	public static final KeyBinding charge = new KeyBinding("key.charge.name", Keyboard.KEY_T, "category.tms.name");//2
	public static final KeyBinding mode = new KeyBinding("key.mode.name", Keyboard.KEY_F, "category.tms.name");//3
	public static final KeyBinding action = new KeyBinding("key.action.name", Keyboard.KEY_G, "category.tms.name");//4
	public static final KeyBinding mode_in = new KeyBinding("key.zoom_in.name", Keyboard.KEY_EQUALS, "category.tms.name");//5
	public static final KeyBinding mode_out = new KeyBinding("key.zoom_out.name", Keyboard.KEY_MINUS, "category.tms.name");//6
	/*//Primary
	public static final KeyBinding numpad0 = new KeyBinding("key.numpad0.name", Keyboard.KEY_NUMPAD0, "category.tms.name");//1
	public static final KeyBinding numpad9 = new KeyBinding("key.numpad9.name", Keyboard.KEY_NUMPAD9, "category.tms.name");//2
	public static final KeyBinding numpad8 = new KeyBinding("key.numpad8.name", Keyboard.KEY_NUMPAD8, "category.tms.name");//3
	public static final KeyBinding numpad7 = new KeyBinding("key.numpad7.name", Keyboard.KEY_NUMPAD7, "category.tms.name");//4
	public static final KeyBinding numpad6 = new KeyBinding("key.numpad6.name", Keyboard.KEY_NUMPAD6, "category.tms.name");//5
	public static final KeyBinding numpad5 = new KeyBinding("key.numpad5.name", Keyboard.KEY_NUMPAD5, "category.tms.name");//6
	public static final KeyBinding numpad4 = new KeyBinding("key.numpad4.name", Keyboard.KEY_NUMPAD4, "category.tms.name");//7
	public static final KeyBinding numpad3 = new KeyBinding("key.numpad3.name", Keyboard.KEY_NUMPAD3, "category.tms.name");//8
	public static final KeyBinding numpad2 = new KeyBinding("key.numpad2.name", Keyboard.KEY_NUMPAD2, "category.tms.name");//9
	public static final KeyBinding numpad1 = new KeyBinding("key.numpad1.name", Keyboard.KEY_NUMPAD1, "category.tms.name");//10
	 */
	public static final KeyBinding booster = new KeyBinding("key.booster.name", Keyboard.KEY_B, "category.tms.name");//13
	public static final KeyBinding grab = new KeyBinding("key.grab.name", Keyboard.KEY_V, "category.tms.name");//14
	public static final KeyBinding lie = new KeyBinding("key.lie.name", Keyboard.KEY_C, "category.tms.name");//15

	public static final KeyBinding[] list_key = new KeyBinding[] {
		reload, charge, mode, action, mode_in, mode_out, 
		//numpad0, numpad9, numpad8, numpad7, numpad6, numpad5, numpad4, numpad3, numpad2, numpad1,
		booster, grab, lie
	};

	public static void preInit() {

		for (int k = 0; k < list_key.length; k++) 
			ClientRegistry.registerKeyBinding(list_key[k]);

	}

}
