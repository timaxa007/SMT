package timaxa007.module.player_inventory;

import net.minecraftforge.common.MinecraftForge;
import timaxa007.api.IProxyModuleCommon;
import timaxa007.module.player_inventory.event.EventModulePlayerInventory1;
import timaxa007.module.player_inventory.event.EventModulePlayerInventory2;
import cpw.mods.fml.common.FMLCommonHandler;

public class ProxyCommon implements IProxyModuleCommon {

	public void preInit() {

	}

	public void init() {
		FMLCommonHandler.instance().bus().register(new EventModulePlayerInventory1());
		MinecraftForge.EVENT_BUS.register(new EventModulePlayerInventory2());
	}

	public void postInit() {

	}

}
