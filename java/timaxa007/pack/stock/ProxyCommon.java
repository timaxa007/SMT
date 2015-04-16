package timaxa007.pack.stock;

import net.minecraftforge.common.MinecraftForge;
import timaxa007.api.IProxyPackCommon;
import timaxa007.pack.stock.lib.ReceivingNutriment;
import timaxa007.pack.stock.render.RenderMain;

public class ProxyCommon implements IProxyPackCommon {

	@Override
	public void preInit() {

		RenderMain.preInit();

	}

	@Override
	public void init() {

		MinecraftForge.EVENT_BUS.register(new ReceivingNutriment.EventNutrimentCommon());

	}

	@Override
	public void postInit() {

	}

}
