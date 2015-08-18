package timaxa007.pack.conjoint;

import net.minecraftforge.common.MinecraftForge;
import timaxa007.api.IProxyPackClient;
import timaxa007.pack.conjoint.event.EventClientSMT;
import timaxa007.pack.conjoint.event.EventItemStorageClient;
import timaxa007.pack.conjoint.event.EventPackConjointsClient;
import timaxa007.pack.conjoint.lib.LangLib;
import timaxa007.pack.conjoint.render.RenderMain;
import cpw.mods.fml.common.FMLCommonHandler;

public class ProxyClient implements IProxyPackClient {

	@Override
	public void preInit() {

		MinecraftForge.EVENT_BUS.register(new EventPackConjointsClient());

		LangLib.init(PackConjoint.MODID);

	}

	@Override
	public void init() {

		MinecraftForge.EVENT_BUS.register(new EventClientSMT());
		FMLCommonHandler.instance().bus().register(new EventItemStorageClient());

		RenderMain.init();

	}

	@Override
	public void postInit() {

	}

}
