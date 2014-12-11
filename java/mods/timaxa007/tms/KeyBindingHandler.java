package mods.timaxa007.tms;

import java.util.EnumSet;

import net.minecraft.client.settings.KeyBinding;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.FMLClientHandler;
//import cpw.mods.fml.client.registry.KeyBindingRegistry.KeyHandler;
//import cpw.mods.fml.common.TickType;


public class KeyBindingHandler /*extends KeyHandler*/ {
/*
public static KeyBinding reload_key_bind = new KeyBinding("Reload", Keyboard.KEY_R);
public static KeyBinding change_type_key_bind = new KeyBinding("Change Type", Keyboard.KEY_T);
public static KeyBinding mode_switch_key_bind = new KeyBinding("Mode Switch", Keyboard.KEY_F);

public static KeyBinding use_key_bind = new KeyBinding("Use", Keyboard.KEY_NUMPAD0);
//public static KeyBinding fast_use1_key_bind = new KeyBinding("Fast Use 1", Keyboard.KEY_NUMPAD1);
public static KeyBinding down_key_bind = new KeyBinding("Down", Keyboard.KEY_NUMPAD2);
//public static KeyBinding fast_use3_key_bind = new KeyBinding("Fast Use 3", Keyboard.KEY_NUMPAD3);
public static KeyBinding move_left_key_bind = new KeyBinding("Move Left", Keyboard.KEY_NUMPAD4);
public static KeyBinding stop_key_bind = new KeyBinding("Stop", Keyboard.KEY_NUMPAD5);
public static KeyBinding move_right_key_bind = new KeyBinding("Move Right", Keyboard.KEY_NUMPAD6);
public static KeyBinding yaw_left_key_bind = new KeyBinding("Yaw Left", Keyboard.KEY_NUMPAD7);
public static KeyBinding up_key_bind = new KeyBinding("Up", Keyboard.KEY_NUMPAD8);
public static KeyBinding yaw_right_key_bind = new KeyBinding("Yaw Right", Keyboard.KEY_NUMPAD9);

public static KeyBinding[] arrayOfKeys = new KeyBinding[] {
reload_key_bind, change_type_key_bind, mode_switch_key_bind, 
use_key_bind, down_key_bind, move_left_key_bind, stop_key_bind, move_right_key_bind, up_key_bind, yaw_right_key_bind
};
public static boolean[] areRepeating = new boolean[] {false};

public KeyBindingHandler() {super(arrayOfKeys, areRepeating);}

@Override
public String getLabel() {return "TMS KeyBindings";}

@Override
public void keyDown(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd, boolean isRepeat) {
if (tickEnd) {
if (FMLClientHandler.instance().getClient().currentScreen == null) {
if (kb.getKeyCode() == reload_key_bind.getKeyCode())		{System.out.println("reload_key_bind");}
if (kb.getKeyCode() == change_type_key_bind.getKeyCode())	{System.out.println("change_type_key_bind");}
if (kb.getKeyCode() == mode_switch_key_bind.getKeyCode())	{System.out.println("mode_switch_key_bind");}
if (kb.getKeyCode() == use_key_bind.getKeyCode())			{System.out.println("use_key_bind");}
if (kb.getKeyCode() == down_key_bind.getKeyCode())		{System.out.println("down_key_bind");}
if (kb.getKeyCode() == move_left_key_bind.getKeyCode())	{System.out.println("move_left_key_bind");}
if (kb.getKeyCode() == stop_key_bind.getKeyCode())		{System.out.println("stop_key_bind");}
if (kb.getKeyCode() == move_right_key_bind.getKeyCode())	{System.out.println("move_right_key_bind");}
if (kb.getKeyCode() == yaw_left_key_bind.getKeyCode())	{System.out.println("yaw_left_key_bind");}
if (kb.getKeyCode() == up_key_bind.getKeyCode())			{System.out.println("up_key_bind");}
if (kb.getKeyCode() == yaw_right_key_bind.getKeyCode())	{System.out.println("yaw_right_key_bind");}
}
}
}

@Override
public void keyUp(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd) {}

@Override
public EnumSet<TickType> ticks() {return null;}
*/
}
