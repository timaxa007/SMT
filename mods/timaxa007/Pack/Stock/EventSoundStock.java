package mods.timaxa007.Pack.Stock;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;

public class EventSoundStock {

@ForgeSubscribe
public void onSoundPlay(SoundLoadEvent s) {
s.manager.addSound("timaxa007:vodka.ogg");
}

}
