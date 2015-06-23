package timaxa007.pack.techno;

import net.minecraftforge.common.MinecraftForge;
import timaxa007.api.IProxyPackCommon;
import timaxa007.pack.stock.util.RegisterEntity;
import timaxa007.pack.techno.entity.EntityElectricRobot;
import timaxa007.pack.techno.event.EventDetector;
import timaxa007.pack.techno.event.EventTechno;
import timaxa007.pack.techno.render.RenderMain;
import cpw.mods.fml.common.FMLCommonHandler;

public class ProxyCommon implements IProxyPackCommon {

	@Override
	public void preInit() {

		RegisterEntity.registerEntity(EntityElectricRobot.class, "electric_robot");
		RenderMain.preInit();
		MinecraftForge.EVENT_BUS.register(new EventTechno());

	}

	@Override
	public void init() {

		FMLCommonHandler.instance().bus().register(new EventDetector());

	}

	@Override
	public void postInit() {

	}

}
