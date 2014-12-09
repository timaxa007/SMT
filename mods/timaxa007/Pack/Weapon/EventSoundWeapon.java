package mods.timaxa007.Pack.Weapon;

import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.event.ForgeSubscribe;

public class EventSoundWeapon {

@ForgeSubscribe
public void onSoundPlay(SoundLoadEvent s) {
//s.manager.addSound("timaxa007:sound.ogg");
s.manager.addSound("timaxa007:ak74_shoot.ogg");
}

}
