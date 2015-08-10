package timaxa007.module.player_inventory;

import net.minecraftforge.common.MinecraftForge;
import timaxa007.api.IProxyModuleClient;
import timaxa007.module.player_inventory.event.EventModulePlayerInventory1Client;
import timaxa007.module.player_inventory.event.EventModulePlayerInventory2Client;
import cpw.mods.fml.common.FMLCommonHandler;

public class ProxyClient implements IProxyModuleClient {

	public void preInit() {

	}

	public void init() {
		FMLCommonHandler.instance().bus().register(new EventModulePlayerInventory1Client());
		MinecraftForge.EVENT_BUS.register(new EventModulePlayerInventory2Client());
	}

	public void postInit() {

	}

}
