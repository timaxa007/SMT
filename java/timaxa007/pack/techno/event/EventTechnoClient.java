package timaxa007.pack.techno.event;

import net.minecraftforge.client.event.sound.PlaySoundEvent17;
import net.minecraftforge.client.event.sound.SoundEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class EventTechnoClient {
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onDigSound1(SoundEvent.SoundSourceEvent e) {
		//System.out.println(e.name + "1");
	}
	//--------------------------------------------------------------------------------------------------------------
	@SubscribeEvent
	public void onDigSound2(PlaySoundEvent17 e) {
		//System.out.println(e.name + "2");
	}
	//--------------------------------------------------------------------------------------------------------------
}
