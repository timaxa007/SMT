package timaxa007.pack.weapon;

import net.minecraftforge.common.MinecraftForge;
import timaxa007.pack.api.IProxyPackClient;
import timaxa007.pack.weapon.event.EventWeaponsClient;
import timaxa007.pack.weapon.render.RenderMain;

public class ProxyClient implements IProxyPackClient {

	public void preInit() {

		MinecraftForge.EVENT_BUS.register(new EventWeaponsClient());

	}

	public void init() {

		RenderMain.init();

	}

	public void postInit() {
		
	}

}
