package mods.timaxa007.tms;

import net.minecraft.client.settings.KeyBinding;

import org.apache.logging.log4j.Level;
import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.FMLLog;

public class ProxyClient extends ProxyServer {

	@Override
	public void initialize() {
		super.initialize();
		if (Core.debug) FMLLog.log(Core.MODID, Level.DEBUG, "Successful initialized client part.");

		ClientRegistry.registerKeyBinding(new KeyBinding("Reload", Keyboard.KEY_R, "TMS KeyBindings"));
		ClientRegistry.registerKeyBinding(new KeyBinding("Charge", Keyboard.KEY_T, "TMS KeyBindings"));
		ClientRegistry.registerKeyBinding(new KeyBinding("Mode", Keyboard.KEY_F, "TMS KeyBindings"));
		ClientRegistry.registerKeyBinding(new KeyBinding("Use", Keyboard.KEY_NUMPAD0, "TMS KeyBindings"));
		ClientRegistry.registerKeyBinding(new KeyBinding("Yaw Right", Keyboard.KEY_NUMPAD9, "TMS KeyBindings"));
		ClientRegistry.registerKeyBinding(new KeyBinding("Up", Keyboard.KEY_NUMPAD8, "TMS KeyBindings"));
		ClientRegistry.registerKeyBinding(new KeyBinding("Yaw Left", Keyboard.KEY_NUMPAD7, "TMS KeyBindings"));
		ClientRegistry.registerKeyBinding(new KeyBinding("Move Right", Keyboard.KEY_NUMPAD6, "TMS KeyBindings"));
		ClientRegistry.registerKeyBinding(new KeyBinding("Stop", Keyboard.KEY_NUMPAD5, "TMS KeyBindings"));
		ClientRegistry.registerKeyBinding(new KeyBinding("Move Left", Keyboard.KEY_NUMPAD4, "TMS KeyBindings"));
		ClientRegistry.registerKeyBinding(new KeyBinding("Use2", Keyboard.KEY_NUMPAD3, "TMS KeyBindings"));
		ClientRegistry.registerKeyBinding(new KeyBinding("Down", Keyboard.KEY_NUMPAD2, "TMS KeyBindings"));
		ClientRegistry.registerKeyBinding(new KeyBinding("Use1", Keyboard.KEY_NUMPAD1, "TMS KeyBindings"));

	}

}
