package timaxa007.pack.weapon;

import net.minecraftforge.common.MinecraftForge;
import timaxa007.api.IProxyPackCommon;
import timaxa007.pack.weapon.event.EventWeapons;
import timaxa007.pack.weapon.render.RenderMain;

public class ProxyCommon implements IProxyPackCommon {

	public void preInit() {

		RenderMain.preInit();

		MinecraftForge.EVENT_BUS.register(new EventWeapons());

	}

	public void init() {

	}

	public void postInit() {
		
	}

}
