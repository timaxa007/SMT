package mods.timaxa007.tms.util;

import net.minecraft.client.settings.KeyBinding;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.registry.ClientRegistry;

public class RegKey {

	public static final KeyBinding reload = new KeyBinding("Reload", Keyboard.KEY_R, "TMS KeyBindings");//0
	public static final KeyBinding charge = new KeyBinding("Charge", Keyboard.KEY_T, "TMS KeyBindings");//1
	public static final KeyBinding mode = new KeyBinding("Mode", Keyboard.KEY_F, "TMS KeyBindings");//2
	public static final KeyBinding use = new KeyBinding("Use", Keyboard.KEY_NUMPAD0, "TMS KeyBindings");//3
	public static final KeyBinding yaw_right = new KeyBinding("Yaw Right", Keyboard.KEY_NUMPAD9, "TMS KeyBindings");//4
	public static final KeyBinding up = new KeyBinding("Up", Keyboard.KEY_NUMPAD8, "TMS KeyBindings");//5
	public static final KeyBinding yaw_left = new KeyBinding("Yaw Left", Keyboard.KEY_NUMPAD7, "TMS KeyBindings");//6
	public static final KeyBinding move_right = new KeyBinding("Move Right", Keyboard.KEY_NUMPAD6, "TMS KeyBindings");//7
	public static final KeyBinding stop = new KeyBinding("Stop", Keyboard.KEY_NUMPAD5, "TMS KeyBindings");//8
	public static final KeyBinding move_left = new KeyBinding("Move Left", Keyboard.KEY_NUMPAD4, "TMS KeyBindings");//9
	public static final KeyBinding use2 = new KeyBinding("Use2", Keyboard.KEY_NUMPAD3, "TMS KeyBindings");//10
	public static final KeyBinding down = new KeyBinding("Down", Keyboard.KEY_NUMPAD2, "TMS KeyBindings");//11
	public static final KeyBinding use1 = new KeyBinding("Use1", Keyboard.KEY_NUMPAD1, "TMS KeyBindings");//12

	public static final KeyBinding[] list_key = new KeyBinding[] {
		reload, charge, mode, use, 
		yaw_right, up, yaw_left, 
		move_right, stop, move_left, 
		use2, down, use1
	};

	public static void preInt() {

		ClientRegistry.registerKeyBinding(reload);
		ClientRegistry.registerKeyBinding(charge);
		ClientRegistry.registerKeyBinding(mode);
		ClientRegistry.registerKeyBinding(use);
		ClientRegistry.registerKeyBinding(yaw_right);
		ClientRegistry.registerKeyBinding(up);
		ClientRegistry.registerKeyBinding(yaw_left);
		ClientRegistry.registerKeyBinding(move_right);
		ClientRegistry.registerKeyBinding(stop);
		ClientRegistry.registerKeyBinding(move_left);
		ClientRegistry.registerKeyBinding(use2);
		ClientRegistry.registerKeyBinding(down);
		ClientRegistry.registerKeyBinding(use1);

	}

}
