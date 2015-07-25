package timaxa007.module.player_inventory;

import net.minecraftforge.common.MinecraftForge;
import timaxa007.api.IProxyModuleCommon;
import timaxa007.module.player_inventory.event.EventPlayerInventory;
import cpw.mods.fml.common.FMLCommonHandler;

public class ProxyCommon implements IProxyModuleCommon {

	public void preInit() {

	}

	public void init() {

		FMLCommonHandler.instance().bus().register(new EventPlayerInventory());

		//MinecraftForge.EVENT_BUS.register(new EventStatusPlayer.Player());
		//FMLCommonHandler.instance().bus().register(new EventStatusPlayer.Common());
	}

	public void postInit() {
		
	}

}
