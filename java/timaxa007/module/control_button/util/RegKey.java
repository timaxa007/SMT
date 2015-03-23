package timaxa007.module.control_button.util;

import net.minecraft.client.settings.KeyBinding;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.registry.ClientRegistry;

public class RegKey {
	
	private static final String cat_name = "category.control_button.name";

	public static final KeyBinding reload = new KeyBinding("key.reload.name", Keyboard.KEY_R, cat_name);
	public static final KeyBinding charge = new KeyBinding("key.charge.name", Keyboard.KEY_T, cat_name);
	public static final KeyBinding mode = new KeyBinding("key.mode.name", Keyboard.KEY_F, cat_name);
	public static final KeyBinding mode_in = new KeyBinding("key.zoom_in.name", Keyboard.KEY_EQUALS, cat_name);
	public static final KeyBinding mode_out = new KeyBinding("key.zoom_out.name", Keyboard.KEY_MINUS, cat_name);

	public static final KeyBinding action = new KeyBinding("key.action.name", Keyboard.KEY_G, cat_name);
	public static final KeyBinding action_helmet = new KeyBinding("key.action_helmet.name", Keyboard.KEY_L, cat_name);
	public static final KeyBinding action_chest = new KeyBinding("key.action_chest.name", Keyboard.KEY_K, cat_name);
	public static final KeyBinding action_leggin = new KeyBinding("key.action_leggin.name", Keyboard.KEY_J, cat_name);
	public static final KeyBinding action_boot = new KeyBinding("key.action_boot.name", Keyboard.KEY_H, cat_name);

	public static final KeyBinding booster = new KeyBinding("key.booster.name", Keyboard.KEY_B, cat_name);
	public static final KeyBinding grab = new KeyBinding("key.grab.name", Keyboard.KEY_V, cat_name);
	public static final KeyBinding lie = new KeyBinding("key.lie.name", Keyboard.KEY_C, cat_name);

	public static final KeyBinding[] list_key = new KeyBinding[] {
		reload, charge, mode, action, mode_in, mode_out, 
		action_helmet, action_chest, action_leggin, action_boot, 
		booster, grab, lie
	};

	public static void preInit() {

		for (int k = 0; k < list_key.length; k++) 
			ClientRegistry.registerKeyBinding(list_key[k]);

	}

}
