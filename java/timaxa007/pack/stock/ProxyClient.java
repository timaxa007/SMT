package timaxa007.pack.stock;

import net.minecraftforge.common.MinecraftForge;
import timaxa007.api.IProxyPackClient;
import timaxa007.pack.stock.event.EventStockClient;
import timaxa007.pack.stock.lib.ReceivingNutriment;
import timaxa007.pack.stock.render.RenderMain;

public class ProxyClient implements IProxyPackClient {

	@Override
	public void preInit() {

		MinecraftForge.EVENT_BUS.register(new EventStockClient());

	}

	@Override
	public void init() {

		MinecraftForge.EVENT_BUS.register(new ReceivingNutriment.EventNutrimentClient());

		RenderMain.init();

	}

	@Override
	public void postInit() {
		
	}

}
