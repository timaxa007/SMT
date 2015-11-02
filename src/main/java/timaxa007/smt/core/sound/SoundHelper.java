package timaxa007.smt.core.sound;

import cpw.mods.fml.common.ObfuscationReflectionHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.*;
import net.minecraft.util.ResourceLocation;
import timaxa007.smt.core.SMTContainer;

import java.util.HashMap;
import java.util.Map;

/**
 * Simple helper, created for easy sound registration
 * without using external json file
 * @author Dragon2488
 */
@SideOnly(Side.CLIENT)
public class SoundHelper {

    private Map<String, ResourceLocation> sounds;
    private SoundRegistry soundRegistry;
    private SoundHandler soundHandler;

    public SoundHelper() {
        sounds = new HashMap<>();
        soundHandler = Minecraft.getMinecraft().getSoundHandler();
        soundRegistry = ObfuscationReflectionHelper.getPrivateValue(SoundHandler.class, soundHandler, 4);
    }

    /**
     * Registers sound with specified params
     * @param name sound name, used for sound identification
     * @param location full patch to sound file
     * @param volumeMod sound volume modifier, often 1
     * @param pitchMod sound pitch modifier, often 1
     * @param streaming is sound streaming, often false
     * @param category sound category, used in volume settings
     * @throws java.lang.IllegalArgumentException if name is already occupied
     */
    public void registerSound(String name, ResourceLocation location, float volumeMod, float pitchMod, boolean streaming, SoundCategory category) {
        if(sounds.get(name.toLowerCase()) != null) throw new IllegalArgumentException("Sound name " + name + " is already occupied!");
        soundRegistry.registerSound(new SoundAccessor(location, streaming, volumeMod, pitchMod, category));
    }

    /**
     * Plays sound with specified params
     * @param name sound name, used for sound identification
     * @param volume sound volume, often in 0.0-1.0 range
     * @param pitch sound pitch in 0.0-2.0 range
     * @param posX sound x position
     * @param posY sound y position
     * @param posZ sound z position
     * @param repeat is sound repeating
     * @param repeatDelay if repeating, repeat delay
     * @throws java.lang.IllegalArgumentException if name is unknown
     */
    public void playSound(String name, float volume, float pitch, double posX, double posY, double posZ, boolean repeat, int repeatDelay) {
        ResourceLocation location = sounds.get(name.toLowerCase());
        if(location == null) throw new IllegalArgumentException("Unknown sound name " + name + "!");
        soundHandler.playSound(new SimpleSound(location, volume, pitch, posX, posY, posZ, repeat, repeatDelay));
    }

    /**
     * Stops sound if playing
     * @param sound sound to stop, can be null
     */
    public void stopSound(ISound sound) {
        soundHandler.stopSound(sound);
    }

    /**
     *
     * @param sound the sound to test, can be null
     * @return true if sound playing, otherwise false
     */
    public boolean isPlaying(ISound sound) {
        return soundHandler.isSoundPlaying(sound);
    }

    /**
     * Stops all playing sounds
     */
    public void stopSounds() {
        soundHandler.stopSounds();
    }

}
