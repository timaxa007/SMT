package smt.pack.weapon.client.event;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import smt.pack.weapon.SMTWeapon;

public class EventsForgeClient {

	@SubscribeEvent
	public void onRenderPlayer(RenderPlayerEvent.Pre event) {
		if (event.entityPlayer.inventory.getCurrentItem() != null && event.entityPlayer.inventory.getCurrentItem().getItem() == SMTWeapon.item.weapon) {
			if (event.renderer.modelArmor != null)
				event.renderer.modelArmor.aimedBow = true;
			if (event.renderer.modelArmorChestplate != null)
				event.renderer.modelArmorChestplate.aimedBow = true;
			if (event.renderer.modelBipedMain != null)
				event.renderer.modelBipedMain.aimedBow = true;
		}
	}

}
