package timaxa007.module.control_button;

import net.minecraftforge.common.MinecraftForge;
import timaxa007.module.control_button.event.EventActionArmorKey;
import timaxa007.module.control_button.event.EventActionMouse;
import timaxa007.module.control_button.event.EventActionPrimaryKey;
import timaxa007.module.control_button.event.EventControlButtonClient;
import timaxa007.module.control_button.util.RegKey;
import cpw.mods.fml.common.FMLCommonHandler;

public class ProxyClient extends ProxyCommon {

	public void preInit() {
		super.preInit();

		RegKey.preInit();

	}

	@Override
	public void init() {
		super.init();
		
		MinecraftForge.EVENT_BUS.register(new EventControlButtonClient());
		//MinecraftForge.EVENT_BUS.register(new EventMouse());
		FMLCommonHandler.instance().bus().register(new EventActionMouse());
		FMLCommonHandler.instance().bus().register(new EventActionPrimaryKey());
		FMLCommonHandler.instance().bus().register(new EventActionArmorKey());

	}

}
