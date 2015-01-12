package mods.timaxa007.pack.weapon;

import mods.timaxa007.pack.weapon.event.EventWeaponsClient;
import mods.timaxa007.tms.util.IProxy;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ProxyClient extends ProxyCommon implements IProxy {

	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);

		MinecraftForge.EVENT_BUS.register(new EventWeaponsClient());

	}

	public void init() {
		super.init();

		render.init();

	}

}
