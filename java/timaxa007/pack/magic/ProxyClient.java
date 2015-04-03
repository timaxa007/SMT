package timaxa007.pack.magic;

import net.minecraftforge.common.MinecraftForge;
import timaxa007.pack.api.IProxyPackClient;
import timaxa007.pack.magic.event.EventMagicClient;
import timaxa007.pack.magic.event.EventMana;
import timaxa007.pack.magic.lib.Spells;
import timaxa007.pack.magic.render.RenderMain;
import cpw.mods.fml.common.FMLCommonHandler;

public class ProxyClient implements IProxyPackClient {

	@Override
	public void preInit() {

		MinecraftForge.EVENT_BUS.register(new EventMagicClient());

	}

	@Override
	public void init() {

		MinecraftForge.EVENT_BUS.register(new Spells.EventSpellsClient());
		FMLCommonHandler.instance().bus().register(new EventMana.Client());

		RenderMain.init();

	}

	@Override
	public void postInit() {
		
	}

}
