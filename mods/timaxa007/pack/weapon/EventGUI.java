package mods.timaxa007.pack.weapon;

import mods.timaxa007.pack.weapon.gui.WeaponsIngameGUI;
import net.minecraft.client.Minecraft;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;

public class EventGUI {
//--------------------------------------------------------------------------------------------------------------
Minecraft mc = Minecraft.getMinecraft();

@ForgeSubscribe
public void statusBullet(LivingUpdateEvent p) {

if ((mc.ingameGUI != null) && (!(mc.ingameGUI instanceof WeaponsIngameGUI))) {
mc.ingameGUI = new WeaponsIngameGUI(mc);
}

}
//--------------------------------------------------------------------------------------------------------------
}
