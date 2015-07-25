package timaxa007.pack.magic;

import net.minecraftforge.common.MinecraftForge;
import timaxa007.api.IProxyPackCommon;
import timaxa007.pack.magic.event.*;
import timaxa007.pack.magic.render.RenderMain;
import cpw.mods.fml.common.FMLCommonHandler;

public class ProxyCommon implements IProxyPackCommon {

	@Override
	public void preInit() {

		MinecraftForge.EVENT_BUS.register(new EventMagic());
		RenderMain.preInit();

	}

	@Override
	public void init() {

		FMLCommonHandler.instance().bus().register(new EventMana.Common());
		MinecraftForge.EVENT_BUS.register(new EventMana.Player());
		MinecraftForge.EVENT_BUS.register(new EventSpells.Common());
		MinecraftForge.EVENT_BUS.register(new EventTest());

	}

	@Override
	public void postInit() {

	}

}
