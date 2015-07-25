package timaxa007.pack.item;

import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraftforge.common.MinecraftForge;
import timaxa007.api.IProxyPackCommon;
import timaxa007.pack.item.event.*;
import timaxa007.pack.item.render.RenderMain;

public class ProxyCommon implements IProxyPackCommon {

	@Override
	public void preInit() {

		MinecraftForge.EVENT_BUS.register(new EventPackItems());

		RenderMain.preInit();

	}

	@Override
	public void init() {

		MinecraftForge.EVENT_BUS.register(new EventWorldBlockData());
		FMLCommonHandler.instance().bus().register(new EventUpdate());

	}

	@Override
	public void postInit() {

	}

}
