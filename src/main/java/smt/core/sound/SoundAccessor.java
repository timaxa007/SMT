package smt.core.sound;

import net.minecraft.client.audio.SoundCategory;
import net.minecraft.client.audio.SoundEventAccessorComposite;
import net.minecraft.client.audio.SoundPoolEntry;
import net.minecraft.util.ResourceLocation;

/**
 * Simple sound accessor with underlying SoundPoolEntry
 * Used by SoundHelper
 * @author Dragon2488
 */
public class SoundAccessor extends SoundEventAccessorComposite {

    /**
     * Underlying SoundPoolEntry
     * Can't be null
     */
    private final SoundPoolEntry underlyingEntry;

    /**
     * Constructs new sound accessor with specified params
     * @param location sound location, can't be null
     * @param location full patch to sound file
     * @param volumeMod sound volume modifier, often 1
     * @param pitchMod sound pitch modifier, often 1
     * @param streaming is sound streaming, often false
     * @param category sound category, used in volume settings
     */
    public SoundAccessor(ResourceLocation location, boolean streaming, float volumeMod, float pitchMod, SoundCategory category) {
        super(location, volumeMod, pitchMod, category);
        underlyingEntry = new SoundPoolEntry(location, volumeMod, pitchMod, streaming);
    }

    /**
     * Dummy override of listeners count getter
     * @return the count of listeners
     */
    @Override
    public int func_148721_a() {
        return 1;
    }

    /**
     * Returns SoundPoolEntry of this accessor
     * @return Underlying SoundPoolEntry
     */
    @Override
    public SoundPoolEntry func_148720_g() {
        return underlyingEntry;
    }

}
