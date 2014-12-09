package mods.timaxa007.pack.stock;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;

public class EventSoundStock {

@ForgeSubscribe
public void onSoundPlay(SoundLoadEvent s) {
s.manager.addSound("timaxa007:vodka.ogg");
}

}
