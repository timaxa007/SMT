package mods.timaxa007.tms.util;

import net.minecraft.client.settings.KeyBinding;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.registry.ClientRegistry;

public class RegKey {

	public static final KeyBinding reload = new KeyBinding("key.reload.name", Keyboard.KEY_R, "category.tms.name");//1
	public static final KeyBinding charge = new KeyBinding("key.charge.name", Keyboard.KEY_T, "category.tms.name");//2
	public static final KeyBinding mode = new KeyBinding("key.mode.name", Keyboard.KEY_F, "category.tms.name");//3
	public static final KeyBinding hook = new KeyBinding("key.hook.name", Keyboard.KEY_G, "category.tms.name");//4
	public static final KeyBinding zoom_in = new KeyBinding("key.zoom_in.name", Keyboard.KEY_EQUALS, "category.tms.name");//5
	public static final KeyBinding zoom_out = new KeyBinding("key.zoom_out.name", Keyboard.KEY_MINUS, "category.tms.name");//6

	public static final KeyBinding use = new KeyBinding("key.use.name", Keyboard.KEY_NUMPAD0, "category.tms.name");//1
	public static final KeyBinding yaw_right = new KeyBinding("key.yaw_right.name", Keyboard.KEY_NUMPAD9, "category.tms.name");//2
	public static final KeyBinding up = new KeyBinding("key.up.name", Keyboard.KEY_NUMPAD8, "category.tms.name");//3
	public static final KeyBinding yaw_left = new KeyBinding("key.yaw_left.name", Keyboard.KEY_NUMPAD7, "category.tms.name");//4
	public static final KeyBinding move_right = new KeyBinding("key.move_right.name", Keyboard.KEY_NUMPAD6, "category.tms.name");//5
	public static final KeyBinding stop = new KeyBinding("key.stop.name", Keyboard.KEY_NUMPAD5, "category.tms.name");//6
	public static final KeyBinding move_left = new KeyBinding("key.move_left.name", Keyboard.KEY_NUMPAD4, "category.tms.name");//7
	public static final KeyBinding use2 = new KeyBinding("key.use2.name", Keyboard.KEY_NUMPAD3, "category.tms.name");//8
	public static final KeyBinding down = new KeyBinding("key.down.name", Keyboard.KEY_NUMPAD2, "category.tms.name");//9
	public static final KeyBinding use1 = new KeyBinding("key.use1.name", Keyboard.KEY_NUMPAD1, "category.tms.name");//10

	public static final KeyBinding booster = new KeyBinding("key.booster.name", Keyboard.KEY_B, "category.tms.name");//13
	public static final KeyBinding grab = new KeyBinding("key.grab.name", Keyboard.KEY_V, "category.tms.name");//14
	public static final KeyBinding lie = new KeyBinding("key.lie.name", Keyboard.KEY_C, "category.tms.name");//15

	public static final KeyBinding[] list_key = new KeyBinding[] {
		reload, charge, mode, hook, zoom_in, zoom_out, 
		use, yaw_right, up, yaw_left, move_right, stop, move_left, use2, down, use1,
		booster, grab, lie
	};

	public static void preInit() {

		for (int k = 0; k < list_key.length; k++) 
			ClientRegistry.registerKeyBinding(list_key[k]);

	}

}
