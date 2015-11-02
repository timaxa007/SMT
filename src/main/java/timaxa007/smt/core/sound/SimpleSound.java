package timaxa007.smt.core.sound;

import net.minecraft.client.audio.PositionedSound;
import net.minecraft.util.ResourceLocation;

/**
 * Simple implementation of PositionedSound
 * Instead of minecraft implementation, constructor is public
 * Used by SoundHelper
 * @author Dragon2488
 */
public class SimpleSound extends PositionedSound {

    /**
     * Constructs new sound with specified params
     * @param location sound location, can't be null
     * @param volume sound volume, often in 0.0-1.0 range
     * @param pitch sound pitch in 0.0-2.0 range
     * @param posX sound x position
     * @param posY sound y position
     * @param posZ sound z position
     * @param repeat is sound repeating
     * @param repeatDelay if repeating, repeat delay
     */
    public SimpleSound(ResourceLocation location, float volume, float pitch, double posX, double posY, double posZ, boolean repeat, int repeatDelay) {
        super(location);
        this.volume = volume;
        this.field_147663_c = pitch;
        this.xPosF = (float) posX;
        this.yPosF = (float) posY;
        this.zPosF = (float) posZ;
        this.repeat = repeat;
        this.field_147665_h = repeatDelay;
    }

}
