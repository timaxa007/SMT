package timaxa007.pack.techno;

import timaxa007.pack.techno.event.EventTechnoClient;
import timaxa007.tms.util.IProxy;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ProxyClient extends ProxyCommon implements IProxy {

	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);

		MinecraftForge.EVENT_BUS.register(new EventTechnoClient());

	}

	public void init() {
		super.init();

		render.init();

	}

}
