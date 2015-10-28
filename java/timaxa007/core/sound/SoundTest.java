package timaxa007.core.sound;

import timaxa007.core.CoreSMT;
import net.minecraft.client.audio.ISound;
import net.minecraft.util.ResourceLocation;

public class SoundTest implements ISound {

	@Override
	public ResourceLocation getPositionedSoundLocation() {
		return new ResourceLocation(CoreSMT.MODID, "sound_test");
	}

	@Override
	public boolean canRepeat() {
		return true;
	}

	@Override
	public int getRepeatDelay() {
		return 1;
	}

	@Override
	public float getVolume() {
		return 1.0F;
	}

	@Override
	public float getPitch() {
		return 1.0F;
	}

	@Override
	public float getXPosF() {
		return 1.0F;
	}

	@Override
	public float getYPosF() {
		return 1.0F;
	}

	@Override
	public float getZPosF() {
		return 1.0F;
	}

	@Override
	public AttenuationType getAttenuationType() {
		return AttenuationType.LINEAR;
	}

}
