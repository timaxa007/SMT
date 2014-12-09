package mods.timaxa007.Pack.Mining;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;

public class EventSoundMining {

@ForgeSubscribe
public void onSoundPlay(SoundLoadEvent s) {
s.manager.addSound("timaxa007:sound.ogg");
}

}
