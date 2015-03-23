package timaxa007.tms;

import net.minecraftforge.common.MinecraftForge;

import org.apache.logging.log4j.Level;

import timaxa007.tms.event.EventClientTMS;
import cpw.mods.fml.common.FMLLog;

public class ProxyClient extends ProxyCommon {

	public void preInit() {
		super.preInit();

	}

	@Override
	public void init() {
		super.init();

		if (Core.debug) FMLLog.log(Core.MODID, Level.DEBUG, "Successful initialized client part.");

		MinecraftForge.EVENT_BUS.register(new EventClientTMS());

	}

}
