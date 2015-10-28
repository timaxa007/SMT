package timaxa007.core.sound;

import net.minecraft.client.audio.SoundHandler;
import cpw.mods.fml.client.FMLClientHandler;

public class SoundHelper/*?*/ {

	public static SoundHandler snd = FMLClientHandler.instance().getClient().getSoundHandler();
	
	public static SoundTest sound_test = new SoundTest();

	public static void isSoundPlaying() {
		snd.isSoundPlaying(sound_test);
	}

	public static void playSound() {
		snd.playSound(sound_test);
	}

	public static void stopSound() {
		snd.stopSound(sound_test);
	}

}
