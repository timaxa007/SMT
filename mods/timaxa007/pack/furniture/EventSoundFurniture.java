package mods.timaxa007.pack.furniture;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;

public class EventSoundFurniture {
//--------------------------------------------------------------------------------------------------------------
@ForgeSubscribe
public void onSoundPlay(SoundLoadEvent s) {
s.manager.addSound("timaxa007:sound.ogg");
}
//--------------------------------------------------------------------------------------------------------------
}
