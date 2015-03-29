package timaxa007.pack.stock;

import net.minecraftforge.common.MinecraftForge;
import timaxa007.pack.stock.event.EventStockClient;
import timaxa007.pack.stock.lib.ReceivingNutriment;
import timaxa007.tms.util.IProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

public class ProxyClient extends ProxyCommon implements IProxy {

	public void preInit(FMLPreInitializationEvent event) {
		super.preInit(event);

		MinecraftForge.EVENT_BUS.register(new EventStockClient());

	}

	public void init() {
		super.init();

		MinecraftForge.EVENT_BUS.register(new ReceivingNutriment.EventNutrimentClient());

		render.init();

	}

}
